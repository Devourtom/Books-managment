package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.svse.entity.UserinfoEntity;
import com.svse.util.DBConnection;


/**
 * 
 * @author Administrator 表内容操作的工具类
 */
public class UserinfoDAO
{
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public UserinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<UserinfoEntity> getAll()
	{
		List<UserinfoEntity> ar = new ArrayList<UserinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from  userinfo order by uid asc";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String upsw = rs.getString("upsw");

				UserinfoEntity dept = new UserinfoEntity();
				dept.setUid(uid);
				dept.setUname(uname);
				dept.setUpsw(upsw);
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
	public void addUserinfo(UserinfoEntity userinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "insert into userinfo values(null,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, userinfo.getUname());
			pre.setString(2, userinfo.getUpsw());
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
	public UserinfoEntity getOne(int uid)
	{
		UserinfoEntity userinfo = new UserinfoEntity();
		try
		{
			conn = dbc.getConnection();
			String sql = "select *  from userinfo where uid=?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, uid);
			rs = pre.executeQuery();
			while (rs.next())
			{

				String uname = rs.getString("uname");
				String upsw = rs.getString("upsw");

				userinfo.setUid(uid);
				userinfo.setUname(uname);
				userinfo.setUpsw(upsw);
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
	public void updateUserinfo(UserinfoEntity userinfo)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "update userinfo set uname=?,upsw=? where uid=?";
			pre = conn.prepareStatement(sql);
			pre.setString(1, userinfo.getUname());
			pre.setString(2, userinfo.getUpsw());
			pre.setInt(3, userinfo.getUid());
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
	public void delUserinfo(int uid)
	{
		try
		{
			conn = dbc.getConnection();
			String sql = "delete from userinfo where uid=?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, uid);
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
	
	public int login(UserinfoEntity userEntity) {
        int t = 0;
        try {
            
        	conn = dbc.getConnection();
            
            String sql = "select count(*) from userinfo where uname=? and upsw=?";
            pre = conn.prepareStatement(sql);
            
            pre.setString(1,userEntity.getUname());
            pre.setString(2, userEntity.getUpsw());
 
   
            rs = pre.executeQuery();
            while (rs.next()){
                t = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }
}
