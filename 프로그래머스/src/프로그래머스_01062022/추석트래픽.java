package 프로그래머스_01062022;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 추석트래픽 {

	public static void main(String[] args) throws ParseException {		
		String input = "2016-09-15 01:00:04.002";
		String inputSec = "2.0s";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd HH:mm:sss");
		Date date = sd.parse(input);
	
		SimpleDateFormat sec = new SimpleDateFormat("sss");
		Date seconds = sec.parse(inputSec);
		
		
		date.before(seconds);
		System.out.println(date);
	}
}
