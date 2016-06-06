//生产保时捷工厂的工厂
class SuperPorscheFactory implements Provider {
    @Override
    public CarFactory creatCarFactory() {
        return new PorscheFactory();
    }
}
