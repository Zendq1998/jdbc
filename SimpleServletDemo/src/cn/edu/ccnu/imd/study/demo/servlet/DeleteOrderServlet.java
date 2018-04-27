package cn.edu.ccnu.imd.study.demo.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccnu.imd.study.demo.biz.OrderBiz;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class DeleteOrderServlet extends HttpServlet {
	private String url;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 删除定单
		this.delOrder(request, response);

		this.url = "/servlets/OrderList.html";
		request.getRequestDispatcher(this.url).forward(request, response);
	}

	// 删除定单
	void delOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 定义变量取值
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = 0;
			System.out.println("获取ID失败！");
		}

		OrderVo vo = new OrderVo();
		vo.setId(id);

		OrderBiz ob = new OrderBiz();
		ob.delOrder(vo);
	}

}
