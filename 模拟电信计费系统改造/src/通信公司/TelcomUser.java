package ͨ�Ź�˾;
import user.*;
import factory.*;
import utility.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TelcomUser {
	private String phoneNumber;
	//���к���
	private String callTo;
	//�����洢ͨѶ��¼
	private StringBuffer commiuncationRecords;
	//����һ��User�û�feifei
	User feifei;
	public  TelcomUser (String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.commiuncationRecords = new StringBuffer();
		//ʹ�ù�������
		Factory userFactory = (Factory) XMLUtil.getBean();	
		feifei=userFactory.produceuser();
	}
	
	//ģ��ͨ����¼���γ�
	public void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {
			//��ʼʱ�䣬��ǰʱ��ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//����ʱ�䣬��ʼ���ʮ���������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//���к���
			callTo = getCallToStringPhoneNumber();
			//����ͨ����¼
			 this.commiuncationRecords.append(this.phoneNumber +
					 ","+ timeStart +
					 "," +timeEnd +
					 "," +this.callTo +
					 ";"); 
		}
	}
	
	//������ɱ��к��루����λ��������
	public String getCallToStringPhoneNumber() {
		// TODO Auto-generated method stub
		return "1380372" + String.valueOf(new Random().nextInt(10))
		+ String.valueOf(new Random().nextInt(10))
		+ String.valueOf(new Random().nextInt(10))
		+ String.valueOf(new Random().nextInt(10));
	}
	
	//ģ��Ʒѷ��������ַ�������ʽ���ر�����4λС���ļƷѽ��
	public String accountFee(long timeStart, long timeEnd) {
		// TODO Auto-generated method stub
		//ÿ�����շѲ�ͬӪҵ�̲�ͬ��Ǯ,����ǰӪҵ�̵ķ���Ϊ׼
				double feePerMinute = feifei.feilv();
				//ͨ���������������������
				int minutes = Math.round((timeEnd - timeStart)/60000);
				//���㻰��
				double feeTotal = feePerMinute * minutes;
				return String.format("%.4f", feeTotal);
	}
	
/*    //��ӡͨ����¼
	public void printDetails() {
		��ȡȫ��ͨ����¼
		String allRecords = this.commiuncationRecords.toString();
		�ָ�ͨ����¼
		String [] recordArray = allRecords.split(";");
		ѭ�����ָ�ͨ����¼��ÿһ�����
		for(int i=0;i<recordArray.length;i++) {
			String[] recordField = recordArray[i].split(",");
			System.out.println(feifei.name());
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			System.out.println("ͨ����ʼʱ�䣺" + new Date(Long.parseLong(recordField[1])));
			System.out.println("ͨ������ʱ�䣺" + new Date(Long.parseLong(recordField[2])));
			System.out.println("�Ʒѷ��ʣ�"+feifei.feilv()+"Ԫ");
			System.out.println("�Ʒѣ�"
			+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
					+ "Ԫ��");
		}
	}           */
//	��ӡͨ����¼
	public void printDetails() {
		//��ȡȫ��ͨ����¼
				String allRecords = this.commiuncationRecords.toString();
				//�ָ�ͨ����¼
				String [] recordArray = allRecords.split(";");
				//ѭ���ָ��¼�ڵ�ÿһ����
				for(int i = 0; i < recordArray.length; i++) {
//					System.out.println("---------ͨ����¼�ָ���---------");
					//ͨѶ��˾����
					System.out.println("---------"+feifei.name()+"---------");
					String [] recordField = recordArray[i].split(",");
					System.out.println("���У�" + recordField[0]);
					System.out.println("���У�" + recordField[3]);
					//ͨ����ʼʱ��
					Date timeStart = new Date(Long.parseLong(recordField[1]));
					//ͨ������ʱ��
					Date timeEnd = new Date(Long.parseLong(recordField[2]));
					//ͨ��ʱ��
					Date timeminus = new Date(Long.parseLong(recordField[2])-Long.parseLong(recordField[1]));
					
					DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
					//��������ʱ�������ʽ��¼ͨ���Ŀ�ʼ����ʱ��
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
					//�Է�����ʽ��¼ͨ��ʱ��,�ù˿Ϳ��ĸ�����
					SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("mm��ss��");
					//DateFormat
					/*
					System.out.println("ͨ����ʼʱ�䣺" + mediumFormat.format(timeStart));
					System.out.println("ͨ������ʱ�䣺" + mediumFormat.format(timeEnd));
					*/
					
					//������Ҫ�ĸ������		
					System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
					System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
					System.out.println("ͨ��ʱ����"+simpleDateFormat2.format(timeminus));
					System.out.println("�Ʒѷ��ʣ�"+feifei.feilv());
					System.out.println("�Ʒѣ�" 
							+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
							+ " Ԫ��");
				}
			}
	}
