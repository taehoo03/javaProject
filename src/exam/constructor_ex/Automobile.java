package exam.constructor_ex;

public class Automobile extends Car {

    private String autoManual;

   
    public Automobile(String carNo, String carName,
            String carMaker, int carYear, String autoManual) {

        super(carNo, carName, carMaker, carYear);
        this.autoManual = autoManual;
    }

    public void showInfo() { 
        System.out.println("차량 번호 : " + carNo);
        System.out.println("차종 : " + carName);
        System.out.println("제조사 : " + carMaker);
        System.out.println("연식 : " + carYear);
        System.out.println("기어변속 : " + autoManual);
    }
}