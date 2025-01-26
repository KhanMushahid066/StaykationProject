package in.main.entities;

import java.util.Date;

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
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;
    private Date calendarDate;
    private Long propertyId;
    private Double pricePerDay;

    @ManyToOne
    @JoinColumn(name = "propertyId", insertable = false, updatable = false)
    private Property property;

    // Getters and Setters
}

