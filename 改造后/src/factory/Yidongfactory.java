package factory;
import 通讯公司.*;
public class Yidongfactory implements Factory{

	@Override
	public Tongxun produceTongxun() {
		// TODO Auto-generated method stub
		return new Yidong();
	}
	
}
