//保时捷工厂
class PorscheFactory implements CarFactory {
    @Override
    public void productCar() {
        System.out.println("生产保时捷汽车");
    }
}