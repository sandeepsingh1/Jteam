package com.hannover.constants;

/**
 * This interface contains all the exception messages common to all modules.
 * @author piyush.mittal
 *
 */
public interface ErrorMessages {

	/**
	 * Error message while obtaining DAOImpl instance from DAOFactory.
	 */
	public static final String DAO_IMPL_INSTANCE_CREATION_EXCEPTION = "Error in instantiating DAO implememtation class.";
	/**
	 * Error message while loading the system.properties file.
	 */
	public static final String ERR_INITIALIZING_SYSTEM = "Could not configure System Repository. Calls to read System properties will fail. System not properly initialized.";

	/**
	 * Error message while loading the quartz.properties file.
	 */
	public static final String ERR_INITIALIZING_QUARTZ = "Could not configure Quartz Repository. Calls to read Quartz properties will fail. Quartz not properly initialized.";

	public static final String  HIERARCHY_TYPE_READ_EXCEPTION = "Error while fetching hierarchy type from database.";

	/**
	 * image type fetch exception.
	 */
	public static final String  IMAGE_TYPE_READ_EXCEPTION = "Error while fetching image type from database.";
	
	/**
	 * SystemVariable creation failures.
	 */
	public static final String SYSTEMVARIABLE_CREATE_EXCEPTION = "Error while creating SystemVariable in database.";
	/**
	 * SystemVariable update failures.
	 */
	public static final String SYSTEMVARIABLE_UPDATE_EXCEPTION = "Error while updating SystemVariable in database.";
	/**
	 * SystemVariable read failures.
	 */
	public static final String SYSTEMVARIABLE_READ_EXCEPTION = "Error while fetching SystemVariable from database.";
	/**
	 * Customer Profile read failures.
	 */
	public static final String CUSTOMERPROFILE_READ_EXCEPTION = "Error while fetching Customer Profile from database.";
	/**
	 * Customer Service read failures.
	 */
	public static final String CUSTOMERSERVICE_READ_EXCEPTION = "Error while fetching Customer Service from database.";
	/**
	 * Customer Account read failures.
	 */
	public static final String CUSTOMERACCOUNT_READ_EXCEPTION = "Error while fetching Customer Account from database.";
	/**
	 * Payment Data read failures.
	 */
	public static final String PAYMENTDATA_READ_EXCEPTION = "Error while fetching Payment Data from database.";
	/**
	 * iTalk Account read failures.
	 */
	public static final String ITALKACCOUNT_READ_EXCEPTION = "Error while fetching iTalk Account from database.";
	/**
	 * iTalk Reload Data read failures.
	 */
	public static final String ITALKRELOAD_READ_EXCEPTION = "Error while fetching iTalk Reload from database.";
	/**
	 * Bill Summary read failures.
	 */
	public static final String BILLSUMMARY_READ_EXCEPTION = "Error while fetching Bill Summary from database.";
	/**
	 * Payment Mode read failures.
	 */
	public static final String PAYMENTMODE_READ_EXCEPTION = "Error while fetching Payment Mode from database.";
	/**
	 * Payment Channel read failures.
	 */
	public static final String PAYMENTCHANNEL_READ_EXCEPTION = "Error while fetching Payment Channel from database.";
	/**
	 * Payment Center Type read failures.
	 */
	public static final String PAYMENTCENTERTYPE_READ_EXCEPTION = "Error while fetching Payment Center Type from database.";
	/**
	 * Credit Card Type read failures.
	 */
	public static final String CREDITCARDTYPE_READ_EXCEPTION = "Error while fetching Credit Card Type from database.";
	/**
	 * Upload Scheme parse errors.
	 */
	public static final String SCHEME_CONFIG_PARSE_FAILED = "The scheme config coudn't be parsed correctly";
	
	public static final String SCHEME_CONFIG_NULL = "The scheme config is null";
	
	public static final String SCHEME_READ_EXCEPTION = "Error while reading Scheme in database.";
	
	/**
	 * Mandatory Parameter missing.
	 */
	public static final String MANDATORY_PARAMETER_MISSING_EXCEPTION = "Mandatory parameter missing";
	
	public static final String NAME_MASTER_READ_EXCEPTION = "Error while fetching master names from database.";
	
	public static final String INVALID_PARAMETER_EXCEPTION = "Parameter provided is invalid";
	
	public static final String ACTIVATED_CARD_EXCEPTION = "Card is already activated";
	
	public static final String SUSPENDED_CARD_EXCEPTION = "Card is already suspended";

	public static final String TERMINATED_CARD_EXCEPTION = "Card is already terminated";

	public static final String ACTIVATED_MEMBERSHIP_EXCEPTION = "Membership is already activated";
	
	public static final String SUSPENDED_MEMBERSHIP_EXCEPTION = "Membership is already suspended";

	public static final String TERMINATED_MEMBERSHIP_EXCEPTION = "Membership is already terminated";

	public static final String BIN_RANGE_READ_EXCEPTION = "Error while reading Bin Range from Database.";

	public static final String CUSTOMER_NOT_ELIGIBLE = "Customer is not eligible to place this request";

	public static final String INVALID_REQUEST = "Invalid Request";
}

