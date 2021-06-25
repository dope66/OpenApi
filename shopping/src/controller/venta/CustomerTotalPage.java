package controller.venta;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.SalesDAO;
import model.DTO.CustomerTotalDTO;

public class CustomerTotalPage {
	public void customerTotal(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SalesDAO dao= new SalesDAO();
		List<CustomerTotalDTO> list=
				dao.customerTotal();
		String googleList="[['���̵�/�̸�','�ѱ��űݾ�','��Ƚ��','��ձݾ�']";
		for(CustomerTotalDTO dto : list) {
			googleList+=",['"+dto.getMemId()+"/"+dto.getMemName()+"',"
		+dto.getSumPrice()+","+dto.getCount()+","+dto.getAvg()+"]";
		}
		googleList+="]";
		request.setAttribute("googleList", googleList);
		request.setAttribute("list", list);
		
	}
}
