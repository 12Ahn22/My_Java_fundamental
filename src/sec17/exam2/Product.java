package sec17.exam2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;

    @Override
    public String toString() {
        return "Product{" +
                "pno=" + pno +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 주소가 같으면 같은 객체
        if (o == null || getClass() != o.getClass()) return false; // 클래스가 다르면 다른 객체
        Product product = (Product) o; // 비교를 위한 강제 타입 캐스팅
        return pno == product.pno; // 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(pno);
    }
}
