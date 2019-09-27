package guru.springframework.tdd;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

import guru.springframework.SpringBootWebApplication;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
/**
 * @author Tharanga Rajapaksha
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = SpringBootWebApplication.class) 
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringRestControllerTest {

	@Value("${server.port}") 
    int port;
       @Test
       public void getDataTest() {
              get("/api/tdd/responseData").then().assertThat().body("data", equalTo("responseData"));
       }
       @Before
       public void setBaseUri () {
               RestAssured.port = port;
               RestAssured.baseURI = "http://localhost"; // replace as appropriate
       }
}
