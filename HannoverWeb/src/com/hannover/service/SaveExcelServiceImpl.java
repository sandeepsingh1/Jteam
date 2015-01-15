package com.hannover.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.annotation.ejb.RemoteBinding;

import com.hannover.dao.DAOFactory;
import com.hannover.dao.PatientClaimDetailDAO;
import com.hannover.exception.DAOException;
import com.hannover.helper.SearchVO;
import com.hannover.model.PatientCliamDetail;

@Stateless
@Remote(SaveExcelService.class)
@RemoteBinding(jndiBinding="SaveExcelService")

public class SaveExcelServiceImpl implements SaveExcelService {
	PatientClaimDetailDAO dao = (PatientClaimDetailDAO) DAOFactory.getDAOInstance(PatientClaimDetailDAO.class);

	public void createPatientCliamDetails(List<PatientCliamDetail> pdList){
		try {
			dao.create(pdList);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<PatientCliamDetail> getFailedTrends(){
		SearchVO searchVO = new SearchVO();
		searchVO.addIsNotNullCondition("ruleStatus");
		List<PatientCliamDetail> pcdList = new ArrayList<PatientCliamDetail>();
		try {
			pcdList =  dao.search(searchVO);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return pcdList;
	}

}
