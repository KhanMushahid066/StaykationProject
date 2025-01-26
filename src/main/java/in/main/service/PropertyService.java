package in.main.service;

import org.springframework.web.multipart.MultipartFile;

import in.main.dtos.PropertyDTO;
import in.main.entities.Property;

public interface PropertyService {

	
	void save(PropertyDTO dto , MultipartFile[] files);
	PropertyDTO getPropertyById(Long id);
	
	void deletePropertyById(Long id);
	Property updateById(PropertyDTO propertyDTO,MultipartFile[] files,Long id);
}
