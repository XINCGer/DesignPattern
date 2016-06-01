//多线程单例模式
class Singleton {
    private static Singleton instance;
    //synchronized加锁同步会降低效率,这里先判断是否为空
    //不为空则不需要加锁,提高程序效率
    //补全 构造器
  private Singleton(){}
    
    public static Singleton getInstance (){
        //补全 创建实例
      if(instance ==null){
        synchronized(Singleton.class){
          if(instance ==null){
            instance = new Singleton();
          }
        }
      }
        
        return instance;
    }
}