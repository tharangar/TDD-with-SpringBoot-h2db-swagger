package guru.springframework.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated user ID")
    private Integer id;
   // @Version
    //@ApiModelProperty(notes = "The auto-generated version of the product")
    //private Integer version;
    //@ApiModelProperty(notes = "The application-specific product ID")
    //private String productId;
    @ApiModelProperty(notes = "The user full name")
    private String fname;
    //@ApiModelProperty(notes = "The image URL of the product")
    //private String imageUrl;
    @ApiModelProperty(notes = "The username", required = true)
    private String uname;
    
    @ApiModelProperty(notes = "The password", required = true)
    private String pword;
    
    
    public String getPword() {
        return pword;
    }
    
    public String getFname() {
        return fname;
    }

    public String getUname() {
        return uname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUname(String uname) {
    	this.uname = uname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public void setPword(String pword) {
        this.pword = pword;
    }
}
