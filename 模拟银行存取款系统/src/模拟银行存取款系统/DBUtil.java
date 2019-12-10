package 模拟银行存取款系统;
import java.util.*;

public class DBUtil{
	private static DBUtil instance = null;
	private HashMap<String, User> users = new HashMap<String, User>();


private DBUtil(){
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
}
   //懒汉式单例模式
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
	//根据银行卡号获取对应单个账户的信息
	public User getUser(String cardId) {
		User user = (User) users.get(cardId);
		return user;
	}
	//获取所有账户的信息
	public HashMap<String,User> getUsers(){
		return users;
	}
}
