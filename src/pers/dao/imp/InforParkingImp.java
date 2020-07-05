package pers.dao.imp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pers.dao.InforParkingDao;
import pers.factory.ServiceFactory;
import pers.table.InforParking;

/**
 * 实现InforParkingDao接口
 * @author ASUS
 *
 */
public class InforParkingImp implements InforParkingDao {

	
	@Override
	public boolean add(InforParking inforparking,ArrayList<InforParking> list,String filename) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String date=dateFormat.format(new Date().getTime()).toString();
		inforparking.setToday(date);
		
		for(InforParking in:list)
		{
			if(in.getToday().equals(inforparking.getToday()))
			{
				in.setEn_num(in.getEn_num()+1);
				in.setEx_num(in.getEx_num()+1);
				in.setFee(in.getFee()+inforparking.getFee());
				Writerinformation(list,filename);
				return true;
			}
		}
		File file = new File(filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true));
	    StringBuilder sb=new StringBuilder();
		sb.append(inforparking.getToday()).append(",").append(inforparking.getEn_num()).append(",").append(inforparking.getEx_num()).append(",").append(inforparking.getFee());			
		bw.write(sb.toString());
		bw.newLine();
		bw.flush();
		bw.close();
		list.add(inforparking);
        return true;
	}

	@Override
	public boolean getInformation(ArrayList<InforParking> list) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean Writerinformation(ArrayList<InforParking> list,String filename) throws IOException
	{
		      File file = new File(filename);
					BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
				for(InforParking in:list)
				{
					StringBuilder sb=new StringBuilder();
					sb.append(in.getToday()).append(",").append(in.getEn_num()).append(",").append(in.getEx_num()).append(",").append(in.getFee());
					bw.write(sb.toString());
					bw.newLine();
					bw.flush();
				}
				bw.close();
		return true;
		
	}

	@Override
	public boolean Readerinformation(ArrayList<InforParking> list, String filename) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String ch;
		// 读入信息
		while ((ch = br.readLine()) != null) {
			String[] inforparkingdata = ch.split(",");
			
			InforParking s = new InforParking(inforparkingdata[0],Integer.parseInt(inforparkingdata[1]),Integer.parseInt(inforparkingdata[2]),Float.parseFloat(inforparkingdata[3]));
		
			// 添加到集合中
			list.add(s);
		}
		// 关闭文件
		br.close();
		return true;
	}

	@Override
	public boolean delinformation(ArrayList<InforParking> list, String filename, String date) {
		// TODO Auto-generated method stub
		for(InforParking in:list)
		{
			if(in.getToday().equals(date))
			{
				list.remove(in);
				try {
					Writerinformation(list,filename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
			
		}
		return false;
	}

	@Override
	public boolean updateinformation(ArrayList<InforParking> list, String filename, String date,InforParking inforparking) {
		// TODO Auto-generated method stub
		for(InforParking in:list)
		{
			if(in.getToday().equals(date))
			{
				in.setEn_num(inforparking.getEn_num());
				in.setEx_num(inforparking.getEx_num());
				in.setFee(inforparking.getFee());
				try {
					Writerinformation(list,filename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
			
		}
		return false;
	}
	
	
	}

