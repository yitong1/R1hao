package 使用ArrayList模拟电信计费系统;

import 使用ArrayList模拟电信计费系统.TelcomUserBasedOnCollection;

public class TelcomAccountSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化一个电信用户类TelcomUser
		TelcomUserBasedOnCollection telcomUser = new TelcomUserBasedOnCollection("13800138000");
		//生成通话记录
		telcomUser.generateCommunicateRecord();
		//打印通话详单
		telcomUser.printDetails();
	}

}
