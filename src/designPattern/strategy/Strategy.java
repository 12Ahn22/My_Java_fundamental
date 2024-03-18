package designPattern.strategy;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// 결제 전략 인터페이스
interface PaymentStrategy {
    // 결제라는 메서드 추상화
    public void pay(int amount);
}

// 카카오로 결제하는 전략
// @AllArgsConstructor // 이거 왜안되냐
class KakaoPayment implements PaymentStrategy{
    // 카카오 결제 시, 이름, 카드번호, cvv, 만료일이 필요하다.
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Kakao");
    }

    public KakaoPayment(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }
}

// 네이버로 결제하는 전략
class NaverPayment implements PaymentStrategy{
    // 네이버 결제 시, 이메일, 비밀번호만 필요하다.
    private String email;
    private String password;

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Naver");
    }

    public NaverPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

// 제품 클래스
class Item{
    private String name;
    @Getter
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

}

// 쇼핑 카트 클래스
class ShoppingCart{
    List<Item> items;
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }

    // 가격 총 계산
    public int calculateTotal(){
        int sum = 0;
        for(Item item: items){
            sum += item.getPrice();
        }
        return sum;
    }

    // 외부에서 '결제전략'을 받아 다양한 결제 방법(행위)를 실행한다.
    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount); // 전략의 결제 방법 실행
    }
}

public class Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item a = new Item("ice", 300);
        Item b = new Item("potato", 500);

        cart.addItem(a);
        cart.addItem(b);

        // pay by Kakao
        cart.pay(new KakaoPayment("ayo","1234-567","111","24.12.15"));

        // pay by Naver
        cart.pay(new NaverPayment("ann@naver.com","123456"));
    }
}
