package pers.ui;

import java.util.Random;

import pers.factory.DaoFactory;
import pers.factory.ServiceFactory;
import pers.table.Manager;
import pers.table.Member;
import pers.table.Parking;

public class addDate {
public static void main(String[] args)
{
	Random r=new Random(1);
	for(int i=0;i<10000;i++)
	{
		String id=""+i;
		int bb=r.nextInt(2);
		Manager member=new Manager(bb,id,""+i,"a"+i);
	   ServiceFactory.getImpServiceInstance().addManger(member);
	}
}
}
