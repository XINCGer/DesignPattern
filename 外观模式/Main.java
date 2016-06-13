class Frame {
    public void create() {
        System.out.println("组装骨架");
    }
}

class Engine {
    public void create() {
        System.out.println("组装引擎");
    }
}

class Wheel {
    public void create() {
        System.out.println("组装轮子");
    }
}

class Controller {
    private Frame frame;
    private Engine engine;
    private Wheel wheel;

    public Controller(){
        frame = new Frame();
        engine = new Engine();
        wheel = new Wheel();
    }

    public void build(){
        frame.create();
        engine.create();
        wheel.create();
        System.out.println("汽车组装完成");
    }
}
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        //补全,操作员按生产按钮开始组装汽车
        controller.build();
    }

}
