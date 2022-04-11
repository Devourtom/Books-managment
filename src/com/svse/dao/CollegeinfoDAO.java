package com.svse.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.CollegeinfoEntity;
import com.svse.util.DBConnection;

public class CollegeinfoDAO {
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public CollegeinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<CollegeinfoEntity> getAll()
	{
		List<CollegeinfoEntity> ar = new ArrayList<CollegeinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from  collegeinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				String eremark = rs.getString("eremark");

				CollegeinfoEntity dept = new CollegeinfoEntity();
				dept.setEid(eid);
				dept.setEname(ename);
				dept.setEremark(eremark);
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
	public void addCollegeinfo(CollegeinfoEntity collegeinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "insert into collegeinfo values(null,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, collegeinfo.getEname());
			pre.setString(2, collegeinfo.getEremark());
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
		public CollegeinfoEntity getOne(int eid)
		{
			CollegeinfoEntity collegeinfo = new CollegeinfoEntity();
			try
			{
				conn = dbc.getConnection();
				String sql = "select *  from collegeinfo where eid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, eid);
				rs = pre.executeQuery();
				while (rs.next())
				{

					String ename = rs.getString("ename");
					String eremark = rs.getString("eremark");

					collegeinfo.setEid(eid);
					collegeinfo.setEname(ename);
					collegeinfo.setEremark(eremark);
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
			return collegeinfo;
		}

		// 修改
		public void updateCollegeinfo(CollegeinfoEntity collegeinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "update collegeinfo set Ename=?,eremark=? where eid=?";
				pre = conn.prepareStatement(sql);
				pre.setString(1, collegeinfo.getEname());
				pre.setString(2, collegeinfo.getEremark());
				pre.setInt(3, collegeinfo.getEid());
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

		// 删除
		public void delCollegeinfo(int eid)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "delete from collegeinfo where eid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, eid);
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
