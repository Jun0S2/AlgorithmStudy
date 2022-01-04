package 프로그래머스_01042022;
/**
 * 알고리즘 스터디
 * 정답 실패
 * -> 해쉬맵으로 풀어보라고 피드백 받음
 * */
import java.util.ArrayList;

public class 오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}

	public static ArrayList<User> logs = new ArrayList<>();
	public static ArrayList<String> messages = new ArrayList<>();
	
	public static class User{
		String userid;
		boolean visited;
		String nickname;
		
		public User(String userid, String nickname) {
			this.nickname = nickname;
			this.userid = userid;
			this.visited = true;
		}

	}
	
	private static void solution(String[] record) {
		/*Step 1 : records 에서 기록 분리*/
		for(int i = 0 ; i<record.length ; i++) {
			String[] temp= record[i].split(" ");
			if(temp[0]=="Enter" && !logs.contains(temp[1])) {
				logs.add(new User(temp[1],temp[2]));	
			}	
		}
		
		for(int i = 0 ; i<record.length ; i++) {
			if(!logs.isEmpty()) {
				System.out.println(logs.get(i).userid);
			}
		}
		
		
	}

}
