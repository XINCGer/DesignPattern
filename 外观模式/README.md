##外观模式(Facade)  
> 为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。  
隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。降低访问复杂系统的内部子系统时的复杂度。  
类图：  ![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/facade.png)  
在客户端和复杂系统之间再加一层，将调用顺序、依赖关系等处理好。举个例子：我们经常用的电脑，开机其实是个非常  
复杂的过程，而我们只需要按开机按钮就可以了。  

模拟电脑启动，假设电脑启动顺序：启动CPU，启动内存，启动硬盘，加载数据等。  
```Java  
public class CPU {
 
    public void startup(){
        System.out.println("启动CPU");
    }
}
public class Memory {
 
    public void startup(){
        System.out.println("启动内存");
    }
}
public class Disk {
 
    public void startup(){
        System.out.println("启动硬盘");
    }
}
//facade
public class Computer {
 
    CPU cpu;
    Memory memory;
    Disk disk;
 
    public Computer(){
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }
 
    public void start(){
        cpu.startup();
        memory.startup();
        disk.startup();
    }
}
public static void main(String[] args) {
        Computer computer = new Computer();
        //启动computer是个很复杂的过程,我们并不需要知道其启动各个子系统的加载过程
        //只需要调用computer为各个子系统提供统一的一个接口start()就可以启动computer了
        computer.start();
    }  
```  
##外观模式优点：  
> 1.减少系统相互依赖。  

> 2.提高灵活性。  

> 3.提高了安全性。  

##适用场景：  
> 1.为复杂的模块或子系统提供外界访问的模块。  

> 2.客户程序与抽象类的实现部分之间存在着很大的依赖性。引入facade 将这个子系统与客户以及其他的子系统分离   
可以提高子系统的独立性和可移植性。
