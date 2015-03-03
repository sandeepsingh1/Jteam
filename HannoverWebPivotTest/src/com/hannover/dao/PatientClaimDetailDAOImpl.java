package com.hannover.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import com.hannover.exception.DAOException;
import com.hannover.model.PO;
import com.hannover.model.PatientClaimDetail;


/**
 * Exposes the CRUD functionalities for PaitientCliamDetails table.
 * 
 * 
 */
public class PatientClaimDetailDAOImpl extends DAOImpl<PatientClaimDetail> implements
		PatientClaimDetailDAO {
	private static String PIE_QUERY = "select 'Failed' ||'#'||trend_name||'<br>'||disease_name||'~~~'|| round(100.0 * count(*)/(select  count(*) from patient_claim_details), 2)||'%~~~' as trend_name from patient_claim_details where rule_status is not null and upload_details_id = uploadDetailsId  group by  trend_name, disease_name union select 'Passed'||'~~~'|| round(100.0 * count(*)/(select  count(*) from patient_claim_details), 2)||'%' as trend_name from patient_claim_details where rule_status is null and upload_details_id = uploadDetailsId ";

	@Override
	protected Class<? extends PO> getPOClass() {
		return PatientClaimDetail.class;
	}
	
	public List<String> getPieData(Long uploadDetailsId) throws DAOException{
		System.out.println("Entering :: getPieData()");
		List<String> pieDataList = new ArrayList<String>();
		try{
			Transaction tx = getCurrentSession().beginTransaction();
			PIE_QUERY = PIE_QUERY.replaceAll("uploadDetailsId", uploadDetailsId.toString());
			SQLQuery query = getCurrentSession().createSQLQuery(PIE_QUERY);
			query.addScalar("trend_name", Hibernate.STRING);
			pieDataList = (List<String>) query.list();
			tx.commit();
		}
		catch(HibernateException he){
			System.out.println(he);
			throw new DAOException(he);
		}
		return pieDataList;
	}
	

}
