package controller.venta;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.CustomerTotalDTO;

public class CustomerTotalPage {
	public void customerTotal(HttpServletRequest request) {
		SalesDAO dao= new SalesDAO();
		List<CustomerTotalDTO> list=
				dao.customerTotal();
		String googleList="[['¾ÆÀÌµð/ÀÌ¸§','ÃÑ±¸¸Å±Ý¾×','ÃÑÈ½¼ö','Æò±Õ±Ý¾×']";
		for(CustomerTotalDTO dto : list) {
			googleList+=",['"+dto.getMemId()+"/"+dto.getMemName()+"',"
		+dto.getSumPrice()+","+dto.getCount()+","+dto.getAvg()+"]";
		}
		googleList+="]";
		request.setAttribute("googleList", googleList);
		request.setAttribute("list", list);
		
	}
}
