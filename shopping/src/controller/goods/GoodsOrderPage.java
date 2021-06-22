package controller.goods;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.PurchaseDTO;

public class GoodsOrderPage {

		public String goodsOrder(HttpServletRequest request	) {
			HttpSession session = request.getSession();
			AuthInfo authInfo=(AuthInfo) session.getAttribute("authInfo");
			
			Date day=new Date();
			SimpleDateFormat df= new SimpleDateFormat("yyyyMMddHHmmss");
			String purchaseNum= df.format(day);
			
			
			PurchaseDTO dto = new PurchaseDTO();
			dto.setPurchaseTotPrice(request.getParameter("purchaseTotPrice"));
			String memId=authInfo.getUserId();
			dto.setMemId(memId);
			dto.setPurchaseAddr(request.getParameter("purchaseAddr"));
			dto.setPurchaseMethod(request.getParameter("purchaseMethod"));
			dto.setPurchaseNum(purchaseNum);
			dto.setPurchaseRequest(request.getParameter("purchaseRequest"));
			dto.setReceiverName(request.getParameter("receiverName"));
			dto.setReceiverPhone(request.getParameter("purchasePhone"));
			GoodsDAO dao= new GoodsDAO();
			dao.purchaseInsert(dto);
			String []prodNums =request.getParameter("prodNums").split(",");
			for (String prodNum:prodNums) {
			dao.purchaseListInsert(purchaseNum,prodNum,memId);
			}
			for (String prodNum:prodNums) {
				dao.cartDel(prodNum,memId);
			}
			
			return purchaseNum+","+dto.getPurchaseTotPrice(); //2개값을 한번에 보내기위해 묶었다.
		}

}
