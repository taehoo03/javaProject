package bookcrud;

import java.sql.Date;
import java.util.Scanner;

public class BookMain {

    static Scanner sc = new Scanner(System.in);

    static BookDAO bookDAO = new BookDAO();
    static PublisherDAO publisherDAO = new PublisherDAO();
    static ClientDAO clientDAO = new ClientDAO();
    static BookSaleDAO saleDAO = new BookSaleDAO();

    public static void main(String[] args) {

        while (true) {
            System.out.println();
            System.out.println("********************");
            System.out.println("    도서 관리 프로그램");
            System.out.println("********************");
            System.out.println("다음 메뉴에서 선택");
            System.out.println("1. 도서 관리");
            System.out.println("2. 출판사 관리");
            System.out.println("3. 고객 관리");
            System.out.println("4. 판매 관리");
            System.out.println("5. 고객 로그인");
            System.out.println("6. 종료");
            System.out.println("********************");

            int menu = inputInt("메뉴 번호 입력 : ");

            switch (menu) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    publisherMenu();
                    break;
                case 3:
                    clientMenu();
                    break;
                case 4:
                    saleMenu();
                    break;
                case 5:
                    login();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
    }

    static void bookMenu() {
        while (true) {
            System.out.println("\n====================");
            System.out.println("도서 관리");
            System.out.println("====================");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 정보 조회");
            System.out.println("3. 도서 정보 수정");
            System.out.println("4. 도서 정보 삭제");
            System.out.println("5. 이전 메뉴");

            int menu = inputInt("메뉴 번호 입력 : ");

            switch (menu) {
                case 1: insertBook(); break;
                case 2: bookDAO.selectBook(); break;
                case 3: updateBook(); break;
                case 4: deleteBook(); break;
                case 5: return;
                default: System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
    }

    static void insertBook() {
        System.out.println("\n********************");
        System.out.println("도서 정보 등록");
        System.out.println("********************");

        int bookNo = inputInt("도서번호 입력 : ");
        String bookName = input("도서명 입력 : ");
        String bookAuthor = input("저자 입력 : ");
        int bookPrice = inputInt("가격 입력 : ");
        Date bookDate = inputDate("발행일 입력 (yyyy-MM-dd) : ");
        int bookStock = inputInt("재고 입력 : ");
        String pubNo = input("출판사 번호 입력 : ");

        Book book = new Book(bookNo, bookName, bookAuthor,
                bookPrice, bookDate, bookStock, pubNo);

        bookDAO.insertBook(book);
    }

    static void updateBook() {
        System.out.println("\n********************");
        System.out.println("도서 정보 수정");
        System.out.println("********************");

        int bookNo = inputInt("수정할 도서번호 입력 : ");
        String bookName = input("도서명 입력 : ");
        String bookAuthor = input("저자 입력 : ");
        int bookPrice = inputInt("가격 입력 : ");
        Date bookDate = inputDate("발행일 입력 (yyyy-MM-dd) : ");
        int bookStock = inputInt("재고 입력 : ");
        String pubNo = input("출판사 번호 입력 : ");

        bookDAO.updateBook(new Book(bookNo, bookName, bookAuthor,
                bookPrice, bookDate, bookStock, pubNo));
    }

    static void deleteBook() {
        int bookNo = inputInt("삭제할 도서번호 입력 : ");
        bookDAO.deleteBook(bookNo);
    }

    static void publisherMenu() {
        while (true) {
            System.out.println("\n====================");
            System.out.println("출판사 관리");
            System.out.println("====================");
            System.out.println("1. 출판사 등록");
            System.out.println("2. 출판사 정보 조회");
            System.out.println("3. 출판사 정보 수정");
            System.out.println("4. 출판사 정보 삭제");
            System.out.println("5. 이전 메뉴");

            int menu = inputInt("메뉴 번호 입력 : ");

            switch (menu) {
                case 1:
                    publisherDAO.insertPublisher(
                            new Publisher(input("출판사 번호 입력 : "),
                                    input("출판사명 입력 : ")));
                    break;
                case 2:
                    publisherDAO.selectPublisher();
                    break;
                case 3:
                    publisherDAO.updatePublisher(
                            new Publisher(input("수정할 출판사 번호 입력 : "),
                                    input("출판사명 입력 : ")));
                    break;
                case 4:
                    publisherDAO.deletePublisher(input("삭제할 출판사 번호 입력 : "));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
    }

    static void clientMenu() {
        while (true) {
            System.out.println("\n====================");
            System.out.println("고객 관리");
            System.out.println("====================");
            System.out.println("1. 고객 등록");
            System.out.println("2. 고객 정보 조회");
            System.out.println("3. 고객 정보 수정");
            System.out.println("4. 고객 정보 삭제");
            System.out.println("5. 이전 메뉴");

            int menu = inputInt("메뉴 번호 입력 : ");

            switch (menu) {
                case 1: insertClient(); break;
                case 2: clientDAO.selectClient(); break;
                case 3: updateClient(); break;
                case 4: clientDAO.deleteClient(input("삭제할 고객번호 입력 : ")); break;
                case 5: return;
                default: System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
    }

    static void insertClient() {
        System.out.println("\n********************");
        System.out.println("고객 정보 등록");
        System.out.println("********************");

        String no = input("고객번호 입력 : ");
        String name = input("고객명 입력 : ");
        String phone = input("전화번호 입력 : ");
        String address = input("주소 입력 : ");
        Date birth = inputDate("생년월일 입력 (yyyy-MM-dd) : ");
        String hobby = input("취미 입력 : ");
        String gender = input("성별 입력 : ");

        clientDAO.insertClient(new Client(no, name, phone, address,
                birth, hobby, gender));
    }

    static void updateClient() {
        String no = input("수정할 고객번호 입력 : ");
        String name = input("고객명 입력 : ");
        String phone = input("전화번호 입력 : ");
        String address = input("주소 입력 : ");
        Date birth = inputDate("생년월일 입력 (yyyy-MM-dd) : ");
        String hobby = input("취미 입력 : ");
        String gender = input("성별 입력 : ");

        clientDAO.updateClient(new Client(no, name, phone, address,
                birth, hobby, gender));
    }

    static void saleMenu() {
        while (true) {
            System.out.println("\n====================");
            System.out.println("판매 관리");
            System.out.println("====================");
            System.out.println("1. 판매 등록");
            System.out.println("2. 판매 정보 조회");
            System.out.println("3. 판매 정보 수정");
            System.out.println("4. 판매 정보 삭제");
            System.out.println("5. 이전 메뉴");

            int menu = inputInt("메뉴 번호 입력 : ");

            switch (menu) {
                case 1: insertSale(); break;
                case 2: saleDAO.selectSale(); break;
                case 3: updateSale(); break;
                case 4: saleDAO.deleteSale(input("삭제할 판매번호 입력 : ")); break;
                case 5: return;
                default: System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
    }

    static void insertSale() {
        System.out.println("\n********************");
        System.out.println("판매 정보 등록");
        System.out.println("********************");

        String bsNo = input("판매번호 입력 : ");
        Date bsDate = inputDate("판매일 입력 (yyyy-MM-dd) : ");
        String bsQty = input("판매수량 입력 : ");
        String bookNo = input("도서번호 입력 : ");
        String clientNo = input("고객번호 입력 : ");

        saleDAO.insertSale(new BookSale(bsNo, bsDate, bsQty, bookNo, clientNo));
    }

    static void updateSale() {
        String bsNo = input("수정할 판매번호 입력 : ");
        Date bsDate = inputDate("판매일 입력 (yyyy-MM-dd) : ");
        String bsQty = input("판매수량 입력 : ");
        String bookNo = input("도서번호 입력 : ");
        String clientNo = input("고객번호 입력 : ");

        saleDAO.updateSale(new BookSale(bsNo, bsDate, bsQty, bookNo, clientNo));
    }

    static void login() {
        System.out.println("\n********************");
        System.out.println("CLIENT 로그인");
        System.out.println("********************");

        String clientNo = input("고객번호 입력 : ");
        clientDAO.login(clientNo);
    }

    static String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    static int inputInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(input(message));
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력하세요.");
            }
        }
    }

    static Date inputDate(String message) {
        while (true) {
            try {
                return Date.valueOf(input(message));
            } catch (IllegalArgumentException e) {
                System.out.println("날짜 형식은 yyyy-MM-dd 입니다.");
            }
        }
    }
}
