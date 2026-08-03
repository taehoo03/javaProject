package api.objectapi.datesdf;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateEx {

	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 =now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd 일 hh시 mm분 ss 초"); //생성자에 날짜 data 의 형식

	}

}
