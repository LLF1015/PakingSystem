/**
* <p>Title: InforParkingDao.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.dao;

import pers.table.Member;

/**
 * 
 * @author ASUS
 *
 */
public interface MemberDao {
	/**
	 * 增加会员
	 * @param member
	 * @return 是否成功修改
	 */
       public boolean add(Member member);
       /**
        * 得到指定pnum的id
        * @param pnum
        * @return String
        */
       public String checkM(String pnum);
       /**
        * 得到空车位的id
        * @return id
        */
       public String getId();
}
