package biz.nable.sampath.oc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Tharanga Rajapaksha
 *
 */
@RestController
public class SpringRestController {
	
	@RequestMapping(path = "/api/tdd/{data}", method= RequestMethod.GET)
    public Response getData(@PathVariable("data") String data) {
                      return new Response(data);
    }
    //inner class
    class Response {
                      private String data;
                      public Response(String data) {
                                        this.data = data;
                      }
                      public String getData() {
                                        return data;
                      }
    }

}
