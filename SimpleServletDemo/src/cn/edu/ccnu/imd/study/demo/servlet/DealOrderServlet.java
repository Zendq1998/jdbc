package cn.edu.ccnu.imd.study.demo.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccnu.imd.study.demo.biz.OrderBiz;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class DealOrderServlet extends HttpServlet {
	private String url;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 修改定单状态
		this.dealOrder(request, response);

		this.url = "/servlets/OrderList.html";
		request.getRequestDispatcher(this.url).forward(request, response);
	}

	// 改变定单状态
	void dealOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 定义变量取值
		int id;
		short state;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = 0;
			System.out.println("获取ID失败！");
		}
		try {
			state = Short.parseShort(request.getParameter("state"));
		} catch (Exception e) {
			state = 4;
			System.out.println("获取state失败！");
		}
		OrderVo vo = new OrderVo();
		vo.setId(id);
		vo.setState(state);
		OrderBiz ob = new OrderBiz();
		ob.changeOrder(vo);
	}
}
