package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfoDTO;
import model.CartDTO;
import repository.GoodsRepository;

public class CartProdDeleteService {
@Autowired
GoodsRepository goodsRepository;
public void cartProdDel(String prodNum,HttpSession session) {
	
	//memid(내아이디)가 필요하다 그래서 세션이 필요하다 
	AuthInfoDTO authInfo= (AuthInfoDTO)session.getAttribute("authInfo");
	String memId=authInfo.getUserId();
	CartDTO dto= new CartDTO();
	dto.setProdNum(prodNum);
	dto.setMemId(memId);
	
	
	goodsRepository.cartProdDel(dto);
	
}
}
