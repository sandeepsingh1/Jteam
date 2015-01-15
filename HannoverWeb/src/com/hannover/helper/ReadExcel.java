package com.hannover.helper;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;

import com.hannover.model.AdmissionDetail;
import com.hannover.model.ClaimDetail;
import com.hannover.model.DiseaseDetail;
import com.hannover.model.HospitalDetail;
import com.hannover.model.PackageDetail;
import com.hannover.model.PatientCliamDetail;
import com.hannover.model.PatientDetail;
import com.hannover.service.SaveExcelService;
import com.hannover.service.SaveExcelServiceImpl;


	public class ReadExcel {

	    @SuppressWarnings("unchecked")
    public static void uploadFile(InputStream file) throws Exception {
            KnowledgeBase kbase = RunRules.readKnowledgeBase();
            List<String> list = new ArrayList<String>( );
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            ksession.setGlobal("list", list);
            //KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
	    	//Get the workbook instance for XLS file 
	    	XSSFWorkbook workbook = new XSSFWorkbook(file);
	    	SimpleDateFormat sdf  = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	    	SimpleDateFormat sdf2  = new SimpleDateFormat("MM/dd/yyyy");
	    	//Get first sheet from the workbook
	    	XSSFSheet sheet = workbook.getSheetAt(0);
	    	//Get iterator to all the rows in current sheet
	    	PatientDetail pd = null;
	    	PackageDetail pkd = null;
	    	ClaimDetail cd = null;
	    	HospitalDetail hd = null;
	    	DiseaseDetail dd = null;
	    	AdmissionDetail ad = null;
//	    	List<PatientDetail> pdSet = new ArrayList<PatientDetail>();
//	    	Set<HospitalDetail> hdSet = new HashSet<HospitalDetail>();
//	    	Set<DiseaseDetail> ddSet = new HashSet<DiseaseDetail>();
//	    	Set<PackageDetail> pkgSet = new HashSet<PackageDetail>();
//	    	List<ClaimDetail> cdList = new ArrayList<ClaimDetail>();
//	    	List<AdmissionDetail> adList = new ArrayList<AdmissionDetail>();
	    	List<PatientCliamDetail> pcdList = new ArrayList<PatientCliamDetail>();
	    	PatientCliamDetail patientCliamDetail = null;
	    	for(Row row: sheet){
	    		if(row.getRowNum() !=0){
		    		ad = new AdmissionDetail();
		    		pd = new PatientDetail();
		    		pkd = new PackageDetail();
		    		cd = new ClaimDetail();
		    		hd = new HospitalDetail();
		    	    dd = new DiseaseDetail();
		    	    patientCliamDetail = new PatientCliamDetail();
		    	    
		    	    String admissionDate = null;
		    	    String dischargeDate = null;
		    	    String blockTxnDate = null;
		    	    String claimTxnDate = null;
		    		Iterator<Cell> cellIterator = row.cellIterator();
		    		while(cellIterator.hasNext()){
		    			Cell cell = cellIterator.next();
		    			int cellIndex = cell.getColumnIndex();
		    			
		    			if(cellIndex == 1){
		    				pd.setUrn(getStringValue(cell));
		    				patientCliamDetail.setUrn(getStringValue(cell));
		    			}
//		    			else if(cellIndex == 2){
//		    				pd.setHofName(getStringValue(cell));
//		    			}
		    			else if(cellIndex == 3){
		    				try{
		    					ad.setPatientAge(BigDecimal.valueOf(cell.getNumericCellValue()));
		    					patientCliamDetail.setPatientAge(BigDecimal.valueOf(cell.getNumericCellValue()));
		    				}catch(Exception e){
//		    					ad.setPatientAge(BigDecimal.valueOf(0));
//		    					patientCliamDetail.setPatientAge(BigDecimal.valueOf(0));
		    					String val = cell.getStringCellValue();
		    					BigDecimal dVal = null;
		    					try{
		    						dVal = new BigDecimal(val);
		    					}catch(NumberFormatException ne){
		    						dVal = BigDecimal.valueOf(0);
		    					}
		    					ad.setPatientAge(dVal);
		    					patientCliamDetail.setPatientAge(dVal);
		    				}
		    			}
//		    			else if(cellIndex == 4){
//		    				pd.setGender(getStringValue(cell));
//		    				patientCliamDetail.setGender(getStringValue(cell));
//		    			}
		    			else if(cellIndex == 5){
		    				pd.setPatientName(getStringValue(cell));
		    				patientCliamDetail.setPatientName(getStringValue(cell));
		    			}
//		    			else if(cellIndex == 6){
//		    				ad.setRelation(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 7){
//		    				admissionDate = getStringValue(cell);
//		    			}
//		    			else if(cellIndex == 8){
//		    				admissionDate = admissionDate+" "+getStringValue(cell);
//		    				ad.setAdmissionDate(sdf.parse(admissionDate));
//		    			}
//		    			else if(cellIndex == 9){
//		    				dischargeDate = getStringValue(cell);
//		    			}
//		    			else if(cellIndex == 10){
//		    				dischargeDate = dischargeDate+" "+getStringValue(cell);
//		    				ad.setDischargeDate(sdf.parse(dischargeDate));
//		    			}
		    			if(cellIndex == 11){
		    				try{
		    					ad.setNumberOfDays(BigDecimal.valueOf(cell.getNumericCellValue()));
			    				patientCliamDetail.setNumberOfDays(BigDecimal.valueOf(cell.getNumericCellValue()));
		    				}catch(Exception e){
		    					String val = cell.getStringCellValue();
		    					BigDecimal dVal = null;
		    					try{
		    						dVal = new BigDecimal(val);
		    					}catch(NumberFormatException ne){
		    						dVal = BigDecimal.valueOf(0);
		    					}
		    					ad.setNumberOfDays(dVal);
		    					patientCliamDetail.setNumberOfDays(dVal);
		    				}
		    			}
//		    			else if(cellIndex == 12){
//		    				pd.setBeneficiaryDistrictName(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 13){
//		    				pd.setBeneficiaryBlockName(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 14){
//		    				pd.setBeneficiaryPanchayatName(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 15){
//		    				pd.setBeneficiaryVillageName(getStringValue(cell));
//		    			}
		    			else if(cellIndex == 16){
		    				hd.setHospitalName(getStringValue(cell));
		    				patientCliamDetail.setHospitalName(getStringValue(cell));
		    			}
		    			else if(cellIndex == 17){
		    				hd.setHospitalCode(getStringValue(cell));
		    			}
//		    			else if(cellIndex == 18){
//		    				hd.setHospitalDistrictName(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 19){
//		    				hd.setHospitalType(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 20){
//		    				pd.setMemberId(getStringValue(cell));
//		    			}
		    			else if(cellIndex == 21){
		    				dd.setDiseaseName(getStringValue(cell));
		    				patientCliamDetail.setDiseaseName(getStringValue(cell));
		    			}
//		    			else if(cellIndex == 22){
//		    				dd.setDiseaseType(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 23){
//		    				pkd.setPackageCode(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 24){
//		    				pkd.setPackageName(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 25){
//		    				cd.setTransactionCode(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 26){
//		    				blockTxnDate = getStringValue(cell);
//		    			}
//		    			else if(cellIndex == 27){
//		    				blockTxnDate = blockTxnDate+" "+getStringValue(cell);
//		    				cd.setBlockTxnDate(sdf.parse(blockTxnDate));
//		    			}
//		    			else if(cellIndex == 28){
//		    				claimTxnDate = getStringValue(cell);
//		    			}
//		    			else if(cellIndex == 29){
//		    				claimTxnDate = claimTxnDate+" "+getStringValue(cell);
//		    				cd.setClaimTxnDate(sdf.parse(claimTxnDate));
//		    			}
//		    			else if(cellIndex == 30){
//		    				cd.setTransactionStatus(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 31){
//		    				try{
//		    					cd.setTravelAmtTillDate(Double.valueOf(cell.getNumericCellValue()).longValue());
//		    				}catch(Exception e){
//		    					cd.setTravelAmtTillDate(Long.valueOf(0));
//		    				}
//		    			}
//		    			else if(cellIndex == 32){
//		    				cd.setUploadDate(sdf2.parse(getStringValue(cell)));
//		    			}
//		    			else if(cellIndex == 33){
//		    				cd.setFloatRecDate(sdf2.parse(getStringValue(cell)));
//		    			}
//		    			else if(cellIndex == 34){
//		    				try{
//		    					cd.setClaimedAmount(Double.valueOf(cell.getNumericCellValue()).longValue());
//		    				}catch(Exception e){
//		    					cd.setClaimedAmount(Long.valueOf(0));
//		    				}
//		    			}
//		    			else if(cellIndex == 35){
//		    				try{
//		    					cd.setApprovedAmount(Double.valueOf(cell.getNumericCellValue()).longValue());
//		    				}catch(Exception e){
//		    					cd.setApprovedAmount(Long.valueOf(0));
//		    				}
//		    			}
//		    			else if(cellIndex == 36){
//		    				cd.setClaimStatus(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 37){
//		    				cd.setFinalStatus(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 38){
//		    				cd.setAuthorizationMode(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 39){
//		    				ad.setAgeRemarks(getStringValue(cell));
//		    			}
		    			else if(cellIndex == 40){
		    				pd.setGender(getStringValue(cell));
		    				patientCliamDetail.setGender(getStringValue(cell));
		    			}
//		    			else if(cellIndex == 41){
//		    				cd.setClaimid(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 42){
//		    				cd.setManualOrOnline(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 43){
//		    				cd.setBcpauthorizationcode(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 44){
//		    				cd.setBcpauthorizationdate(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 45){
//		    				cd.setRejectRemarks(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 46){
//		    				cd.setDate(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 47){
//		    				cd.setYear(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 48){
//		    				cd.setMonth(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 49){
//		    				cd.setWeek(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 50){
//		    				ad.setAgeRange(getStringValue(cell));
//		    			}
//		    			else if(cellIndex == 51){
//		    				cd.setSyncDelay(getStringValue(cell));
//		    			}
		    		}
//		    		ad.setDiseaseDetail(dd);
//		    		ad.setHospitalDetail(hd);
//		    		ad.setPackageDetail(pkd);
//		    		ad.setDiseaseDetail(dd);
//		    		//ad.setClaimDetails(cd);
//		    		cd.setAdmissionDetail(ad);
//		    		adList.add(ad);
//		    		cdList.add(cd);
//		    		//pdSet.add(pd);
		    		pcdList.add(patientCliamDetail);
		    		ksession.insert(patientCliamDetail);
	                ksession.fireAllRules();
		    		//System.out.println(ad.toString());
		    	}
	    	}
//	    	list = (List<String>) ksession.getGlobal("list");
//    		System.out.println(list.size());
//    		for(String failedRule: list){
//    			System.out.println(failedRule);
//    		}
	    	ksession.dispose(); 
	    	System.out.println(" pcdList size = "+pcdList.size());
	    	SaveExcelService saveExcelService = new SaveExcelServiceImpl();
    		saveExcelService.createPatientCliamDetails(pcdList);

	    }
	    
	    private static String getStringValue(Cell cell){
	    	int cellType = cell.getCellType();
	    	if(cellType == Cell.CELL_TYPE_STRING){
	    		return cell.getStringCellValue();
	    	}else{
	    		return "";
	    	}
	    	
	    }
}

