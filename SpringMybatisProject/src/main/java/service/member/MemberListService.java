package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageAction;
import model.MemberDTO;
import model.StartEndPageDTO;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
 public void memList(Model model,String memId, Integer page)
 {
	 int limit =5;
	 int limitPage=10;
	 MemberDTO dto= new MemberDTO();
	 //						1 -1=0*10+1=1	
	 if(page!=null) {
	 Long startRow=((long)page-1)*limit +1;
	 Long endRow=startRow+limit -1 ;
	 //mybatis에서 3개 못받아서 DTo만들거임
	 StartEndPageDTO sep= new StartEndPageDTO();
	 sep.setStartRow(startRow);
	 sep.setEndRow(endRow);
	 
	 
	 dto.setStartEndPageDTO(sep);
	 }
	 dto.setMemId(memId);
	 List<MemberDTO> list=memberRepository.memList(dto);
	 Integer count = memberRepository.getMemberCount();
	 model.addAttribute("lists",list);
	 model.addAttribute("count",count);
	 //총페이지수 
	 int maxPage =(int)((double) count / limit+0.99);
	 int startPage= (int)((double)page / limitPage +0.99);
	 int endPage=startPage+limitPage-1;
	 if(endPage>maxPage)endPage=maxPage;
	 model.addAttribute("maxPage",maxPage);
	 model.addAttribute("startPage",startPage);
	 model.addAttribute("endPage",endPage);
	 model.addAttribute("page",page);
	 if(page!=null) {
	 PageAction pageAction= new PageAction();
	 pageAction.page(count, limit, page, limitPage, model, "memList");
	 }
 }
}
