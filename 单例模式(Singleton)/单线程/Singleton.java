//单线程实现单例模式
class Singleton {
    private static Singleton instance;
    
    //补全 构造器
  private Singleton(){
    
  }
    
    public static Singleton getInstance (){
        //补全 创建实例
        if(instance ==null)instance = new Singleton();
        return instance;
    }
}

