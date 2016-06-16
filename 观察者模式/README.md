##观察者模式(Observer)  
> 对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。  
类图：  ![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/observer.jpg)  
1.抽象主题(Subject)角色：把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以有任意数量的观察者。  
抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。  
2.抽象观察者(Observer)角色：为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。  
3.具体主题(ConcreteSubject)角色：在具体主题内部状态改变时，给所有登记过的观察者发出通知。具体主题角色通常用一个子类实现。  
4.具体观察者(ConcreteObserver)角色：该角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协  
调。通常用一个子类实现。如果需要，具体观察者角色可以保存一个指向具体主题角色的引用。  

##控件按钮、报警器等都是观察者模式。  
```Java  
public interface Subject {
    //添加观察者
    void attach(Observer o);
    //删除观察者
    void detach(Observer o);
    //通知观察者
    void notifyObservers();
    //发生某事
    void doSomeThings()
}
//观察者
public interface Observer {
 
    void update();
}
public class ConcreteSubject implements Subject {
 
    ArrayList<Observer> observers = new ArrayList<>();
 
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
 
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
 
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
 
    public void doSomeThings(){
        //doSomeThings
        notifyObservers();//通知观察者
    }
}
//具体观察者
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("我观察到subject发生了某事");
    }
}
public static void main(String[] args) {
        Subject cs = new ConcreteSubject();
        //添加观察者
        cs.attach(new ConcreteObserver());
        //subject发生了某事，通知观察者
        cs.doSomeThings();
    }
```   

输出结果：  
![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/tobserver.png)  

##观察者模式优点：  
> 1.观察者和被观察者是抽象耦合的。  

> 2.建立一套触发机制。  

##观察者模式缺点：  
> 1.如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。  

> 2.如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。  

> 3.观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。  

##适用场景：  
> 1.当一个抽象模型有两个方面, 其中一个方面依赖于另一方面。将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。  

> 2.当对一个对象的改变需要同时改变其它对象, 而不知道具体有多少对象有待改变。  

> 3.当一个对象必须通知其它对象，而它又不能假定其它对象是谁。换言之, 你不希望这些对象是紧密耦合的。  
 
