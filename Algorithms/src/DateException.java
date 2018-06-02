
public class DateException {

	public static int daysOfYear = 365;
	public static int daysOfLeapYear = 366;
	
	enum week { //like a class
		Monday, Tuesday, Wednesday, Thursday, Friday, Staurday, Sunday
	} //use ; or not is same
	
	public static week weeks[] = week.values();
	
	public static void main(String args[]) {
//		String date = "2018-03-0";
//		String date = "2018-02-29";
//		String date = "2020-02-29"; //legal;
		String date = "2018-03-29";
		try {
			legalDateDetection(date);
		} catch(MyDateException e) {
			e.printStackTrace();
			return; //不再进行星期计算
		}
		System.out.println(dayOfWeek(date));
	}
	
	public static void legalDateDetection(String date) throws MyDateException {
		String splitsdate[] = date.split("[/-]");
		int year = transferStrToInt(splitsdate[0]); //每次调用函数都有属于自己的YMD
		int month = transferStrToInt(splitsdate[1]);
		int day = transferStrToInt(splitsdate[2]);
		int dayOfFeb = 28; //进行检测时只需要一个变量进行取值
		if(year%4==0 && year%100!=0 || year%400==0) {
			dayOfFeb = 29;
		}
		if(month > 12 || month <= 0) {
			throw new MyDateException("Month Error");
		}
		if(day <= 0) {
			throw new MyDateException("Day Error, <= 0");
		}
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(day > 31) {
				throw new MyDateException("Day Error");
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(day > 30) {
				throw new MyDateException("Day Error");
			}
			break;
		case 2:
			if(day > dayOfFeb) {
				throw new MyDateException("Day Error");
			}
			break;
		default :
			throw new MyDateException("Enter Error");
		}
		System.out.println(date + " is legal!");
	}

	public static week dayOfWeek(String date) {
		String splitsdate[] = date.split("[/-]");
		int year = transferStrToInt(splitsdate[0]);
		int month = transferStrToInt(splitsdate[1]);
		int day = transferStrToInt(splitsdate[2]);
		int sumDays = 0;
		int daysOfThisYear = 0;
		int days[] = {31, 28, 31, 30, 31, 30, 
				31, 31, 30, 31, 30, 31}; //本年天数计算需要进行月份天数的叠加，数组进行数据整合
//除本年之前的天数，默认21世纪起
		for(int i = 2000; i < year; i++) {
			if(i%4==0 && i%100!=0 || i%400==0) {
				sumDays += daysOfLeapYear;
			} else {
				sumDays += daysOfYear;
			}
		}
		
		if(year%4==0 && year%100!=0 || year%400==0) {
			days[1] = 29;
		}
//在本年中除本月之前的月份总天数		
		for(int i = 0; i < month - 1; i++) {
			daysOfThisYear += days[i];
		}
		
		daysOfThisYear += day; //本年内第几天
		sumDays += daysOfThisYear;//总共的天数
		int sumDaysMode7 = sumDays % 7;
		sumDaysMode7 -= 3;//以写该程序的日期的星期数为准，进行移位 增/减
		
		if(sumDaysMode7 < 0) {
			sumDaysMode7 = 7 + sumDaysMode7;
		}

		System.out.println("Days of this year: " + daysOfThisYear);
		return weeks[sumDaysMode7];
	}
	
	public static int transferStrToInt(String s) {
		return Integer.parseInt(s);
	}
	
}

class MyDateException extends Exception {
	private static final long serialVersionUID = 1L;
	MyDateException(String s) {
		super(s);
	}
}
