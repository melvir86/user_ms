package project.user.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import project.user.entities.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findBy_id(ObjectId _id);

    List<User> findByUsernameAndPasswordAndRole(String username, String password, String role);

    List<User> findByRole(String role);

    //findByStatusCodeNot(String statusCode);
    //findFirstOrderByCounter
    //List<Person> findByNameAndNickname(String name, String nickname);

    //@Query("{'address.state' : ?0}")
    //List<Person> findByState(String state);

}
