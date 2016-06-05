public class Main {

    public static void main(String[] args) {
        //保时捷工厂生产保时捷
        CarFactory pf = new PorscheFactory();
        pf.productCar();
        //拖拉机工厂生产拖拉机
        CarFactory tf = new TractorFactory();
        tf.productCar();
        //补全 奔驰工厂生产奔驰
       CarFactory bf = new BensFactory();
       bf.productCar();
    }

}
