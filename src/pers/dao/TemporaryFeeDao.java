/**
* <p>Title: TemporaryFeeDao.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.dao;

import java.util.ArrayList;
import java.util.Vector;

import pers.table.InforParking;
import pers.table.TemporaryFee;

/**
 * 
 * @author ASUS
 *
 */
public interface TemporaryFeeDao {
	/**
	 * 车辆进入增加流水
	 * @param pnum 车牌号
	 * @param id 车位编号
	 * @return boolean 增加成功与否
	 */
	public boolean add(String pnum,String id);
	/**
	 * 车辆离开完善流水信息
	 * @param pnum
	 * @param mid 
	 * @return boolean
	 */
	public float comp(String pnum,String mid,float price);
	/**
	 * 得到车位编号
	 * @param pnum
	 * @return boolean
	 */
	public String getPId(String pnum);
	
	/**
	 *  得到进入时间
	 * @param pnum
	 * @return String
	 */
	public Long getEnT(String pnum);
	
	/**
	 *  查询流水
	 * @param page
	 * @return Vector<TemporaryFee>
	 */
	public Vector<TemporaryFee> queryT(int page);
	/**
	 *得到流水数目
	 * @return int
	 */
	public int count();
	/**
	 * 得到日常信息
	 * @param list
	 * @return 是否成功得到日常信息
	 */
	public boolean total(ArrayList<InforParking> list);
}
