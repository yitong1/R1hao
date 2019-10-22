package java1;

public class Chengche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Chuzuche cc = new Chuzuche();
         new Thread (cc,"李司机").start(); 
         new Thread (cc,"王司机").start();
         new Thread (cc,"张司机").start();
         new Thread (cc,"刘司机").start();
         new Thread (cc,"郭司机").start();
	}

}
class Chuzuche implements Runnable{
	private int num=100;
	public void run() {
		while(true) {
			if(num>0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + "接送第" + num-- + "个乘客");
			}
		}
	}
}