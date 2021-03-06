package meet;

import java.sql.Connection;
import java.util.List;

import common.DBConnection;

public class MeetBiz {
	public List getAllMeets() {
//		声明一个集合类
		List l = null;
//		定义一个数据库连接获取对象
		DBConnection dbc = new DBConnection();
//		获取数据库连接，并判断是否成功
		if(dbc.getConnect()) {
			Connection conn = dbc.getConn();
//			创建一个dao
			MeetDao dao = new MeetDao();
//			把数据丢给dao去执行sql
			l = dao.findbyAll(conn);
//			关闭数据库
			try {
				conn.close();
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		else {
			System.out.println("数据库连接失败");
		}
		return l;
		
	}
}
