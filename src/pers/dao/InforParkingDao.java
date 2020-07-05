
package pers.dao;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import pers.table.InforParking;

public interface InforParkingDao {
	/**
	 * 
	 * @param inforparking
	 * @param list
	 * @param filename
	 * @return 是否添加成功
	 * @throws IOException
	 */
	public boolean add(InforParking inforparking,ArrayList<InforParking> list,String filename)throws IOException;	
	/**
	 * 
	 * @param list
	 * @return 是否成功
	 */
	public boolean getInformation(ArrayList<InforParking> list);
	/**
	 * 把list中的内容写入到文件
	 * @param list
	 * @param filename
	 * @return 是否成功
	 * @throws IOException
	 */
	public boolean Writerinformation(ArrayList<InforParking> list,String filename)throws IOException;
	/**
	 * 从文件中读取内容
	 * @param list
	 * @param filename
	 * @return 是否成功
	 * @throws IOException
	 */
	public boolean Readerinformation(ArrayList<InforParking> list,String filename)throws IOException;

	/**
	 * 删除指定id
	 * @param list
	 * @param filename
	 * @param date
	 * @return 是否成功
	 */
	public boolean delinformation(ArrayList<InforParking> list,String filename,String date);
	/**
	 * 修改指定id
	 * @param list
	 * @param filename
	 * @param date
	 * @param inforParking
	 * @return 是否成功
	 */
	public boolean updateinformation(ArrayList<InforParking> list,String filename,String date,InforParking inforParking);
}
