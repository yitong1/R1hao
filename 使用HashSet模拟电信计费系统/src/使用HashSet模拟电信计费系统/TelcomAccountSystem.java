package 使用HashSet模拟电信计费系统;


import 使用HashSet模拟电信计费系统.TelcomUser;

public class TelcomAccountSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化一个电信用户类TelcomUser
		TelcomUser telcomUser = new TelcomUser("13800138000");
		//生成通话记录
		telcomUser.generateCommunicateRecord();
		//打印通话详单
		telcomUser.printDetails();
		//打印被叫号码
		telcomUser.printCallTo();
	}

}
