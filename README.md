# DesignPattern
汇智网的设计模式教程练习代码

## [【新】Unity常用设计模式总结](https://github.com/XINCGer/Unity3DTraining/tree/master/DesignPatterns)

### 说明  
[教程地址](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/)  
[单例模式](https://github.com/XINCGer/DesignPattern/tree/master/%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F(Singleton))  
[工厂模式](https://github.com/XINCGer/DesignPattern/tree/master/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F)  
[抽象工厂模式](https://github.com/XINCGer/DesignPattern/tree/master/%E6%8A%BD%E8%B1%A1%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F)  
[建造者模式](https://github.com/XINCGer/DesignPattern/tree/master/%E5%BB%BA%E9%80%A0%E8%80%85%E6%A8%A1%E5%BC%8F)  
[模版方法模式](https://github.com/XINCGer/DesignPattern/tree/master/%E6%A8%A1%E7%89%88%E6%96%B9%E6%B3%95%E6%A8%A1%E5%BC%8F)  
[适配器模式](https://github.com/XINCGer/DesignPattern/tree/master/%E9%80%82%E9%85%8D%E5%99%A8%E6%A8%A1%E5%BC%8F)  
[外观模式](https://github.com/XINCGer/DesignPattern/tree/master/%E5%A4%96%E8%A7%82%E6%A8%A1%E5%BC%8F)  
[装饰器模式](https://github.com/XINCGer/DesignPattern/tree/master/%E8%A3%85%E9%A5%B0%E5%99%A8%E6%A8%A1%E5%BC%8F)  
[观察者模式](https://github.com/XINCGer/DesignPattern/tree/master/%E8%A7%82%E5%AF%9F%E8%80%85%E6%A8%A1%E5%BC%8F)  
[策略模式](https://github.com/XINCGer/DesignPattern/tree/master/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F)

### 设计模式的六大原则  

> 1 开闭原则

一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。在软件的生命周期内，因变化、升级和维护对原有代码进行修改，可能会引入错误。所以当软件需要变化时，通过扩展软件实体的行为来实现变化，而不是修改原有代码。

> 2 里氏代换原则

任何基类可以出现的地方，子类一定可以出现。里氏代换原则是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。里氏代换原则是对“开-闭”原则的补充。实现“开-闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。通俗的说就是：子类可以扩展父类的功能，但不能改变父类原有的功能。

> 3 单一职责原则

一个类只负责一项职责。

> 4 依赖倒置原则

高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象。通俗的说：多用抽象的接口来描述相同的动作，降低实现这个动作的人和物之间的耦合度。

> 5 接口隔离原则

客户端不应该依赖它不需要的接口；一个类对另一个类的依赖应该建立在最小的接口上。

> 6 迪米特法则

一个对象应该对其他对象保持最少的了解。类与类之间的关系越密切，耦合度越大，当一个类发生改变时，对另一个类的影响也越大。
