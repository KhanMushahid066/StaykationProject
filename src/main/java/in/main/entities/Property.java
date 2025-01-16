package in.main.entities;

import java.util.List;

import in.main.dtos.Imagedto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long propertyId;

	private String propertyName;
	private Double basePrice;
	private String propertyType;
	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;
}
