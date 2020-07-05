/**
* <p>Title: ConnOra.java<／p>
* <p>Description: 实现数据库的连接的与关闭<／p>
* <p>Copyright: Copyright (c) 2020年6月25日<／p>
* <p>Company: LLL<／p>
* @author LLF
* @date 2020年6月25日
* @version 1.0
*/
package pers.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 实现数据库的连接与关闭
 * @author LLF
 * 
 */
public class ConnMySql {

	/**
	 * 
	 * @return Connection
	 */
	
	public static Connection connMysql() {
		Connection con = null;// 创建一个数据库连接
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载MySql驱动程序
			System.out.println("开始尝试连接数据库！");
			String url="jdbc:mysql://localhost:3306/jsu?useSSL=false";
			String user = "root";// 用户名
			String password = "12345";// 设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			System.out.println("连接成功！");

		} catch (Exception e) {
			System.out.println("未连接");
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * 关闭数据库
	 * @param con 连接
	 */
	public void closeMysql(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("数据库连接已关闭！");
	}
}
