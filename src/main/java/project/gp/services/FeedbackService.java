package project.gp.services;

import lombok.extern.slf4j.Slf4j;
import project.gp.entities.Feedback;
import project.gp.repositories.FeedbackRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackpository;

    public FeedbackService(FeedbackRepository feedbackpository) {
        this.feedbackpository = feedbackpository;
    }

    //Retrieve all Feedbacks
    public List<Feedback> getAllFeedbacks() {
        return feedbackpository.findAll();
    }
 
    //Retrieve 1 Feedback
     public Feedback getFeedback(String id) {
 
         return feedbackpository.findById(id).get();
     }

    //Creates a Feedback
     public Feedback saveFeedback(Feedback feedback) {

        return feedbackpository.save(feedback);
     }

    //Updares an existing Feedback
    public Feedback updateFeedback(String id, Feedback feedback) {
        Feedback existFeedback = getFeedback(id);
        existFeedback.setType(feedback.getType());
        existFeedback.setStatus(feedback.getStatus());
        existFeedback.setFeedback(feedback.getFeedback());
        existFeedback.setLastModifiedDate(feedback.getLastModifiedDate());
        feedbackpository.save(existFeedback);
        return existFeedback;
    }
 
    //Delete a Feedback
     public void deleteFeedback(String id) {
 
        feedbackpository.deleteById(id);
     }

    //Retrieve Feedback by Id
    public List<Feedback> getFeedbackByObjectId(ObjectId id) {

        List<Feedback> feedback = feedbackpository.findBy_id(id);
        return feedback;
    }

    //Retrieve Feedback by Type
    public List<Feedback> getFeedbackByType(String type) {

        List<Feedback> feedbackList = feedbackpository.findByType(type);
        return feedbackList;
    }

    //Retrieve Feedback by User
    public List<Feedback> getFeedbackByUser(String user) {
    
        List<Feedback> feedbackList = feedbackpository.findByUser(user);
        return feedbackList;
    }

    //Retrieve Feedback that contains a keyword
    public List<Feedback> getFeedbackByFeedbackContains(String keyword) {

        List<Feedback> feedbackList = feedbackpository.findByFeedbackContains(keyword);

        return feedbackList;
    }

}
