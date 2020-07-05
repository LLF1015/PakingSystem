/**
* <p>Title: MemberFeeDao.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.dao;

import pers.table.MemberFee;

/**
 * 
 * @author ASUS
 *
 */
public interface MemberFeeDao {
	/**
	 * 增加会员流水
	 * @param mFee
	 * @return boolean
	 */
	public int add(MemberFee mFee);

}
