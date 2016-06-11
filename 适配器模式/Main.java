//MicroUSB接口,客户端所期待的接口
interface MicroUSB {
    void process();
}

//USBTypec接口,需要被适配的接口
interface USBTypec {
    void process();
}

class Phone implements MicroUSB {
    @Override
    public void process() {
        System.out.println("使用MicroUSB接口进行充电");
    }
}

class Car implements USBTypec {
    @Override
    public void process() {
        System.out.println("使用USBTypec接口进行充电");
    }
}

//适配器,将USBTypec接口转换成MicroUSB
class USBTypecToMicroUSB implements MicroUSB {

    USBTypec usbTypec;

    public USBTypecToMicroUSB(USBTypec usbTypec) {
        this.usbTypec = usbTypec;
    }

    @Override
    public void process() {
        System.out.println("USBTypec接口转换成MicroUSB");
       usbTypec.process();
        
    }
}

public class Main {

    public static void main(String[] args) {
        USBTypec usbTypec = new Car();
        USBTypecToMicroUSB tTom = new USBTypecToMicroUSB(usbTypec);
        tTom.process();
    }

}
