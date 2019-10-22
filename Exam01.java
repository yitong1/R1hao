package java1;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MfWindow mw01 = new MfWindow();
         MfWindow mw02 = new MfWindow();
         new Thread (mw01,"线程01").start();
         new Thread (mw02,"线程02").start();
	}

}

class MfWindow extends Thread{
	private int num=10;
	public void run() {
		while(true) {
			if(num>0) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name + "打印" + num--);				
			}
		}
	}	
}