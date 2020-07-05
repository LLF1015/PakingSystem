package pers.service;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import pers.table.InforParking;
import pers.table.Manager;
import pers.table.Member;
import pers.table.MemberFee;
import pers.table.Parking;
import pers.table.TemporaryFee;

public interface IEmpService {
	/**
	 * 得到当前可用的车位
	 * @param state
	 * @return 数量
	 */
public int CheckNumber(String state);
/**
 * 得到指定pnum的id
 * @param p_num
 * @return 查询到的id
 */
public String CheckM_M(String p_num);
/**
 * 确定指定的id车位是否可以停车
 * @param id
 * @return 是否是否可以停车
 */
public boolean CheckM_P(String id);
/**
 * 增加进入流水
 * @param pnum
 * @param id
 * @return 返回是否添加流水成功
 */
public boolean addTemporary(String pnum, String id);
/**
 * 增加会员
 * @param member
 * @return 返回是否添加会员成功
 */
public boolean addMember(Member member);
/**
 * 增加会员收费信息
 * @param mfee
 * @return 返回是否添加会员收费成功
 */
public int addMemberFee(MemberFee mfee);
/**
 * 增加管理员信息
 * @param manager
 * @return 返回是否添加管理员成功
 */
public boolean addManger(Manager manager);
/**
 * 增加停车位信息
 * @param parking
 * @return 返回是否添加停车位成功
 */
public boolean addParking(Parking parking);
/**
 * 增加日常停车场信息
 * @param infrorking
 * @param list
 * @param fileName
 * @return 返回是否添加日常停车场信息成功
 * @throws IOException
 */
public boolean addInforParking(InforParking infrorking,ArrayList<InforParking> list,String fileName) throws IOException;
/**
 * 修改管理员权限
 * @param id
 * @param power
 * @return 返回是否修改管理员权限成功
 */
public boolean upMp(String id,int power);
/**
 * 删除信息
 * @param id
 * @param state
 * @return 返回是否删除信息成功
 */
public boolean del(String id,String state);
/**
 * 删除日常信息
 * @param list
 * @param filename
 * @param date
 * @return 返回是否删除日常信息成功
 */
public boolean delInforParking(ArrayList<InforParking> list, String filename, String date);
/**
 * 修改车位信息
 * @param type
 * @param id
 * @param state
 * @return 返回是否修改车位信息成功
 */
public boolean updateCar(String type, String id,String state);
/**
 * 确定车位状态
 * @param id
 * @return 返回车位状态
 */
public boolean CheckState(String id);
/**
 * 得到ID
 * @param data
 * @param state
 * @return id号
 */
public String getId(String data,String state);
/**
 * 得到停车位价格
 * @param id
 * @param n
 * @return 停车位价格
 */
public float getPriceParkig(String id,int n);
/**
 * 得到出车库信息
 * @param pnum
 * @param mid
 * @param price
 * @return 出库信息
 */
public float getcompTemp(String pnum, String mid, float price);
/**
 * 确定管理员登录账号和密码
 * @param tf
 * @param pf
 * @return 管理员账号和密码
 */
public HashMap<String, Object> check(String tf, String pf);
/**
 * 得到表的记录
 * @return int
 */
public int count();
/**
 * 查找管理员
 * @param id
 * @return 返回管理员id
 */
public String findManager(String id);
/**
 * 查找车库信息
 * @param page
 * @return 车库信息
 */
public Vector<TemporaryFee> queryT(int page);
/**
 * 得到日常信息
 * @param list
 * @return 返回是否成功得到日产信息
 */
public boolean total(ArrayList<InforParking> list);
/**
 * 把日常信息存储到文件中
 * @param list
 * @param filename
 * @return 返回是否成功存储到文件
 * @throws IOException
 */
public boolean Writerinformation(ArrayList<InforParking> list,String filename) throws IOException;
/**
 * 从文件中入去入场信息
 * @param list
 * @param filename
 * @return 返回是否成功从文件读取
 * @throws IOException
 */
public boolean Readerinformation(ArrayList<InforParking> list,String filename) throws IOException;
/**
 * 修改信息
 * @param list
 * @param filename
 * @param date
 * @param inforParking
 * @return  boolean 
 */
public boolean updateinformation(ArrayList<InforParking> list,String filename,String date,InforParking inforParking);

}
