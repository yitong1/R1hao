package java1;

public class Example02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xiazai xz = new Xiazai();
        new Thread (xz,"1").start(); 
        new Thread (xz,"2").start();
        new Thread (xz,"3").start();
        new Thread (xz,"4").start();
        new Thread (xz,"5").start();
	}

}
class Xiazai implements Runnable{
	private int num=100;
	public void run() {
		while(true) {
			if(num>0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + "正在下载第" + num-- + "部分");
			}
		}
	}
}