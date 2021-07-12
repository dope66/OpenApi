package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsListService {
@Autowired
GoodsRepository goodsRepository;
	public void goodsList(Model model) {
		//list로 값을 전달?= model
		List<GoodsDTO> list =goodsRepository.goodsList();
		model.addAttribute("lists",list);
		 // 여기서 만들었어 ? 그럼 리포지트로 간다 이말이야 
	
		
	}
	
}
