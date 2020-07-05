package pers.factory;

import java.sql.Connection;

import pers.dao.imp.InforParkingImp;
import pers.dao.imp.ManagerDaoImp;
import pers.dao.imp.MemberDaoImp;
import pers.dao.imp.MemberFeeDaoImp;
import pers.dao.imp.ParkingDaoImp;
import pers.dao.imp.TemporaryDaoImp;
import pers.data.ConnMySql;

public class DaoFactory {
	
	private ConnMySql dbc=new ConnMySql();
	/**
	 * 
	 * @param conn
	 * @return ManagerDaoImp
	 */
public static ManagerDaoImp getManagerDaoInstance(Connection conn)
{
	return new ManagerDaoImp(conn);
	
}
/**
 * 
 * @param conn
 * @return MemberDaoImp
 */
public static MemberDaoImp getMemberDaoInstance(Connection conn)
{
	return new MemberDaoImp(conn);
	
}
/**
 * 
 * @param conn
 * @return MemberFeeDaoImp
 */
public static MemberFeeDaoImp getMemberFeeDaoInstance(Connection conn)
{
	return new MemberFeeDaoImp(conn);
	
}
/**
 * 
 * @param conn
 * @return ParkingDaoImp
 */
public static ParkingDaoImp getParkingDaoInstance(Connection conn)
{
	return new ParkingDaoImp(conn);
	
}
/**
 * 
 * @param conn
 * @return TemporaryDaoImp
 */
public static TemporaryDaoImp getTemporaryDaoInstance(Connection conn)
{
	return new TemporaryDaoImp(conn);
	
}
/**
 * 
 * @return InforParkingImp
 */
public static InforParkingImp getInforParkingDaoInstance()
{
	return new InforParkingImp();
	
}
}
