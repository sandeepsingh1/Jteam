package com.hannover.dao;

import com.hannover.model.PO;
import com.hannover.model.PatientCliamDetail;


/**
 * Exposes the CRUD functionalities for ImageType table.
 * 
 * 
 */
//private static FAILED_QUERY ="select 'Failed' as status, trend_name||'<br>'||disease_name as trend_name , count(*), (select  count(*) from patient_cliam_details) from patient_cliam_details where rule_status is not null group by  trend_name, disease_name;";
//private static PASSED_QUERY ="select 'Passed' as status, '' as trend_name, count(*), (select  count(*) from patient_cliam_details) from patien	t_cliam_details where rule_status is null;";

public class PatientClaimDetailDAOImpl extends DAOImpl<PatientCliamDetail> implements
		PatientClaimDetailDAO {
	@Override
	protected Class<? extends PO> getPOClass() {
		return PatientCliamDetail.class;
	}
	

}
