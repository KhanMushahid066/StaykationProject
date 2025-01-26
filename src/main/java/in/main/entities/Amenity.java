package in.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;
    private Long propertyId;
    private String amenity;

    @ManyToOne
    @JoinColumn(name = "property_id", insertable = false, updatable = false)
    private Property property;

}

