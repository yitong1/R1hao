package factory;
import user.*;
import ͨ�Ź�˾.*;
public class DianxinFactory implements Factory{
	//�������Ź�˾
	public User produceuser() {
		return new Dianxin();
	}
}
