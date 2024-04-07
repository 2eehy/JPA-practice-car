package hooyoung.practicecar.car.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "car_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carCode;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_price")
    private int carPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;


    public Car carName(String val) {
        this.carName = val;
        return this;
    }

    public Car carPrice(int val) {
        this.carPrice = val;
        return this;
    }

    public Car categoryCode(int val) {
        this.categoryCode = val;
        return this;
    }

    public Car orderableStatus(String val) {
        this.orderableStatus = val;
        return this;
    }

    public Car builder() {
        return new Car(carCode, carName, carPrice, categoryCode, orderableStatus);
    }

    protected Car() {}

    public Car(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.carCode = menuCode;
        this.carName = menuName;
        this.carPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return carCode;
    }

    public String getMenuName() {
        return carName;
    }

    public int getMenuPrice() {
        return carPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }



    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + carCode +
                ", menuName='" + carName + '\'' +
                ", menuPrice=" + carPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
