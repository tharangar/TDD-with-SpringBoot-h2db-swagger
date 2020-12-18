package biz.nable.sampath.oc.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import biz.nable.sampath.oc.db.entity.Product;
import biz.nable.sampath.oc.db.entity.User;
import biz.nable.sampath.oc.services.ProductService;
import biz.nable.sampath.oc.services.UserService;

@RestController
@RequestMapping("/user")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "View a list of configured users",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<User> list(Model model){
        Iterable<User> userList = userService.listAllUsers();
        return userList;
    }
    
    @ApiOperation(value = "Search a product with an ID",response = User.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public User showUser(@PathVariable Integer id, Model model){
       User user = userService.getUserById(id);
        return user;
    }

    @ApiOperation(value = "Add a user")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity("User saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a user")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user){
        User storeduser = userService.getUserById(id);
        storeduser.setFname(user.getFname());
        storeduser.setUname(user.getUname());
        userService.saveUser(storeduser);
        return new ResponseEntity("  updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a user")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);

    }

}
