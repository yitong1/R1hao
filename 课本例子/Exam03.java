package java1;

public class Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           FaZuoye fzy = new FaZuoye();
           new Thread(fzy,"王老师").start();
           new Thread(fzy,"李老师").start();
           new Thread(fzy,"刘老师").start();
	}

}
class FaZuoye  implements Runnable{
	private int sum = 100;
	public void run() {
		while(true) {
			if(sum>0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + "正在分发第" + sum-- + "本作业");
				
			}
		}
	}
}