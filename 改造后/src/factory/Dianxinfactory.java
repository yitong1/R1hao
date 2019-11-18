package factory;
import 通讯公司.*;
public class Dianxinfactory implements Factory{

	@Override
	public Tongxun produceTongxun() {
		// TODO Auto-generated method stub
		return new Dianxin();
	}
	
}
