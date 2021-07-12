package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsCommand;
import service.goods.GoodsDetailService;
import service.goods.GoodsListService;
import service.goods.GoodsNumberService;
import service.goods.GoodsWriteService;
import validator.GoodsCommandValidator;
@Controller
@RequestMapping("goods")
public class GoodsController {
@Autowired
GoodsNumberService goodsNumberService;
@Autowired
GoodsWriteService goodsWriteService;
@Autowired
GoodsListService goodsListService;
@Autowired
GoodsDetailService goodsDetailService;

@RequestMapping(value="goodsJoin",method=RequestMethod.POST)
public String join(GoodsCommand goodsCommand, Errors errors,
		HttpSession session) {
	//errors를 가져왔으니 위에 ERRORS를 추가하자 
	new GoodsCommandValidator().validate(goodsCommand, errors);
	if(errors.hasErrors()) {
		return"goods/goodsJoin";
		
	}
	goodsWriteService.goodsWrite(goodsCommand,session);
	return "redirect:goodsList";
}
@RequestMapping("prodModify")

public String prdModify(@RequestParam(value="prodNum") String prodNum,
		Model model) {
	goodsDetailService.goodsDetail(prodNum, model);
	return "goods/goodsModify";
}
@RequestMapping("prodDetail")
public String prodDetail(@RequestParam(value="prodNum") 
	String prodNum, Model model) {
	//리포지트를 사용하기 위해서는 service를 만들어야됩니다
	//리포지트를 사용하는 이유는 디비에 접속하기 위해서 사용하는게 리포지트 
	
	goodsDetailService.goodsDetail(prodNum, model);
	return "goods/goodsDetail";
	
}

	@RequestMapping("goodsList")
	public String list(Model model) {
		goodsListService.goodsList(model);
		
		return "goods/goodsList";
	}
	@RequestMapping("goodsRegist")
	//아래 모델을 썻으니?까 모델을 불러온다 이말이야
	public String regist(Model model) {
		//db로 먼저갔다와야된다.그러니까 서비스 
		//Model:자바에서 만들어진 값을 jsp에 전달하기 위해서 사용 
		goodsNumberService.goodsNum(model);
		
		return "goods/goodsJoin";
	}
}
