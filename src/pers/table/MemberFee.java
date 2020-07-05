/**
* <p>Title: MemberFee.java<／p>
* <p>Description: 对应t_memberfee表<／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.table;

import java.sql.Date;

/**
 * @author LLF
 */
public class MemberFee {

	private String id;// 车位编号
	private String serial_num;// 流水号
	private String plate_num;// 车牌号
	private Date eff_date;// 生效期
	private Date ex_date;// 有效期
	private float fee;//收费
	private String mid;//收费员
	
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public MemberFee(String id,String m_id, float fee,
			           String s_n,String p_num,Date eff,Date ex) {
		this.id  = id;
		this.mid = m_id;
		this.fee = fee;
		this.ex_date = ex;
		this.eff_date = eff;
		this.plate_num = p_num;
		this.serial_num = s_n;	
	}
	public MemberFee(String id,String m_id,String p_num,Date eff,Date ex) {
		this.id  = id;
		this.mid = m_id;
		this.ex_date = ex;
		this.eff_date = eff;
		this.plate_num = p_num;
	}
	/**
	 * 
	 * @return 会员的车位编号
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id 设置会员的车位编号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return 获取会员的流水号
	 */
	public String getSerial_num() {
		return serial_num;
	}

	/**
	 * 
	 * @param serial_num 会员的流水号
	 */
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}

	/**
	 * 
	 * @return 得到会员的车牌号
	 */
	public String getPlate_num() {
		return plate_num;
	}

	/**
	 * 
	 * @param plate_num 会员的车牌号
	 */
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
	}

	/**
	 * 
	 * @return 得到会员生效期
	 */
	public Date getEff_date() {
		return eff_date;
	}

	/**
	 * 
	 * @param eff_date 会员生效期
	 */
	public void setEff_date(Date eff_date) {
		this.eff_date = eff_date;
	}

	/**
	 * 
	 * @return 得到会员到期时间
	 */
	public Date getEx_date() {
		return ex_date;
	}

	/**
	 * 
	 * @param ex_date 会员到期时间
	 */
	public void setEx_date(Date ex_date) {
		this.ex_date = ex_date;
	}
}
