package 프로그래머스_01062022;
/**
 * @author June Park
 * initial thoughts : use if-else if 
 * final thoughts : use string.replace function
 * */
public class 숫자문자열과영단어 {

	public static void main(String[] args) {
		String s ="2three45sixseven";
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		String numbers[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		for(int i = 0 ; i<10;i++) {
			s = s.replace(numbers[i], Integer.toString(i));
		}
		return Integer.parseInt(s);
	}


}
