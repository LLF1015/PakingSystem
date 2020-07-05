/**
* <p>Title: ManagerDaoImp.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import pers.dao.ManagerDao;
import pers.data.ConnMySql;
import pers.table.Manager;

/**
 * 实现ManagerDao接口
 * @author LLF
 */
public class ManagerDaoImp implements ManagerDao {

	private Connection conn=null; 
	public ManagerDaoImp(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public HashMap<String, Object> check(String tf, String pf) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "select * from t_manager where id=?";
		String id = null;
		String pwd = null;
		int    power = 0;
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, tf);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("id");
				pwd = rs.getString("pwd");
				power = rs.getInt("power");
			}
			psmt.close();
			rs.close();
		//	conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tf.equals(id) && pf.equals(pwd)) {
			flag = true;
		}
		hMap.put("flag", flag);
		hMap.put("power",power);
		return hMap;
	}


	@Override
	public boolean add(Manager manager) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into t_manager values(?,?,?,?)";
		try {
			//Connection connection = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, manager.getId());
			psmt.setString(2, manager.getPwd());
			psmt.setString(3, manager.getName());
			psmt.setInt(4, manager.getPower());
			int rs = psmt.executeUpdate();
			if(rs == 1) {
				flag = true;
			}
			psmt.close();
			//connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		return flag;
	}

	@Override
	public boolean delManager(String id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from t_manager where id=?";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			if (psmt.executeUpdate() > 0) {
				flag = true;
			}
			psmt.close();
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	
	@Override
	public String findManager(String id) {
		// TODO Auto-generated method stub
		String string=null;
		String sql = "select * from t_manager where id=?";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				string =string+ rs.getString("id");
				string =string+ rs.getString("pwd");
				string =string+ rs.getString("name");
				string =string+rs.getInt("power");
			}
			psmt.close();
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}

	@Override
	public boolean upMP(String id, int power) {
		// TODO Auto-generated method stub
		boolean flag = true;
		String sql = "update t_manager set power=? where id=?";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, power);
			psmt.setString(2, id);
			int rs=psmt.executeUpdate();
			if(rs > 0) {
				flag = true;
			}
			psmt.close();
			//conn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

}
