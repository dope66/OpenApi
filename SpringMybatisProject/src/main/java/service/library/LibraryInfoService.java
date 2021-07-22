package service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryInfoService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libraryInfo( Model model,String noticeNo)
	{ 
		libraryRepository.libCount(noticeNo);
	LibraryDTO dto= libraryRepository.libraryInfo(noticeNo);
	model.addAttribute("dto",dto);
	}
}
