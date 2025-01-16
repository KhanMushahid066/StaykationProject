package in.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.main.entities.ImageUpload;
import in.main.service.ImpageUploadService;

@RestController
@RequestMapping("/api")
public class ImageUploadController {

	@Autowired
	private ImpageUploadService impageUploadService;


	@PostMapping("/saveImg")
	public ResponseEntity<String> uploadImg(@RequestPart("img") ImageUpload imageUpload,
			@RequestParam("files") MultipartFile file) {
		try {
			if (file.getSize() > 0) {
				imageUpload.setImage(file.getBytes());
			}
			impageUploadService.save(imageUpload);
			return ResponseEntity.ok("Data received successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
		}
	}
	
	@GetMapping("/getImg/{id}")
	public ResponseEntity<byte[]> getImg(@PathVariable Long id) {
	    ImageUpload imageUpload = impageUploadService.findById(id);
	    System.out.println(imageUpload.toString());
	    if (imageUpload != null) {
	        byte[] imageBytes = imageUpload.getImage();
	        return ResponseEntity.ok()
	                             .contentType(MediaType.IMAGE_JPEG)
	                             .body(imageBytes);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}

}
