package project.user.controllers;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import project.user.entities.User;
import project.user.services.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Log
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("/Users")
    public List<User> getUsers(@RequestParam(required = false) String type) throws Exception {
        
        log.info("Received request to retrieve all User or User by type : " + type);

        return UserService.getAllUsers();
    }

    @GetMapping(value = "/Users/login")
    public List<User> getUserByUsernameAndPasswordAndRole(@RequestParam(required = false) String username, @RequestParam(required = false) String password, @RequestParam(required = false) String role) throws Exception {

        log.info("Received request to retrieve User with username, password and role = ");
        List<User> UserList = UserService.getUserByUsernameAndPasswordAndRole(username, password, role);

        return UserList;
    }

}
