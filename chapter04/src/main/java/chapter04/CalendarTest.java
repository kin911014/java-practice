package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// 팩토리메소드: 인스탄스를 찍어서 만든다
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11); // month(12) -1
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		cal.set(20, 11, 18);
		cal.add(Calendar.DATE, 5000);
		printDate(cal);
	}
	public static void printDate(Calendar cal) {
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		// 년도
		int year = cal.get(Calendar.YEAR);
		
		// 월 (0~11, +1), 
		int month = cal.get(Calendar.MONTH);
		// 일		
		int date = cal.get(Calendar.DATE);
		// 요일{1(일요일)~7(토요일)}
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 시
		int hour = cal.get(Calendar.HOUR);
		// 분
		int minute = cal.get(Calendar.MINUTE);
		// 초
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year + "년" +
		(month+1) + "월" +
		date + "일" +
		day + "날짜" +
		hour + "시" +
		minute + "분" +
		second + "초"
		);
	}
}
