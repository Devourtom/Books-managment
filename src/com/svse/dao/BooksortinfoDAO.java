package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.BooksortinfoEntity;
import com.svse.entity.UserinfoEntity;
import com.svse.util.DBConnection;

public class BooksortinfoDAO {
	
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public BooksortinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<BooksortinfoEntity> getAll()
	{
		List<BooksortinfoEntity> ar = new ArrayList<BooksortinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from  booksortinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String sremark = rs.getString("sremark");

				BooksortinfoEntity dept = new BooksortinfoEntity();
				dept.setSid(sid);
				dept.setSname(sname);
				dept.setSremark(sremark);
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
		public void addBooksortinfo(BooksortinfoEntity booksortinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "insert into booksortinfo values(null,?,?)";
				pre = conn.prepareStatement(sql);
				pre.setString(1, booksortinfo.getSname());
				pre.setString(2, booksortinfo.getSremark());
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
		public BooksortinfoEntity getOne(int sid)
		{
			BooksortinfoEntity booksortinfo = new BooksortinfoEntity();
			try
			{
				conn = dbc.getConnection();
				String sql = "select *  from booksortinfo where sid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, sid);
				rs = pre.executeQuery();
				while (rs.next())
				{

					String sname = rs.getString("sname");
					String sremark = rs.getString("sremark");

					booksortinfo.setSid(sid);
					booksortinfo.setSname(sname);
					booksortinfo.setSremark(sremark);
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
			return booksortinfo;
		}
		
		// 修改
		public void updateBooksortinfo(BooksortinfoEntity booksortinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "update booksortinfo set sname=?,sremark=? where sid=?";
				pre = conn.prepareStatement(sql);
				pre.setString(1, booksortinfo.getSname());
				pre.setString(2, booksortinfo.getSremark());
				pre.setInt(3, booksortinfo.getSid());
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
