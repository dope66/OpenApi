package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsDetailService {
	@Autowired
	GoodsRepository goodsRepository;
	//모델 : 리포지트로부터 받은걸 jsp로 넘기기위해서 
public void goodsDetail(String prodNum, Model model) {
	GoodsDTO dto= goodsRepository.goodsDetail(prodNum);
	//model.addA
	model.addAttribute("goodsCommand",dto);
	
	
	
	
}
}
