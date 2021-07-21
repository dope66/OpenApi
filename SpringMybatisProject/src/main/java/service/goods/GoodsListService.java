package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageAction;
import model.GoodsDTO;
import model.StartEndPageDTO;
import repository.GoodsRepository;

public class GoodsListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsList(Model model,Integer page) {
		int limit =3;
		 int limitPage=10;
		 GoodsDTO dto= new GoodsDTO();
		 if(page!=null) {
			 //						1 -1=0*10+1=1	
			 Long startRow=((long)page-1)*limit +1;
			 Long endRow=startRow+limit -1 ;
			 //mybatis에서 3개 못받아서 DTo만들거임
			 StartEndPageDTO sep= new StartEndPageDTO();
			 sep.setStartRow(startRow);
			 sep.setEndRow(endRow);
			 dto.setStartEndPageDTO(sep);
			  
		 }
		
		
		List<GoodsDTO> list = goodsRepository.goodsList(dto);
		int count=goodsRepository.count();
		model.addAttribute("lists",list);
		model.addAttribute("count",count);
		
		if(page!=null) { PageAction pageAction= new PageAction();
		 pageAction.page(count, limit, page, limitPage, model, "goodsList");
		 }
		
	}
}