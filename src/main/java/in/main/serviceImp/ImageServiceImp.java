package in.main.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.dtos.Imagedto;
import in.main.entities.Image;
import in.main.repo.ImageRepo;
import in.main.service.ImageServie;

@Service
public class ImageServiceImp  implements ImageServie{

	@Autowired
	private ImageRepo imageRepo;
	@Override
	public void add(Imagedto imagedto) {
		Image img = new Image();
		img.setTittle(imagedto.getTittle());
		img.setDescription(imagedto.getDescription());
//		img.setFile(imagedto.getFile());
		imageRepo.save(img);
		
	}

}
