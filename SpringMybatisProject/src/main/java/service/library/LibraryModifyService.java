package service.library;

import org.springframework.beans.factory.annotation.Autowired;

import command.LibraryCommand;
import model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryModifyService {
	@Autowired
	LibraryRepository libraryRepository;
 public void libModify(LibraryCommand libraryCommand) {
	 LibraryDTO dto= new LibraryDTO();
	 dto.setNoticeCon(libraryCommand.getNoticeCon());
	 dto.setNoticeSub(libraryCommand.getNoticeSub());
	 dto.setNoticeNo(libraryCommand.getNoticeNo());
	 System.out.println(dto.getNoticeCon());
	 System.out.println(dto.getNoticeSub());
	 System.out.println(dto.getNoticeNo());
	 libraryRepository.libModify(dto);
 }
}
