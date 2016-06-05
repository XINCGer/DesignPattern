//拖拉机工厂
class TractorFactory implements CarFactory {
    @Override
    public void productCar() {
        System.out.println("生产拖拉机");
    }
}