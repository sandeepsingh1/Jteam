package com.hannover.helper;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * This class is designed to help in searching records in database. users can
 * add search conditions by using different methods. Methods for adding
 * conditions are in triplets. One simple version, which considers that property
 * represents relation in terms member variables at all levels. One with
 * an extra integer argument needs to specify the level at which property
 * included component (starting from 1). One with a boolean argument should be
 * avoided as setting this boolean as true means that whole property refers to a 
 * component setting it false will mean as just calling the first version of the
 * method. Similarly, one can define orders for sorting results. One can define
 * pageSize and pageNumber for paginated search.
 *  
 * @author ashok.agrawal
 * 
 */

public class SearchVO implements Serializable {

	private static final long serialVersionUID = 5699481852902819161L;

	private Set<Condition> conditions;
	private Set<Order> orders;
	private Set<FetchMode> fetchModes;
	private Integer pageNumber;
	private Integer pageSize;
	
	private CollectiveCondition collectiveCondition;
	
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void addEqualsCondition(String searchProperty, Object searchValue) {
		addEqualsCondition(searchProperty, searchValue, 0);
	}

	public void addEqualsCondition(String searchProperty, Object searchValue,
			boolean isComponent) {
		addEqualsCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addEqualsCondition(String searchProperty, Object searchValue,
			int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.EQUALS, conponentLevel));
	}

	public void addNotEqualsCondition(String searchProperty, Object searchValue) {
		addNotEqualsCondition(searchProperty, searchValue, 0);
	}

	public void addNotEqualsCondition(String searchProperty,
			Object searchValue, boolean isComponent) {
		addNotEqualsCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addNotEqualsCondition(String searchProperty,
			Object searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.NOT_EQUALS, conponentLevel));
	}

	public void addIsNullCondition(String searchProperty) {
		addIsNullCondition(searchProperty, 0);
	}

	public void addIsNullCondition(String searchProperty, boolean isComponent) {
		addIsNullCondition(searchProperty, isComponent?1:0);
	}
	
	public void addIsNullCondition(String searchProperty, int conponentLevel) {
		if (searchProperty != null && searchProperty.length() > 0
				&& !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, null, ConditionType.IS_NULL,
					conponentLevel));
	}

	public void addIsNotNullCondition(String searchProperty) {
		addIsNotNullCondition(searchProperty, 0);
	}

	public void addIsNotNullCondition(String searchProperty, boolean isComponent) {
		addIsNotNullCondition(searchProperty, isComponent?1:0);
	}
	
	public void addIsNotNullCondition(String searchProperty, int conponentLevel) {
		if (searchProperty != null && searchProperty.length() > 0
				&& !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, null,
					ConditionType.IS_NOT_NULL, conponentLevel));
	}

	public void addLesserCondition(String searchProperty, Object searchValue) {
		addLesserCondition(searchProperty, searchValue, 0);
	}

	public void addLesserCondition(String searchProperty, Object searchValue,
			boolean isComponent) {
		addLesserCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addLesserCondition(String searchProperty, Object searchValue,
			int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue, ConditionType.LESSER,
					conponentLevel));
	}

	public void addGreaterCondition(String searchProperty, Object searchValue) {
		addGreaterCondition(searchProperty, searchValue, 0);
	}

	public void addGreaterCondition(String searchProperty, Object searchValue,
			boolean isComponent) {
		addGreaterCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addGreaterCondition(String searchProperty, Object searchValue,
			int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.GREATER, conponentLevel));
	}

	public void addLesserEqualsCondition(String searchProperty,
			Object searchValue) {
		addLesserEqualsCondition(searchProperty, searchValue, 0);
	}

	public void addLesserEqualsCondition(String searchProperty,
			Object searchValue, boolean isComponent) {
		addLesserEqualsCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addLesserEqualsCondition(String searchProperty,
			Object searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.LESSER_EQUAL, conponentLevel));
	}

	public void addGreaterEqualsCondition(String searchProperty,
			Object searchValue) {
		addGreaterEqualsCondition(searchProperty, searchValue, 0);
	}

	public void addGreaterEqualsCondition(String searchProperty,
			Object searchValue, boolean isComponent) {
		addGreaterEqualsCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addGreaterEqualsCondition(String searchProperty,
			Object searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.GREATER_EQUAL, conponentLevel));
	}

	public void addLikeCondition(String searchProperty, String searchValue) {
		addLikeCondition(searchProperty, searchValue, 0);
	}

	public void addLikeCondition(String searchProperty, String searchValue,
			boolean isComponent) {
		addLikeCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addLikeCondition(String searchProperty, String searchValue,
			int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.LIKE, conponentLevel));
	}

	public void addLikeIgnoreCaseCondition(String searchProperty,
			String searchValue) {
		addLikeIgnoreCaseCondition(searchProperty, searchValue, 0);
	}

	public void addLikeIgnoreCaseCondition(String searchProperty,
			String searchValue, boolean isComponent) {
		addLikeIgnoreCaseCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addLikeIgnoreCaseCondition(String searchProperty,
			String searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.LIKE_IGNORE_CASE, conponentLevel));
	}

	public void addStartsWithCondition(String searchProperty, String searchValue) {
		addStartsWithCondition(searchProperty, searchValue, 0);
	}

	public void addStartsWithCondition(String searchProperty,
			String searchValue, boolean isComponent) {
		addStartsWithCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addStartsWithCondition(String searchProperty,
			String searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.LIKE_STARTS_WITH, conponentLevel));
	}

	public void addStartsWithIgnoreCaseCondition(String searchProperty,
			String searchValue) {
		addStartsWithIgnoreCaseCondition(searchProperty, searchValue, 0);
	}

	public void addStartsWithIgnoreCaseCondition(String searchProperty,
			String searchValue, boolean isComponent) {
		addStartsWithIgnoreCaseCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addStartsWithIgnoreCaseCondition(String searchProperty,
			String searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.LIKE_STARTS_WITH_IGNORE_CASE, conponentLevel));
	}

	public void addEqualsIgnoreCaseCondition(String searchProperty,
			String searchValue) {
		addEqualsIgnoreCaseCondition(searchProperty, searchValue, 0);
	}

	public void addEqualsIgnoreCaseCondition(String searchProperty,
			String searchValue, boolean isComponent) {
		addEqualsIgnoreCaseCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addEqualsIgnoreCaseCondition(String searchProperty,
			String searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.EQUALS_IGNORE_CASE, conponentLevel));
	}

	public void addEqualsCaseSensitiveCondition(String searchProperty,
			String searchValue) {
		addEqualsCaseSensitiveCondition(searchProperty, searchValue, 0);
	}

	public void addEqualsCaseSensitiveCondition(String searchProperty,
			String searchValue, boolean isComponent) {
		addEqualsCaseSensitiveCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addEqualsCaseSensitiveCondition(String searchProperty,
			String searchValue, int conponentLevel) {
		if (searchValue != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValue,
					ConditionType.EQUALS_CASE_SENSITIVE, conponentLevel));
	}

	public void addInCondition(String searchProperty, Collection searchValues) {
		addInCondition(searchProperty, searchValues, 0);
	}

	public void addInCondition(String searchProperty, Collection searchValues,
			boolean isComponent) {
		addInCondition(searchProperty, searchValues, isComponent?1:0);
	}
	
	public void addInCondition(String searchProperty, Collection searchValues,
			int conponentLevel) {
		if (searchValues != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValues.toArray(),
					ConditionType.IN, conponentLevel));
	}

	public void addInCondition(String searchProperty, Object... searchValues) {
		addInCondition(searchProperty, searchValues, 0);
	}

	public void addInCondition(String searchProperty, boolean isComponent,
			Object... searchValues) {
		addInCondition(searchProperty, searchValues, isComponent?1:0);
	}
	
	public void addInCondition(String searchProperty, Object[] searchValues,
			int conponentLevel) {
		if (searchValues != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValues,
					ConditionType.IN, conponentLevel));
	}
	
	public void addNotInCondition(String searchProperty, Collection searchValues) {
		addNotInCondition(searchProperty, searchValues, 0);
	}

	public void addNotInCondition(String searchProperty, Collection searchValues,
			boolean isComponent) {
		addNotInCondition(searchProperty, searchValues, isComponent?1:0);
	}
	
	public void addNotInCondition(String searchProperty, Collection searchValues,
			int conponentLevel) {
		if (searchValues != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValues.toArray(),
					ConditionType.NOT_IN, conponentLevel));
	}

	public void addNotInCondition(String searchProperty, Object... searchValues) {
		addNotInCondition(searchProperty, searchValues, 0);
	}

	public void addNotInCondition(String searchProperty, boolean isComponent,
			Object... searchValues) {
		addNotInCondition(searchProperty, searchValues, isComponent?1:0);
	}
	
	public void addNotInCondition(String searchProperty, Object[] searchValues,
			int conponentLevel) {
		if (searchValues != null && searchProperty != null
				&& searchProperty.length() > 0 && !searchProperty.endsWith("."))
			addCondition(new AtomicCondition(searchProperty, searchValues,
					ConditionType.NOT_IN, conponentLevel));
	}
	
	public <T extends Comparable> void addBetweenCondition(String searchProperty, T low, T high){
		addBetweenCondition(searchProperty, low, high, 0);
	}

	public <T extends Comparable> void addBetweenCondition(String searchProperty, T low, T high, int conponentLevel){
		if(high != null && low != null && searchProperty.indexOf('.') != 0 && searchProperty.lastIndexOf('.') != searchProperty.length()-1){
			addCondition(new AtomicCondition(searchProperty, new Object[]{low, high}, ConditionType.BETWEEN, conponentLevel));
		}
	}
	
	public void addDateEqualsCondition(String searchProperty,
			Date searchValue){
		addDateEqualsCondition(searchProperty, searchValue, 0);
	}
	
	public void addDateEqualsCondition(String searchProperty,
			Date searchValue, boolean isComponent){
		addDateEqualsCondition(searchProperty, searchValue, isComponent?1:0);
	}
	
	public void addDateEqualsCondition(String searchProperty,
			Date searchValue, int conponentLevel){
		Date referenceDate = truncate(searchValue);
		addGreaterEqualsCondition(searchProperty, referenceDate, conponentLevel);
		addLesserCondition(searchProperty, new Date(referenceDate.getTime() + 86400000), conponentLevel);
	}

	public void addFetchMode(String property, org.hibernate.FetchMode fetchMode) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addFetchMode(new FetchMode(property, fetchMode));
	}
	
	public void addFetchMode(String property, org.hibernate.FetchMode fetchMode, int conponentLevel) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addFetchMode(new FetchMode(property, fetchMode, conponentLevel));
	}
	
	private void addFetchMode(FetchMode fetchMode) {
		if (fetchModes != null) {
			fetchModes.add(fetchMode);
		} else {
			fetchModes = new LinkedHashSet<FetchMode>();
			fetchModes.add(fetchMode);
		}
	}
	
	public void addOrderAscending(String property) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.ASCENDING));
	}
	
	public void addOrderAscending(String property, boolean ignoreCase) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.ASCENDING, ignoreCase));
	}

	public void addOrderAscending(String property, int componentLevel) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.ASCENDING, componentLevel));
	}

	public void addOrderAscending(String property, int componentLevel, boolean ignoreCase) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.ASCENDING, componentLevel, ignoreCase));
	}

	public void addOrderDescending(String property) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.DESCENDING));
	}
	
	public void addOrderDescending(String property, boolean ignoreCase) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.DESCENDING, ignoreCase));
	}
	
	public void addOrderDescending(String property, int componentLevel) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.DESCENDING, componentLevel));
	}
	
	public void addOrderDescending(String property, int componentLevel, boolean ignoreCase) {
		if (property != null && property.length() > 0
				&& !property.endsWith("."))
			addOrder(new Order(property, Order.DESCENDING, componentLevel, ignoreCase));
	}

	private void addCondition(Condition condition) {
		if(collectiveCondition != null)
			collectiveCondition.addCondition(condition);
		else{
			if (conditions == null)
				conditions = new HashSet<Condition>();
			conditions.add(condition);
		}
	}

	private void addOrder(Order order) {
		if (orders != null) {
			orders.add(order);
		} else {
			orders = new LinkedHashSet<Order>();
			orders.add(order);
		}
	}
	
	public void startOrCondition(){
		if(collectiveCondition == null || !(collectiveCondition instanceof OrCondition)){
			OrCondition orCondition = new OrCondition(collectiveCondition);
			collectiveCondition = orCondition;
		}else
			throw new IllegalStateException("ConditionCollection is not null. It can't be set to a new OrCondition. An Or-Condition might already be active.");
	}
	
	public void closeOrCondition(){
		if(collectiveCondition != null && collectiveCondition instanceof OrCondition){
			CollectiveCondition tmpConditionCollection = collectiveCondition;
			collectiveCondition = tmpConditionCollection.getParent();
			addCondition(tmpConditionCollection);
		}else
			throw new IllegalStateException("Current ConditionCollection is either null or not an Or-Condition.");
	}
	
	public void startAndCondition(){
		if(collectiveCondition != null && !(collectiveCondition instanceof AndCondition)){
			AndCondition andCondition = new AndCondition(collectiveCondition);
			collectiveCondition = andCondition;
		}else
			throw new IllegalStateException("ConditionCollection is not null. It can't be set to a new OrCondition. An And-Condition might already be active.");
	}
	
	public void closeAndCondition(){
		if(collectiveCondition != null && collectiveCondition instanceof AndCondition){
			CollectiveCondition tmpConditionCollection = collectiveCondition;
			collectiveCondition = tmpConditionCollection.getParent();
			addCondition(tmpConditionCollection);
		}else
			throw new IllegalStateException("Current ConditionCollection is either null or not an And-Condition.");
	}

	public Criteria buildSearchCriteria(Criteria criterion){
		CriteriaCreator criteriaCreator = new CriteriaCreator(criterion);
		if(criterion == null)
			return null;
		buildCriteria(criterion, criteriaCreator);
		if (fetchModes != null && fetchModes.size() > 0) {
			for (FetchMode fetchMode : fetchModes) {
				criterion.setFetchMode(fetchMode.getProperty(criteriaCreator), fetchMode.type);
			}
		}
		
		if (orders != null && orders.size() > 0) {
			for (Order order : orders) {
				criterion.addOrder(order.getOrder(criteriaCreator));
			}
		}
		
		if(pageSize !=null && pageSize.intValue() > 0){
			criterion.setMaxResults(pageSize);
			if(pageNumber!=null && pageNumber.intValue() > 0){
				criterion.setFirstResult((pageNumber.intValue()-1)*pageSize.intValue());
			}
		}
		return criterion;
	}
	
	public Criteria buildCountCriteria(Criteria criterion){
		CriteriaCreator criteriaCreator = new CriteriaCreator(criterion);
		buildCriteria(criterion, criteriaCreator);
		criterion.setProjection(Projections.rowCount());
		return criterion;
	}

	private Criteria buildCriteria(Criteria criterion, CriteriaCreator criteriaCreator) {
		Criterion tmpCriterion;
		if (conditions != null && conditions.size() > 0 && criterion != null) {
			for (Condition condition : conditions){
				tmpCriterion = condition.getCriterion(criteriaCreator);
				if(tmpCriterion != null)
					criterion.add(tmpCriterion);
			}
		}
		return criterion;
	}
	
	/* Method for clearing instance variables, if required
	 * Can also be utilized for reusing the instance for next search
	 */
	public void clear(){
		if(conditions != null)
			conditions.clear();
		if(orders != null)
			orders.clear();
		pageNumber = null;
		pageSize = null;
	}
	
	public void clearConditions(){
		conditions.clear();
	}
	public void clearOrders(){
		orders.clear();
	}
	public void clearPageNumber(){
		pageNumber = null;
	}
	public void clearPageSize(){
		pageSize = null;
	}
	
	private static Date truncate(Date input){
		if(input == null) return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setLenient(false);
		calendar.setTime(input);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	private class AtomicCondition implements Condition, Serializable, Comparable<Condition> {
		private static final long serialVersionUID = -7177754419250009240L;
		
		private ConditionType mode;
		private String searchProperty;
		private Object searchValue;
		private int componentLevel;

		private AtomicCondition(String searchProperty, Object searchValue, ConditionType mode) {
			this.searchProperty = searchProperty;
			this.searchValue = searchValue;
			this.mode = mode;
		}
		
		private AtomicCondition(String searchProperty, Object searchValue, ConditionType mode,
				int componentLevel) {
			this.searchProperty = searchProperty;
			this.searchValue = searchValue;
			this.mode = mode;
			this.componentLevel = componentLevel;
		}
		
		public Criterion getCriterion(CriteriaCreator criteriaCreator){
			String propertyName;
			if(componentLevel == 1){
				propertyName = searchProperty;
			}else if(componentLevel > 1){
				int tmpIndex = 0;
				for(int i=1; i<componentLevel; i++){
					try{
						tmpIndex = searchProperty.indexOf('.', tmpIndex+1);
					}catch(IndexOutOfBoundsException e){
						throw new IllegalArgumentException("Can't find level "+componentLevel+" in property: "+searchProperty);
					}
					if(tmpIndex < 1)
						throw new IllegalArgumentException("Can't find level "+componentLevel+" in property: "+searchProperty);
				}
				propertyName = criteriaCreator.getCriteria(searchProperty.substring(0, tmpIndex)).getAlias() + '.'+
								searchProperty.substring(tmpIndex+1);
			}else if(searchProperty.indexOf('.') == -1){
				propertyName = searchProperty;
			}else{
				propertyName = criteriaCreator.getCriteria(searchProperty.substring(0, searchProperty.lastIndexOf('.'))).getAlias()
				+ '.' + searchProperty.substring(searchProperty.lastIndexOf('.')+1);
			}
			return createCriterion(propertyName);
		}
		
		private Criterion createCriterion(String propertyName){
			switch (mode) {
				case EQUALS:
					return Restrictions.eq(propertyName, searchValue);
				case GREATER:
					return Restrictions.gt(propertyName, searchValue);
				case LESSER:
					return Restrictions.lt(propertyName, searchValue);
				case LESSER_EQUAL:
					return Restrictions.le(propertyName, searchValue);
				case GREATER_EQUAL:
					return Restrictions.ge(propertyName, searchValue);
				case LIKE:
					return Restrictions.like(propertyName, (String) searchValue, MatchMode.ANYWHERE);
				case LIKE_IGNORE_CASE:
					return Restrictions.ilike(propertyName, (String) searchValue, MatchMode.ANYWHERE);
				case LIKE_STARTS_WITH:
					return Restrictions.like(propertyName, (String) searchValue, MatchMode.START);
				case LIKE_STARTS_WITH_IGNORE_CASE:
					return Restrictions.ilike(propertyName, (String) searchValue, MatchMode.START);
				case EQUALS_IGNORE_CASE:
					return Restrictions.ilike(propertyName, (String) searchValue, MatchMode.EXACT);
				case EQUALS_CASE_SENSITIVE:
					return Restrictions.like(propertyName, (String) searchValue, MatchMode.EXACT);
				case IN:
					return Restrictions.in(propertyName, (Object[]) searchValue);
				case NOT_IN:
					return Restrictions.not(Restrictions.in(propertyName, (Object[]) searchValue));
				case NOT_EQUALS:
					return Restrictions.ne(propertyName, searchValue);
				case IS_NULL:
					return Restrictions.isNull(propertyName);
				case IS_NOT_NULL:
					return Restrictions.isNotNull(propertyName);
				case BETWEEN:
					return Restrictions.between(propertyName, ((Object[])searchValue)[0], ((Object[])searchValue)[1]);
				default:
					return null;
			}
		}

		public int hashCode() {
			return ((searchProperty != null)?searchProperty.hashCode():0) + ((searchValue != null)?searchValue.hashCode():0) 
					+ mode.ordinal() + ((componentLevel <1)?0:componentLevel);
		}

		public boolean equals(Object other) {
			if (this == other)
				return true;
			if (other == null)
				return false;
			if (!this.getClass().equals(other.getClass()))
				return false;
			AtomicCondition c = (AtomicCondition) other;
			return this.mode == c.mode 
					&& ((searchProperty == null && c.searchProperty == null) || (searchProperty != null) && searchProperty.equals(c.searchProperty))
					&& ((searchValue == null && c.searchValue == null) || (searchValue != null) && searchValue.equals(c.searchValue))
					&& ((componentLevel <1 && c.componentLevel <1) || (componentLevel == c.componentLevel));
		}

		public int compareTo(Condition other) {
			if(other == null)
				throw new NullPointerException();
			if(!this.getClass().equals(other.getClass()))
				return this.getClass().getName().compareTo(other.getClass().getName());
			AtomicCondition o = (AtomicCondition)other;
			int result = this.searchProperty.compareTo(o.searchProperty);
			if (result != 0)
				return result;
			result = this.mode.ordinal() - o.mode.ordinal();
			if (result != 0)
				return result;
			if (this.searchValue instanceof Comparable
					&& this.searchValue.getClass().equals(
							o.searchValue.getClass()))
				return ((Comparable) this.searchValue).compareTo(o.searchValue);
			if (this.searchValue.equals(o.searchValue))
				return 0;
			if(this.searchValue != null && o.searchValue != null)
				return this.searchValue.hashCode() - o.searchValue.hashCode();
			else if(this.searchValue != null || o.searchValue != null)
				return (this.searchValue != null)?1:0;
			else return 0;
		}
	}
	
	private enum ConditionType implements Serializable{
		EQUALS, GREATER, LESSER, LESSER_EQUAL, GREATER_EQUAL, LIKE, LIKE_IGNORE_CASE, LIKE_STARTS_WITH, LIKE_STARTS_WITH_IGNORE_CASE, EQUALS_IGNORE_CASE, EQUALS_CASE_SENSITIVE, IN, NOT_IN, NOT_EQUALS, IS_NULL, IS_NOT_NULL, BETWEEN;
	}

	private class Order implements Serializable {
		private static final long serialVersionUID = -8742403903278798684L;
		private static final byte ASCENDING = 1;
		private static final byte DESCENDING = 2;

		private byte type;
		private boolean ignoreCase = false;
		private String property;
		private int componentLevel;

		private Order(String property, byte type) {
			this.property = property;
			this.type = type;
			this.ignoreCase = false;
		}
		
		private Order(String property, byte type, boolean ignoreCase) {
			this.property = property;
			this.type = type;
			this.ignoreCase = ignoreCase;
		}
		
		private Order(String property, byte type, int componentLevel) {
			this.property = property;
			this.type = type;
			this.ignoreCase = false;
			this.componentLevel = componentLevel;
		}
		
		private Order(String property, byte type, int componentLevel, boolean ignoreCase) {
			this.property = property;
			this.type = type;
			this.ignoreCase = ignoreCase;
			this.componentLevel = componentLevel;
		}
		
		private org.hibernate.criterion.Order getOrder(CriteriaCreator criteriaCreator){
			String propertyName;
			if(componentLevel == 1){
				propertyName = property;
			}else if(componentLevel > 1){
				int tmpIndex = 0;
				for(int i=1; i<componentLevel; i++){
					try{
						tmpIndex = property.indexOf('.', tmpIndex+1);
					}catch(IndexOutOfBoundsException e){
						throw new IllegalArgumentException("Can't find level "+componentLevel+" in property: "+property);
					}
					if(tmpIndex < 1)
						throw new IllegalArgumentException("Can't find level "+componentLevel+" in property: "+property);
				}
				propertyName = criteriaCreator.getCriteria(property.substring(0, tmpIndex)).getAlias() + '.'+
				property.substring(tmpIndex+1);
			}else if(property.indexOf('.') == -1){
				propertyName = property;
			}else{
				propertyName = criteriaCreator.getCriteria(property.substring(0, property.lastIndexOf('.'))).getAlias()
				+ '.' + property.substring(property.lastIndexOf('.')+1);
			}
			if (type == Order.ASCENDING) {
				if(ignoreCase) {
					return org.hibernate.criterion.Order.asc(propertyName).ignoreCase();
				} else {
					return org.hibernate.criterion.Order.asc(propertyName);
				}
			} else {
				if(ignoreCase) {
					return org.hibernate.criterion.Order.desc(propertyName).ignoreCase();
				} else {
					return org.hibernate.criterion.Order.desc(propertyName);
				}
			}
		}
		
		public int hashCode(){
			return (this.property == null)?0:this.property.hashCode() + type + ((componentLevel <1)?0:componentLevel);
		}
		
		public boolean equals(Object other){
			if (this == other)
				return true;
			if (other == null)
				return false;
			if (!this.getClass().equals(other.getClass()))
				return false;
			Order o = (Order) other;
			if(this.type != o.type)
				return false;
			else if((componentLevel >= 1 || o.componentLevel >= 1) && (componentLevel != o.componentLevel))
				return false;
			else if(this.property != null)
				return this.property.equals(o.property);
			else
				return o.property == null;
		}
	}
	
	private class FetchMode implements Serializable {
		private static final long serialVersionUID = -8742403903278798684L;
		
		private org.hibernate.FetchMode type;
		private String property;
		private int componentLevel;

		private FetchMode(String property, org.hibernate.FetchMode type) {
			this.property = property;
			this.type = type;
		}
		
		private FetchMode(String property, org.hibernate.FetchMode type, int componentLevel) {
			this.property = property;
			this.type = type;
			this.componentLevel = componentLevel;
		}
		
		private String getProperty(CriteriaCreator criteriaCreator){
			String propertyName;
			if(componentLevel == 1){
				propertyName = property;
			}else if(componentLevel > 1){
				int tmpIndex = 0;
				for(int i=1; i<componentLevel; i++){
					try{
						tmpIndex = property.indexOf('.', tmpIndex+1);
					}catch(IndexOutOfBoundsException e){
						throw new IllegalArgumentException("Can't find level "+componentLevel+" in property: "+property);
					}
					if(tmpIndex < 1)
						throw new IllegalArgumentException("Can't find level "+componentLevel+" in property: "+property);
				}
				propertyName = criteriaCreator.getCriteria(property.substring(0, tmpIndex)).getAlias() + '.'+
				property.substring(tmpIndex+1);
			}else if(property.indexOf('.') == -1){
				propertyName = property;
			}else{
				propertyName = criteriaCreator.getCriteria(property.substring(0, property.lastIndexOf('.'))).getAlias()
				+ '.' + property.substring(property.lastIndexOf('.')+1);
			}
			return propertyName;
		}
		
		public int hashCode(){
			return (this.property == null)?0:this.property.hashCode() + type.hashCode() + ((componentLevel <1)?0:componentLevel);
		}
		
		public boolean equals(Object other){
			if (this == other)
				return true;
			if (other == null)
				return false;
			if (!this.getClass().equals(other.getClass()))
				return false;
			Order o = (Order) other;
			if(!this.type.equals(o.type))
				return false;
			else if((componentLevel >= 1 || o.componentLevel >= 1) && (componentLevel != o.componentLevel))
				return false;
			else if(this.property != null)
				return this.property.equals(o.property);
			else
				return o.property == null;
		}
	}
	
	private class OrCondition implements CollectiveCondition{
		private static final long serialVersionUID = -3060921921082770683L;
		
		private Set<Condition> conditions;
		private CollectiveCondition parent;
		
		private OrCondition(CollectiveCondition parent){
			this.parent = parent;
		}
		
		public Criterion getCriterion(CriteriaCreator criteriaCreator){
			Criterion finalCriterion = null, curentCtiterion = null;
			if(conditions != null && conditions.size() > 0){
				for(Condition condition: conditions){
					curentCtiterion = condition.getCriterion(criteriaCreator);
					if(finalCriterion == null)
						finalCriterion = curentCtiterion;
					else if(curentCtiterion != null)
						finalCriterion = Restrictions.or(finalCriterion, curentCtiterion);
				}
			}
			return finalCriterion;
		}
		
		public void addCondition(Condition condition){
			if(conditions == null)
				conditions = new HashSet<Condition>();
			conditions.add(condition);
		}
		
		public void clearConditions() {
			conditions = null;
		}
		
		public CollectiveCondition getParent() {
			return parent;
		}
		
		public int hashCode(){
			return ((conditions == null)?0:conditions.hashCode()) + ((parent == null)?0:parent.hashCode());
		}
		
		public boolean equals(Object other){
			if (this == other)
				return true;
			if (other == null)
				return false;
			if (!this.getClass().equals(other.getClass()))
				return false;
			OrCondition oc = (OrCondition)other;
			if((parent == null && oc.parent == null) || (parent != null && parent.equals(oc.parent))){
				return (conditions == null && oc.conditions == null) || (conditions != null && conditions.equals(oc.conditions));
			}else
				return false;
		}
	}
	
	private class AndCondition implements CollectiveCondition{
		private static final long serialVersionUID = -2921814238292541165L;
		
		private Set<Condition> conditions;
		private CollectiveCondition parent;

		private AndCondition(CollectiveCondition parent){
			this.parent = parent;
		}
		public Criterion getCriterion(CriteriaCreator criteriaCreator){
			Criterion finalCriterion = null, curentCtiterion = null;
			if(conditions != null && conditions.size() > 0){
				for(Condition condition: conditions){
					curentCtiterion = condition.getCriterion(criteriaCreator);
					if(finalCriterion == null)
						finalCriterion = curentCtiterion;
					else if(curentCtiterion != null)
						finalCriterion = Restrictions.and(finalCriterion, curentCtiterion);
				}
			}
			return finalCriterion;
		}
		
		public void addCondition(Condition condition){
			if(conditions == null)
				conditions = new HashSet<Condition>();
			conditions.add(condition);
		}
		
		public void clearConditions() {
			conditions = null;
		}
		
		public CollectiveCondition getParent() {
			return parent;
		}
		
		public int hashCode(){
			return ((conditions == null)?0:conditions.hashCode()) + ((parent == null)?0:parent.hashCode());
		}
		
		public boolean equals(Object other){
			if (this == other)
				return true;
			if (other == null)
				return false;
			if (!this.getClass().equals(other.getClass()))
				return false;
			AndCondition ac = (AndCondition)other;
			if((parent == null && ac.parent == null) || (parent != null && parent.equals(ac.parent))){
				return (conditions == null && ac.conditions == null) || (conditions != null && conditions.equals(ac.conditions));
			}else
				return false;
		}
	}
	
	private class CriteriaCreator implements Serializable{
		private static final long serialVersionUID = 3888645899955538157L;
		
		private Criteria parentCriteria;
		private Map<String, Criteria> criteriaMap;
		
		public CriteriaCreator(Criteria baseCriteria){
			this.parentCriteria = baseCriteria;
			criteriaMap = new HashMap<String, Criteria>();
			criteriaMap.put("", parentCriteria);
		}
		
		public Criteria getCriteria(String criteriaName){
			if(criteriaName.length() == 0)
				return parentCriteria;
			else{
				int startIndex = 0;
				int nextIndex = criteriaName.indexOf('.');
				String key = "_";
				String keyIncrement;
				Criteria currentCriteria = parentCriteria;
				boolean searchInMap = true;
				while (nextIndex > 0){
					keyIncrement = criteriaName.substring(startIndex, nextIndex);
					key += keyIncrement;
					if (searchInMap && criteriaMap.get(key) != null) {
						currentCriteria = criteriaMap.get(key);
					} else {
						currentCriteria = currentCriteria.createCriteria(keyIncrement, key);
						criteriaMap.put(key, currentCriteria);
						searchInMap = false;
					}
					startIndex = nextIndex + 1;
					nextIndex = criteriaName.indexOf('.', startIndex);
					key += '_';
				}
				keyIncrement = criteriaName.substring(startIndex);
				key += keyIncrement;
				if (searchInMap && criteriaMap.get(key) != null) {
					currentCriteria = criteriaMap.get(key);
				} else {
					currentCriteria = currentCriteria.createCriteria(keyIncrement, key);
					criteriaMap.put(key, currentCriteria);
				}
				return currentCriteria;
			}
		}
	}
	
	private interface CollectiveCondition extends Condition{
		void addCondition(Condition condition);
		void clearConditions();
		CollectiveCondition getParent();
	}
	
	private interface Condition extends Serializable{
		Criterion getCriterion(CriteriaCreator criteriaCreator);
	}
}
