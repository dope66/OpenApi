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

public class GoodsBuyService {
	@Autowired
	GoodsRepository goodsRepository;

	public void goodsBuy(String[] prodNums, HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO) session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		List<ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		for (String prodNum : prodNums) {
			//cartList에서 사용했던 정보를 그대로 옮겼다.
			CartDTO dto = new CartDTO();
			dto.setMemId(memId);
			dto.setProdNum(prodNum);
			ProductCartDTO productCartDTO = goodsRepository.cartList(dto);
			list.add(productCartDTO);
		}
		model.addAttribute("lists", list);
	}
}
