## 抽象工厂模式(Abstract Factory)  
为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类。  
抽象工厂是工厂模式的升级版，他用来创建一组相关或者相互依赖的对象。来看下抽象工厂模式的类图：  
![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/afactory.png)  
上节学习了工厂模式，类的创建依赖工厂类，程序需要扩展时，我们必须创建新的工厂类。  
工厂类是用来生产产品的那我们也可以把“工厂类当成我们要生产的产品”，所以抽象工厂  
就是“工厂的工厂”，即生产工厂的工厂。下面通过一个例子来深入理解。 
```Java
//CPU工厂接口
public interface CPUFactory {  
    public void createCPU();  
}  

//IntelCPU工厂
public class IntelCPU implements CPUFactory {  
    @Override  
    public void createCPU() {  
        System.out.println("Intel CPU");  
    }  
} 

//AMDCPU工厂  
public class AMDCPU implements CPUFactory {  
    @Override  
    public void createCPU() {  
        System.out.println("AMD CPU");  
    }  
}  

//创建抽象工厂类接口  
public interface Provider {  
    public CPUFactory createCPUFactory();  
}  

public class InterCPUFactory implements Provider {  
    @Override  
    public CPUFactory createCPUFactory() {  
        return new InterCPU();  
    }  
}  

public class AMDCPUFactory implements Provider { 
    @Override  
    public CPUFactory createCPUFactory() {  
        return new AMDCPU();  
    }  
}  

public static void main(String[] args) {
        //创建一个生产CPU工厂的工厂
        Provider cpufactory = new InterCPUFactory();
        //通过CPU工厂的工厂创建一个IntelCPU工厂
        CPUFactory intelcpu = cpufactory.createCPUFactory();
        //IntelCPU工厂生产intelCPU
        intelcpu.createCPU();
  }  
  ```
## 抽象工厂的优点：  
抽象工厂模式除了具有工厂方法模式的优点外，最主要的优点就是可以在类的内部对产品族进行约束。  
所谓的产品族，一般或多或少的都存在一定的关联（例如不同厂商生产CPU）。  

## 适用场景：  
一个继承体系中，如果存在着多个等级结构（即存在着多个抽象类），并且分属各个等级结构中的实现类  
之间存在着一定的关联或者约束，就可以使用抽象工厂模式。
