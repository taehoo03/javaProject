package exam.constructor_ex;

public class Car {

    protected String carNo;
    protected String carName;
    protected String carMaker;
    protected int carYear;


    public Car(String carNo, String carName, String carMaker, int carYear) {
        this.carNo = carNo;
        this.carName = carName;
        this.carMaker = carMaker;
        this.carYear = carYear;
    }
}