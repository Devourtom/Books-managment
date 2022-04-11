package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.MajorinfoEntity;
import com.svse.entity.StuinfoEntity;
import com.svse.util.DBConnection;

public class StuinfoDAO {
	
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public StuinfoDAO()
	{
		dbc = new DBConnection();
	}

	// ȫ��ѯ
	public List<StuinfoEntity> getAll()
	{
		List<StuinfoEntity> ar = new ArrayList<StuinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from stuinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int sid = rs.getInt("sid");
				int mid = rs.getInt("mid");
				String sname = rs.getString("sname");
				String ssex = rs.getString("ssex");
				String stel = rs.getString("stel");
				String saddress = rs.getString("saddress");

				StuinfoEntity dept = new StuinfoEntity();
				dept.setSid(sid);
				dept.setMid(mid);
				dept.setSname(sname);
				dept.setSsex(ssex);
				dept.setStel(stel);
				dept.setSaddress(saddress);
				ar.add(dept);
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbc.closeAll(rs, pre, conn);
		}
		return ar;
	}
	
	
	// ����
			public void addStuinfo(StuinfoEntity stuinfo)
			{
				try
				{
					conn = dbc.getConnection();
					String sql = "insert into stuinfo values(null,?,?,?,?,?)";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, stuinfo.getMid());
					pre.setString(2, stuinfo.getSname());
					pre.setString(3, stuinfo.getSsex());
					pre.setString(4, stuinfo.getSname());
					pre.setString(5, stuinfo.getSaddress());
					pre.executeUpdate();

				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					dbc.closeAll(rs, pre, conn);
				}
			}
			// ��ѯһ������
			public StuinfoEntity getOne(int sid)
			{
				StuinfoEntity stuinfo = new StuinfoEntity();
				try
				{
					conn = dbc.getConnection();
					String sql = "select * from stuinfo where sid=?";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, sid);
					rs = pre.executeQuery();
					while (rs.next())
					{
						int mid = rs.getInt("mid");
						String sname = rs.getString("sname");
						String ssex = rs.getString("ssex");
						String stel = rs.getString("stel");
						String saddress = rs.getString("saddress");
						
						
						stuinfo.setSid(sid);
						stuinfo.setMid(sid);
						stuinfo.setSname(sname);
						stuinfo.setSsex(ssex);
						stuinfo.setStel(stel);
						stuinfo.setSaddress(saddress);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					dbc.closeAll(rs, pre, conn);
				}
				return stuinfo;
			}

			// �޸�
			public void updateStuinfo(StuinfoEntity stuinfo)
			{
				try
				{
					conn = dbc.getConnection();
					String sql = "update stuinfo set mid=?,sname=?,ssex=?,stel=?,saddress=? where sid=?";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, stuinfo.getMid());
					pre.setString(2, stuinfo.getSname());
					pre.setString(3, stuinfo.getSsex());
					pre.setString(4, stuinfo.getStel());
					pre.setString(5, stuinfo.getSaddress());
					pre.setInt(6, stuinfo.getSid());
					pre.executeUpdate();
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					dbc.closeAll(rs, pre, conn);
				}
			}

}
