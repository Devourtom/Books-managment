package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.BookinfoEntity;
import com.svse.entity.MajorinfoEntity;
import com.svse.util.DBConnection;

public class BookinfoDAO {

	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public BookinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<BookinfoEntity> getAll()
	{
		List<BookinfoEntity> ar = new ArrayList<BookinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from bookinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int bid = rs.getInt("bid");
				int sid = rs.getInt("sid");
				String bname = rs.getString("bname");
				float bprice = rs.getFloat("bprice");
				String bisbn = rs.getString("bisbn");
				String bpublish = rs.getString("bpublish");
				String bauth = rs.getString("bauth");
				int bcount = rs.getInt("bcount");
				String sremark = rs.getString("sremark");
				int bout = rs.getInt("bout");

				BookinfoEntity dept = new BookinfoEntity();
				dept.setBid(bid);
				dept.setSid(sid);
				dept.setBname(bname);
				dept.setBprice(bprice);
				dept.setBisbn(bisbn);
				dept.setBpublish(bpublish);
				dept.setBauth(bauth);
				dept.setBcount(bcount);
				dept.setSremark(sremark);
				dept.setBout(bout);
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
			public void addBookinfo(BookinfoEntity bookinfo)
			{
				try
				{
					conn = dbc.getConnection();
					String sql = "insert into bookinfo values(null,?,?,?,?,?,?,?,?,?)";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, bookinfo.getSid());
					pre.setString(2, bookinfo.getBname());
					pre.setFloat(3, bookinfo.getBprice());
					pre.setString(4, bookinfo.getBisbn());
					pre.setString(5, bookinfo.getBpublish());
					pre.setString(6, bookinfo.getBauth());
					pre.setInt(7, bookinfo.getBcount());
					pre.setString(8, bookinfo.getSremark());
					pre.setInt(9, bookinfo.getBout());
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
		public BookinfoEntity getOne(int bid)
		{
			BookinfoEntity bookinfo = new BookinfoEntity();
			try
			{
				conn = dbc.getConnection();
				String sql = "select * from bookinfo where bid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, bid);
				rs = pre.executeQuery();
				while (rs.next())
				{

					int sid = rs.getInt("sid");
					String bname = rs.getString("bname");
					float bprice = rs.getFloat("bprice");
					String bisbn = rs.getString("bisbn");
					String bpublish = rs.getString("bpublish");
					String bauth = rs.getString("bauth");
					int bcount = rs.getInt("bcount");
					String sremark = rs.getString("sremark");
					int bout = rs.getInt("bout");

					bookinfo.setBid(bid);
					bookinfo.setSid(sid);
					bookinfo.setBname(bname);
					bookinfo.setBprice(bprice);
					bookinfo.setBisbn(bisbn);
					bookinfo.setBpublish(bpublish);
					bookinfo.setBauth(bauth);
					bookinfo.setBcount(bcount);
					bookinfo.setSremark(sremark);
					bookinfo.setBout(bout);
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
			return bookinfo;
		}
		public void updateBookinfo(BookinfoEntity bookinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "update bookinfo set sid=?,bname=?,bprice=?,bisbn=?,bpublish=?,bauth=?,bcount=?,sremark=?,bout=? where bid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, bookinfo.getSid());
				pre.setString(2, bookinfo.getBname());
				pre.setFloat(3, bookinfo.getBprice());
				pre.setString(4, bookinfo.getBisbn());
				pre.setString(5, bookinfo.getBpublish());
				pre.setString(6, bookinfo.getBauth());
				pre.setInt(7, bookinfo.getBcount());
				pre.setString(8, bookinfo.getSremark());
				pre.setInt(9, bookinfo.getBout());
				pre.setInt(10, bookinfo.getBid());
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
