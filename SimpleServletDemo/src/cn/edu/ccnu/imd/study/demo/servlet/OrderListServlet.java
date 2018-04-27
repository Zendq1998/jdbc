package cn.edu.ccnu.imd.study.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccnu.imd.study.demo.biz.OrderBiz;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderListServlet extends HttpServlet {
	private String url;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 定单列表
		this.getOrderList(request, response);
		request.getRequestDispatcher(this.url).forward(request, response);
	}

	// 获取表单列表
	void getOrderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sql = "1=1";

		OrderBiz biz = new OrderBiz();
		List _l = biz.getAllOrder(sql);

		request.setAttribute("OrderList", _l);
		this.url = "/WEB-INF/jsp/OrderList.jsp";
	}

}
