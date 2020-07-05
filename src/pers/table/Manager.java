/**
* <p>Title: Manager.java<／p>
* <p>Description: 对应t_manager表<／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.table;

/**
 * @author LLF
 */
public class Manager {
	private int    power;//权限
	private String id;//工号
	private String pwd;//密码
	private String name;//姓名
	
	public Manager()
	{
		
	}
	public Manager(int p,String id,String pwd,String name) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.power = p;
	}
	/**
	 * @return String
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @param id id号
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 * @return 密码
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 
	 * @param pwd 密码
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	 * @return 密码
	 */
	public int getPower() {
		return power;
	}
	/**
	 * 
	 * @param power 密码
	 */
	public void setPower(int power) {
		this.power = power;
	}
	
}
