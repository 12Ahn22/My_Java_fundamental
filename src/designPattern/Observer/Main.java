package designPattern.Observer;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public Object getUpdate(Observer obj);
}

interface Observer{
    public void update(); // 상태변화에 따른 행동 호출
}

class Topic implements Subject{ // 주체
    private List<Observer> observers; // 옵저버들(팔로워들)
    private String message;

    public Topic(){
        this.observers = new ArrayList<>();
        this.message = "";
    }
    @Override
    public void register(Observer obj) {
        if(!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    // 옵저버(팔로워)들에게 상태가 변경됬음을 알리기
    public void notifyObservers() {
        // 모든 옵저버들에게 상태변화 알림
        this.observers.forEach(Observer::update); // 옵저버들 업데이트!
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    // 메세지(상태)를 받고 옵저버들에게 알리는 메서드
    public void postMessage(String msg){
        System.out.println("Message sended to Topic: " + msg);
        this.message = msg;
        notifyObservers();
    }
}

// 옵저버들(구독자들)
@AllArgsConstructor
class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    @Override
    public void update() {
        // 주체(Topic)의 상태가 변해서 실행되는 업데이트 메서드
        String msg = (String) topic.getUpdate(this);
        System.out.println(name + ":: got message >>" + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Topic topic = new Topic(); // 주체
        
        // 옵저버 생성하기
        Observer a = new TopicSubscriber("a", topic); // topic을 구독하는 옵저버 a
        Observer b = new TopicSubscriber("b", topic); // topic을 구독하는 옵저버 b
        Observer c = new TopicSubscriber("c", topic); // topic을 구독하는 옵저버 c
        
        // 구독하기
        topic.register(a);
        topic.register(b);
        topic.register(c);

        topic.postMessage("This is my message!");
    }
}
