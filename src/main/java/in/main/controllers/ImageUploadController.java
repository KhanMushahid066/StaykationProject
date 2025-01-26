package in.main.controllers;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
public class ImageUploadController 
{

	@Autowired
	private ImpageUploadService imageUploadService;

	@PostMapping("/saveImg")
	public ResponseEntity<String> uploadImg(@RequestPart("img") ImageUpload imageUpload, @RequestParam("files") MultipartFile file) 
	{
		try {
					if (file.getSize() > 0) 
					{
						
							imageUpload.setImage(file.getBytes());
					}
					imageUploadService.save(imageUpload);
					return ResponseEntity.ok("Data received successfully!");
			} catch (Exception e) 
			{
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
			}
	}

	//test 1
//	@GetMapping("/getImg/{id}")
//	public ResponseEntity<byte[]>getImg(@PathVariable Long id) 
//	{
//		ImageUpload imageUpload = impageUploadService.findById(id);
//		System.out.println(imageUpload.toString());
//			if (imageUpload != null) 
//			{
//				byte[] imageBytes = imageUpload.getImage();
//				return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//			} else 
//			{
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//			}
//			
//	}
	
	
	//test 2
//	@GetMapping("/getImg/{id}")
//	public ResponseEntity<ImageUpload> getImg(@PathVariable Long id) 
//	{
//	    ImageUpload imageUpload = impageUploadService.findById(id);
//
//	    if (imageUpload != null) 
//	    {
//	        return ResponseEntity.ok().body(imageUpload);
//	    } 
//	    else 
//	    {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	    }
//	}
	
	//test 3
	@GetMapping("/getImg/{id}")
	public ResponseEntity<Map<String, Object>> getImg(@PathVariable Long id) 
	{
	    ImageUpload imageUpload = imageUploadService.findById(id);

	    if (imageUpload != null) 
	    {
	        Map<String, Object> responseBody = new HashMap<>();
	        
	        // Image ko Base64 encoded string mein convert karna
	        
	        String base64Image = Base64.getEncoder().encodeToString(imageUpload.getImage());

	        // Sabhi fields ko responseBody mein add karna
	        responseBody.put("id", imageUpload.getId());
	        responseBody.put("imgname", imageUpload.getImgname());
	        responseBody.put("title", imageUpload.getTitle());
	        responseBody.put("description", imageUpload.getDescription());
	        responseBody.put("place", imageUpload.getPlace());
	        // Base64 encoded image string bhejna
	        responseBody.put("image", base64Image);

	        System.out.println(responseBody);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	        return ResponseEntity.ok().headers(headers).body(responseBody);
	    } 
	    else 
	    {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}



}
