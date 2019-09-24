interface IProduct{
 
    public void productMethod();            //定义抽象printthing()方法
}
//定义product类去实现IProduct接口
class product implements IProduct{
             //实现printthing()方法
            public void productMethod(){

                  System.out.println("产品");
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