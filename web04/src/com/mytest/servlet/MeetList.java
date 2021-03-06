package com.mytest.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mytest.meet.*;
/**
 * Servlet implementation class MeetList
 */
@WebServlet("/MeetList")
public class MeetList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 TODO Auto-generated method stub
		int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		String sql = "1=1";
		MeetBiz biz = new MeetBiz();
//		用biz获取我们要的数据
		List l = biz.getAllMeets();
		Map map = biz.getAllMeets2(sql,3,page);
//		把数据发到jsp
		request.setAttribute("meetList",l);
		request.setAttribute("meetMap", map);
		request.getRequestDispatcher("/WEB-INF/jsp/MeetList.jsp").forward(request,response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
