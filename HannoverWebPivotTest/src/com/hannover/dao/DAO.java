package com.hannover.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hannover.exception.DAOException;
import com.hannover.helper.SearchVO;
import com.hannover.model.PO;


/**
 * Interface for accessing DAO layer.
 *
 * @param <T>
 */
public interface DAO<T extends PO> {
	/**
	 * Creates a record in the database.
	 * @param po
	 * @return
	 */
	public T create(T po) throws DAOException;
	
	/**
	 * Creates a list of records in the database.
	 * @param po
	 * @return
	 */
	public Collection<T> create(Collection<T> poList) throws DAOException;

	/**
	 * Updates a record in the database.
	 * @param po
	 * @return
	 */
	public T update(T po) throws DAOException;
	
	/**
	 * Updates a list of records in the database.
	 * @param po
	 * @return
	 */
	public Collection<T> update(Collection<T> poList) throws DAOException;
	
	/**
	 * Fetches a record from database based on its primary key.
	 * @param id
	 * @return
	 */
	public T read(Serializable id) throws DAOException;
	
	/**
	 * Deletes a record from database based on its primary key.
	 * @param id
	 */
	public void delete(Serializable id) throws DAOException;
	
	/**
	 * searches and results list of POJOs matching conditions provided
	 * @param searchVO
	 * @return list of POJOs matching the conditions provided
	 * @throws DAOException
	 * Do not mention any order or fetch size in searchVO
	 */
	public List<T> search(SearchVO searchVO) throws DAOException;
	
	/**
	 * Returns count of rows matching conditions provided
	 * @param searchVO
	 * @return Integer count of rows matching conditions
	 * @throws DAOException
	 */
	public Integer count(SearchVO searchVO) throws DAOException;
	
	/**
	 * Searches and results a unique POJO matching conditions provided
	 * @param searchVO
	 * @return list of POJOs matching the conditions provided
	 * @throws DAOException. Please note that exception will also be
	 * thrown if criteria defined in SearchVO return more than 1 result
	 */
	public T searchUnique(SearchVO searchVO) throws DAOException;
	
	/**
	 * Updates/Creates a record in the database according to its availability in DB.
	 * @param po
	 * @return
	 */
	public T createOrUpdate(T po) throws DAOException;
	
	/**
	 * Checks for uniqueness on given property value. If check is for insertion (id == null), 
	 * returns true if no element exists with given value of given property. If check is for
	 * update (id != null), returns true if no element exists for given value of given property
	 * or only one element exists that too with same id as provided. if value is String, it will
	 * be matched on equalsIgnoreCase basis
	 * @param property name of property that has to be searched
	 * @param value value of the property to be matched in database
	 * @param id id of element (to be provided only in update operation) in database
	 * @return
	 * @throws DAOException
	 */
	public boolean verifyUnique(String property, Object value, Serializable id) throws DAOException;
	
	public boolean verifyCompositeUnique(Map<String, Object> parameterValPair, Serializable id) throws DAOException;
}
