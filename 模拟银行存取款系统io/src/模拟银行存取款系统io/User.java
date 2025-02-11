package 模拟银行存取款系统io;

import java.util.*;
import java.io.*;

/** 
 * 用户信息
 */
public class User {
	private String call;//手机号码
	private int account;//存款额
	private String userName;//用户名
	private String cardPwd;//银行卡密码
	private String cardId;//卡号
	private String sex;//性别
	
	public String getSex() {
		return sex;
	}	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getCardId(){
		return cardId;
	}
	public void setCardId(String callId){
		this.cardId = callId;
	}
	
	public String getCardPwd(){
		return cardPwd;
	}
	public void setCardPwd(String cardPwd){
		this.cardPwd = cardPwd;
	}
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public int getAccount() {
		return account;
	}
	public int setAccount(int account){
		return this.account = account;
	}
	
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
}