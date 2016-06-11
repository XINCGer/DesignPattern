##适配器模式(Adapter Class/Object)  
是指将一个接口转换成客户端希望的另外一个接口，该模式使得原本不兼容的类可以一起工作。  
举个例子：macbook pro有一个HDMI接口，一条HDMI接口的数据线，现在要外接显示器，而显示  
器只有VGI接口，我们需要一个HDMI-VGI转换器，这个转换器其实起到的作用就是适配器，让两个不兼容的接口可以一起工作。  

类图：  ![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/adapter.png)  
##适配器有4种角色：

> 1.目标抽象角色(Target)：定义客户所期待的使用接口。(GVI接口)  

> 2.源角色(Adaptee)：需要被适配的接口。(HDMI接口)  

> 3.适配器角色(Adapter)：把源接口转换成符合要求的目标接口的设备。(HDMI-VGI转换器)  

> 4.客户端(client)：例子中指的VGI接口显示器。  
把HDMI接口转换成VGI接口，使得macbook pro可以外接显示器。  

```Java  
//HDMI接口，需要被适配的接口
public interface HDMIPort {
    void workByHDMI();
}
//VGI接口，客户端所期待的接口
public interface VGIPort {
    void workByVGI();
}
//将HDMI接口转换为VGI,这就是适配器
public class HDMIToVGI implements VGIPort{
 
    HDMIPort hdmiPort;
 
    public HDMIToVGI(HDMIPort hdmiPort) {
        this.hdmiPort = hdmiPort;
    }
    //将HDMI接口转换为VGI接口
    @Override
    public void workByVGI() {
        hdmiPort.workByHDMI();
    }
}
 public static void main(String[] args) {
        //定义一个HDMI接口
        HDMIPort hdmiPort = new HDMIPort() {
            @Override
            public void workByHDMI() {
                //hdmi接口工作方式
            }
        };
        //将HDMI接口转换为VGI接口
        VGIPort vgiPort = new HDMIToVGI(hdmiPort);
        //经过转换HDMI接口变成了VGI接口
        vgiPort.workByVGI();
    }
```  

##适配器模式优点：
> 1.可以让任何两个没有关联的类一起运行。  

> 2.提高了类的复用。  

> 3.增加了类的透明度。  

> 4.灵活性好。  

##适配器模式缺点：过多地使用适配器，会让系统非常零乱，不易整体进行把握。  

##适用场景：  
> 1.系统需要使用现有的类，而此类的接口不符合系统的需要。  

> 2.想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类  
包括一些可能在将来引进的类一起工作，这些源类不一定有一致的接口。  

> 3.通过接口转换，将一个类插入另一个类系中。  
