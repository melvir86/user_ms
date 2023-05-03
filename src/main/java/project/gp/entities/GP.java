package project.gp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "gp")
public class GP {

    @Id
    private ObjectId _id;
    private String name;
    private String address;
    private String borough;
    private String telephone;
    private String maxcapacity;
    private String currentcapacity;
    private String status;
    private String admin;
    @LastModifiedDate
    public LocalDateTime lastModifiedDate;
    //private Date createdDate = new Date();

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
}
