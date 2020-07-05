/**
* <p>Title: TemporaryDaoImp.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CSU<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import pers.dao.TemporaryFeeDao;
import pers.data.ConnMySql;
import pers.table.InforParking;
import pers.table.TemporaryFee;
import pers.ui.ManagerUI;

/**
 * 实现TemporaryDao接口
 * @author LLF
 */
public class TemporaryDaoImp implements TemporaryFeeDao{

	private Connection conn=null; 
	public TemporaryDaoImp(Connection conn)
	{
		this.conn=conn;
	}
	public boolean add(String pnum, String id) {
		boolean flag = false;
		java.util.Date now = new java.util.Date(); 
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
	    long s1=now.getTime();
		++ManagerUI.ennum;
		int en_num=ManagerUI.ennum;
		String s_ennum  = Integer.toBinaryString(en_num);
		int len = s_ennum.length();
		if(len<4) {
			for(int j = 0; j < 4-len; j++) {
				s_ennum = "0"+s_ennum;
			}
		}
		String s_num = s1+id+s_ennum;
		String sql = "insert into t_tempfee(s_num,id,p_num,en_time) values(?,?,?,?)";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, s_num);
			psmt.setString(2, id);
			psmt.setString(3, pnum);
			psmt.setLong(4, s1);
			int rs = psmt.executeUpdate();
			System.out.println(rs+"!!!!!!");
			if(rs==1) {
				flag = true;
			//	InforParkingDao iDao=new InforParkingDaoImp();
				//InforParking iParking = new InforParking(en_num, ManagerUI.exnum, ManagerUI.fee, ManagerUI.mid);
				//iDao.inUpInfor(iParking);
			}
			psmt.close();
			//conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(flag+"添加成功?");
		return flag;
	}

	@Override
	public float comp(String pnum, String mid, float price) {
		// TODO Auto-generated method stub
		boolean flag = false;
		//float tprice = 0;
		String sql ="update t_tempfee set ex_time=?,fee=?,m_id=? where p_num = ? and ex_time is null";
		Long ent =getEnT(pnum);		
		java.util.Date  date0=new java.util.Date();
		Long  data1=date0.getTime();
		
	    System.out.println(new SimpleDateFormat().format(ent));
		System.out.println(ent);
		System.out.println(new SimpleDateFormat().format(data1));
      	float time=(float) ((data1-ent)/(60*60*1000*1.0));//得到停车时间
      	float fee = price;
      	if(time>=0) {
      		System.out.println("time"+time);
      		System.out.println("price"+price);
      		fee =time*price;//得到费用
      		System.out.println("ifee"+fee);
      	} 	
	
		try {
		//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setLong(1, data1);
			psmt.setFloat(2, fee);
			psmt.setString(3, mid);
			psmt.setString(4, pnum);
			int rs = psmt.executeUpdate();
			/*if(rs==1) {
				flag = true;
				tprice = fee;
				++ManagerUI.exnum;
				ManagerUI.fee+=fee;
				InforParkingDao iDao=new InforParkingDaoImp();
				InforParking iParking = new InforParking(ManagerUI.ennum, ManagerUI.exnum, ManagerUI.fee, ManagerUI.mid);
				iDao.inUpInfor(iParking);
			}*/
			psmt.close();
			//conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ofee"+fee);
		return fee;
	}

	@Override
	public String getPId(String pnum) {
		// TODO Auto-generated method stub
		String id = null;
		String sql = "select id from t_tempfee where p_num = ? and ex_time is null";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, pnum);
			
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				id=rs.getString("id");
			}
			//conn.close();
			psmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("aaaaaaaaaaa"+id);
		return id;
	}

	@Override
	public Long getEnT(String pnum) {
		// TODO Auto-generated method stub
	 Long date = null ;
		String sql = "select en_time from t_tempfee where p_num=? and ex_time is null";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, pnum);
			
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				date = rs.getLong("en_time");				
			}
		//	conn.close();
			psmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public Vector<TemporaryFee> queryT(int page) {
		// TODO Auto-generated method stub
		Vector<TemporaryFee> list = new Vector<TemporaryFee>();
		String sql = "select * from t_tempfee limit ?,?";
		try {
			//Connection conn =  ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, (page-1)*TemporaryFee.PageSize);
			psmt.setInt(2, (page)*TemporaryFee.PageSize);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String s_num = rs.getString("s_num");
				String id    = rs.getString("id");
				String p_num = rs.getString("p_num");
				Long en_time = rs.getLong("en_time");
				Long ex_time = rs.getLong("ex_time");
				float fee    = rs.getFloat("fee");
				String m_id  = rs.getString("m_id");
				TemporaryFee tFee = new TemporaryFee(id, p_num, m_id, s_num, fee, en_time, ex_time);
				list.add(tFee);
			//	System.out.println(sno);
			}
			psmt.close();
			rs.close();
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int num = 0;
		String sql = "select count(*)num from t_tempfee";
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				num = rs.getInt("num");				
			}
			//conn.close();
			psmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public boolean total(ArrayList<InforParking> list) {
		// TODO Auto-generated method stub
		String sql = "select * from t_tempfee";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			//Connection conn = ConnMySql.connMysql();
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String date=dateFormat.format(rs.getLong("en_time")).toString();
				String date1=dateFormat.format(rs.getLong("ex_time")).toString();
				float fee=rs.getFloat("fee");
				boolean flag=false;
				//循环遍历
				for(InforParking inforparking:list)
				{
					//如果当前日期存在
					if(inforparking.getToday().equals(date))
					{
						flag=true;
						inforparking.setEn_num(inforparking.getEn_num()+1);
		                if(!date1.equals(""))
		                {
		                	inforparking.setEx_num(inforparking.getEx_num()+1);
		                	inforparking.setFee(inforparking.getFee()+fee);
		                }
		                
					}
					
				}
				if(flag==false)
				{
					
					if(!date1.equals(""))
					{
						InforParking inforparking1=new InforParking(date,1,1,fee);
						list.add(inforparking1);
					}
					else
					{
						InforParking inforparking1=new InforParking(date,1,0,0);
						list.add(inforparking1);
					}
				}
			}
			//conn.close();
			psmt.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	
}
