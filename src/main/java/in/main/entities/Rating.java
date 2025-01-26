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
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;
	private Long propertyId;
	private Long customerId;
	private Integer ratings;

	@ManyToOne
	@JoinColumn(name = "propertyId", insertable = false, updatable = false)
	private Property property;

	// Getters and Setters
}
