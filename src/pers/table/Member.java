/**
* <p>Title: Member.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: CSU<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.table;

/**
 * 
 * @author LLF
 * 
 */
public class Member {
	private String name;// 会员姓名
	private String tel;// 会员电话
	private String id;// 车位编号
	private String plate_num;// 车牌号
	
	
	
	public Member(String id,String p_num,String name,String tel) {
		this.id = id;
        this.name = name;
        this.tel = tel;
		this.plate_num = p_num;
	
	}

	
	/**
	 * 
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  
	 * @return 电话号码
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 
	 * @param tel 电话号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 * @return 车牌号
	 */
	public String getPlate_num() {
		return plate_num;
	}

	/**
	 * 
	 * @param plate_num 车牌号
	 */
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
	}
}
