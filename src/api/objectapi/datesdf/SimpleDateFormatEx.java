package api.objectapi.datesdf;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SimpleDateFormatEx {

	public static void main(String[] args) {
		//SimpledateFormat 클래스
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(now));
		 sdf = new SimpleDateFormat("yyyy년 MM월 dd 일");
		System.out.println(sdf.format(now));
		 sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
			System.out.println(sdf.format(now));
			 sdf = new SimpleDateFormat("오늘은 E 요일");
				System.out.println(sdf.format(now));
				 sdf = new SimpleDateFormat("올해의 D 번째 날");
					System.out.println(sdf.format(now));
					 sdf = new SimpleDateFormat("이달의 d  번째 날");
						System.out.println(sdf.format(now));

	}

}
