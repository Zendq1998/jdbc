package com.mytest.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mytest.meet.MeetBiz;
import com.mytest.meet.MeetVo;

/**
 * Servlet implementation class ChangeAll
 */
@WebServlet("/ChangeAll")
public class ChangeAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetVo vo = getForm(request, response);
		if (updateInfo(vo)) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败！");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/PostInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	MeetVo getForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String timestr = request.getParameter("createTime");
		System.out.println(timestr);
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		Date createTime = new Date();
		if (timestr != null) {
			try {
				createTime = sdf.parse(timestr);
				System.out.print("转化成功！"+createTime);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.print("转化失败！"+createTime);
				e1.printStackTrace();
			}
		}
		int id = 0;
		int one = 0;
		String idstr = request.getParameter("id");
		String name = request.getParameter("name");
		String position = request.getParameter("position");
		String phone = request.getParameter("phone");
		String station = request.getParameter("station");
		String onestr = request.getParameter("one");
		
		try {
			if (null != idstr && !"".equals(idstr)) {
				id = Integer.parseInt(idstr);
			}
			if (null != onestr && !"".equals(onestr)) {
				one = Integer.parseInt(onestr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MeetVo vo1 = new MeetVo();
		vo1.setId(id);
		vo1.setName(name);
		vo1.setPosition(position);
		vo1.setPhone(phone);
		vo1.setCreateTime(createTime);
		vo1.setStation(station);
		vo1.setOne(one);
		System.out.print(createTime);
		return vo1;
	}
	
	boolean updateInfo(MeetVo vo) {
		MeetBiz mb = new MeetBiz();
		if(mb.updateOneInfo(vo)) {
			return true;
		} else {
			return false;
		}
	}

}
