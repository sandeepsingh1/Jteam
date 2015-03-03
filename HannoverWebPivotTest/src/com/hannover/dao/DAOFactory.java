package com.hannover.dao;

import java.util.HashMap;
import java.util.Map;

import com.hannover.model.PO;


/**
 * This class is the factory for DAO implementation instances.
 * We provide a DAO interface to it and it returns the implementation instance.
 * @author piyush.mittal
 *
 */
public class DAOFactory {

	private static final Map<Class<? extends DAO<? extends PO>>, DAO<? extends PO>> daoStore = new HashMap<Class<? extends DAO<? extends PO>>, DAO<? extends PO>>();
	private static final Map<Class<? extends PO>, DAO<? extends PO>> poDaoMap = new HashMap<Class<? extends PO>, DAO<? extends PO>>();
	private static final Map<Class<? extends PO>, DAO<? extends PO>> poStagingDaoMap = new HashMap<Class<? extends PO>, DAO<? extends PO>>();
	/**
	 * Returns the instance of the DAOImpl class
	 * based on the name of the DAO interface.
	 * @param interfaceName
	 * @return
	 */
	public static DAO getDAOInstance(String interfaceName){
		try{
			return (DAO)(Class.forName(interfaceName+"Impl").newInstance());
		}
		catch(ClassNotFoundException ex){
			throw new RuntimeException("Error in instantiating DAO implememtation class.",ex);
		}
		catch(IllegalAccessException ex){
			throw new RuntimeException("Error in instantiating DAO implememtation class.",ex);
		}
		catch(InstantiationException ex){
			throw new RuntimeException("Error in instantiating DAO implememtation class.",ex);
		}
	}
	
	/**
	 * Returns the instance of the DAOImpl class
	 * based on the DAO interface class.
	 * @param interfaceName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <S extends PO,T extends DAO<S>> T getDAOInstance(Class<T> DAOInterface){
		T instance = (T)daoStore.get(DAOInterface.getName());
		if(instance != null)
			return instance;
		else{
			try{
				instance = (T)getDAOInstance(DAOInterface.getName());
				daoStore.put(DAOInterface, instance);
				return instance;
			}catch(RuntimeException e){
				System.out.println("RuntimeException while creating DAO of type: "+DAOInterface.getName());
				throw e;
			}
		}
	}
	
	public static <T extends PO> DAO<T> getDAO(Class<T> poClass){
		DAO<T> dao = (DAO<T>)poDaoMap.get(poClass);
		if(dao != null)
			return dao;
		else{
			dao = new DAOImpl<T>(poClass);
			poDaoMap.put(poClass, dao);
			return dao;
		}
	}
	

}
