package factory;
import factory.*;
import tv.*;
public class HaierTVFactory implements TVFactory{
	public TV produceTV(){
		return new HaierTV();
	}
}