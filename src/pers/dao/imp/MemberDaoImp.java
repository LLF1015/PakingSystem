/**
* <p>Title: MemberDaoImp.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020年<／p>
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
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import pers.table.Member;
import pers.dao.MemberDao;
import pers.data.ConnMySql;

/**实现MemberDao接口
 * @author LLF
 */
public class MemberDaoImp implements MemberDao{

	private Connection conn=null; 
	public MemberDaoImp(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean add(Member member) {
		boolean flag = false;	
		String sql = "insert into t_member(id,p_num,name,tel) values(?,?,?,?)";
		
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPlate_num());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getTel());
			int rs = psmt.executeUpdate();
			if(rs==1) {
				flag = true;
			}
			psmt.close();
		//	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String checkM(String pnum) {
		String id="";
		String sql = "select id from t_member where p_num=?";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, pnum);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("id");
			}
			psmt.close();
			rs.close();
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public String getId() {
		
		String id = null;
		String sql = "select * from (select id from t_parking where state='空' and type='临时' order by id) where rownum<2";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("id");
			}
			psmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	
}
