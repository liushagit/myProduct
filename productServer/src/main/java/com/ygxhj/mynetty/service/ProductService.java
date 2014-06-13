package com.ygxhj.mynetty.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.ygxhj.mynetty.core.ProductSet;
import com.ygxhj.mynetty.core.dao.ProductDAO;
import com.ygxhj.mynetty.core.dao.ProductDAOImpl;
import com.ygxhj.mynetty.core.model.Player;
import com.ygxhj.mynetty.core.model.Product;
import com.ygxhj.mynetty.core.model.ProductExample;
import com.ygxhj.mynetty.dbutil.DBManager;
import com.ygxhj.mynetty.dbutil.DBService;
import com.ygxhj.mynetty.dbutil.GlobalGenerator;
import com.ygxhj.mynetty.exception.ProductException;

public class ProductService {

	private static final Logger logger = Logger.getLogger(ProductService.class);
	
	/**
	 * 获取一个存在的产品
	 * 先从内存中获取，内存中不存在时从db中获取
	 * @param productId
	 * @return
	 */
	public static Product getExitProduct(String productId){
		Product product = ProductSet.getInstance().getProduct(productId);
		if (product == null) {
			ProductDAO dao = (ProductDAO) DBManager.getDao(ProductDAOImpl.class);
			ProductExample example = new ProductExample();
			example.createCriteria().andProductIdEqualTo(productId);
			try {
				List<Product> list = dao.selectByExample(example);
				if (list != null && list.size() > 0) {
					product = list.get(0);
				}
				if (product != null) {
					ProductSet.getInstance().addProduct(product);;
				}
			} catch (Exception e) {
				logger.error("quary product exception", e);
				return null;
			}
		}
		return product;
	}
	
	/**
	 * 添加一个产品
	 * @param productId
	 * @param name
	 * @param destance
	 * @param number
	 * @return
	 * @throws ProbeException
	 */
	public static Product addProduct(Player player,String productId ,String name,String destance,int number,int price,int discount,int deductPrice)throws ProductException{
		checkProduct(productId, name, destance, number);
		Product product = getExitProduct(productId);
		if (product == null) {
			product = createProduct(productId, name, destance,price,discount,deductPrice);
		}
		
		product.addNumber(number);
		product.setLastUpdate(new Date());
		product.setDestance(destance);
		product.setName(name);
		product.setPrice(price);
		product.setDeductPrice(deductPrice);
		product.setDiscount(discount);
		
		DBService.commit(product);
		return product;
	}
	
	/**
	 * 校验产品信息的正确性
	 * @param productId
	 * @param name
	 * @param destance
	 * @param number
	 */
	private static void checkProduct(String productId ,String name,String destance,int number) throws ProductException{
		if (productId == null || name == null || destance == null || number <= 0) {
			throw new ProductException("product info error!");
		}
		if (productId.length() <= 0 || name.length() <= 0 || destance.length() <= 0) {
			throw new ProductException("product info error!!");
		}
	}
	private static Product createProduct(String productId ,String name,String destance,int price,int discount,int deductPrice) throws ProductException{
		Product product = new Product();
		int id = GlobalGenerator.getInstance().getReusedIdForNewObj(product.tableName);
		if (id <= 0) {
			throw new ProductException("get product id error");
		}
		Date date = new Date();
		product.setId(id);
		product.setCreateTime(date);
		product.setDestance(destance);
		product.setLastUpdate(date);
		product.setName(name);
		product.setProductId(productId);
		product.setProductNum(0);
		product.setPrice(price);
		product.setDeductPrice(deductPrice);
		product.setDiscount(discount);
		return product;
	}
	
	public static void consumProduct(Player player,String productId,int number) throws ProductException{
		Product product = getExitProduct(productId);
		if (product == null) {
			throw new ProductException("产品不存在，请选择其他产品！");
		}
		if (product.getProductNum() <= 0) {
			throw new ProductException(product.getName() + "数量不足，请尝试其他产品！");
		}
		product.consumNumber(number);
		
		DBService.commit(product);
	}
}
