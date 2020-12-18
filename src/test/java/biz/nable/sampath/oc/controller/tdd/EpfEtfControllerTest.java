package biz.nable.sampath.oc.controller.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import biz.nable.sampath.oc.controllers.EpfEtfRequestController;
import biz.nable.sampath.oc.db.entity.EpfEtfRequest;
import biz.nable.sampath.oc.requestsResponse.dto.EpfEtfRequestDto;
import biz.nable.sampath.oc.services.EpfEtfRequestService;
import biz.nable.sampath.oc.services.EpfEtfRequestServiceImpl;
import biz.nable.sb.cor.common.response.CommonResponse;

@SpringBootTest
public class EpfEtfControllerTest {
	
	@MockBean
	EpfEtfRequestServiceImpl epfEtfRequestService;
	
	@InjectMocks
	@Autowired
	EpfEtfRequestController epfEtfController;
	
	
	// Calling the rest method
	
	@Test
	public void testEpfEtfRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        // Create the object
        EpfEtfRequest epfRequest = new EpfEtfRequest();
        epfRequest.setCompanyId("nable");
        epfRequest.setNumber("EPF001");
        BigDecimal amount = new BigDecimal("10000.00");
        epfRequest.setAmount(amount); // bigDecimal
        
        // Before 
        when(epfEtfRequestService.addEpfEtfRequest(epfRequest)).thenReturn(epfRequest);
        // then 
        EpfEtfRequestDto dto = new EpfEtfRequestDto();
        dto.setCompanyId("nable");
        dto.setNumber("EPF001");

        dto.setAmount(amount); // bigDecimal
        
        ResponseEntity<CommonResponse> responseEntity = epfEtfController.doPayment(epfRequest, "001", "nable", "nable");
        
        CommonResponse res = responseEntity.getBody();
         
        assertThat(res.getErrorCode()).isEqualTo("200");
       // assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
   
		
	}
	
	
	// Now write the test case to call through webmvc (directly API not the mehtod)
	
	
	
	
	
	

}
