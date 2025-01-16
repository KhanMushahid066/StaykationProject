package in.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.main.dtos.PropertyDTO;
import in.main.service.PropertyService;

@RestController
@RequestMapping("/api")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/saveProperty")
    public ResponseEntity<String> uploadFileAndData(
            @RequestPart("files") MultipartFile[] files,
            @RequestPart("property") PropertyDTO propertyDTO) {
        
        // Process the files
        for (MultipartFile file : files) {
            System.out.println("File received: " + file.getOriginalFilename());
        }

        // Process the JSON data
        System.out.println("Property data: " + propertyDTO);
        propertyService.save(propertyDTO, files);

        return ResponseEntity.ok("Data received successfully!");
    }


//    @GetMapping("/getproperty{id}")
//    public ResponseEntity<?> getProperty(@PathVariable("id") Long id) {
//        // Your logic here
//        return ResponseEntity.ok("Property data for ID: " + id);
//    }
    
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
    
    @GetMapping("/testproperty")
    public String test() {
    	return "all working";
    }
}



