package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.BorrowinfoEntity;
import com.svse.entity.MyclassinfoEntity;
import com.svse.util.DBConnection;

public class BorrowinfoDAO {

	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public BorrowinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<BorrowinfoEntity> getAll()
	{
		List<BorrowinfoEntity> ar = new ArrayList<BorrowinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from borrowinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int wid = rs.getInt("wid");
				int sid = rs.getInt("sid");
				int bid = rs.getInt("bid");
				int eid = rs.getInt("eid");
				String bdate = rs.getString("bdate");

				BorrowinfoEntity dept = new BorrowinfoEntity();
				dept.setWid(wid);
				dept.setSid(sid);
				dept.setBid(bid);
				dept.setEid(eid);
				dept.setBdate(bdate);
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
		public void addBorrowinfo(BorrowinfoEntity borrowinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "insert into borrowinfo values(null,?,?,?,?)";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, borrowinfo.getSid());
				pre.setInt(2, borrowinfo.getBid());
				pre.setInt(3, borrowinfo.getEid());
				pre.setString(4, borrowinfo.getBdate());

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
				public BorrowinfoEntity getOne(int wid)
				{
					BorrowinfoEntity borrowinfo = new BorrowinfoEntity();
					try
					{
						conn = dbc.getConnection();
						String sql = "select *  from borrowinfo where wid=?";
						pre = conn.prepareStatement(sql);
						pre.setInt(1, wid);
						rs = pre.executeQuery();
						while (rs.next())
						{	
							int sid = rs.getInt("sid");
							int bid = rs.getInt("bid");
							int eid = rs.getInt("eid");
							String bdate = rs.getString("bdate");

							borrowinfo.setWid(wid);
							borrowinfo.setSid(sid);
							borrowinfo.setBid(bid);
							borrowinfo.setEid(eid);
							borrowinfo.setBdate(bdate);
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
					return borrowinfo;
				}
		// 修改
		public void updateBorrowinfo(BorrowinfoEntity borrowinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "update borrowinfo set sid=?,bid=?,eid=?,bdate=? where wid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, borrowinfo.getSid());
				pre.setInt(2, borrowinfo.getBid());
				pre.setInt(3, borrowinfo.getEid());
				pre.setString(4, borrowinfo.getBdate());
				pre.setInt(5, borrowinfo.getWid());
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
