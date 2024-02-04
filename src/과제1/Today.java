package 과제1;

public class Today {
    public static void main(String[] args) {
        Person ayoung = new Person("아영", 29);
//        아침에 일어남
        ayoung.wakeUp();
//        친구를 만남
        Person myFriend = new Person("친구", 29);

//        같이 버스를 타고 카페에 감
        Bus bus = new Bus();
        bus.setPassengers(new Person[]{ayoung, myFriend});
        bus.getPassenger();
        bus.run();
        bus.stop();
//        커피 마심
        ayoung.eat("아이스 아메리카노");
        myFriend.eat("스파클링 홍차");

//        이야기함
        ayoung.talk("독감 때문에 너무 힘들어....");
        myFriend.talk("금방 나을거야.:(");

//        버스타고 집에감
        bus.run();
        bus.stop();

//        잠
        ayoung.sleep();
    }
}

interface Vehicle {
    void run();

    void stop();

    void setPassengers(Person[] names);

    void getPassenger();
}

class Bus implements Vehicle {
    private final int CAPACITY = 30;
    private int cnt = 0;
    private final Person[] passengers = new Person[CAPACITY];

    @Override
    public void run() {
        System.out.println("버스가 달립니다.");
    }

    @Override
    public void stop() {
        System.out.println("버스가 도착했다.");
    }

    @Override
    public void setPassengers(Person[] names) {
        for (int i = 0; i < names.length; i++) {
            passengers[cnt] = names[i];
            cnt++;
        }
    }

    @Override
    public void getPassenger() {
        System.out.println("<탑승객 목록>");
        for (int i = 0; i < cnt; i++) {
            System.out.println(passengers[i].getName());
        }
        System.out.println("--------------");
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void wakeUp() {
        System.out.println("아침 8시에 기상");
    }

    public void talk(String talking) {
        System.out.print(name + "> ");
        System.out.println(talking);
    }


    public void sleep() {
        System.out.println("이제 잘 시간...");
    }


    public void eat(String food) {
        System.out.println(food + "를 먹었다.");
    }

}