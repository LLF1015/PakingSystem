package pers.dao;

import pers.table.Parking;

/**
 * 
 * 对车位的数据操作接口
 * @author LLF
 * 
 */
public interface ParkingDao {

	/**
	 * 得到相应类型空车位数
	 * @param type
	 * @return int
	 */
	public int parkingNullNum(String type);
	/**
	 * 得到临时车位相应状态的第一个车位编号
	 * @param state
	 * @return String
	 */
	public String getPId(String state);
	/**
	 * 更新t_parking表车位的状态state
	 * @param state
	 * @param id
	 * @return boolean
	 */
	public boolean upTPS(String state,String id);
	/**
	 * 车位状态是否为空
	 * @param id
	 * @return boolean
	 */
	public boolean checkState(String id);
	
	/**
	 * 得到单价(n=0为临时）
	 * @param id
	 * @return float
	 */
	public float getPrice(String id,int n);
	/**
	 * 添加停车位
	 * @param parking
	 * @return 是否成功添加
	 */
	public boolean addParking(Parking parking);
	/**
	 * 删除停车位
	 * @param id
	 * @return 是否成功删除
	 */
    public boolean delParking(String id);
    /**
     * 修改车位状态
     * @param type
     * @param id
     * @return 是否成功删除
     */
	public boolean upTPT(String type,String id);
	/**
	 * 确定车位是否可以使用
	 * @param id
	 * @return 是否可以成功使用
	 */
	public boolean checkM(String id);
}
