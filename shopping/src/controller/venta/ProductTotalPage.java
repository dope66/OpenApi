package controller.venta;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.ProductTotalDTO;

public class ProductTotalPage {
	public void productTotal(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SalesDAO dao= new SalesDAO();
		List<ProductTotalDTO> list=
				dao.productTotal();
		String googleList="[[''상품번호/상품이름','총구매금액','총횟수','평균금액'']";
		for(ProductTotalDTO dto : list) {
			googleList+=",['"+dto.getProdNum()+"/"+dto.getProdName()+"',"
		+dto.getSumPrice()+","+dto.getCount()+","+dto.getAvgPrice()+"]";
		}
		googleList+="]";
		request.setAttribute("googleList", googleList);
		request.setAttribute("list", list);
		
	}
}
