package project.gp.controllers;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import project.gp.entities.GP;
import project.gp.services.GPService;

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
public class GPController {

    @Autowired
    private GPService gpService;

    @GetMapping("/GPs")
    public List<GP> getGPs(@RequestParam(required = false) String type) throws Exception {

        log.info("Received request to retrieve all GP or GP by type : " + type);

        return gpService.getAllGPs();
    }

    /* 
    @PostMapping("/GPs")
    public ResponseEntity<GP> saveGP(@RequestBody GP GP) {
        try {
            return new ResponseEntity<GP>(GPService.saveGP(GP), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<GP>(HttpStatus.BAD_REQUEST);
        }
    }
    */

    @PutMapping("/GPs/{id}")
    public ResponseEntity<GP> updateGP(@RequestBody GP GP, @PathVariable String id) {
        try {
            GP updatedGP = gpService.updateGP(id, GP);
            return new ResponseEntity<GP>(updatedGP, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<GP>(HttpStatus.NOT_FOUND);
        }
    }

    /* 
    @DeleteMapping("/GPs/{id}")
    public ResponseEntity<String> deleteGP(@PathVariable String id) {
        try {
            GPService.deleteGP(id);
            return new ResponseEntity<String>("You have successfully deleted a GP with an id of: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    */

    @GetMapping(value = "/GPs/{admin}")
    public List<GP> getGPBy_Admin(@PathVariable String admin) throws Exception {

        //log.info("Received request to retrieve GP with admin = ");
        List<GP> GPList = gpService.getGPByAdmin(admin);

        return GPList;
    }

    @GetMapping(value = "/GPs/borough/{borough}")
    public List<GP> getGPBy_Borough(@PathVariable String borough) throws Exception {

        log.info("Received request to retrieve GP with borough = ");
        List<GP> GPList = gpService.getGPByBorough(borough);

        return GPList;
    }

    @GetMapping(value = "/GPs/borough/recommended/{borough}")
    public List<GP> getGPWithLeastCurrentCapacityBy_Borough(@PathVariable String borough, @RequestParam(required = false) String primaryGP) throws Exception {

        log.info("Received request to retrieve GP with least current capacity with borough = ");
        List<GP> GPList = gpService.getGPWithLeastCurrentCapacityByBorough(borough);

        return GPList;
    }

    /*
    @GetMapping(value = "/GPs/user")
    public List<GP> getGPByUser(@RequestParam(required = false) String user) throws Exception {

        log.info("Received request to retrieve GP by user = " + user);
        List<GP> GPList = GPService.getGPByUser(user);

        return GPList;
    }
    

    @GetMapping(value = "/GPs/search")
    public List<GP> searchGP(@RequestParam(required = false) String keyword) throws Exception {

        log.info("Received request to retrieve GP containing keyword = " + keyword);
        List<GP> GPList = GPService.getGPByGPContains(keyword);

        return GPList;
    }
    */

}
