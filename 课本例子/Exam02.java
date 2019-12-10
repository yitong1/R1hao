package java1;

public class Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int x=100;
         DaYin dy = new DaYin();
         new Thread(dy,"new").start();
         while(true) {
        	 if(x>0) {
        		 System.out.println("main");
        		 x--;
        	 }
         }
	}

}
class DaYin implements Runnable{
	
	private int y=50;
	
	public void run() {
		while(true) {
			if(y>0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name);
				y--;
			}
		}
	}
	
}