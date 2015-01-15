package com.hannover.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the claim_details database table.
 * 
 */
@Entity
@Table(name="claim_details")
@NamedQuery(name="ClaimDetail.findAll", query="SELECT c FROM ClaimDetail c")
public class ClaimDetail extends AbstractPO {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLAIM_DETAILS_CLAIMID_GENERATOR", sequenceName="CLAIM_DETAILS_MASTERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLAIM_DETAILS_CLAIMID_GENERATOR")
	@Column(name="claim_id")
	private Long id;

	@Column(name="approved_amount")
	private Long approvedAmount;

	@Column(name="authorization_mode")
	private String authorizationMode;

	private String bcpauthorizationcode;

	private String bcpauthorizationdate;

	@Column(name="claim_status")
	private String claimStatus;

	@Column(name="claimed_amount")
	private Long claimedAmount;

	private String claimid;

	private String date;

	@Column(name="final_status")
	private String finalStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="float_rec_date")
	private Date floatRecDate;

	@Column(name="manual_or_online")
	private String manualOrOnline;

	private String month;

	@Column(name="reject_remarks")
	private String rejectRemarks;
	
	@Column(name="rule_status")
	private String ruleStatus;
	
	@Column(name="rule_remarks")
	private String ruleRemarks;

	private String rfu1;

	private String rfu2;

	private String rfu3;

	@Column(name="sync_delay")
	private String syncDelay;

	@Column(name="transaction_status")
	private String transactionStatus;
	
	@Column(name="transaction_code")
	private String transactionCode;
	
	@Column(name="block_txn_date")
	private Date blockTxnDate;
	
	@Column(name="claim_txn_date")
	private Date claimTxnDate;

	public Date getClaimTxnDate() {
		return claimTxnDate;
	}

	public void setClaimTxnDate(Date claimTxnDate) {
		this.claimTxnDate = claimTxnDate;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public Date getBlockTxnDate() {
		return blockTxnDate;
	}

	public void setBlockTxnDate(Date blockTxnDate) {
		this.blockTxnDate = blockTxnDate;
	}

	@Column(name="travel_amt_till_date")
	private Long travelAmtTillDate;

	@Temporal(TemporalType.DATE)
	@Column(name="upload_date")
	private Date uploadDate;

	private String week;

	private String year;

	//bi-directional many-to-one association to AdmissionDetail
	@ManyToOne
	@JoinColumn(name="admission_id")
	private AdmissionDetail admissionDetail;

	public ClaimDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long claimId) {
		this.id = claimId;
	}

	public Long getApprovedAmount() {
		return this.approvedAmount;
	}

	public void setApprovedAmount(Long approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public String getAuthorizationMode() {
		return this.authorizationMode;
	}

	public void setAuthorizationMode(String authorizationMode) {
		this.authorizationMode = authorizationMode;
	}

	public String getBcpauthorizationcode() {
		return this.bcpauthorizationcode;
	}

	public void setBcpauthorizationcode(String bcpauthorizationcode) {
		this.bcpauthorizationcode = bcpauthorizationcode;
	}

	public String getBcpauthorizationdate() {
		return this.bcpauthorizationdate;
	}

	public void setBcpauthorizationdate(String bcpauthorizationdate) {
		this.bcpauthorizationdate = bcpauthorizationdate;
	}

	public String getClaimStatus() {
		return this.claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Long getClaimedAmount() {
		return this.claimedAmount;
	}

	public void setClaimedAmount(Long claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public String getClaimid() {
		return this.claimid;
	}

	public void setClaimid(String claimid) {
		this.claimid = claimid;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFinalStatus() {
		return this.finalStatus;
	}

	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}

	public Date getFloatRecDate() {
		return this.floatRecDate;
	}

	public void setFloatRecDate(Date floatRecDate) {
		this.floatRecDate = floatRecDate;
	}

	public String getManualOrOnline() {
		return this.manualOrOnline;
	}

	public void setManualOrOnline(String manualOrOnline) {
		this.manualOrOnline = manualOrOnline;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getRejectRemarks() {
		return this.rejectRemarks;
	}

	public void setRejectRemarks(String rejectRemarks) {
		this.rejectRemarks = rejectRemarks;
	}

	public String getRuleStatus() {
		return ruleStatus;
	}

	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}

	public String getRuleRemarks() {
		return ruleRemarks;
	}

	public void setRuleRemarks(String ruleRemarks) {
		this.ruleRemarks = ruleRemarks;
	}

	public String getRfu1() {
		return this.rfu1;
	}

	public void setRfu1(String rfu1) {
		this.rfu1 = rfu1;
	}

	public String getRfu2() {
		return this.rfu2;
	}

	public void setRfu2(String rfu2) {
		this.rfu2 = rfu2;
	}

	public String getRfu3() {
		return this.rfu3;
	}

	public void setRfu3(String rfu3) {
		this.rfu3 = rfu3;
	}

	public String getSyncDelay() {
		return this.syncDelay;
	}

	public void setSyncDelay(String syncDelay) {
		this.syncDelay = syncDelay;
	}

	public String getTransactionStatus() {
		return this.transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Long getTravelAmtTillDate() {
		return this.travelAmtTillDate;
	}

	public void setTravelAmtTillDate(Long travelAmtTillDate) {
		this.travelAmtTillDate = travelAmtTillDate;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public AdmissionDetail getAdmissionDetail() {
		return this.admissionDetail;
	}

	public void setAdmissionDetail(AdmissionDetail admissionDetail) {
		this.admissionDetail = admissionDetail;
	}

}