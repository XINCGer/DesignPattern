## 装饰器模式(Decorator)  
> 对客户透明的方式动态地给一个对象附加上更多的责任，同时又不改变其结构。  
装饰模式可以在不使用创造更多子类的情况下，将对象的功能加以扩展。  
类图：  ![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/decorator.png)  

1.抽象构件(Component)角色：给出一个抽象接口，以规范准备接收附加责任的对象。  
2.具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类。  
3.装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。  
4.具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。  
## Java IO中就是典型的装饰器  
```Java  
//InputStream提供的基本方法(Component)
public abstract class InputStream implements Closeable {
 
}
//默认目标实现类(ConcreteComponent)
public class FileInputStream extends InputStream {
 
}
/*装饰实现类（FilterInputStream）一定是继承或实现原始接口(InputStream)的，内部有包含一个原始接口的超类(其实就是某个默认目标实现类)*/
//Decorator
public class FilterInputStream extends InputStream {
    /**
     * The input stream to be filtered.
     */
    protected volatile InputStream in;
 
    protected FilterInputStream(InputStream in) {
        this.in = in;
    }
}
//具体装饰类(ConcreteDecorator)
public class BufferedInputStream extends FilterInputStream {
 
    public BufferedInputStream(InputStream in) {
        this(in, DEFAULT_BUFFER_SIZE);
    }
}
//具体装饰类(ConcreteDecorator)
public class DataInputStream extends FilterInputStream implements DataInput {
 
    public DataInputStream(InputStream in) {
        super(in);
    }
} 
```

## 装饰器模式优点：  
> 1.装饰类和被装饰类可以独立发展，不会相互耦合。

> 2.装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。  
就增加功能来说，装饰器模式相比生成子类更为灵活。  

## 适用场景：  
> 1.扩展一个类的功能。  

> 2.动态增加功能，动态撤销。
