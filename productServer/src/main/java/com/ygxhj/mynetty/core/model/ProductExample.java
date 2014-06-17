package com.ygxhj.mynetty.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductExample {

	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Abator for iBATIS. This field corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public ProductExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	protected ProductExample(ProductExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table product
	 * @abatorgenerated  Mon Jun 16 19:57:09 CST 2014
	 */
	public static class Criteria {
		protected List<String> criteriaWithoutValue;
		protected List<Map<String, Object>> criteriaWithSingleValue;
		protected List<Map<String, Object>> criteriaWithListValue;
		protected List<Map<String, Object>> criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList<String>();
			criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
			criteriaWithListValue = new ArrayList<Map<String, Object>>();
			criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List<String> getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List<Map<String, Object>> getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List<Map<String, Object>> getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List<Map<String, Object>> getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition,
				List<? extends Object> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(value1);
			list.add(value2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return this;
		}

		public Criteria andProductIdIsNull() {
			addCriterion("product_id is null");
			return this;
		}

		public Criteria andProductIdIsNotNull() {
			addCriterion("product_id is not null");
			return this;
		}

		public Criteria andProductIdEqualTo(String value) {
			addCriterion("product_id =", value, "productId");
			return this;
		}

		public Criteria andProductIdNotEqualTo(String value) {
			addCriterion("product_id <>", value, "productId");
			return this;
		}

		public Criteria andProductIdGreaterThan(String value) {
			addCriterion("product_id >", value, "productId");
			return this;
		}

		public Criteria andProductIdGreaterThanOrEqualTo(String value) {
			addCriterion("product_id >=", value, "productId");
			return this;
		}

		public Criteria andProductIdLessThan(String value) {
			addCriterion("product_id <", value, "productId");
			return this;
		}

		public Criteria andProductIdLessThanOrEqualTo(String value) {
			addCriterion("product_id <=", value, "productId");
			return this;
		}

		public Criteria andProductIdLike(String value) {
			addCriterion("product_id like", value, "productId");
			return this;
		}

		public Criteria andProductIdNotLike(String value) {
			addCriterion("product_id not like", value, "productId");
			return this;
		}

		public Criteria andProductIdIn(List<String> values) {
			addCriterion("product_id in", values, "productId");
			return this;
		}

		public Criteria andProductIdNotIn(List<String> values) {
			addCriterion("product_id not in", values, "productId");
			return this;
		}

		public Criteria andProductIdBetween(String value1, String value2) {
			addCriterion("product_id between", value1, value2, "productId");
			return this;
		}

		public Criteria andProductIdNotBetween(String value1, String value2) {
			addCriterion("product_id not between", value1, value2, "productId");
			return this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2,
					"createTime");
			return this;
		}

		public Criteria andProductNumIsNull() {
			addCriterion("product_num is null");
			return this;
		}

		public Criteria andProductNumIsNotNull() {
			addCriterion("product_num is not null");
			return this;
		}

		public Criteria andProductNumEqualTo(Integer value) {
			addCriterion("product_num =", value, "productNum");
			return this;
		}

		public Criteria andProductNumNotEqualTo(Integer value) {
			addCriterion("product_num <>", value, "productNum");
			return this;
		}

		public Criteria andProductNumGreaterThan(Integer value) {
			addCriterion("product_num >", value, "productNum");
			return this;
		}

		public Criteria andProductNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("product_num >=", value, "productNum");
			return this;
		}

		public Criteria andProductNumLessThan(Integer value) {
			addCriterion("product_num <", value, "productNum");
			return this;
		}

		public Criteria andProductNumLessThanOrEqualTo(Integer value) {
			addCriterion("product_num <=", value, "productNum");
			return this;
		}

		public Criteria andProductNumIn(List<Integer> values) {
			addCriterion("product_num in", values, "productNum");
			return this;
		}

		public Criteria andProductNumNotIn(List<Integer> values) {
			addCriterion("product_num not in", values, "productNum");
			return this;
		}

		public Criteria andProductNumBetween(Integer value1, Integer value2) {
			addCriterion("product_num between", value1, value2, "productNum");
			return this;
		}

		public Criteria andProductNumNotBetween(Integer value1, Integer value2) {
			addCriterion("product_num not between", value1, value2,
					"productNum");
			return this;
		}

		public Criteria andDestanceIsNull() {
			addCriterion("destance is null");
			return this;
		}

		public Criteria andDestanceIsNotNull() {
			addCriterion("destance is not null");
			return this;
		}

		public Criteria andDestanceEqualTo(String value) {
			addCriterion("destance =", value, "destance");
			return this;
		}

		public Criteria andDestanceNotEqualTo(String value) {
			addCriterion("destance <>", value, "destance");
			return this;
		}

		public Criteria andDestanceGreaterThan(String value) {
			addCriterion("destance >", value, "destance");
			return this;
		}

		public Criteria andDestanceGreaterThanOrEqualTo(String value) {
			addCriterion("destance >=", value, "destance");
			return this;
		}

		public Criteria andDestanceLessThan(String value) {
			addCriterion("destance <", value, "destance");
			return this;
		}

		public Criteria andDestanceLessThanOrEqualTo(String value) {
			addCriterion("destance <=", value, "destance");
			return this;
		}

		public Criteria andDestanceLike(String value) {
			addCriterion("destance like", value, "destance");
			return this;
		}

		public Criteria andDestanceNotLike(String value) {
			addCriterion("destance not like", value, "destance");
			return this;
		}

		public Criteria andDestanceIn(List<String> values) {
			addCriterion("destance in", values, "destance");
			return this;
		}

		public Criteria andDestanceNotIn(List<String> values) {
			addCriterion("destance not in", values, "destance");
			return this;
		}

		public Criteria andDestanceBetween(String value1, String value2) {
			addCriterion("destance between", value1, value2, "destance");
			return this;
		}

		public Criteria andDestanceNotBetween(String value1, String value2) {
			addCriterion("destance not between", value1, value2, "destance");
			return this;
		}

		public Criteria andLastUpdateIsNull() {
			addCriterion("last_update is null");
			return this;
		}

		public Criteria andLastUpdateIsNotNull() {
			addCriterion("last_update is not null");
			return this;
		}

		public Criteria andLastUpdateEqualTo(Date value) {
			addCriterion("last_update =", value, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateNotEqualTo(Date value) {
			addCriterion("last_update <>", value, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateGreaterThan(Date value) {
			addCriterion("last_update >", value, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateGreaterThanOrEqualTo(Date value) {
			addCriterion("last_update >=", value, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateLessThan(Date value) {
			addCriterion("last_update <", value, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateLessThanOrEqualTo(Date value) {
			addCriterion("last_update <=", value, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateIn(List<Date> values) {
			addCriterion("last_update in", values, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateNotIn(List<Date> values) {
			addCriterion("last_update not in", values, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateBetween(Date value1, Date value2) {
			addCriterion("last_update between", value1, value2, "lastUpdate");
			return this;
		}

		public Criteria andLastUpdateNotBetween(Date value1, Date value2) {
			addCriterion("last_update not between", value1, value2,
					"lastUpdate");
			return this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("price is null");
			return this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("price is not null");
			return this;
		}

		public Criteria andPriceEqualTo(Integer value) {
			addCriterion("price =", value, "price");
			return this;
		}

		public Criteria andPriceNotEqualTo(Integer value) {
			addCriterion("price <>", value, "price");
			return this;
		}

		public Criteria andPriceGreaterThan(Integer value) {
			addCriterion("price >", value, "price");
			return this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("price >=", value, "price");
			return this;
		}

		public Criteria andPriceLessThan(Integer value) {
			addCriterion("price <", value, "price");
			return this;
		}

		public Criteria andPriceLessThanOrEqualTo(Integer value) {
			addCriterion("price <=", value, "price");
			return this;
		}

		public Criteria andPriceIn(List<Integer> values) {
			addCriterion("price in", values, "price");
			return this;
		}

		public Criteria andPriceNotIn(List<Integer> values) {
			addCriterion("price not in", values, "price");
			return this;
		}

		public Criteria andPriceBetween(Integer value1, Integer value2) {
			addCriterion("price between", value1, value2, "price");
			return this;
		}

		public Criteria andPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("price not between", value1, value2, "price");
			return this;
		}

		public Criteria andDiscountIsNull() {
			addCriterion("discount is null");
			return this;
		}

		public Criteria andDiscountIsNotNull() {
			addCriterion("discount is not null");
			return this;
		}

		public Criteria andDiscountEqualTo(Integer value) {
			addCriterion("discount =", value, "discount");
			return this;
		}

		public Criteria andDiscountNotEqualTo(Integer value) {
			addCriterion("discount <>", value, "discount");
			return this;
		}

		public Criteria andDiscountGreaterThan(Integer value) {
			addCriterion("discount >", value, "discount");
			return this;
		}

		public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
			addCriterion("discount >=", value, "discount");
			return this;
		}

		public Criteria andDiscountLessThan(Integer value) {
			addCriterion("discount <", value, "discount");
			return this;
		}

		public Criteria andDiscountLessThanOrEqualTo(Integer value) {
			addCriterion("discount <=", value, "discount");
			return this;
		}

		public Criteria andDiscountIn(List<Integer> values) {
			addCriterion("discount in", values, "discount");
			return this;
		}

		public Criteria andDiscountNotIn(List<Integer> values) {
			addCriterion("discount not in", values, "discount");
			return this;
		}

		public Criteria andDiscountBetween(Integer value1, Integer value2) {
			addCriterion("discount between", value1, value2, "discount");
			return this;
		}

		public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
			addCriterion("discount not between", value1, value2, "discount");
			return this;
		}

		public Criteria andDeductPriceIsNull() {
			addCriterion("deduct_price is null");
			return this;
		}

		public Criteria andDeductPriceIsNotNull() {
			addCriterion("deduct_price is not null");
			return this;
		}

		public Criteria andDeductPriceEqualTo(Integer value) {
			addCriterion("deduct_price =", value, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceNotEqualTo(Integer value) {
			addCriterion("deduct_price <>", value, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceGreaterThan(Integer value) {
			addCriterion("deduct_price >", value, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("deduct_price >=", value, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceLessThan(Integer value) {
			addCriterion("deduct_price <", value, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceLessThanOrEqualTo(Integer value) {
			addCriterion("deduct_price <=", value, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceIn(List<Integer> values) {
			addCriterion("deduct_price in", values, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceNotIn(List<Integer> values) {
			addCriterion("deduct_price not in", values, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceBetween(Integer value1, Integer value2) {
			addCriterion("deduct_price between", value1, value2, "deductPrice");
			return this;
		}

		public Criteria andDeductPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("deduct_price not between", value1, value2,
					"deductPrice");
			return this;
		}

		public Criteria andPlayerIdIsNull() {
			addCriterion("player_id is null");
			return this;
		}

		public Criteria andPlayerIdIsNotNull() {
			addCriterion("player_id is not null");
			return this;
		}

		public Criteria andPlayerIdEqualTo(Long value) {
			addCriterion("player_id =", value, "playerId");
			return this;
		}

		public Criteria andPlayerIdNotEqualTo(Long value) {
			addCriterion("player_id <>", value, "playerId");
			return this;
		}

		public Criteria andPlayerIdGreaterThan(Long value) {
			addCriterion("player_id >", value, "playerId");
			return this;
		}

		public Criteria andPlayerIdGreaterThanOrEqualTo(Long value) {
			addCriterion("player_id >=", value, "playerId");
			return this;
		}

		public Criteria andPlayerIdLessThan(Long value) {
			addCriterion("player_id <", value, "playerId");
			return this;
		}

		public Criteria andPlayerIdLessThanOrEqualTo(Long value) {
			addCriterion("player_id <=", value, "playerId");
			return this;
		}

		public Criteria andPlayerIdIn(List<Long> values) {
			addCriterion("player_id in", values, "playerId");
			return this;
		}

		public Criteria andPlayerIdNotIn(List<Long> values) {
			addCriterion("player_id not in", values, "playerId");
			return this;
		}

		public Criteria andPlayerIdBetween(Long value1, Long value2) {
			addCriterion("player_id between", value1, value2, "playerId");
			return this;
		}

		public Criteria andPlayerIdNotBetween(Long value1, Long value2) {
			addCriterion("player_id not between", value1, value2, "playerId");
			return this;
		}
	}
}