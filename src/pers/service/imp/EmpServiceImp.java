package pers.service.imp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import pers.dao.MemberDao;
import pers.dao.ParkingDao;
import pers.dao.TemporaryFeeDao;
import pers.dao.imp.MemberDaoImp;
import pers.dao.imp.ParkingDaoImp;
import pers.dao.imp.TemporaryDaoImp;
import pers.data.ConnMySql;
import pers.factory.DaoFactory;
import pers.service.IEmpService;
import pers.table.InforParking;
import pers.table.Manager;
import pers.table.Member;
import pers.table.MemberFee;
import pers.table.Parking;
import pers.table.TemporaryFee;
import pers.ui.InforPanel;

public class EmpServiceImp implements IEmpService {

	private ConnMySql dbc=new ConnMySql();
	@Override
	public String CheckM_M(String p_num) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		String cM_M;
		 cM_M=DaoFactory.getMemberDaoInstance(conn).checkM(p_num);
		this.dbc.closeMysql(conn);
		return cM_M;
	}
	@Override
	public boolean addTemporary(String pnum, String id) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		boolean flag=false;
		flag=DaoFactory.getTemporaryDaoInstance(this.dbc.connMysql()).add(pnum, id);
		this.dbc.closeMysql(conn);
		return flag;
	}
	@Override
	public boolean updateCar(String type, String id,String state) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		boolean flag=false;
		System.out.println("业务层"+type+id+state);
		if(state.equals("T"))
		{
			 flag=DaoFactory.getParkingDaoInstance(this.dbc.connMysql()).upTPT(type, id);
		}
		else if(state.equals("S"))
		{
			flag=DaoFactory.getParkingDaoInstance(this.dbc.connMysql()).upTPS(type, id);
		}
		this.dbc.closeMysql(conn);
		return flag;
	}
	@Override
	public int CheckNumber(String state) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		int count=0;
		if(state.equals("临时"))
		{
			 count=DaoFactory.getParkingDaoInstance(this.dbc.connMysql()).parkingNullNum("临时");
			 System.out.println("临时车俩"+count);
		}
		else if(state.equals("all"))
		{
			count=DaoFactory.getParkingDaoInstance(this.dbc.connMysql()).parkingNullNum("all");
		}
		this.dbc.closeMysql(conn);
		return count;
		
		
	}
	@Override
	public boolean CheckState(String id) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		boolean flag=false;
		flag=DaoFactory.getParkingDaoInstance(this.dbc.connMysql()).checkState(id);
		this.dbc.closeMysql(conn);
		return flag;
	}
	@Override
	public String getId(String state,String data) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		String string = null;
		System.out.println("oooooo"+state);
		if(state.equals("p"))
		{
			 string=DaoFactory.getParkingDaoInstance(this.dbc.connMysql()).getPId(data);
		}
		else if(state.equals("t"))
		{
			System.out.println("temporary");
			string=DaoFactory.getTemporaryDaoInstance(this.dbc.connMysql()).getPId(data);
			System.out.println(string);
		}
		else if(state.equals("m"))
		{
			string=DaoFactory.getMemberDaoInstance(this.dbc.connMysql()).getId();
		}
		System.out.println("temporary");System.out.println("temporary");System.out.println("temporary");
		this.dbc.closeMysql(conn);
		return string;
		
	}
	@Override
	public float getPriceParkig(String id, int n) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		float price;
		price=DaoFactory.getParkingDaoInstance(this.dbc.connMysql()).getPrice(id, n);
		this.dbc.closeMysql(conn);
		return price;
		}
	@Override
	public float getcompTemp(String pnum, String mid, float price) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		float tprice;
		tprice=DaoFactory.getTemporaryDaoInstance(this.dbc.connMysql()).comp(pnum, mid, price);
		this.dbc.closeMysql(conn);
		System.out.println("tprice"+tprice);
		return tprice;
	}
	
	@Override
	public HashMap<String, Object> check(String tf, String pf) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap=DaoFactory.getManagerDaoInstance(conn).check(tf, pf);
		this.dbc.closeMysql(conn);
		return hMap;
	}
	@Override
	public boolean CheckM_P(String id) {
		Connection conn=this.dbc.connMysql();
		boolean cM_P;
		 cM_P=DaoFactory.getParkingDaoInstance(conn).checkM(id);
		this.dbc.closeMysql(conn);
		return cM_P;
	}
	@Override
	public boolean addMember(Member member) {
		Connection conn=this.dbc.connMysql();
		boolean flag;
		 flag=DaoFactory.getMemberDaoInstance(conn).add(member);
		this.dbc.closeMysql(conn);
		return flag;
	}
	@Override
	public int addMemberFee(MemberFee mFee) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		int fee;
		 fee=DaoFactory.getMemberFeeDaoInstance(conn).add(mFee);
		this.dbc.closeMysql(conn);
		return fee;
	}
	@Override
	public boolean addManger(Manager manager) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		boolean flag;
		 flag=DaoFactory.getManagerDaoInstance(conn).add(manager);
		this.dbc.closeMysql(conn);
		return flag;
	}
	@Override
	public boolean upMp(String id, int power) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		boolean flag;
		 flag=DaoFactory.getManagerDaoInstance(conn).upMP(id, power);
		this.dbc.closeMysql(conn);
		return flag;
	}
	@Override
	public boolean del(String id,String state) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		boolean flag = false;
		if(state.equals("M"))
		 {
			flag=DaoFactory.getManagerDaoInstance(conn).delManager(id);
		 }
		else if(state.equals("P"))
		{
			System.out.println("pppppppppppp"+flag);
			flag=DaoFactory.getParkingDaoInstance(conn).delParking(id);
		}
		this.dbc.closeMysql(conn);
		System.out.println("pppppppppppp"+flag);
		return flag;
	}
	@Override
	public boolean addParking(Parking parking) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		boolean flag;
		 flag=DaoFactory.getParkingDaoInstance(conn).addParking(parking);
		this.dbc.closeMysql(conn);
		return flag;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		int count;
		 count=DaoFactory.getTemporaryDaoInstance(conn).count();
		this.dbc.closeMysql(conn);
		return count;
	}
	@Override
	public Vector<TemporaryFee> queryT(int page) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		Vector<TemporaryFee> list = new Vector<TemporaryFee>();
		 list=DaoFactory.getTemporaryDaoInstance(conn).queryT(page);
		this.dbc.closeMysql(conn);
		return list;
	}
	@Override
	public boolean total(ArrayList<InforParking> list) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		DaoFactory.getTemporaryDaoInstance(conn).total(list);
		return true;
	}
	@Override
	public boolean Writerinformation(ArrayList<InforParking> list, String filename) throws IOException {
		// TODO Auto-generated method stub
		DaoFactory.getInforParkingDaoInstance().Writerinformation(list, filename);
		return true;
	}
	@Override
	public boolean Readerinformation(ArrayList<InforParking> list, String filename) throws IOException {
		// TODO Auto-generated method stub
		DaoFactory.getInforParkingDaoInstance().Readerinformation(list, filename);
		return false;
	}
	@Override
	public boolean addInforParking(InforParking infrorking,ArrayList<InforParking> list, String fileName) throws IOException {
		// TODO Auto-generated method stub
		return DaoFactory.getInforParkingDaoInstance().add(infrorking,list, fileName);
		}
	@Override
	public String findManager(String id) {
		// TODO Auto-generated method stub
		Connection conn=this.dbc.connMysql();
		return DaoFactory.getManagerDaoInstance(conn).findManager(id);
	}
	@Override
	public boolean delInforParking(ArrayList<InforParking> list, String filename, String date) {
		// TODO Auto-generated method stub
		return DaoFactory.getInforParkingDaoInstance().delinformation(list, filename, date);
	}
	@Override
	public boolean updateinformation(ArrayList<InforParking> list, String filename, String date,
			InforParking inforParking) {
		// TODO Auto-generated method stub
		return DaoFactory.getInforParkingDaoInstance().updateinformation(list, filename, date, inforParking);
	}
}

