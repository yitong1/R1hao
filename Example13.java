interface Factory{
 
     void printnumber();            //�������printnumber()����
}
//����Add��ȥʵ��Factory�ӿ�
class Add implements Factory{
             //ʵ��printnumber()����
            public void printnumber(){

                  System.out.println("a+b");
           }
}
class Jian implements Factory{
                 //ʵ��printnumber()����
            public void printnumber(){
                
                  System.out.println("a-b");
          }
}
class Cheng implements Factory{
           //ʵ��printnumber()����
            public void printnumber(){
                 
                  System.out.println("a*b");
          }
}
class Chu implements Factory{
           //ʵ��printnumber()����
            public void printnumber(){
                 
                  System.out.println("a/b");
          }
}
//���������
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
          //���徲̬��factoryprintnumber()����������һ��Factory���͵Ĳ���
          public static void factoryprintnumber(Factory an){
                      an.printnumber();                              //����ʵ�ʲ�����printnumber()����
          }
}