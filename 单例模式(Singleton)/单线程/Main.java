public class Main {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        //判断两个实例s1 s2是否为同一个实例
        System.out.println(s1 == s2);
    }

}