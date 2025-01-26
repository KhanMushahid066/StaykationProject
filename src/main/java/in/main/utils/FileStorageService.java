package in.main.utils;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    // Fetch directory path from application.properties
    @Value("${file.upload-dir}")
    private String uploadDir;

    /**  
     * Save file in the directory and return the saved file path
     *
     * @param file MultipartFile to save
     * @return Saved file path
     * @throws IOException If file saving fails
     */
    public String saveFile(MultipartFile file) throws IOException {
        // Resolve full path relative to the project root
        String fullPath = System.getProperty("user.dir") + File.separator + uploadDir;//ye line me jo methods h wo kya kar rahe h 

        // Ensure directory exists
        File directory = new File(fullPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }

        // Generate unique file name
        String originalFilename = file.getOriginalFilename();//step1 get original file name
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));//step 2 concanate original file name with extenstion
        String uniqueFileName = UUID.randomUUID().toString() + extension;//step 3 join uniqueid with extension==originalfile+extension

        // Complete file path
        String filePath = fullPath + File.separator + uniqueFileName;//join fullpath with uniquiFilename == uniqueid+imagename+extenstion

        // Save the file
        Files.copy(file.getInputStream(), Paths.get(filePath));//ye line me jo methods h wo kya kar rahe h 

       // return "/images/" + uniqueFileName; // Return relative path for storage in DB
        return  uniqueFileName;
    }
}

