package project.gp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import project.gp.entities.Feedback;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {

    List<Feedback> findAllByOrderByCreatedDateAsc();
    List<Feedback> findBy_id(ObjectId _id);
    List<Feedback> findByType(String type);

    List<Feedback> findByUser(String user);

    //List<Person> findByNameAndNickname(String name, String nickname);

    //@Query("{'address.state' : ?0}")
    //List<Person> findByState(String state);

    List<Feedback> findByFeedbackContains(String keyword);
}
