package exam;

public class Reservation {

    String plane;
    String name;
    String start;
    String end;
    int price;
    String seat;


    public Reservation() {
        this("KE1001","홍길동","인천","뉴욕",1600000,"A38");
    }

   
    public Reservation(String p, String n, String s, String e, int c, String a) {
        plane = p;
        name = n;
        start = s; 
        end = e;
        price = c;
        seat = a;
    }

    
    public void showRsvInfo() {
        System.out.println("항공기 : " + plane);
        System.out.println("이름 : " + name);
        System.out.println("출발지 : " + start);
        System.out.println("도착지 : " + end);
        System.out.println("금액 : " + price);
        System.out.println("좌석 번호 : " + seat);
    }
}