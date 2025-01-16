package in.main.dtos;

public class Imagedto {
    private String tittle;
    private String description;
    private String filePath;

    public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Imagedto() {
        super();
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String title) {
        this.tittle = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
