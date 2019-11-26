package ʹ��HashSetģ����żƷ�ϵͳ;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	
	private HashSet callToNumbers;
	private Vector commiuncationRecords;
	
	public TelcomUser (String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.commiuncationRecords = new Vector();
		this.callToNumbers = new HashSet();
	}
	//ģ��ͨ����¼���γ�
	void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {
			//��ʼʱ�䣬��ǰʱ��ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//����ʱ�䣬��ʼ���ʮ���������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//���к���
			this.callTo = getCallToPhoneNumber();
			this.callToNumbers.add(this.callTo);
			//����ͨ����¼
			 this.commiuncationRecords.add(this.phoneNumber +
					 ","+ timeStart +
					 "," +timeEnd +
					 "," +this.callTo +
					 ";"); 
		}
	}
	//��foreachѭ����callToNumbers��ߴ�ĵ绰�����ӡ����
    public void printCallTo() {
		// TODO Auto-generated method stub
		for(Object number:this.callToNumbers) {
			System.out.println(number);
		}
	}	
	//������ɱ��к��루����λ��������
	private String getCallToPhoneNumber() {
		return "1380372999" + String.valueOf(new Random().nextInt(10));
//		+ String.valueOf(new Random().nextInt(10))
//		+ String.valueOf(new Random().nextInt(10))
//		+ String.valueOf(new Random().nextInt(10));
	}
	//ģ��Ʒѷ��������ַ�������ʽ���ر�����4λС���ļƷѽ��
	private String accountFee(long timeStart,long timeEnd) {
		//ÿ�����շ�0.2Ԫ
		double feePerMinute = 0.2;
		//ͨ���������������������
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
/*	//��ӡͨ����¼
	void printDetails() {
		//��ȡȫ��ͨ����¼
		String allRecords = this.commiuncationRecords.toString();
		//�ָ�ͨ����¼
		String [] recordArray = allRecords.split(";");
		//ѭ�����ָ�ͨ����¼��ÿһ�����
		for(int i=0;i<recordArray.length;i++) {
			String[] recordField = recordArray[i].split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			System.out.println("ͨ����ʼʱ�䣺" + new Date(Long.parseLong(recordField[1])));
			System.out.println("ͨ������ʱ�䣺" + new Date(Long.parseLong(recordField[2])));
			System.out.println("�Ʒѣ�"
			+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
					+ "Ԫ��");
		}
	}  */
	//��ӡͨ����¼
	void printDetails() {
		//��ȡȫ��ͨ����¼
	//	String allRecords = this.commiuncationRecords.toString();
		//�ָ�ͨ����¼
	//	String [] recordArray = allRecords.split(";");
		//ѭ���ָ��¼�ڵ�ÿһ����
		
		/*
		 * ʹ��Iterator������
		 */
//	    Iterator it = this.commiuncationRecords.iterator();
		Enumeration enumeration = this.commiuncationRecords.elements();
	
		while(enumeration.hasMoreElements()) {
//			System.out.println("---------ͨ����¼�ָ���---------");
			//String [] recordField = ((String) this.commiuncationRecords.get(i)).split(",");
			String [] recordField = ((String) enumeration.nextElement()).split(",");
			//System.out.println("���У�" + recordField[0]);
		    /*
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			DateFormat
			/*
			System.out.println("ͨ����ʼʱ�䣺" + mediumFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + mediumFormat.format(timeEnd));
			*/
			/*
			SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
					*/
		}

	}
	
}
