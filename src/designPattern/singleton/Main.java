package designPattern.singleton;

public class Main {
    public static void main(String[] args) {
//        싱글톤
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
//        Singleton b = new Singleton(); // 되긴 하는데 이러면 싱클톤이 아닌가?
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        if(a == b){
            System.out.println("a == b");
        }
    }
}
