package com.hannover.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.annotation.ejb.RemoteBinding;

import com.hannover.dao.DAOFactory;
import com.hannover.dao.PatientClaimDetailDAO;
import com.hannover.dao.TrendsDAO;
import com.hannover.dao.UploadDetailDAO;
import com.hannover.exception.DAOException;
import com.hannover.helper.SearchVO;
import com.hannover.model.PatientClaimDetail;
import com.hannover.model.Trends;
import com.hannover.model.UploadDetail;

@Stateless
@Remote(SaveExcelService.class)
@RemoteBinding(jndiBinding="SaveExcelService")

public class SaveExcelServiceImpl implements SaveExcelService {
	PatientClaimDetailDAO dao = (PatientClaimDetailDAO) DAOFactory.getDAOInstance(PatientClaimDetailDAO.class);
	UploadDetailDAO uploadDao = (UploadDetailDAO) DAOFactory.getDAOInstance(UploadDetailDAO.class);
	TrendsDAO trendsDao = (TrendsDAO)DAOFactory.getDAOInstance(TrendsDAO.class);
	
	public void createPatientCliamDetails(List<PatientClaimDetail> pdList){
		try {
			dao.create(pdList);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<PatientClaimDetail> getFailedTrends(){
		SearchVO searchVO = new SearchVO();
		searchVO.addIsNotNullCondition("ruleStatus");
		searchVO.addEqualsCondition("uploadDetailsId", getLatestUploadData().getId());
		List<PatientClaimDetail> pcdList = new ArrayList<PatientClaimDetail>();
		try {
			pcdList =  dao.search(searchVO);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return pcdList;
	}
	
	public UploadDetail uploadFileDetails(UploadDetail uploadDetail){
		try {
			uploadDetail = uploadDao.create(uploadDetail);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return uploadDetail;
	}
	
	public UploadDetail updateUploadFileDetails(UploadDetail uploadDetail){
		try {
			uploadDetail = uploadDao.createOrUpdate(uploadDetail);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return uploadDetail;
	}
	
	public String getCSVFileData(String state, String year, String month){
		String csvData = null;
		SearchVO searchVO = new SearchVO();
		searchVO.addEqualsCondition("state", state);
		searchVO.addEqualsCondition("year", year);
		searchVO.addEqualsCondition("month", month);
		try{
			UploadDetail ud = uploadDao.searchUnique(searchVO);
			csvData = ud.getCsvfile();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvData;
	}
	
	public UploadDetail getUploadData(String state, String year, String month){
		UploadDetail ud = null;
		SearchVO searchVO = new SearchVO();
		searchVO.addEqualsCondition("state", state);
		searchVO.addEqualsCondition("year", year);
		searchVO.addEqualsCondition("month", month);
		try{
			ud = uploadDao.searchUnique(searchVO);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return ud;
	}
	
	
	public String getPieData(Long uploadDetailsId){
		StringBuffer sb = new StringBuffer();
		try{
			List<String> pieDataList = dao.getPieData(uploadDetailsId);
			for(String pieData: pieDataList){
				sb.append(pieData);
				sb.append("\n");
			}
		} catch(DAOException de){
			de.printStackTrace();
		}
		return sb.toString();
	}
	
	public String getCSVAIData(){
		String csvData = null;
		SearchVO searchVO = new SearchVO();
		searchVO.addOrderDescending("id");
		searchVO.setPageNumber(1);
		searchVO.setPageSize(1);
		try{
			UploadDetail ud = uploadDao.searchUnique(searchVO);
			if(ud != null)
				csvData = ud.getCsvfileAi();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvData;
	}
	
	public String getCSVBIData(){
		String csvData = null;
		SearchVO searchVO = new SearchVO();
		searchVO.addOrderDescending("id");
		searchVO.setPageNumber(1);
		searchVO.setPageSize(1);
		try{
			UploadDetail ud = uploadDao.searchUnique(searchVO);
			if(ud != null)
				csvData = ud.getCsvfile();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvData;
	}
	
	public UploadDetail getLatestUploadData(){
		UploadDetail ud = null;
		SearchVO searchVO = new SearchVO();
		searchVO.addOrderDescending("id");
		searchVO.setPageNumber(1);
		searchVO.setPageSize(1);
		try{
			ud = uploadDao.searchUnique(searchVO);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return ud;
	}
	
	public void saveTrend(Trends trend){
		try{
			trendsDao.createOrUpdate(trend);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Trends> getTrends(){
		try{
			SearchVO searchVO = new SearchVO();
			return trendsDao.search(searchVO);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Trends getTrend(Long id){
		try{
			SearchVO searchVO = new SearchVO();
			searchVO.addEqualsCondition("id", id);
			return trendsDao.searchUnique(searchVO);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
