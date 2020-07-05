package pers.ui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import pers.dao.ManagerDao;
import pers.factory.ServiceFactory;
import pers.table.InforParking;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * 登录
 * @author ASUS
 *
 */
public class Login {


	private JFrame frame;//界面
	private JPasswordField passwordField1_1;//密码
	private JTextField textField1_1;//账号
	private static Login window;//登录界面
	/**
	 * Launch the application.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(javax.swing.plaf.nimbus.NimbusLookAndFeel.class.getName());
					window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * 
	 */
	public Login() {
		initialize();//初始化界面
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setTitle("停车场管理系统登录");//设置标题
		frame.setBounds(100, 100, 448, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		passwordField1_1 = new JPasswordField();//密码框
		passwordField1_1.setFont(new Font("黑体", Font.PLAIN, 20));
		passwordField1_1.setBounds(138, 157, 150, 39);
		frame.getContentPane().add(passwordField1_1);

		textField1_1 = new JTextField();
		textField1_1.setFont(new Font("黑体", Font.PLAIN, 18));
		textField1_1.setBounds(138, 93, 150, 39);
		frame.getContentPane().add(textField1_1);
		textField1_1.setColumns(10);

		JButton button1_1 = new JButton("登录");
		button1_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {//键盘按键响应
				if(arg0.getKeyCode()== KeyEvent.VK_ENTER) {
					loginF();
				}
			}
		});
		button1_1.setFont(new Font("黑体", Font.PLAIN, 20));
		button1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginF();
			}
		});
		button1_1.setBounds(152, 224, 112, 39);
		//加入到界面
		frame.getContentPane().add(button1_1);
		
		JLabel label1_1 = new JLabel("工号：");
		label1_1.setFont(new Font("黑体", Font.PLAIN, 20));
		label1_1.setBounds(65, 94, 72, 36);
		frame.getContentPane().add(label1_1);
		
		JLabel label1_2 = new JLabel("密码：");
		label1_2.setFont(new Font("黑体", Font.PLAIN, 20));
		label1_2.setBounds(65, 157, 72, 39);
		frame.getContentPane().add(label1_2);
	}
	
	private void loginF() {
		boolean flag  = false;
		int     power = 0;
		String inputPassword = String.valueOf(passwordField1_1.getPassword());//得到密码值
		HashMap<String, Object> hashMap = new HashMap<String, Object>();//创建hashMap集合
     	hashMap = ServiceFactory.getImpServiceInstance().check(textField1_1.getText(), inputPassword);//t
		flag = (boolean) hashMap.get("flag");
		power = (int) hashMap.get("power");
		if (flag == true) {
			window.frame.dispose();
			String mid = textField1_1.getText();
			ManagerUI mUi = null;
			mUi = new ManagerUI(mid,power);
		    System.out.println("初始化成功!"); 
		    //进入管理界面
			mUi.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "密码或账号错误！", "提示", JOptionPane.ERROR_MESSAGE);
			passwordField1_1.setText("");
		}
	}
}
