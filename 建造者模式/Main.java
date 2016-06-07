class Car {
    //frame
    String frame;
    //engine
    String engine;
    //wheel
    String wheel;
    //...
}

interface Builder {
    void buildFrame();

    void buildEngine();

    void buildWheel();

    Car buildCar();
}

//911制造者
class Builder911 implements Builder {
    Car car = new Car();

    @Override
    public void buildFrame() {
        System.out.println("制造911骨架");
    }

    @Override
    public void buildEngine() {
        System.out.println("制造911引擎");
    }

    @Override
    public void buildWheel() {
        System.out.println("制造911引擎");
    }

    @Override
    public Car buildCar() {
        System.out.println("911汽车各部组装完毕");
        return car;
    }
}

//Cayma制造者
class BuilderCayma implements Builder {
    Car car = new Car();

    @Override
    public void buildFrame() {
        System.out.println("制造Cayma骨架");
    }

    @Override
    public void buildEngine() {
        System.out.println("制造Cayma引擎");
    }

    @Override
    public void buildWheel() {
        System.out.println("制造Cayma轮子");
    }

    @Override
    public Car buildCar() {
        System.out.println("Cayma汽车各部组装完毕");
        return car;
    }
}

//指导者
class Director {
    private Builder builder;

    //传入具体制造者
    public Director(Builder builder) {
        this.builder = builder;
    }

    public Car build() {
        builder.buildFrame();
        builder.buildEngine();
        builder.buildWheel();
        return builder.buildCar();
    }
}

public class Main {

    public static void main(String[] args) {
        //制造一台911
        Builder builder = new Builder911();
        Director director = new Director(builder);
        Car car911 = director.build();
        //补全,制造Cayma
        Builder builder1 = new BuilderCayma();
        Director director1 = new Director(builder1);
        Car cayma = director1.build();
    }

}
