package project.gp.controllers;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import project.gp.entities.Feedback;
import project.gp.services.FeedbackService;

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
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedbacks")
    public List<Feedback> getFeedbacks(@RequestParam(required = false) String type) throws Exception {

        log.info("Received request to retrieve all feedback or feedback by type : " + type);

        if (type!=null){
            return feedbackService.getFeedbackByType(type);
        }
        else {
            return feedbackService.getAllFeedbacks();
        }
    }

    @PostMapping("/feedbacks")
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
        try {
            return new ResponseEntity<Feedback>(feedbackService.saveFeedback(feedback), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Feedback>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback, @PathVariable String id) {
        try {
            Feedback updatedFeedback = feedbackService.updateFeedback(id, feedback);
            return new ResponseEntity<Feedback>(updatedFeedback, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Feedback>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedbacks/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable String id) {
        try {
            feedbackService.deleteFeedback(id);
            return new ResponseEntity<String>("You have successfully deleted a feedback with an id of: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping(value = "/feedbacks/{id}")
    public List<Feedback> getFeedbackBy_Id(@PathVariable ObjectId id) throws Exception {

        //log.info("Received request to retrieve employee with user id = ");
        List<Feedback> feedbackList = feedbackService.getFeedbackByObjectId(id);

        return feedbackList;
    }

    @GetMapping(value = "/feedbacks/user")
    public List<Feedback> getFeedbackByUser(@RequestParam(required = false) String user) throws Exception {

        log.info("Received request to retrieve feedback by user = " + user);
        List<Feedback> feedbackList = feedbackService.getFeedbackByUser(user);

        return feedbackList;
    }

    @GetMapping(value = "/feedbacks/search")
    public List<Feedback> searchFeedback(@RequestParam(required = false) String keyword) throws Exception {

        log.info("Received request to retrieve feedback containing keyword = " + keyword);
        List<Feedback> feedbackList = feedbackService.getFeedbackByFeedbackContains(keyword);

        return feedbackList;
    }

}
