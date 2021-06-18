package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsController extends HttpServlet implements Servlet {

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if (command.equals("/goodsList.gd")) {
			GoodsListPage action =new GoodsListPage();
			
			action.goodsList(request);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsRegist.gd")) {
			response.setCharacterEncoding("utf-8");
			GoodsNumberPage action=
					new GoodsNumberPage();
			action.goodsNum(request);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("goods/goodsJoin.jsp");
			dispatcher.include(request, response);
		}else if(command.equals("/goodsJoin.gd")) {
			GoodsJoinPage action = new GoodsJoinPage();
			action.goodsJoin(request);
			response.sendRedirect("goodsList.gd");
		}
		else if (command.equals("/prodDetail.gd")) {
			GoodsModifyPage action= new GoodsModifyPage();
			action.goodsModify(request);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("goods/goodsModify.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/goodsModify.gd")) {
			GoodsUpdatePage action= new GoodsUpdatePage();
			//�쐞�뿉�꽌 �옒紐삵빐�꽌 modify瑜� �빐�꽌 �뿬湲곗뿉 �뾽�뜲�씠�듃瑜쇳븿
			action.goodsUpdate(request);
			response.sendRedirect("goodsList.gd");
		}
		else if(command.equals("/prodDel.gd")) {
			GoodsDeletePage action= new  GoodsDeletePage();
			action.prodDelete(request);
			response.sendRedirect("goodsList.gd");		
		}else if(command.equals("/prodInfo.gd")) {
			response.setCharacterEncoding("utf-8");
			GoodsModifyPage action= new GoodsModifyPage();
			action.goodsModify(request);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("goods/goodsDetail.jsp");
			dispatcher.include(request, response);// forward include anyway
		}else if (command.equals("/goodsCartAdd.gd")) {
			GoodsCartAddPage action=
					new GoodsCartAddPage();
			action.cartAdd(request);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("goods/goodsCart.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
