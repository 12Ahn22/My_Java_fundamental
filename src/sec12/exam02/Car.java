package sec12.exam02;

public class Car {
    //    필드
    private String model;
    private String owner;

    //    생성자
    Car() {
    }

    Car(String model) {
        this.model = model;
    }

    Car(String model, String owner){
        this.model = model;
        this.owner = owner;
    }

//    메서드

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
