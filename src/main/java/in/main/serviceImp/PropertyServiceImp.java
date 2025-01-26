package in.main.serviceImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.main.dtos.Imagedto;
import in.main.dtos.PropertyDTO;
import in.main.entities.Property;
import in.main.repo.ImageRepo;
import in.main.repo.PropertyRepo;
import in.main.service.PropertyService;
import in.main.utils.FileStorageService;
@Service
public class PropertyServiceImp implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public void save(PropertyDTO dto, MultipartFile[] files){
        Property property = new Property();
        property.setPropertyName(dto.getPropertyName());
        property.setBasePrice(dto.getBasePrice());
        property.setPropertyType(dto.getPropertyType());
        Property savedProperty = propertyRepo.save(property);

        List<in.main.entities.Image> images = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            Imagedto imageDto = dto.getImages().get(i);

            in.main.entities.Image img = new in.main.entities.Image();
            img.setTittle(imageDto.getTittle());
            img.setDescription(imageDto.getDescription());
            img.setProperty(savedProperty);

            // Save the file using FileStorageService
            String filePath;//create lc varible 
			try {
				filePath = fileStorageService.saveFile(file); // assign the value from filStorageservice
				img.setFilePath( filePath);//set the path get from the fileservice
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            

            images.add(img);//set multiple images object in image entity
        }
        imageRepo.saveAll(images);//save list of image entity value in db;

       
    }

	
	
	@Override
	public PropertyDTO getPropertyById(Long id) {
	    // Fetch property from the database
	    Property property = propertyRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Property not found for ID: " + id));
	    
	    // Map property to PropertyDTO
	    PropertyDTO propertyDTO = new PropertyDTO();
	    propertyDTO.setPropertyName(property.getPropertyName());
	    propertyDTO.setBasePrice(property.getBasePrice());
	    propertyDTO.setPropertyType(property.getPropertyType());

	    // Add image URLs (assuming images are stored in a static folder or database path)
	    List<Imagedto> images = property.getImages().stream().map(image -> {
	        Imagedto imageDTO = new Imagedto();
	        imageDTO.setDescription(image.getDescription());
	        imageDTO.setTittle(image.getTittle());
//	        imageDTO.setTittle(image.getTittle());
	        imageDTO.setFilePath("/images/" + image.getFilePath()); // Assuming images are in static/images
	        return imageDTO;
	    }).toList();

	    propertyDTO.setImages(images);

	    return propertyDTO;
	}



	@Override
	public void deletePropertyById(Long id) {
		propertyRepo.deleteById(id);
		
	}



	@Override
	public Property updateById(PropertyDTO dto,MultipartFile[] files,Long id) {
		Optional<Property> optional = propertyRepo.findById(id);
		Property updatedproperty=null;
		if(!optional.isEmpty()) {
			Property property = optional.get();
			property.setPropertyName(dto.getPropertyName());
	        property.setBasePrice(dto.getBasePrice());
	        property.setPropertyType(dto.getPropertyType());
	        updatedproperty = propertyRepo.save(property);

	        List<in.main.entities.Image> images = new ArrayList<>();
	        for (int i = 0; i < files.length; i++) {
	            MultipartFile file = files[i];
	            Imagedto imageDto = dto.getImages().get(i);

	            in.main.entities.Image img = new in.main.entities.Image();
	            img.setTittle(imageDto.getTittle());
	            img.setDescription(imageDto.getDescription());
	            img.setProperty(updatedproperty);

	            // Save the file using FileStorageService
	            String filePath;//create lc varible 
				try {
					filePath = fileStorageService.saveFile(file); // assign the value from filStorageservice
					img.setFilePath( filePath);//set the path get from the fileservice
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            

	            images.add(img);//set multiple images object in image entity
	        }
	        imageRepo.saveAll(images);//save list of image entity value in db;

		}
		return updatedproperty;
	}


	

	
}
