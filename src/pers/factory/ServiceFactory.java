package pers.factory;

import pers.service.IEmpService;
import pers.service.imp.EmpServiceImp;

public class ServiceFactory {
	/**
	 * 得到IEMService
	 * @return IEmpService
	 */
public static IEmpService getImpServiceInstance()
{
	return new EmpServiceImp();
}
}
