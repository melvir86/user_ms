package project.gp.services;

import lombok.extern.slf4j.Slf4j;
import project.gp.entities.GP;
import project.gp.repositories.GPRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GPService {

    @Autowired
    private GPRepository GPRepository;

    public GPService(GPRepository GPRepository) {
        this.GPRepository = GPRepository;
    }

    //Retrieve all GPs
    public List<GP> getAllGPs() {
        return GPRepository.findAll();
    }
 
    //Retrieve 1 GP
     public GP getGP(String id) {
 
         return GPRepository.findById(id).get();
     }

    //Creates a GP
     public GP saveGP(GP GP) {

        return GPRepository.save(GP);
     }

    //Updates an existing GP
    public GP updateGP(String id, GP GP) {
        GP existGP = getGP(id);
        existGP.setName(GP.getName());
        existGP.setAddress(GP.getAddress());
        existGP.setBorough(GP.getBorough());
        existGP.setTelephone(GP.getTelephone());
        existGP.setMaxcapacity(GP.getMaxcapacity());
        existGP.setCurrentcapacity(GP.getCurrentcapacity());
        existGP.setStatus(GP.getStatus());
        existGP.setAdmin(GP.getAdmin());
        existGP.setLastModifiedDate(GP.getLastModifiedDate());
        GPRepository.save(existGP);
        return existGP;
    }

    //Updates only the current capacity of an existing GP
    public GP updateGPCurrentCapacity(String id, GP GP) {
        GP existGP = getGP(id);
        existGP.setCurrentcapacity(GP.getCurrentcapacity());
        GPRepository.save(existGP);
        return existGP;
    }
 
    //Delete a GP
     public void deleteGP(String id) {
 
        GPRepository.deleteById(id);
     }

    //Retrieve GP by Id
    public List<GP> getGPByObjectId(ObjectId id) {

        List<GP> GP = GPRepository.findBy_id(id);
        return GP;
    }

    //Retrieve GP by Admin
    public List<GP> getGPByAdmin(String admin) {
    
        List<GP> GPList = GPRepository.findByAdmin(admin);
        return GPList;
    }

    //Retrieve GP by Borough
    public List<GP> getGPByBorough(String borough) {
    
        List<GP> GPList = GPRepository.findByBorough(borough);
        return GPList;
    }

    //Retrieve GP by Borough
    public List<GP> getGPWithLeastCurrentCapacityByBorough(String borough, String primaryGP) {
    
        List<GP> GPList = GPRepository.findFirstByBoroughAndNameNotLikeOrderByCurrentcapacity(borough, primaryGP);
        return GPList;
    }
    
    //Retrieve GP that contains a keyword
    public List<GP> getGPByNameContains(String keyword) {

        List<GP> GPList = GPRepository.findByNameContains(keyword);

        return GPList;
    }

}
