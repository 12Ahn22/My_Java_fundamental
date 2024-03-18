package designPattern.factory;

// 각 커피들의 부모 역할을 하는 클래스
// 각 커피 제품들을 추상화 한 것
abstract class Coffee{
    public  abstract  int getPrice();

    @Override
    public String toString() {
        return "Price: " + this.getPrice();
    }
}

// 아래는 각각 제품 구현체들(기본, 라떼, 아메리카노)
class DefaultCoffee extends Coffee{
    private int price;
    public DefaultCoffee(){
        this.price = -1;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

class Latte extends Coffee{
    private int price;
    public Latte(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

class Americano extends Coffee{
    private int price;
    public Americano(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}


// 커피 공장 - 객체를 생성해서 반환해주는 역할만 한다. 공장 객체
class CoffeeFactory{
    public static Coffee getCoffee(String type, int price){
        // 아래 코드들은 Enum이나 Map으로 if문을 사용하지 않고 Mapping할 수 있음
        if("Latte".equalsIgnoreCase(type)) return new Latte(price);
        else if("Americano".equalsIgnoreCase(type)) return new Americano(price);
        // 새로운 커피가 늘어 날 수록, 여기 코드가 변경되야함 -> 더 나은 방법이 있을 듯
        else return  new DefaultCoffee();
    }
}
public class Factory {
    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("latte", 3000);
        Coffee americano = CoffeeFactory.getCoffee("americano", 1500);
        System.out.println(latte);
        System.out.println(americano);
    }
}
