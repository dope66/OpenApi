package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.goods.GoodsReviewsService;

@Controller
@RequestMapping("prod")
public class GoodsViewController {
	@Autowired
	GoodsReviewsService goodsReviewsService;

	
	@RequestMapping("goodsView")
	public String goodsView(
			@RequestParam(value="prodNum")String prodNum,
			Model model ,HttpSession session) {
		goodsReviewsService.goodsReviews(prodNum, model,session);
		return "goods/goodsView";

	}

}
