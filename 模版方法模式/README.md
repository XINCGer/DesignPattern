##模板方法模式(Template Method)  
定义一个操作中算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变算法的结构即可重定义该算法中的某些特定步骤。  
类图：  
![](http://www.hubwiz.com/course/5710cb2e08ce8b3d3a1430f1/img/template.png)  
模板方法模式是编程中经常用到的模式，其非常简单，AbstractClass叫抽象模板，其方法分为3类：  

> 1.抽象方法：父类中只声明但不加以实现，而是定义好规范，然后由它的子类去实现。  

> 2.模版方法：由抽象类声明并加以实现。一般来说，模版方法调用抽象方法来完成主要的逻辑功能，  
并且，模版方法大多会定义为final类型，指明主要的逻辑功能在子类中不能被重写。  

> 3.钩子方法：由抽象类声明并加以实现。但是子类可以去扩展，子类可以通过扩展钩子方法来影响模版方法的逻辑。  

实现类用来实现细节。抽象类中的模版方法正是通过实现类扩展的方法来完成业务逻辑。    
现在要实现一个对无序数组从小到大排序并打印数组的类。排序算法有很多种，打印功能固定的。  
定义一个AbstractClass定义抽象排序方法由子类去实现；模板类实现打印方法。  
```Java
//抽象模板类
public abstract class AbstractSort {
 
    public abstract void sort(int[] array);
    //防止子类覆盖使用final修饰
    public final void printArray(int[] array) {
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
//具体实现类
public class QuickSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        //使用快排算法实现
    }
}
public class MergeSort extends AbstractSort {
    @Override
    public void sort(int[] array) {
        //使用归并排序算法实现
    }
}
public static void main(String[] args) {
        int[] arr = {3,5,2,45,243,341,111,543,24};
        //AbstractSort s = new MergeSort();
        AbstractSort s = new QuickSort();
        s.printArray(arr);
    }  
```
##模板方法模式优点：
> 1.容易扩展。一般来说，抽象类中的模版方法是不易反生改变的部分，而抽象方法是容易反生变化的部分  
因此通过增加实现类一般可以很容易实现功能的扩展，符合开闭原则。  

> 2.便于维护。对于模版方法模式来说，正是由于他们的主要逻辑相同，才使用了模版方法。  

##适用场景：  
在多个子类拥有相同的方法，并且这些方法逻辑相同时，可以考虑使用模版方法模式。  
在程序的主框架相同，细节不同的场合下，也比较适合使用这种模式。
