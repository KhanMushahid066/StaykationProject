package in.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.main.dtos.PropertyDTO;
import in.main.entities.Property;
import in.main.service.PropertyService;

@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/saveProperty")
    public ResponseEntity<String> saveProperty(
            @RequestPart("files") MultipartFile[] files,
            @RequestPart("property") PropertyDTO propertyDTO) {
        
        // Process the files cchecking...
        for (MultipartFile file : files) {
            System.out.println("File received: " + file.getOriginalFilename());
        }

        // Process the JSON data checking...
        System.out.println("Property data: " + propertyDTO);
        propertyService.save(propertyDTO, files);

        return ResponseEntity.ok("Data received successfully!");
    }



    @GetMapping("/getproperty/{id}")
    public ResponseEntity<?> getProperty(@PathVariable("id") Long id) {
        try {
            PropertyDTO propertyDTO = propertyService.getPropertyById(id);
            return ResponseEntity.ok(propertyDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound()
                    .build();
        }
    }
    
    
    
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
    	
    	try {
    		propertyService.deletePropertyById(id);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	return ResponseEntity.ok("deleted successfully.....");
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Property> updateById(@RequestBody PropertyDTO dto, @RequestPart MultipartFile[] files, @PathVariable Long id) {
        Property updatedProperty = propertyService.updateById(dto, files, id);
        if (updatedProperty != null) {
            return new ResponseEntity<>(updatedProperty, HttpStatus.OK); // Return 200 OK with updated property
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if property not found
        }
    }

    @GetMapping("/testproperty")
    public String test() {
    	return "all working";
    }
}



