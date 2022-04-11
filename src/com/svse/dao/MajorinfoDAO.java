package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.DeptinfoEntity;
import com.svse.entity.MajorinfoEntity;
import com.svse.util.DBConnection;

public class MajorinfoDAO {
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public MajorinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<MajorinfoEntity> getAll()
	{
		List<MajorinfoEntity> ar = new ArrayList<MajorinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from majorinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int mid = rs.getInt("mid");
				int pid = rs.getInt("pid");
				String mname = rs.getString("mname");
				String mremark = rs.getString("mremark");

				MajorinfoEntity dept = new MajorinfoEntity();
				dept.setMid(mid);
				dept.setPid(pid);
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
		public void addMajorinfo(MajorinfoEntity majorinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "insert into majorinfo values(null,?,?,?)";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, majorinfo.getPid());
				pre.setString(2, majorinfo.getMname());
				pre.setString(3, majorinfo.getMremark());
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
		public MajorinfoEntity getOne(int mid)
		{
			MajorinfoEntity majorinfo = new MajorinfoEntity();
			try
			{
				conn = dbc.getConnection();
				String sql = "select * from majorinfo where mid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, mid);
				rs = pre.executeQuery();
				while (rs.next())
				{

					String mname = rs.getString("mname");
					String mremark = rs.getString("mremark");

					majorinfo.setMid(mid);
					majorinfo.setMname(mname);
					majorinfo.setMremark(mremark);
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
			return majorinfo;
		}

		// 修改
		public void updateMajorinfo(MajorinfoEntity majorinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "update majorinfo set pid=?,mname=?,mremark=? where mid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, majorinfo.getPid());
				pre.setString(2, majorinfo.getMname());
				pre.setString(3, majorinfo.getMremark());
				pre.setInt(4, majorinfo.getMid());
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
