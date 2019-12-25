package ģ�����д�ȡ��ϵͳio;
import java.*;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;

public class DBUtil{
	private static DBUtil instance = null;
	private HashMap<String, User> users = new HashMap<String, User>();
	public StringBuffer line;
	private FileInputStream fs;
	public FileOutputStream fos;

private DBUtil(){
	/*
	//----------Jack----------
	User u1 = new User();
	u1.setCardId("184801");
	u1.setCardPwd("123456");
	u1.setUserName("Jack");
	u1.setCall("13837894739");
	u1.setAccount(10000);
	users.put(u1.getCardId(), u1);
	//----------Rose----------
	User u2 = new User();
	u2.setCardId("184802");
	u2.setCardPwd("1234567");
	u2.setUserName("Rose");
	u2.setCall("13709747294");
	u2.setAccount(90000);
	users.put(u2.getCardId(), u2);
	//----------Sdaily----------
	User u3 = new User();
	u3.setCardId("184803");
	u3.setCardPwd("12345678");
	u3.setUserName("Sdaily");
	u3.setCall("18258492049");
	u3.setAccount(50000);
	users.put(u3.getCardId(), u3);
	*/
	getUsersFromInputStream("user.dat");
}

public void processUserString(String userString) {
	String[] userFields=userString.split(",");
	User u=new User();
	u.setCardId(userFields[0]);
	u.setCardPwd(userFields[1]);
	u.setUserName(userFields[2]);
	u.setCall(userFields[3]);
	u.setSex(userFields[4]);
	u.setAccount(Integer.parseInt(userFields[5]));
	users.put(u.getCardId(),u);
}
//�����ļ��ֽ���������ȡ�û���Ϣ
private void getUsersFromInputStream(String isName) {
	try {
		fs=new FileInputStream(isName);
		byte[] content = new byte[1024];
		int i=0;
		int conInteger=0;
		while(true) {
			try {
				conInteger=fs.read();
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(-1==conInteger) {
				break;
			}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {	
			try {
				System.out.println(new String(content,"GBK").trim());
				i=0;
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			continue;
		    }else {
		    	content[i]=(byte)conInteger;
		    	i++;
		    }
		
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

public void update() {
	Set<String> userSet=users.keySet();
	StringBuffer uStringBuffer=new StringBuffer();
	for(String cardId:userSet) {
		User u=(User)users.get(cardId);
		String uString=u.getCardId()+","+u.getCardPwd()+","+u.getUserName()+","
				+u.getCall()+","+u.getSex()+","+u.getAccount()+"\r\n";
		uStringBuffer.append(uString);
		}
	putUsersToFile(uStringBuffer.toString(),"user.dat");
}

private void putUsersToFile(String uString,String osName) {
	try {
		fos=new FileOutputStream(osName);
		try {
			fos.write(uString.getBytes("GBK"));
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
   //����ʽ����ģʽ
   public static DBUtil getInstance(){
	  if(instance == null){
		synchronized (DBUtil.class){
			if(instance == null){
				instance = new DBUtil();
			}
		}
	}
	return instance;
   }
	//�������п��Ż�ȡ��Ӧ�����˻�����Ϣ
	public User getUser(String cardId) {
		User user = (User) users.get(cardId);
		return user;
	}
	//��ȡ�����˻�����Ϣ
	public HashMap<String,User> getUsers(){
		return users;
	}
	public void addUser(User u) {
		users.put(u.getCardId(),u);
	}
}
