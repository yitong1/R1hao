package 使用HashSet模拟电信计费系统;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	
	private TreeSet callToNumbers;
	private Vector commiuncationRecords;
	
	public TelcomUser (String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.commiuncationRecords = new Vector();
		this.callToNumbers = new TreeSet();
	}
	//模拟通话记录的形成
	void generateCommunicateRecord() {
		//随机生成通话记录数目
		int recordNum = new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {
			//开始时间，当前时间前的某个随机时间
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//结束时间，开始后的十分钟内随机一个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//被叫号码
			this.callTo = getCallToPhoneNumber();
			this.callToNumbers.add(this.callTo);
			//插入通话记录
			 this.commiuncationRecords.add(this.phoneNumber +
					 ","+ timeStart +
					 "," +timeEnd +
					 "," +this.callTo +
					 ";"); 
		}
	}
	//用foreach循环将callToNumbers里边存的电话号码打印出来
    public void printCallTo() {
		// TODO Auto-generated method stub
		for(Object number:this.callToNumbers) {
			System.out.println(number);
		}
	}	
	//随机生成被叫号码（后四位）并返回
	private String getCallToPhoneNumber() {
		return "1380372999" + String.valueOf(new Random().nextInt(10));
//		+ String.valueOf(new Random().nextInt(10))
//		+ String.valueOf(new Random().nextInt(10))
//		+ String.valueOf(new Random().nextInt(10));
	}
	//模拟计费方法，以字符串的形式返回保留的4位小数的计费结果
	private String accountFee(long timeStart,long timeEnd) {
		//每分钟收费0.2元
		double feePerMinute = 0.2;
		//通话分钟数按四舍五入计算
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
/*	//打印通话记录
	void printDetails() {
		//获取全部通话记录
		String allRecords = this.commiuncationRecords.toString();
		//分割通话记录
		String [] recordArray = allRecords.split(";");
		//循环将分割通话记录的每一项输出
		for(int i=0;i<recordArray.length;i++) {
			String[] recordField = recordArray[i].split(",");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("呼叫：" + recordField[3]);
			System.out.println("通话开始时间：" + new Date(Long.parseLong(recordField[1])));
			System.out.println("通话结束时间：" + new Date(Long.parseLong(recordField[2])));
			System.out.println("计费："
			+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
					+ "元。");
		}
	}  */
	//打印通话记录
	void printDetails() {
		//获取全部通话记录
	//	String allRecords = this.commiuncationRecords.toString();
		//分割通话记录
	//	String [] recordArray = allRecords.split(";");
		//循环分割记录内的每一项并输出
		
		/*
		 * 使用Iterator迭代器
		 */
//	    Iterator it = this.commiuncationRecords.iterator();
		Enumeration enumeration = this.commiuncationRecords.elements();
	
		while(enumeration.hasMoreElements()) {
//			System.out.println("---------通话记录分割线---------");
			//String [] recordField = ((String) this.commiuncationRecords.get(i)).split(",");
			String [] recordField = ((String) enumeration.nextElement()).split(",");
			//System.out.println("主叫：" + recordField[0]);
		    /*
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			DateFormat
			/*
			System.out.println("通话开始时间：" + mediumFormat.format(timeStart));
			System.out.println("通话结束时间：" + mediumFormat.format(timeEnd));
			*/
			/*
			SimpleDateFormat			
			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
			
			System.out.println("计费：" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " 元。");
					*/
		}

	}
	
}
