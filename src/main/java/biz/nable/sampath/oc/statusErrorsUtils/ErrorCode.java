package biz.nable.sampath.oc.statusErrorsUtils;

public class ErrorCode {
	
	

	    private ErrorCode() {
	        throw new IllegalStateException("Error Code class");
	    }

	    public static final String OPERATION_SUCCESS = "B200";
	    public static final String INVALID_USER_ID = "B410";

	    // Business
	    public static final String VALIDATION_ERROR = "B400";
	    public static final String NO_TRANSFER_RECORD_FOUND = "B401";
	    public static final String NO_TRANSFER_HISTORY_RECORD_FOUND = "B402";

	    public static final String TRANSFER_RECORD_IS_NOT_ELIGIBLE_FOR_RECONCILE="B4005";
	    public static final String NO_CORPORATE_PAYEE_RECORD_FOUND = "B403";
	    public static final String NO_COMMISSION_COLLECTION_RECORD_FOUND = "B404";


	    public static final String WORKFLOW_SUBMISSION_ERROR = "T_TRF_001_E";
	    public static final String VALIDATION_ERROR_RULE_LIMIT_CHECK = "B_TRF_002_E";
	    public static final String VALIDATION_ERROR_ENTERER_LIMIT_CHECK = "B_TRF_003_E";
	    public static final String VALIDATION_ERROR_APPROVER_LIMIT_CHECK = "B_TRF_004_E";
	    public static final String VALIDATION_ERROR_COMPANY_LIMIT_CHECK = "B_TRF_005_E";
	    public static final String VALIDATION_ERROR_BALANCE_CHECK = "B_TRF_006_E";
	    public static final String ENTERER_ACCOUNT_VALIDATION_ERROR = "T_TRF_002_E";

	    public static final String ENTERER_ACCOUNT_PERMISSION_ERROR = "B_TRF_001_E";

	    public static final String PAYEE_RECORD_NOT_FOUND = "B_TRF_007_E";

	    public static final String EXECUTION_FAILURE = "E_EX_001";
	    public static final String NOT_ENOUGH_BALANCE = "E_BL_001";
	    public static final String TRANSFER_END_POINT_CALLING_ERROR = "E_TF_001";
	    public static final String COMMISSION_CALCULATION_ERROR = "E_CC_001";

	    public static final String USER_NOT_PERMITTED = "B4011";

	    public static final String SERVICE_UNAVAILABLE_OR_INVOKE_FAILURE = "E_COM_001";

	    // Runtime
	    public static final String UNKNOWN_ERROR = "T500";
	    public static final String DATA_COPY_ERROR = "T520";
	    // Network
	    public static final String CREATE_APPROVAL_ERROR = "T421";
	    public static final String FINACLE_REQUEST_ERROR = "T422";

	    public static final String FIELDS_CAN_NOT_BE_EMPTY = "B_TRF_010";
	    public static final String FROM_ACCOUNT_TO_ACCOUNT_CAN_NOT_BE_SAME = "B_TRF_014_E";

	    //CorporatePayee
	    public static final String INVALID_NIC_OR_MOBILE_NO ="B_TRF_022_E";
	    public static final String CP_FIELDS_CAN_NOT_BE_EMPTY = "B_TRF_020_E";

	    //Limit validation errors
	    public static final String MAX_NUM_OF_TRANS_EXCEEDED = "B_TRF_009_E";
	    
	    public static final String TRANSACTION_DAILY_LIMIT_EXCEEDED = "B_TRF_040_E"; 
	    public static final String TRANSACTION_MONTHLY_LIMIT_EXCEEDED = "B_TRF_041_E"; 
	    public static final String TRANSACTION_ANNUAL_LIMIT_EXCEEDED = "B_TRF_042_E"; 
	    public static final String TRANSACTION_MAX_LIMIT_EXCEEDED = "B_TRF_043_E"; 
	    public static final String TRANSACTION_MIN_LIMIT_VIOLATED = "B_TRF_044_E"; 


	    public static final String GROUP_LMT_DAILY_LIMIT_EXCEEDED = "B_TRF_045_E"; 
	    public static final String GROUP_LMT_MONTHLY_LIMIT_EXCEEDED = "B_TRF_046_E"; 
	    public static final String GROUP_LMT_ANNUAL_LIMIT_EXCEEDED = "B_TRF_047_E"; 
	    
	    public static final String GLOBAL_LMT_DAILY_LIMIT_EXCEEDED = "B_TRF_048_E"; 
	    public static final String GLOBAL_LMT_MONTHLY_LIMIT_EXCEEDED = "B_TRF_049_E"; 
	    public static final String GLOBAL_LMT_ANNUAL_LIMIT_EXCEEDED = "B_TRF_050_E"; 
	    public static final String GLOBAL_LMT_MAX_LIMIT_EXCEEDED = "B_TRF_051_E"; 
	    public static final String GLOBAL_LMT_MIN_LIMIT_VIOLATED = "B_TRF_052_E"; 
	    
	    public static final String LIMIT_IS_NOT_AVAILABLE = "B_TRF_053_E"; 
	    
	    public static final String TRANSACTION_DAILY_NO_OF_TRANS_EXCEEDED = "B_TRF_054_E"; 
	    public static final String TRANSACTION_MONTHLY_NO_OF_TRANS_EXCEEDED = "B_TRF_055_E"; 
	    public static final String TRANSACTION_ANNUAL_NO_OF_TRANS_EXCEEDED = "B_TRF_056_E"; 

	    public static final String GROUP_LMT_DAILY_NO_OF_TRANS_EXCEEDED = "B_TRF_057_E"; 
	    public static final String GROUP_LMT_MONTHLY_NO_OF_TRANS_EXCEEDED = "B_TRF_058_E"; 
	    public static final String GROUP_LMT_ANNUAL_NO_OF_TRANS_EXCEEDED = "B_TRF_059_E"; 
	    
	    public static final String GLOBAL_LMT_DAILY_NO_OF_TRANS_EXCEEDED = "B_TRF_060_E"; 
	    public static final String GLOBAL_LMT_MONTHLY_NO_OF_TRANS_EXCEEDED = "B_TRF_061_E"; 
	    public static final String GLOBAL_LMT_ANNUAL_NO_OF_TRANS_EXCEEDED = "B_TRF_062_E"; 
	    
	    public static final String COMPANY_LIMIT_IS_NOT_AVAILABLE = "B_TRF_063_E"; 
	    public static final String USER_LIMIT_IS_NOT_AVAILABLE = "B_TRF_064_E"; 
	    
	    public static final String REFERENCE_TRANSFER_RECORD_NOT_FOUND="B_TRF_065_E";
	    public static final String REFERENCE_TRANSFER_RECORD_NOT_ELIGIBLE_FOR_RETRY="B_TRF_066_E";
	    public static final String REFERENCE_TRANSFER_RECORD_IS_ALREADY_RETRIED = "B_TRF_067_E";
	    
	    public static final String ALREADY_SUBMITTED_TO_RETRY="B_TRF_068_E";



}
