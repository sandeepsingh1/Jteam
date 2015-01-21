package com.hannover.dao;

import java.util.List;

import com.hannover.exception.DAOException;
import com.hannover.model.PatientClaimDetail;


/**
 * Exposes the CRUD functionalities for the ImageType table.
 * 
 */
public interface PatientClaimDetailDAO extends DAO<PatientClaimDetail> {
	public List<String> getPieData(Long uploadDetailsId) throws DAOException;
}
