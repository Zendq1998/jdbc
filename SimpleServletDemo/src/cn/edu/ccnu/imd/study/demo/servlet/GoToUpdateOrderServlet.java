package cn.edu.ccnu.imd.study.demo.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccnu.imd.study.demo.biz.OrderBiz;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class GoToUpdateOrderServlet extends HttpServlet {
	private String url;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 修改定单第一步
		this.updateOrder1(request, response);
		request.getRequestDispatcher(this.url).forward(request, response);

	}

	// 修改定单
	void updateOrder1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 定义变量取值
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = 0;
			System.out.println("获取ID失败！");
		}

		// 创建VO
		OrderVo vo = new OrderVo();
		vo.setId(id);
		// 创建BIZ
		OrderBiz biz = new OrderBiz();
		vo = biz.getAOrder(vo);
		// 储存入request
		request.setAttribute("OrderVo", vo);
		this.url = "/WEB-INF/jsp/OrderUpdate.jsp";
	}

}
