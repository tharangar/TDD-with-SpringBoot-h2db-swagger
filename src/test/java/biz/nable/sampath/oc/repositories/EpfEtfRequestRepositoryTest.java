package biz.nable.sampath.oc.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import biz.nable.sampath.oc.db.entity.EpfEtfRequest;
import biz.nable.sampath.oc.db.repositories.EpfEtfRepository;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {RepositoryConfiguration.class})
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE) // This will use H2 memory database instead of acutall data source for jpa testings.
//@ContextConfiguration(classes = SpringBootWebApplication.class) 

@SpringBootTest
//@DataJpaTest  // This anotabion didn't work due to error : EpfEtfRequestRepositoryTest.saveEpfEtfRequest ▒ IllegalState Failed to load Ap...
@AutoConfigureTestDatabase(replace = Replace.NONE) // This will use H2 memory database instead of acutall data source for jpa testings.
public class EpfEtfRequestRepositoryTest {
	

	@Autowired
	private EpfEtfRepository epfEtfRepository;
	
//    @Autowired
//    public void setEpfEtfRepository(EpfEtfRepository epfEtfRepository) {
//        this.epfEtfRepository = epfEtfRepository;
//    }
//	

	@Test
	@Rollback(false) // this will persists data event after test case is over. By default it is true due to jpadata tests are not requeed to persists data.
	public void saveEpfEtfRequest() {
		EpfEtfRequest reques = new EpfEtfRequest();
		reques.setCompanyId("nable");
		reques.setFromAccount("100000000");
		reques.setCreatedBy("nable");
		
		EpfEtfRequest savedObject = epfEtfRepository.save(reques);
		
		assertNotNull(savedObject);
		
	}
	
	
	@Test
	@Rollback(false) // If Rollback commented next test will be failed due to after test case data will be rolled backed.
	public void existsByName() {
		boolean result = epfEtfRepository.existsByFromAccount("100000000");
		assertThat(true).isEqualTo(result);
		
		result = epfEtfRepository.existsByFromAccount("000000");
		assertThat(false).isEqualTo(result);
		
	}
	
	
	@Test
	@Rollback(false)
	public void getByName() {
		String companyId = "nable";
		List<EpfEtfRequest> savedObjectList = epfEtfRepository.findByCompanyId(companyId);
		//assertThat(companyId).isEqualTo(savedObject.getCompanyId());
		assertThat(savedObjectList.size()).isGreaterThan(0);
		
		
	}

	
}
