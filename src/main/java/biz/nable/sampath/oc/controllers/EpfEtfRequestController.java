package biz.nable.sampath.oc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.nable.sampath.oc.db.entity.EpfEtfRequest;
import biz.nable.sampath.oc.requestsResponse.dto.EpfEtfRequestDto;
import biz.nable.sampath.oc.services.EpfEtfRequestService;
import biz.nable.sampath.oc.services.EpfEtfRequestServiceImpl;
import biz.nable.sampath.oc.statusErrorsUtils.ErrorCode;
import biz.nable.sb.cor.common.response.CommonResponse;
import biz.nable.sb.cor.common.service.impl.CommonConverter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.validation.Valid; // DTO validaiton 

@RestController
@RequestMapping("/epfetf")
public class EpfEtfRequestController {
	
	//@Autowired
	//private CommonConverter commonConverter; // This component is implemented in the common util package.
	
	@Autowired
	EpfEtfRequestServiceImpl epfEtfRequestService;
	
	@Autowired
	MessageSource messageSource;

	private static final String REQUEST_ID_HEADER = "request-id";

	// do logging with sl4j
	private static final Logger logger = LoggerFactory.getLogger(EpfEtfRequestController.class);

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();


	//public ResponseEntity<Object> doPayment(EpfEtfRequestDto dto) {
		
	    @ApiOperation(value = "EPF/ETF Payment Request", nickname = "Single Transfer Request", notes = "Create singleTransfer.", httpMethod = "POST")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "EPF/ETF Request successful", response = CommonResponse.class),
	            @ApiResponse(code = 400, message = "Input parameters are not valid"),
	            @ApiResponse(code = 500, message = "Internal server error")})
	    @PostMapping(value = "/doPayment")
	    //public ResponseEntity<CommonResponse> doPayment(@Valid @RequestBody EpfEtfRequestDto dto,
	    public ResponseEntity<CommonResponse> doPayment(@Valid @RequestBody EpfEtfRequestDTO dto,
	                                                         @RequestHeader(name = REQUEST_ID_HEADER, required = true) String requestId,
	                                                         @RequestHeader(name = "userId", required = true) String userId,
	                                                         @RequestHeader(name ="companyId", required =true) String companyId) {

	        MDC.put(REQUEST_ID_HEADER, requestId);
	        long startTime = System.currentTimeMillis();

	        logger.info("Start execute method singleTransfer");
	        CommonResponse commonResponse = null;

	        try {
	        	//validator.singleTransferReqValidator(singleTransferRequest);
	          
	                logger.debug("singleTransfer for {}.",companyId );
	                commonResponse = new CommonResponse(HttpStatus.BAD_REQUEST.value(), "success",
		                   "200");
	                
	                // convert DTO to ENTITY

	                
	                epfEtfRequestService.addEpfEtfRequest(dto);

	             //   logger.info(commonResponse.getReturnMessage());

//	   } catch (SystemException e) {
//
//	            logger.info("SystemException occurred while init singleTransfer for {}.", e.getMessage());
//	            commonResponse = new CommonResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
//	                    e.getErrorCode());
	        } catch (Exception e) {
	            logger.error("Error occurred while init singleTransfer for {}.", e);
	            commonResponse = new CommonResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                    "Error occurred while singleTransfer. " + e.getMessage(), ErrorCode.UNKNOWN_ERROR);
	        }


	        long endTime = System.currentTimeMillis();
	        logger.info("singleTransfer rate: avg_resp={}", (endTime - startTime));
	        MDC.clear();
	        try {
	            // due to http status is null exception
	            return ResponseEntity.status(HttpStatus.resolve(commonResponse.getReturnCode())).body(commonResponse);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.resolve(200)).body(commonResponse);
	        }
	    }
	    
	    
	    
	    
	    // Get Details by inquires
	    
	    
	    
	    
	    
	
	
}
