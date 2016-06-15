import java.util.ArrayList;

//安装火灾报警器的工厂
interface Factory {
    //添加火灾报警器
    void attach(Alarm alarm);

    //移除火灾报警器
    void detach(Alarm alarm);

    //通知报警器
    void nofityObserver();

    //发生火灾
    void fire();
    //...
}

//安装了报警器的工厂
class PorscheFactory implements Factory {

    ArrayList<Alarm> alarms = new ArrayList<>();

    @Override
    public void attach(Alarm alarm) {
        alarms.add(alarm);
    }

    @Override
    public void detach(Alarm alarm) {
        alarms.remove(alarm);
    }

    @Override
    public void nofityObserver() {
        for (Alarm alarm : alarms) {
            alarm.rang();
        }
    }

    @Override
    public void fire() {
       //补全,工厂发生火灾,通知报警器
      nofityObserver();
    }
}

//报警器(抽象观察者)
interface Alarm {
    void rang();
}

//火灾报警器(具体观察者)
class FireAlarm implements Alarm {
    //火灾报警器观察到工厂发行火灾鸣笛
    @Override
    public void rang() {
        System.out.println("发生工厂火灾了,鸣笛");
    }
}

public class Main {

    public static void main(String[] args) {
        Factory f = new PorscheFactory();
        //火灾报警器
        Alarm alarm = new FireAlarm();
        //补全,工厂安装火灾报警器
		f.attach(alarm);
      	f.fire();
        //补全,发生火灾了
    }

}
