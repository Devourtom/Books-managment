package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.CollegeinfoEntity;
import com.svse.entity.DeptinfoEntity;
import com.svse.util.DBConnection;

public class DeptinfoDAO {
	
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public DeptinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<DeptinfoEntity> getAll()
	{
		List<DeptinfoEntity> ar = new ArrayList<DeptinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from deptinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int pid = rs.getInt("pid");
				int eid = rs.getInt("eid");
				String pname = rs.getString("pname");
				String premark = rs.getString("premark");

				DeptinfoEntity dept = new DeptinfoEntity();
				dept.setPid(pid);
				dept.setEid(eid);
				dept.setPname(pname);
				dept.setPremark(premark);
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
	public void addDeptinfo(DeptinfoEntity deptinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "insert into deptinfo values(null,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, deptinfo.getEid());
			pre.setString(2, deptinfo.getPname());
			pre.setString(3, deptinfo.getPremark());
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
	public DeptinfoEntity getOne(int pid)
	{
		DeptinfoEntity deptinfo = new DeptinfoEntity();
		try
		{
			conn = dbc.getConnection();
			String sql = "select *  from deptinfo where pid=?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, pid);
			rs = pre.executeQuery();
			while (rs.next())
			{

				String pname = rs.getString("pname");
				String premark = rs.getString("premark");

				deptinfo.setPid(pid);
				deptinfo.setPname(pname);
				deptinfo.setPremark(premark);
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
		return deptinfo;
	}

	// 修改
	public void updateDeptinfo(DeptinfoEntity deptinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "update deptinfo set eid=?,pname=?,premark=? where pid=?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, deptinfo.getEid());
			pre.setString(2, deptinfo.getPname());
			pre.setString(3, deptinfo.getPremark());
			pre.setInt(4, deptinfo.getPid());
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
