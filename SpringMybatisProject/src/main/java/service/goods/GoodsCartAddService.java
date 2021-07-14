package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.CartDTO;
import repository.GoodsRepository;

public class GoodsCartAddService {
	@Autowired
	GoodsRepository goodsRepository;
	public void cartAdd(int cartQty,String prodNum,int prodPrice,
			HttpSession session,Model model) {// dto에 저장해야된다
		CartDTO dto= new CartDTO();
		//memId는 세션으로 받아야된다 그래서 컨트롤러에 세션추가
		AuthInfoDTO authInfo= (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		dto.setCartQty(cartQty);
		dto.setProdNum(prodNum);
		dto.setCartPrice(prodPrice*cartQty);
		int i=goodsRepository.cartAdd(dto);
		model.addAttribute("num",i);//num값누가 받는지 컨트롤로 ㄱ
		//이제 리포지트에 추가 한다 .
	}
}
