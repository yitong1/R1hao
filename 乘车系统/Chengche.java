package java1;

public class Chengche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Chuzuche cc = new Chuzuche();
         new Thread (cc,"��˾��").start(); 
         new Thread (cc,"��˾��").start();
         new Thread (cc,"��˾��").start();
         new Thread (cc,"��˾��").start();
         new Thread (cc,"��˾��").start();
	}

}
class Chuzuche implements Runnable{
	private int num=100;
	public void run() {
		while(true) {
			if(num>0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + "���͵�" + num-- + "���˿�");
			}
		}
	}
}