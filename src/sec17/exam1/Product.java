package sec17.exam1;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
}
