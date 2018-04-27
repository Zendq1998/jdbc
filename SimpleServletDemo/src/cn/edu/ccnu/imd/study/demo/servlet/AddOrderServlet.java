package cn.edu.ccnu.imd.study.demo.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccnu.imd.study.demo.biz.OrderBiz;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class AddOrderServlet extends HttpServlet {
	private String url;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderVo vo = new OrderVo();
		vo = this.getForm(request, response);
		this.addAOrder(vo);
		
		this.url="/servlets/OrderList.html";
		request.getRequestDispatcher(this.url).forward(request, response);
	}

	// ��ȡ����ֲ
	OrderVo getForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �������ȡֵ
		float total = 0f;
		int numbers = 0;
		float price = 0f;
		short state = 0;
		int id = 0;

		// ȡֵ
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String strtotal = request.getParameter("total");
		String strnumbers = request.getParameter("numbers");
		String strprice = request.getParameter("price");
		String strstate = request.getParameter("state");
		String strid = request.getParameter("id");

		try {
			if (null != strtotal && !"".equals(strtotal)) {
				total = Float.parseFloat(strtotal);
			}
			if (null != strnumbers && !"".equals(strnumbers)) {
				numbers = Integer.parseInt(strnumbers);
			}
			if (null != strprice && !"".equals(strprice)) {
				price = Float.parseFloat(strprice);
			}
			if (null != strstate && !"".equals(strstate)) {
				state = Short.parseShort(strstate);
			}
			if (null != strid && !"".equals(strid)) {
				id = Integer.parseInt(strid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ����VOʵ��
		OrderVo vo1 = new OrderVo();
		vo1.setUserid(userid);
		vo1.setState(state);
		vo1.setTotal(total);
		vo1.setNumbers(numbers);
		vo1.setPrice(price);
		vo1.setName(name);

		vo1.setId(id);
		return vo1;
	}

	// ��Ӷ���
	void addAOrder(OrderVo vo) {
		// ����BIZ
		OrderBiz ob = new OrderBiz();
		ob.addOrder(vo);
	}
}
