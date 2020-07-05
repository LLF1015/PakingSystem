/**
* <p>Title: InforParking.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.table;

import java.util.Date;

/**
 * 
 * @author LLF
 *
 */
public class InforParking {
    private String today;
    private int en_num = 0;
    private int ex_num = 0;
    private float fee = 0;
    
    public InforParking(String today,int ennum,int exnum,float fee) {
    	this.today=today;
    	this.fee = fee;
    	this.en_num = ennum;
    	this.ex_num = exnum;
    }
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public int getEn_num() {
		return en_num;
	}
	public void setEn_num(int en_num) {
		this.en_num = en_num;
	}
	public int getEx_num() {
		return ex_num;
	}
	public void setEx_num(int ex_num) {
		this.ex_num = ex_num;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
}
