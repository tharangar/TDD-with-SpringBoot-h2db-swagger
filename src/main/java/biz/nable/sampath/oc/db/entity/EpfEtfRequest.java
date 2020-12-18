package biz.nable.sampath.oc.db.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data  // This is lombok anotation to get getters setters and constructor creation
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "SB_PMT_EPF_ETF_REQUEST")
public class EpfEtfRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EPF_ETF_REQUEST_SEQ")
    @SequenceGenerator(name = "EPF_ETF_REQUEST_SEQ", sequenceName = "EPF_ETF_REQUEST_SEQ", allocationSize = 1)
	private Long ReqId;
    @Column(length = 30)
	private String fromAccount;
    @Column(length = 30)
	private String commissionAccount;
    @Column(length = 5)
	private String type;
    @Column(length = 30)
	private String number;
    @Column(length = 30)
	private String paymentType;
    @Column(length = 30)
	private String surchargeRef;
    
	private Integer noOfEmployees;
	@Column(length = 30)
	private String fileId;
	@Column(length = 4000)
	private String content;
	@Column(length = 30)
	private String fileName;
	
	private BigDecimal amount;
	private Date nextBussinessDate;
	@Column(length = 30)
	private String companyId;
	@Column(length = 30)
	private String rootCompanyId;
	boolean thirdPartyFlag;
	@Column(length = 5)
	private String currency;
	@Column(length = 10)
	private String paymentPeriodFrom;
	@Column(length = 10)
	private String paymentPeriodTo;
	
	// Audit Details
	private Date createdOn;
	@Column(length = 30)
	private String createdBy;
	

	
}
