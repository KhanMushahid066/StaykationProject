package in.main.service;

import in.main.entities.ImageUpload;

public interface ImpageUploadService {

	ImageUpload save(ImageUpload imageUpload);
	public ImageUpload findById(Long id);
}
