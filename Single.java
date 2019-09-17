

public class Single {
	
       private static Single INSTANCE=new Single();//自己创建一个对象
       private Single() {}                        //私有化构造方法
       public static Single getInstance() {
    	   return INSTANCE;
       }
       }
       class Example15{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               Single s1=Single.getInstance();
               Single s2=Single.getInstance();
               System.out.println(s1==s2);
      }
   }
       

