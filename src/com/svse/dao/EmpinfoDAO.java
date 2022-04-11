 package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.CollegeinfoEntity;
import com.svse.entity.EmpinfoEntity;
import com.svse.util.DBConnection;

public class EmpinfoDAO {

	
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public EmpinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<EmpinfoEntity> getAll()
	{
		List<EmpinfoEntity> ar = new ArrayList<EmpinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from  empinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int esex = rs.getInt("esex");
				int eage = rs.getInt("eage");

				EmpinfoEntity dept = new EmpinfoEntity();
				dept.setEid(eid);
				dept.setEname(ename);
				dept.setEsex(esex);
				dept.setEage(eage);
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
	public void addEmpinfo(EmpinfoEntity empinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "insert into empinfo values(null,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, empinfo.getEname());
			pre.setInt(2, empinfo.getEsex());
			pre.setInt(3, empinfo.getEage());
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
			public EmpinfoEntity getOne(int eid)
			{
				EmpinfoEntity empinfo = new EmpinfoEntity();
				try
				{
					conn = dbc.getConnection();
					String sql = "select *  from empinfo where eid=?";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, eid);
					rs = pre.executeQuery();
					while (rs.next())
					{

						String ename = rs.getString("ename");
						int esex = rs.getInt("esex");
						int eage = rs.getInt("eage");

						empinfo.setEid(eid);
						empinfo.setEname(ename);
						empinfo.setEsex(esex);
						empinfo.setEage(eage);
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
				return empinfo;
			}
			// 修改
			public void updateEmpinfo(EmpinfoEntity empinfo)
			{
				try
				{
					conn = dbc.getConnection();
					String sql = "update empinfo set ename=?,esex=?,eage=? where eid=?";
					pre = conn.prepareStatement(sql);
					pre.setString(1, empinfo.getEname());
					pre.setInt(2, empinfo.getEsex());
					pre.setInt(3, empinfo.getEage());
					pre.setInt(4, empinfo.getEid());
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
			public void delEmpinfo(int eid)
			{
				try
				{
					conn = dbc.getConnection();
					String sql = "delete from empinfo where eid=?";
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
