package gaizao;
import java.util.Date;
import java.util.Random;
import ͨѶ��˾.*;
import factory.*;
import utility.XMLUtil;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private StringBuffer communicationRecords;
	Tongxun tongxun;
	
	public TelcomUser(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		this.communicationRecords=new StringBuffer();
		
		Factory userFactory = (Factory) XMLUtil.getBean();	
		tongxun=userFactory.produceTongxun();
	}
	//ģ��ͨ����¼������
	public void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {
			//������ɵ�i��ͨ����¼
	//		TelcomUser telcomUser = new TelcomUser("13800138000");
			//��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ������¼�
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//���к���
			callTo=getCallToPhoneNumber();
			//����ͨ��ʱ��
			this.communicationRecords.append(this.phoneNumber + "," + timeStart + "," + timeEnd + "," + this.callTo + ";");
		}
	}	
	//������ɱ��к��루����λ�����������
	public String getCallToPhoneNumber() {
			return "1380372" + String.valueOf(new Random().nextInt(10)) 
			+ String.valueOf(new Random().nextInt(10)) 
			+ String.valueOf(new Random().nextInt(10))
			+ String.valueOf(new Random().nextInt(10));
		}	
	//ģ��ƷѰ취�����ַ�������ʽ���ر���4λС���ļƷѽ��
	public String accountFee(long timeStart,long timeEnd) {
		//ÿ�����շ�*Ԫ
		double feePerMinute = tongxun.feilv();
		//ͨ���������������������
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}		
	//��ӡͨ����¼
		public void printDetails() {
			//��ȡȫ��ͨ����¼
			String allRecords = this.communicationRecords.toString();
			//�ָ�ͨ��ʱ��
			String [] recordArray = allRecords.split(";");
			//ѭ���ָ��¼�ڵ�ÿһ����
			for(int i = 0;i < recordArray.length;i++) {
				String [] recordField = recordArray[i].split(",");
				System.out.println("ͨѶ��˾��"+tongxun.name());
				System.out.println("���У�" + recordField[0]);
				System.out.println("���У�" + recordField[3]);
				System.out.println("ͨ����ʼʱ�䣺" + new Date(Long.parseLong(recordField[1])));
				System.out.println("ͨ������ʱ�䣺" + new Date(Long.parseLong(recordField[2])));
				System.out.println("���ʣ�"+tongxun.feilv());
				System.out.println("�Ʒѣ�"
				 + accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))
						 + "   Ԫ��");
			}
		}
}
