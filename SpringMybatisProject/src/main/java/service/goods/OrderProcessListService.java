package service.goods;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.OrderListDTO;
import repository.GoodsRepository;

public class OrderProcessListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void orderList(HttpSession session, Model model) {
		AuthInfoDTO authInfo= (AuthInfoDTO)session.getAttribute("authInfo");
		String memId=authInfo.getUserId();
		
		// 일반적인 방법
		List<OrderListDTO> list= goodsRepository.baseOrderList(memId);
		model.addAttribute("list",list);
		
		
	}
}
