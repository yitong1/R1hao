interface Factory{
 
     void printnumber();            //定义抽象printnumber()方法
}
//定义Add类去实现Factory接口
class Add implements Factory{
             //实现printnumber()方法
            public void printnumber(){

                  System.out.println("a+b");
           }
}
class Jian implements Factory{
                 //实现printnumber()方法
            public void printnumber(){
                
                  System.out.println("a-b");
          }
}
class Cheng implements Factory{
           //实现printnumber()方法
            public void printnumber(){
                 
                  System.out.println("a*b");
          }
}
class Chu implements Factory{
           //实现printnumber()方法
            public void printnumber(){
                 
                  System.out.println("a/b");
          }
}
//定义测试类
public class Example13{
          public static void main(String[] args){
             Factory an1=new Add();
             Factory an2=new Jian();
             Factory an3=new Cheng();
             Factory an4=new Chu();
             factoryprintnumber(an1);
             factoryprintnumber(an2);
             factoryprintnumber(an3);
             factoryprintnumber(an4);
          }
          //定义静态的factoryprintnumber()方法，接收一个Factory类型的参数
          public static void factoryprintnumber(Factory an){
                      an.printnumber();                              //调用实际参数的printnumber()方法
          }
}