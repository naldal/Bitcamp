package imageboard.bean;

import lombok.Data;

@Data
public class ImageboardDTO {

	private int seq;
	private String imageid;
	private String imagename;
	private int imageprice;
	private int imageqty;
	private String imagecontent;
	private String image1;
	private String logtime;

}
