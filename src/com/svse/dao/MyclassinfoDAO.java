package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.DeptinfoEntity;
import com.svse.entity.MyclassinfoEntity;
import com.svse.util.DBConnection;

public class MyclassinfoDAO {
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public MyclassinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<MyclassinfoEntity> getAll()
	{
		List<MyclassinfoEntity> ar = new ArrayList<MyclassinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from myclassinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int cid = rs.getInt("cid");
				int mid = rs.getInt("mid");
				int gid = rs.getInt("gid");
				String mname = rs.getString("mname");
				String mremark = rs.getString("mremark");

				MyclassinfoEntity dept = new MyclassinfoEntity();
				dept.setCid(cid);
				dept.setMid(mid);
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
		public void addMyclassinfo(MyclassinfoEntity myclassinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "insert into myclassinfo values(null,?,?,?,?)";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, myclassinfo.getMid());
				pre.setInt(2, myclassinfo.getGid());
				pre.setString(3, myclassinfo.getMname());
				pre.setString(4, myclassinfo.getMremark());
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
		public MyclassinfoEntity getOne(int cid)
		{
			MyclassinfoEntity myclassinfo = new MyclassinfoEntity();
			try
			{
				conn = dbc.getConnection();
				String sql = "select *  from Myclassinfo where cid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, cid);
				rs = pre.executeQuery();
				while (rs.next())
				{	
					int mid = rs.getInt("mid");
					int gid = rs.getInt("gid");
					String mname = rs.getString("mname");
					String mremark = rs.getString("mremark");
					
					myclassinfo.setCid(cid);
					myclassinfo.setMid(mid);
					myclassinfo.setGid(gid);
					myclassinfo.setMname(mname);
					myclassinfo.setMremark(mremark);
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
			return myclassinfo;
		}
		
		// 修改
		public void updateMyclassinfo(MyclassinfoEntity myclassinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "update myclassinfo set mid=?,gid=?,mname=?,mremark=? where cid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, myclassinfo.getMid());
				pre.setInt(2, myclassinfo.getGid());
				pre.setString(3, myclassinfo.getMname());
				pre.setString(4, myclassinfo.getMremark());
				pre.setInt(5, myclassinfo.getCid());
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
