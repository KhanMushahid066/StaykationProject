package in.main.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String password;
    private String emailId;
    private String contactNumber;
    private Date accountCreationDate;
    private String addressProof;
    private String idProof;
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private Long hostId;

    @OneToMany(mappedBy = "user")
    private List<Property> properties;

    // Getters and Setters
}

