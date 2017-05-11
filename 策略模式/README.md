## 策略模式(Strategy)  
> 定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。  
类图：  ![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/strategy.png)  
1.Strategy：策略接口，用来约束一系列具体的策略算法。Context使用这个接口来调用具体的策略，实现定义的策略。  
2.ConcreteStrategy：具体的策略实现，也就是具体的算法实现。  
3.Context：上下午，负责与具体的策略交互，通常上下文会持有一个真正的策略实现。  

策略模式是把一个类中经常改变或者将来可能改变的部分提取出来作为一个接口，然后在类中包含这个对象的实例  
这样类的实例在运行时就可以随意调用实现了这个接口的类的行为。  
##现在我们要根据不同需求，计算两个数的四则运算( + - * /)  
```Java  
//策略定义算法的接口
public interface Strategy {
    int calculate(int num1,int num2);
}
//具体算法,加法
public class OperationAdd implements Strategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
//具体算法,减法
public class OperationSubstract implements Strategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
//具体算法,乘法
public class OperationMultiply implements Strategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
//具体算法,除法
public class OperationDivide implements Strategy {
    @Override
    public int calculate (int num1, int num2){
        int res = 0;
        try {
            res = num1 / num2;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
//上下文
public class Context {
    //持有一个具体策略对象
    private Strategy strategy;
 
    //传入一个具体策略对象
    public Context(Strategy strategy) {
        this.strategy =strategy;
    }
 
    public int calculate(int num1,int num2){
        //调用具体策略对象进行算法运算
        return strategy.calculate(num1,num2);
    }
}
 public static void main(String[] args) {
        //计算 1 + 1
        Context context = new Context(new OperationAdd());
        System.out.println("1 + 1 = " + context.calculate(1,1));
        //计算 1 - 1
        context = new Context(new OperationSubstract());
        System.out.println("1 - 1 = " +context.calculate(1,1));
    }
```   
![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/tstrategy.png)  
## 策略模式优点：  
> 1.算法可以自由切换。  

> 2.避免使用多重条件判断。  

> 3.扩展性良好。  

## 策略模式缺点：  
> 1.策略类会增多。  

> 2.所有策略类都需要对外暴露。  

## 适用场景：  
>  1.如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象  
在许多行为中选择一种行为。  

> 2.一个系统需要动态地在几种算法中选择一种。  

> 3.一个类定义了多种行为, 并且这些行为在这个类的操作中以多个条件语句的形式出现。将相关的条件分支移入它  
们各自的Strategy类中以代替这些条件语句。
