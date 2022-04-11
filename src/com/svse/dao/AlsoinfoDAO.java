package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.AlsoinfoEntity;
import com.svse.entity.BorrowinfoEntity;
import com.svse.util.DBConnection;

public class AlsoinfoDAO {
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public AlsoinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<AlsoinfoEntity> getAll()
	{
		List<AlsoinfoEntity> ar = new ArrayList<AlsoinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from alsoinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int aid = rs.getInt("aid");
				int wid = rs.getInt("wid");
				int eid = rs.getInt("eid");
				String aremark = rs.getString("aremark");

				AlsoinfoEntity dept = new AlsoinfoEntity();
				dept.setAid(aid);
				dept.setWid(wid);
				dept.setEid(eid);
				dept.setAremark(aremark);
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
	public void addAlsoinfo(AlsoinfoEntity alsoinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "insert into alsoinfo values(null,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, alsoinfo.getWid());
			pre.setInt(2, alsoinfo.getEid());
			pre.setString(3, alsoinfo.getAremark());

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
	public AlsoinfoEntity getOne(int aid)
	{
		AlsoinfoEntity alsoinfo = new AlsoinfoEntity();
		try
		{
			conn = dbc.getConnection();
			String sql = "select *  from alsoinfo where aid=?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, aid);
			rs = pre.executeQuery();
			while (rs.next())
			{	
				int wid = rs.getInt("wid");
				int eid = rs.getInt("eid");
				String aremark = rs.getString("aremark");

				alsoinfo.setAid(aid);
				alsoinfo.setWid(wid);
				alsoinfo.setEid(eid);
				alsoinfo.setAremark(aremark);
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
		return alsoinfo;
	}
// 修改
public void updateAlsoinfo(AlsoinfoEntity alsoinfo)
	{
	try
	{
		conn = dbc.getConnection();
		String sql = "update alsoinfo set wid=?,eid=?,aremark=? where aid=?";
		pre = conn.prepareStatement(sql);
		pre.setInt(1, alsoinfo.getWid());
		pre.setInt(2, alsoinfo.getEid());
		pre.setString(3, alsoinfo.getAremark());
		pre.setInt(4, alsoinfo.getAid());
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

//删除
		public void delAlsoinfo(int aid)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "delete from alsoinfo where aid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, aid);
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
