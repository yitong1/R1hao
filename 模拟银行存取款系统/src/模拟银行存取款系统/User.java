package ģ�����д�ȡ��ϵͳ;
/** 
 * �û���Ϣ
 */
public class User {
	private String call;//�ֻ�����
	private int account;//����
	private String userName;//�û���
	private String cardPwd;//���п�����
	private String cardId;//����
	
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
	
	public int getAccount() {
		return account;
	}
	public int setAccount(int account){
		return this.account = account;
	}
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
}