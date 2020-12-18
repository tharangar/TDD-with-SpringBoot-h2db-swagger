package biz.nable.sampath.oc.requestsResponse.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EpfEtfRequestDto {


	private Long ReqId;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "fromAccount Type can’t be null-TCWF03")
	@NotBlank(message = "fromAccount Type can’t be Blank-TCWF03")
	private String fromAccount;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Commission Account can’t be null-TCWF03")
	@NotBlank(message = "Commission Account can’t be Blank-TCWF03")
	private String commissionAccount;
    
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Type can’t be null-TCWF03")
	@NotBlank(message = "Type can’t be Blank-TCWF03")
	private String type;
	
	
	private String number;

	private String paymentType;

	private String surchargeRef;
    
	private Integer noOfEmployees;

	private String fileId;

	private String content;

	private String fileName;
	
	@Min(value = 0L, message = "The value must be positive")
	private BigDecimal amount;
	
	private Date nextBussinessDate;

	private String companyId;

	private String rootCompanyId;
	boolean thirdPartyFlag;

	private String currency;

	private String paymentPeriodFrom;

	private String paymentPeriodTo;
	
	// Audit Details
	private Date createdOn;

	private String createdBy;
	

	
}
