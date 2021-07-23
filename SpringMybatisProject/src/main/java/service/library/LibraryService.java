package service.library;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.LibraryCommand;
import model.AuthInfoDTO;
import model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libWrite(LibraryCommand libraryCommand,
			HttpSession session) {
		//sesssion 로그인 정보 가지고오기위함 
		LibraryDTO dto= new LibraryDTO();
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		dto.setNoticeKind("자료실");
		AuthInfoDTO authInfo=(AuthInfoDTO)session.getAttribute("authInfo");
		dto.setEmployeeId(authInfo.getGrade());
		String originalTotal="";
		String storeTotal="";
		String fileSizeTotal="";
		if(libraryCommand.getNoticeFile()[0].getOriginalFilename()!="") {
			for(MultipartFile mf:libraryCommand.getNoticeFile()) {
				String original=mf.getOriginalFilename();
				String originalExt=
						//ㄹㅇ 이름
						original.substring(original.lastIndexOf("."));
				String store=
						//랜덤 이름 주기
						UUID.randomUUID().toString().replace("- ", "")+
						originalExt;
				//파일 사이즈 가지고와
				String fileSize =Long.toString(mf.getSize());
				originalTotal+=original+",";
				storeTotal +=store+",";
				fileSizeTotal+= fileSize+",";
				//파일경로 가지고오기
				String path="WEB-INF/view/library/upload";
				String realPath=
						session.getServletContext().getRealPath(path);
				//파일 저장하기 
				File  file=new File(realPath+"/"+store);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				dto.setNoticeOrgFile(originalTotal);
				dto.setNoticeFile(storeTotal);
				dto.setNoticeFileSize(fileSizeTotal);
				
				
				
			}
		}
		//alter table notice 
		//add (notice_org_file varchar2(300), notice_file_size varchar2(300));
		///desc notice;

		libraryRepository.libWrite(dto);
		
	}
}
