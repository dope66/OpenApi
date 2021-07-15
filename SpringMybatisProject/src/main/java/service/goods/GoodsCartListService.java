package service.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfoDTO;
import model.CartDTO;
import model.ProductCartDTO;
import repository.GoodsRepository;

public class GoodsCartListService {
	@Autowired
	GoodsRepository goodsRepository;
public void cartList(HttpSession session,Model model) {
	
	AuthInfoDTO authInfo= (AuthInfoDTO)session.getAttribute("authInfo");
	String memId=authInfo.getUserId();
//dto 에 있는 멤버가 1대1 관계일 경우 mybatis는 list로 값을 받아오지못한다
	//사용자의 장바구니에 있는 상품번호를 가져옴 
	List<String>prodNums=goodsRepository.memProdNum(memId);
	List<ProductCartDTO>list =new ArrayList<ProductCartDTO>();
	//리스트를 한번씩 해주기 위해서 for문으로 돌림 
	for(String prodNum: prodNums) {
		CartDTO dto= new CartDTO();
		dto.setMemId(memId);
		dto.setProdNum(prodNum);
		 //1대 1로 가져올때 assosiation을 사용한다.
		ProductCartDTO productCartDTO=
				goodsRepository.cartList(dto);
		list.add(productCartDTO);
	}
	model.addAttribute("lists",list);
}
}
