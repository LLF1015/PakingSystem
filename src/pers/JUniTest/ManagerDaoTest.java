package pers.JUniTest;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import pers.factory.ServiceFactory;
import pers.table.Manager;

public class ManagerDaoTest {

	/**
	 * 测试管理员增加
	 */
	@Test
	public void testAdd() {
		
		Manager manager=new Manager();
		manager.setId("13");
		manager.setName("13");
		manager.setPower(0);
		manager.setPwd("13");
		TestCase.assertTrue(ServiceFactory.getImpServiceInstance().addManger(manager));
	}
	
	/**
	 * 测试删除管理员
	 */
	@Test
	public void testDelManager() {
		TestCase.assertTrue(ServiceFactory.getImpServiceInstance().del("13", "M"));

	}

	/**
	 * 测试查询管理员
	 */
	@Test
	public void testFindManager() {
		TestCase.assertTrue(!ServiceFactory.getImpServiceInstance().findManager("1234").equals("null"));
	}

	/**
	 * 测试修改管理员权限
	 */
	@Test
	public void testUpMP() {
		TestCase.assertTrue(ServiceFactory.getImpServiceInstance().upMp("1234",0));

	}

}
