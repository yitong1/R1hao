package factory;
import user.*;
import ͨ�Ź�˾.*;

public class LiantongFactory implements Factory{
	//������ͨ��˾
	public User produceuser() {
		return new Liantong();
	}
}
