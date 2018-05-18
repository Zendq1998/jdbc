package com.mytest.meet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MeetDao {
	public List findbyAll(Connection _conn) {
//		把sql写出来
		String sql = "select * from meet where 1=1 ";
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
	public List findAll2(Connection _conn, String strSql, int offset, int pageNum) {
//		Vector v = new Vector();
		List l = new ArrayList();
		StringBuffer sbSQL = new StringBuffer();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = _conn;
			sbSQL.append("select * from meet where ");
			sbSQL.append(strSql);
			sbSQL.append(" limit " + offset + "," + pageNum);
			ps = conn.prepareStatement(sbSQL.toString());
			rs = ps.executeQuery();
			while(rs.next()) {
				MeetVo meet = new MeetVo();
				meet.setCreateTime(rs.getDate("createTime"));
				meet.setId(rs.getInt("id"));
				meet.setName(rs.getString("name"));
				meet.setOne(rs.getInt("one"));
				meet.setPhone(rs.getString("phone"));
				meet.setPosition(rs.getString("position"));
				meet.setStation(rs.getString("station"));
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
		} catch (Exception ex) {
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
	
	public boolean update(Connection _conn, MeetVo vo) {
		StringBuffer sbSQL = new StringBuffer();
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = _conn;
			sbSQL.append("update meet set createTime=?, name=?, one=?, phone=?, position=?, station=? where id=?");
			ps = conn.prepareStatement(sbSQL.toString());
			int nIndex = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(++nIndex, sdf.format(vo.getCreateTime()));
			ps.setString(++nIndex, vo.getName());
			ps.setInt(++nIndex, vo.getOne());
			ps.setString(++nIndex, vo.getPhone());
			ps.setString(++nIndex, vo.getPosition());
			ps.setString(++nIndex, vo.getStation());
			ps.setInt(++nIndex, vo.getId());
			ps.execute();
		} catch (Exception ex) {
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

	public boolean delete(Connection _conn, int id) {
		String sql = "delete from meet where id="+id;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = _conn;
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
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
		return true;
	}
	
	public void select(Connection _conn, int id, MeetVo meet) {
		String sql = "SELECT * FROM meet WHERE id=" + id;
		System.out.print(sql);
		PreparedStatement ps = null;
		try {
			ps = _conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				meet.setCreateTime(rs.getDate("createTime"));
				meet.setId(rs.getInt("id"));
				meet.setName(rs.getString("name"));
				meet.setOne(rs.getInt("one"));
				meet.setPhone(rs.getString("phone"));
				meet.setPosition(rs.getString("position"));
				meet.setStation(rs.getString("station"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	}
	public Long count(Connection _conn, String sql) {
		Long num = 0l;
		StringBuffer sbSQL = null;
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = _conn;
			sbSQL = new StringBuffer();
			sbSQL.append("select count(*) as num from meet where ");
			sbSQL.append(sql);
			ps = conn.prepareStatement(sbSQL.toString());
			rs = ps.executeQuery();
			while(rs.next()) {
				num = rs.getLong("num");
			}
		}catch (SQLException e) {
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
		return num;
	}
}
