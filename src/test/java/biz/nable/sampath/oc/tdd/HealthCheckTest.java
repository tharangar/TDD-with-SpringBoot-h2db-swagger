package biz.nable.sampath.oc.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

//import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
	@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
	        "management.server.port=0" })
	public class HealthCheckTest {

	    @Autowired
	    private WebTestClient webTestClient; // instead we can use anotation @WebFluxTest(MyControllerTest.class) also

	    @LocalManagementPort
	    int managementPort;

	    @Test
	    public void testManagementPort() {
	        webTestClient
	                .get().uri("http://localhost:" + managementPort + "/actuator/health")
	                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	                .accept(MediaType.APPLICATION_JSON)
	                .exchange()
	                .expectStatus().isOk();
	    }
	}