package project.user.services;

import lombok.extern.slf4j.Slf4j;
import project.user.entities.User;
import project.user.repositories.UserRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    //Retrieve all Users
    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }
 
    //Retrieve 1 User
     public User getUser(String id) {
 
         return UserRepository.findById(id).get();
     }

    //Creates a User
     public User saveUser(User User) {

        return UserRepository.save(User);
     }
 
    //Delete a User
     public void deleteUser(String id) {
 
        UserRepository.deleteById(id);
     }

    //Retrieve User by Id
    public List<User> getUserByObjectId(ObjectId id) {

        List<User> User = UserRepository.findBy_id(id);
        return User;
    }

    //Retrieve User by Role
    public List<User> getUserByRole(String role) {
    
        List<User> UserList = UserRepository.findByRole(role);
        return UserList;
    }

    //Retrieve User by Username
    public List<User> getUserByUsernameAndPasswordAndRole(String username, String password, String role) {
    
        List<User> UserList = UserRepository.findByUsernameAndPasswordAndRole(username, password, role);
        return UserList;
    }

}
