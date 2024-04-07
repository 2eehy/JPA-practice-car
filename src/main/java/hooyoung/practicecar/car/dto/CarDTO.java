package hooyoung.practicecar.car.dto;

public class CarDTO {

    private int carCode;
    private String carName;
    private int carPrice;
    private int categoryCode;
    private String orderableStatus;

    public CarDTO() {
    }

    public CarDTO(int carCode, String carName, int carPrice, int categoryCode, String orderableStatus) {
        this.carCode = carCode;
        this.carName = carName;
        this.carPrice = carPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getCarCode() {
        return carCode;
    }

    public void setCarCode(int carCode) {
        this.carCode = carCode;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "carCode=" + carCode +
                ", carName='" + carName + '\'' +
                ", carPrice=" + carPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}