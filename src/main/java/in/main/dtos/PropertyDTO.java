package in.main.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PropertyDTO {
    private String propertyName;
    private Double basePrice;
    private String propertyType;
    private List<Imagedto> images; // JSON data
    private MultipartFile[] files; // Uploaded files

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public List<Imagedto> getImages() {
        return images;
    }

    public void setImages(List<Imagedto> images) {
        this.images = images;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}

