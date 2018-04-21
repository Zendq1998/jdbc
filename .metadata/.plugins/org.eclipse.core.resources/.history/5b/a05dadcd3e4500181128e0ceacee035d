package meet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetDao {
	public List findbyAll(Connection _conn) {
//		把sql写出来
		String sql = "select * from meet";
//		准备sql工作
		PreparedStatement ps = null;
		List l = null;
		try {
			ps = _conn.prepareStatement(sql);
//			执行sql
			ResultSet rs = ps.executeQuery();
//			定义一个list
			l = new ArrayList();
//			循环读取数据
			while(rs.next()) {
//				定义一行vo装一行数据
				MeetVo meet = new MeetVo();
//				把每个字段的数据装进vo
				meet.setCreateTime(rs.getDate("createTime"));
				meet.setId(rs.getInt("id"));
				meet.setName(rs.getString("name"));
				meet.setOne(rs.getInt("one"));
				meet.setPhone(rs.getString("phone"));
				meet.setPosition(rs.getString("position"));
				meet.setStation(rs.getString("station"));
//				把vo打包到集合l中
				l.add(meet);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				关闭ps
				if(ps != null) {
					ps.close();
					ps = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return l;
	}
}
