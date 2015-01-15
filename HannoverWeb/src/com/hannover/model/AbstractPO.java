package com.hannover.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

/**
 * Abstract class, all POs should extend it.
 * @author Piyush.Mittal
 *
 */
public abstract class AbstractPO implements PO {

	public boolean equals(Object other){
		if(this == other)
			return true;
		if (other == null)
			return false;
		if(!getClass().equals(other.getClass()))
			return false;
		return this.getId().equals(((PO)other).getId());
	}
	
	 @Override
	public int hashCode() {
		 int hashCode;
		if(this != null && this.getId()!= null){
			hashCode = this.getId().hashCode();
		}else{
			hashCode = super.hashCode();
		}
		return hashCode;
	}
	
	public Object clone(){
		try {
			return super.clone();
		} 
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	/**
	 * Checks for the mandatory parameters in the 
	 * @return
	 */
	public List<String> checkForMandatoryParameters(){
		List<String> missingParameters = new ArrayList<String>();
		try{
			for (Method m : getClass().getMethods()) {
				if(!"getId".equalsIgnoreCase(m.getName())){
					if (m.isAnnotationPresent(Column.class)){
						Column column = m.getAnnotation(Column.class);
						if((!column.nullable() || column.unique())&& 
								m.invoke(this, null) == null){
							missingParameters.add(column.name());
						}
					}
				}
			}
		}
		catch(IllegalAccessException iae){
			return null;
		}
		catch(InvocationTargetException ite){
			return null;
		}
		if(missingParameters.size() >0)
			return missingParameters;
		else
			return null;
	}
}
