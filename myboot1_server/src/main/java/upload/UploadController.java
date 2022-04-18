package upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value="/fileupload", method = RequestMethod.GET)
	public String uploadform(){
		return "upload/uploadform";
	}
	
	@RequestMapping(value="/fileupload", method = RequestMethod.POST)
	public String uploadresult(@ModelAttribute("dto") UploadDTO dto) throws IOException{
		MultipartFile mf1 = dto.getFile1();
		MultipartFile mf2 = dto.getFile2();
		System.out.println(dto.getName());
		System.out.println(dto.getDescription());	
		System.out.println(mf1.getOriginalFilename()); //업로드한 파일이름
		System.out.println(mf2.getOriginalFilename()); //이름
		System.out.println(mf1.getSize()); //길이
		System.out.println(mf2.getSize()); //길이
		System.out.println(mf1.isEmpty()); //파일선택여부
		System.out.println(mf2.isEmpty());

		// 파일내용+파일명--> 서버 c:/upload 폴더 영구 저장
		String savePath = "c:/upload/";
		
		if(!mf1.isEmpty()) {
			String originname1 = mf1.getOriginalFilename();
			String beforeext1 = originname1.substring(0, originname1.indexOf("."));
			String ext1 = originname1.substring(originname1.indexOf("."));
			File serverfile1 = new File(savePath + beforeext1+"("+UUID.randomUUID().toString()+")"+ext1); 
			mf1.transferTo(serverfile1);
		}
		if(!mf2.isEmpty()) {
			//원래파일명
			String originname2 = mf2.getOriginalFilename();
			//확장자 이전파일명
			String beforeext2 = originname2.substring(0, originname2.indexOf("."));
			//확장자 이후
			String ext2 = originname2.substring(originname2.indexOf("."));
			
			File serverfile2 = new File(savePath + beforeext2+"("+UUID.randomUUID().toString()+")"+ext2); 
			mf2.transferTo(serverfile2);
		}
		
		return "upload/uploadresult";
	}
}
