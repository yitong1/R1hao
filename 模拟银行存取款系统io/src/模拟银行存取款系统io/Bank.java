package 模拟银行存取款系统io;

import java.io.*;
import java.util.Scanner;

/** 银行账户类 **/
public class Bank {
	int account;
	private static User user;
	public static void main(String[] args) {
		Bank b = new Bank();
		System.out.println("注册：1" + "\t" + "登录：2" + "\t");
		Scanner in = new Scanner(System.in);
		String s=in.nextLine();
		if("1".contentEquals(s)) {
			b.register();
			b.save();
		
		b.login();
		b.operate();
		}
		else {
			b.login();
			b.operate();
		}
	}
	
	
	private void save() {
		// TODO Auto-generated method stub
		
	}


	/**
	*  账户金额存入、取出和查询操作
	 */
	public void operate() {
		Bank b = new Bank();
		while (true) {
			System.out.println("请输入您要进行的操作类型，按回车键结束");
		  	System.out.println("存款：1" + "\t " + "取款：2" + "\t" + "余额：3" + "\t" + "退出：0");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();//输入的操作类型
			if ("1".equals(s)||"2".equals(s)) {
				int num = 0;
				try {
					if("1".contentEquals(s)) {
						System.out.println("输入存款的金额：");
						num = Integer.parseInt(in.nextLine());
					}else {
						System.out.println("输入取款的金额：");
						num = Integer.parseInt(in.nextLine());
					}				
				}catch(Exception e) {
					System.out.println("金额输入错误！");
					continue;
				}
				switch(s) {
				case "1"://存款操作
					b.income(num);
					break;
				case "2"://取款操作
					b.takeout(num);
					break;
				}
			}else if ("3".equals(s)) {
					b.show();//查询操作
			}else if("0".equals(s)) {
					System.out.println("退出系统！");
					return;
			}else {
					System.out.println("请输入0~3之间的数字选择相关操作！");
			}
		}
	}
	/**
	 * 用户登录网上银行
	 */
	public void login () {
		DBUtil dbutil = DBUtil.getInstance();
		System.out.println("欢迎进入网上银行系统！");
		while (true) {
			Scanner in = new Scanner(System.in);//键盘输入
			System.out.println("请输入银行卡号：");
			String cardId = in.nextLine();
			System.out.println("请输入银行密码：");
			String cardPwd = in.nextLine()+"7716496";
			user=dbutil.getUser(cardId);
			//登录
			if(dbutil.getUsers().containsKey(cardId)
					&& user.getCardPwd().equals(cardPwd)) {
				if(user.getSex().equals("男"))
				   System.out.println("登陆成功！欢迎" + user.getUserName() + "先生");
				else
				   System.out.println("登陆成功！欢迎" + user.getUserName() + "女士");
				break;
			}else {
				System.out.println("银行卡号或密码错误！");
				continue;
			}
		}
	}
	/**
	 * 存款
	 * @param num
	 */
	public void income (int num) {
		account = user.getAccount() + num;
		user.setAccount(account);
		System.out.println("存入金额" + num + "元成功！");
	}
	/**
	 * 取款
	 * 
	 * @param num
	 */
	public void takeout(int num) {
		if(user.getAccount() >= num) {
			account = user.getAccount() - num;
			user.setAccount(account);
			System.out.println("取出金额" + num + "元成功！");
		}else {
			System.out.println("余额不足，取款失败！");
		}
	}
	/**
	 * 余额
	 * @param num
	 */
	public void show() {
		account = user.getAccount();
		System.out.println("余额剩" + account + "元！");
	}
	


private void register() {
	User u=new User();
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入卡号：");
	u.setCardId(scanner.nextLine());
	System.out.println("请输入密码：");
	u.setCardPwd(scanner.nextLine()+"7716496");
	System.out.println("请输入用户名：");
	u.setUserName(scanner.nextLine());
	System.out.println("请输入手机号：");
	u.setCall(scanner.nextLine());
	System.out.println("请输入性别：");
	u.setSex(scanner.nextLine());
	System.out.println("请输入余额：");
	u.setAccount(scanner.nextInt());
	DBUtil dbutil=DBUtil.getInstance();
	dbutil.addUser(u);
}
}