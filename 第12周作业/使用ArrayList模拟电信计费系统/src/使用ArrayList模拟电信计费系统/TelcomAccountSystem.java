package ʹ��ArrayListģ����żƷ�ϵͳ;

import ʹ��ArrayListģ����żƷ�ϵͳ.TelcomUserBasedOnCollection;

public class TelcomAccountSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʵ����һ�������û���TelcomUser
		TelcomUserBasedOnCollection telcomUser = new TelcomUserBasedOnCollection("13800138000");
		//����ͨ����¼
		telcomUser.generateCommunicateRecord();
		//��ӡͨ���굥
		telcomUser.printDetails();
	}

}
