//补全 生产拖拉机工厂的工厂
class SuperTractorFactory implements Provider{
  @Override
    public CarFactory creatCarFactory(){
    return new TractorFactory();
  }
}

