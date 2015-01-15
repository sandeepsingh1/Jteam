package com.hannover.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hannover.exception.DAOException;
import com.hannover.helper.HibernateUtil;
import com.hannover.helper.SearchVO;
import com.hannover.model.PO;

/**
 * Exposes the basic create, update, search, delete methods
 * for all the DAOs.
 *
 * @param <T>
 */
public class DAOImpl<T extends PO> implements DAO<T> {

	/**
	 * Logger instance.
	 */
	private Class<T> poClass;
	
	protected DAOImpl(){
		poClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	DAOImpl(Class<T> poClass){
		this.poClass = poClass;
	}
	
	/**
	 * Creates a record in the database.
	 * @param po
	 * @return
	 */
	public T create(T po) throws DAOException{
		System.out.println("Entering :: DAOImpl:create()");
		try{
			Session session = getCurrentSession();
			session.beginTransaction();
			session.save(po);
			session.close();
			//flushSession();
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		System.out.println("Exiting :: DAOImpl:create()");
		return po;
	}

	/**
	 * Creates a list of records in the database.
	 * @param po
	 * @return
	 */
	public Collection<T> create(Collection<T> poList) throws DAOException{
		System.out.println("Entering :: DAOImpl:create(Collection<T>)");
		
		if(poList == null || poList.size() == 0){
			return poList;
		}

		try{
			Session session = getCurrentSession();
			session.beginTransaction();
			for(T po : poList) {
				session.save(po);
			}
			session.getTransaction().commit();
			//flushSession();
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		System.out.println("Exiting :: DAOImpl:create(Collection<T>)");
		return poList;
	}

	/**
	 * Fetches a record from database based on its primary key.
	 * @param id
	 * @return
	 */
	public T read(Serializable id) throws DAOException{
		System.out.println("Entering :: DAOImpl:read()");
		try{
			Session session = getCurrentSession();
			return (T)session.get(getPOClass(), id);
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
	}

	/**
	 * Updates a record in the database.
	 * @param po
	 * @return
	 */
	public T update(T po) throws DAOException{
		System.out.println("Entering :: DAOImpl:update()");
		Session session = null;
		try{
			session = getCurrentSession();
			session.update(po);
			flushSession();
		}
		catch(NonUniqueObjectException nuoe){
			session.merge(po);
			flushSession();
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		System.out.println("Exiting :: DAOImpl:update()");
		return po;
	} 
	
	/**
	 * Updates a list of records in the database.
	 * @param po
	 * @return
	 */
	public Collection<T> update(Collection<T> poList) throws DAOException{
		System.out.println("Entering :: DAOImpl:update(Collection<T>)");
		
		if(poList == null || poList.size() == 0){
			return poList;
		}

		try{
			Session session = getCurrentSession();
			for(T po : poList) {
				try{
					session.update(po);
				}catch(NonUniqueObjectException nuoe){
					session.merge(po);
					flushSession();
				}
			}
			flushSession();
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		System.out.println("Exiting :: DAOImpl:update(Collection<T>)");
		return poList;
	} 
	
	/**
	 * Deletes a record from database based on its primary key.
	 * @param id
	 */
	public void delete(Serializable id) throws DAOException{
		System.out.println("Entering :: DAOImpl:delete()");
		try{
			Session session = getCurrentSession();
			Object po = session.load(getPOClass(), id);
			if(po != null){
				session.delete(po);
			}
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		System.out.println("Exiting :: DAOImpl:delete()");
	}
	
	/**
	 * Searches and returns list of POJOs matching conditions provided
	 * @param searchVO
	 * @return list of POJOs matching the conditions provided
	 * @throws DAOException
	 */
	public List<T> search(SearchVO searchVO) throws DAOException{
		System.out.println("Entering :: DAOImpl:search()");
		List<T> list = new ArrayList<T>();
		try{
			Transaction tx = getCurrentSession().beginTransaction();
			Criteria criteria = getCriteria();
			if(searchVO != null)
				searchVO.buildSearchCriteria(criteria);
			System.out.println("Exiting :: DAOImpl:search()");
			list = (List<T>)criteria.list();
			tx.commit();
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		return list;
	}
	
	/**
	 * Returns count of rows matching conditions provided
	 * @param searchVO
	 * @return Integer count of rows matching conditions
	 * @throws DAOException
	 */
	public Integer count(SearchVO searchVO) throws DAOException{
		System.out.println("Entering :: DAOImpl:count()");
		try{
			Criteria criteria = getCriteria();
			searchVO.buildCountCriteria(criteria);
			System.out.println("Exiting :: DAOImpl:count()");
			return new Integer(criteria.list().get(0).toString());
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
	}
	
	/**
	 * Searches and results a unique POJO matching conditions provided
	 * @param searchVO
	 * @return list of POJOs matching the conditions provided
	 * @throws DAOException. Please note that exception will also be
	 * thrown if criteria defined in SearchVO return more than 1 result
	 */
	public T searchUnique(SearchVO searchVO) throws DAOException{
		System.out.println("Entering :: DAOImpl:search()");
		try{
			Criteria criteria = getCriteria();
			searchVO.buildSearchCriteria(criteria);
			System.out.println("Exiting :: DAOImpl:search()");
			return (T)criteria.uniqueResult();
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
	}
	
	/**
	 * Updates/Creates a record in the database according to its availability in DB.
	 * @param po
	 * @return
	 */
	public T createOrUpdate(T po) throws DAOException{
		System.out.println("Entering :: DAOImpl:saveOrUpdate()");
		Session session = null;
		try{
			session = getCurrentSession();
			session.saveOrUpdate(po);
			flushSession();
		} catch(NonUniqueObjectException nuoe){
			session.merge(po);
			flushSession();
		} catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		System.out.println("Exiting :: DAOImpl:search()");
		return po;
	}
	
	/**
	 * Checks for the uniqueness of the parameter.
	 */
	public boolean verifyUnique(String property, Object value, Serializable id) throws DAOException{
		try{
			Criteria criteria = getCriteria();
			if(value instanceof String)
				criteria.add(Restrictions.ilike(property, (String)value,MatchMode.EXACT));
			else
				criteria.add(Restrictions.eq(property, value));
			List<T> list = (List<T>)criteria.list();
			if(list == null || list.size() == 0){
				return true;
			}else{
				if(list.size() > 1){
					return false;
				}else{
					if(id == null)
						return false;
					else
						return id.equals(list.get(0).getId());
				}
			}
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
	}
	
	/**
	 * Checks for the uniqueness of the composite parameter set.
	 */
	public boolean verifyCompositeUnique(Map<String, Object> parameterValPair, Serializable id) throws DAOException{
		try{
			Criteria criteria = getCriteria();
			Set<String> keys = parameterValPair.keySet();
			Iterator<String> iter = keys.iterator();
			while(iter.hasNext()){
				String property = iter.next();
				Object value = parameterValPair.get(property);
				if(value instanceof String)
					criteria.add(Restrictions.ilike(property, (String)value,MatchMode.EXACT));
				else
					criteria.add(Restrictions.eq(property, value));
			}
			List<T> list = (List<T>)criteria.list();
			if(list == null || list.size() == 0){
				return true;
			}else{
				if(list.size() > 1){
					return false;
				}else{
					if(id == null)
						return false;
					else
						return id.equals(list.get(0).getId());
				}
			}
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
	}
	/*
	 * This method will return a Hibernate Query based on string (HQL) provided
	 */
	protected Query createQuery(String query){
		try{
			return getCurrentSession().createQuery(query);
		}catch(HibernateException he){
			System.out.println(he);
			return null;
		}
	}
	
	protected SQLQuery createSQLQuery(String query){
		try{
			return getCurrentSession().createSQLQuery(query);
		}catch(HibernateException he){
			System.out.println(he);
			return null;
		}
	}
	/**
	 * Returns the Persistent class.
	 * @return
	 */
	protected Class<? extends PO> getPOClass(){
		return poClass;
	}
	
	/**
	 * Returns the session factory's singleton object.
	 * @return
	 */
	protected SessionFactory getSessionFactory(){
		return HibernateUtil.getSessionFactory();
	}
	
	/**
	 * Returns the current session.
	 * @return
	 */
	protected Session getCurrentSession(){
		return HibernateUtil.getCurrentSession();
	}
	
	/**
	 * Returns the criteria object for the current session.
	 * @return
	 */
	protected Criteria getCriteria(){
		return HibernateUtil.getCurrentSession().createCriteria(getPOClass());
	}
	
	/**
	 * Flushes the current session.
	 */
	protected void flushSession(){
		HibernateUtil.getCurrentSession().flush();
	}
}
