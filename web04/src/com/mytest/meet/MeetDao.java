package com.mytest.meet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public boolean insert(Connection _conn, MeetVo vo) {
		StringBuffer sbSQL = new StringBuffer();
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = _conn;
//			写sql
			sbSQL.append("insert into meet (createTime,id,name,one,phone,position,station)");
			sbSQL.append("values (?,?,?,?,?,?,?)");
			ps = conn.prepareStatement(sbSQL.toString());
			int nIndex = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(++nIndex, sdf.format(vo.getCreateTime()));
			ps.setInt(++nIndex, vo.getId());
			ps.setString(++nIndex, vo.getName());
			ps.setInt(++nIndex, vo.getOne());
			ps.setString(++nIndex, vo.getPhone());
			ps.setString(++nIndex, vo.getPosition());
			ps.setString(++nIndex, vo.getStation());
//			执行sql
			ps.execute();
;		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
					return true;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
