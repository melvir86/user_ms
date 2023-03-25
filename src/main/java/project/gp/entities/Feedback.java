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
@Document(collection = "feedback")
public class Feedback {

    @Id
    private ObjectId _id;
    private String user;
    @CreatedDate
    @Column(updatable = false)
    public LocalDateTime createdDate;
    @LastModifiedDate
    public LocalDateTime lastModifiedDate;
    //private Date createdDate = new Date();
    private String type;
    private String feedback;
    private String status;
    //private List<Address> address;

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
}
