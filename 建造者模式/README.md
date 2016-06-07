##建造者模式(Builder)  
将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示  
主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，由于需求
的变化这个复杂对象的某些部分经常面临着剧烈的变化，一些基本部件不会变。    
所以需要将变与不变分离。与抽象工厂的区别：在建造者模式里，有个指导者(Director)  
由指导者来管理建造者，用户是与指导者联系的，指导者联系建造者最后得到产品。  
即建造者模式可以强制实行一种分步骤进行的建造过程。  
建造者类图：  
![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/builder.png)  
##建造者模式四要素：  

> 1.产品类Product：一般是一个较为复杂的对象，也就是说创建对象的过程比较复杂，一般会有比较多的代码量。

> 2.抽象建造者类Builder: 将建造的具体过程交与它的子类来实现，这样更容易扩展。

> 3.建造者类ConcreteBuilder: 组建产品；返回组建好的产品。

> 4.指导类Director: 负责调用适当的建造者来组建产品，指导类一般不与产品类发生依赖关系，与指导类直接交互的是建造者类。  

似乎很抽象。举个例子：前面你创建了一个生产保时捷的工厂，生产一台保时捷911需要的主要部件都一样(引擎，轮子，方向盘...)  
和流程是不变的，变的是引擎，轮子，控制系统等等部件具体实现，这些部件的生产交由具体的builder去生产。  
```Java
//抽象生产者
public interface Builder {
 
    void buildPartA();
    void buildPartB();
    void buildPartC();
 
    Product buildProduct();
}
//具体生产者
public class ConcreteBuilder implements Builder {
 
    Product product;
 
    @Override
    public void buildPartA() {
 
    }
 
    @Override
    public void buildPartB() {
 
    }
 
    @Override
    public void buildPartC() {
 
    }
 
    @Override
    public Product buildProduct() {
        return product;
    }
}
//产品由各个组件组成
public class Product {
 
    //partA
    //partB
    //partC
}
//指导者,产品生产流程规范
public class Director {
 
    Builder builder;
    //由具体的生产者来生产产品
    public Director(Builder builder) {
        this.builder = builder;
    }
    //生产流程
    public void buildProduct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
public static void main(String[] args) {
        //只需要关心具体建造者,无需关心产品内部构建流程。
        //如果需要其他的复杂产品对象，只需要选择其他的建造者.
        Builder builder = new ConcreteBuilder();
        //把建造者注入指导者
        Director director = new Director(builder);
        //指导者负责流程把控
        director.buildProduct();
        // 建造者返回一个组合好的复杂产品对象
        Product product = builder.buildProduct();
    }
```   
##建造者模式优点：  
> 1.建造者模式的封装性很好。使用建造者模式可以有效的封装变化，在使用建造者模式的场景中，  
一般产品类和建造者类是比较稳定的，因此，将主要的业务逻辑封装在指导者类中对整体而言可以取得比较好的稳定性。  

> 2.建造者模式很容易进行扩展。如果有新的需求，通过实现一个新的建造者类就可以完成。  

##适用场景：需要生成的对象具有复杂的内部结构；需要生成的对象内部属性本身相互依赖。
