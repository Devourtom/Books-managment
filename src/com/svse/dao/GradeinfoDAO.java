package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.GradeinfoEntity;
import com.svse.entity.UserinfoEntity;
import com.svse.util.DBConnection;

public class GradeinfoDAO {
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public GradeinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<GradeinfoEntity> getAll()
	{
		List<GradeinfoEntity> ar = new ArrayList<GradeinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from  gradeinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int gid = rs.getInt("gid");
				String mname = rs.getString("mname");
				String mremark = rs.getString("mremark");

				GradeinfoEntity dept = new GradeinfoEntity();
				dept.setGid(gid);
				dept.setMname(mname);
				dept.setMremark(mremark);
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

	// 增加
	public void addGradeinfo(GradeinfoEntity gradeinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "insert into gradeinfo values(null,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, gradeinfo.getMname());
			pre.setString(2, gradeinfo.getMremark());
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
	// 查询一个对象
		public GradeinfoEntity getOne(int gid)
		{
			GradeinfoEntity userinfo = new GradeinfoEntity();
			try
			{
				conn = dbc.getConnection();
				String sql = "select *  from gradeinfo where gid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, gid);
				rs = pre.executeQuery();
				while (rs.next())
				{

					String mname = rs.getString("mname");
					String mremark = rs.getString("mremark");

					userinfo.setGid(gid);
					userinfo.setMname(mname);
					userinfo.setMremark(mremark);
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
			return userinfo;
		}

		// 修改
		public void updateGradeinfo(GradeinfoEntity gradeinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "update gradeinfo set mname=?,mremark=? where gid=?";
				pre = conn.prepareStatement(sql);
				pre.setString(1, gradeinfo.getMname());
				pre.setString(2, gradeinfo.getMremark());
				pre.setInt(3, gradeinfo.getGid());
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
