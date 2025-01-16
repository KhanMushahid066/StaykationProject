package in.main.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.entities.ImageUpload;
import in.main.repo.ImageUploadRepo;
import in.main.service.ImpageUploadService;
@Service
public class ImageUploadServiceImp   implements ImpageUploadService  {

	
	@Autowired
	private ImageUploadRepo imageUploadRepo;
	@Override
	public ImageUpload save(ImageUpload imageUpload) {
		
		return imageUploadRepo.save(imageUpload);
	}
	
	@Override
	public ImageUpload findById(Long id) {
	    return imageUploadRepo.findById(id).orElse(null);
	}


}
