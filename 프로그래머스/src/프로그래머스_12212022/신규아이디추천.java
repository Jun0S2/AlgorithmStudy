package 프로그래머스_12212022;

public class 신규아이디추천 {

	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		System.out.println(solution(new_id));
	}

	private static String solution(String new_id) {
		//step 1 : Lowercase로 변환
		new_id = new_id.toLowerCase();
		StringBuilder sb = new StringBuilder(); //새로운 아이디를 담을 스트링 빌더
		
		
		//step 2 : valid letters 외의 letters 제외
		for(int i = 0 ; i<new_id.length();i++) {
			int ascii = new_id.charAt(i);
			// 숫자인 경우 - valid
			if(ascii-'0'>=0 && ascii-'0' <=9) sb.append(new_id.charAt(i));
			// 알파벳인 경우
			else if(ascii>=97 && ascii<=122) sb.append(new_id.charAt(i));
			// _, -, . 인 경우
			else if(new_id.charAt(i)=='.'||new_id.charAt(i)=='_'||new_id.charAt(i)=='-') sb.append(new_id.charAt(i));
		}
		//문자열 자체가 공백인 경우 : aaa 리턴
		if(sb.length()==0)return "aaa";
		
		
		//step 3 : 마침표 2개 이상 연속 시 제거
		while(true) {
		if(sb.toString().contains("..")) {
			int remove = sb.indexOf(".."); 	 //연속된 . 가 있다면 인덱스를 찾고
			sb.delete(remove, remove+1);  }  // . 중 하나를 제거한다
		else break;							 //연속된 . 가 없다면 멈춘다

		}
		
	
		//step 4 : 마침표가 처음이나 끝에 있다면 제거
		if(sb.length()>1 && sb.charAt(sb.length()-1)=='.')sb.setLength(sb.length()-1); //끝
		if(sb.charAt(0)=='.') sb.deleteCharAt(0);	//처음 

		
		//step 5 : isEmpty string?
		if(sb.length()==0 || sb.toString()==" ") sb.append("a");

		
		//step 6 : if len>15 set len ==15
		if(sb.length()>15)sb.setLength(15);
		if(sb.length()>1 && sb.charAt(sb.length()-1)=='.')sb.setLength(sb.length()-1); //끝
		
		//step 7 : 길이가 2글자 이하인 경우 길이가 3이 될때 까지 마지막 글자 더함
		if(sb.length()<3) {
			while(sb.length()<3) {
				sb.append(sb.charAt(sb.length()-1));
			}
		}
	//	System.out.println(sb.toString());
		return sb.toString();
	}
}
