package pers.dao;

import java.util.HashMap;

import pers.table.Manager;
/**
 * 对管理员的数据操作的接口
 * @author ASUS
 *
 */
public interface ManagerDao {
	/**
	 * 验登录信息并返回登录人员是否能登录以及其权限
	 * @param tf
	 * @param pf
	 * @return 管理员信息
	 */
	public HashMap<String, Object> check(String tf, String pf);
	
	/**
	 * 增加员工
	 * @param manager
	 * @return 是否增加成功
	 */
	public boolean add(Manager manager);
	/**
	 * 删除员工
	 * @param id
	 * @return 是否成功删除
	 */
	public boolean delManager(String id);
	/**
	 * 查询员工
	 * @param id
	 * @return  管理员信息 
	 */
	public String findManager(String id);
   /**
    * 改变权限
    * @param id
    * @param power
    * @return 是否成功修改
    */
    public boolean upMP(String id,int power);
}
