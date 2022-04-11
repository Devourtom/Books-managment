package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.AlsoinfoEntity;
import com.svse.entity.ExposureinfoEntity;
import com.svse.util.DBConnection;

public class ExposureinfoDAO {

	
	private DBConnection dbc;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;
	public ExposureinfoDAO()
	{
		dbc = new DBConnection();
	}

	// 全查询
	public List<ExposureinfoEntity> getAll()
	{
		List<ExposureinfoEntity> ar = new ArrayList<ExposureinfoEntity>();
		try
		{
			conn = dbc.getConnection();
			String sql = "select * from exposureinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{

				int oid = rs.getInt("oid");
				int sid = rs.getInt("sid");
				int eid = rs.getInt("eid");
				String eremark = rs.getString("eremark");

				ExposureinfoEntity dept = new ExposureinfoEntity();
				dept.setOid(oid);
				dept.setSid(sid);
				dept.setEid(eid);
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
		public void addExposureinfo(ExposureinfoEntity exposureinfo)
		{
			try
			{
				conn = dbc.getConnection();
				String sql = "insert into exposureinfo values(null,?,?,?)";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, exposureinfo.getSid());
				pre.setInt(2, exposureinfo.getEid());
				pre.setString(3, exposureinfo.getEremark());

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
		public ExposureinfoEntity getOne(int oid)
		{
			ExposureinfoEntity exposureinfo = new ExposureinfoEntity();
			try
			{
				conn = dbc.getConnection();
				String sql = "select *  from exposureinfo where oid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, oid);
				rs = pre.executeQuery();
				while (rs.next())
				{	
					int sid = rs.getInt("sid");
					int eid = rs.getInt("eid");
					String eremark = rs.getString("eremark");

					exposureinfo.setOid(oid);
					exposureinfo.setSid(sid);
					exposureinfo.setEid(eid);
					exposureinfo.setEremark(eremark);
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
			return exposureinfo;
		}	
		
		// 修改
		public void updateExposureinfo(ExposureinfoEntity exposureinfo)
			{
			try
			{
				conn = dbc.getConnection();
				String sql = "update exposureinfo set sid=?,eid=?,eremark=? where oid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, exposureinfo.getSid());
				pre.setInt(2, exposureinfo.getEid());
				pre.setString(3, exposureinfo.getEremark());
				pre.setInt(4, exposureinfo.getOid());
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
				public void delExposureinfo(int oid)
				{
					try
					{
						conn = dbc.getConnection();
						String sql = "delete from exposureinfo where oid=?";
						pre = conn.prepareStatement(sql);
						pre.setInt(1, oid);
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
