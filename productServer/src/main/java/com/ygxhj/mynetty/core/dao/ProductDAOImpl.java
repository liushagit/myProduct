package com.ygxhj.mynetty.core.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ygxhj.mynetty.core.model.Product;
import com.ygxhj.mynetty.core.model.ProductExample;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	private SqlMapClient sqlMapClient;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public ProductDAOImpl(SqlMapClient sqlMapClient) {
		super();
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public Long insert(Product record) throws SQLException {
		Object newKey = sqlMapClient.insert("product.abatorgenerated_insert",
				record);
		return (Long) newKey;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public int updateByPrimaryKey(Product record) throws SQLException {
		int rows = sqlMapClient.update(
				"product.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public int updateByPrimaryKeySelective(Product record) throws SQLException {
		int rows = sqlMapClient.update(
				"product.abatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	@SuppressWarnings("unchecked")
	public List<Product> selectByExample(ProductExample example)
			throws SQLException {
		List<Product> list = (List<Product>) sqlMapClient.queryForList(
				"product.abatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public Product selectByPrimaryKey(Long id) throws SQLException {
		Product key = new Product();
		key.setId(id);
		Product record = (Product) sqlMapClient.queryForObject(
				"product.abatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public int deleteByExample(ProductExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"product.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public int deleteByPrimaryKey(Long id) throws SQLException {
		Product key = new Product();
		key.setId(id);
		int rows = sqlMapClient.delete(
				"product.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public int countByExample(ProductExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"product.abatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public int updateByExampleSelective(Product record, ProductExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"product.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public int updateByExample(Product record, ProductExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"product.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	private static class UpdateByExampleParms extends ProductExample {
		private Object record;

		public UpdateByExampleParms(Object record, ProductExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}