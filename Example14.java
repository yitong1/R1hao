interface IProduct{
 
    public void productMethod();            //�������printthing()����
}
//����product��ȥʵ��IProduct�ӿ�
class product implements IProduct{
             //ʵ��printthing()����
            public void productMethod(){

                  System.out.println("��Ʒ");
           }
}

interface IFactory{
               public IProduct createproduct();
}


class Factory implements IFactory{
             
            public IProduct createProduct(){

                  return new Product();
           }
}

public class Client{
            public static void main(String[] args){
            IFactory factory=new Factory();
            IProduct product=factory.createProduct();
            prodect.productMethod();
}
}