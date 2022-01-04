package 프로그래머스_01042022;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(solution(record));
	}

	public static class User {
		String userid;
		String msg;

		public User(String userid, String msg) {
			this.userid = userid;
			this.msg = msg;
		}
	}

	private static String[] solution(String[] record) {
		ArrayList<User> log = new ArrayList<>();//닉네임이 아니라 userid를 저장하는 형식으로!
		HashMap<String, String> nickname = new HashMap<>();//아이디, 닉네임
		
		for (int i = 0; i < record.length; i++) {
			String temp[] = record[i].split(" ");

			if (temp[0].equals("Enter")) {	
				nickname.put(temp[1], temp[2]);
				log.add(new User(temp[1], "님이 들어왔습니다.")); 
			} else if (temp[0].equals("Change")) {
				nickname.put(temp[1], temp[2]);	
			} else if (temp[0].equals("Leave")) {
				log.add(new User(temp[1],"님이 나갔습니다."));		
			}
		}

		String[] answer = new String[log.size()];
		for(int i = 0 ; i<answer.length;i++) {
			answer[i] = nickname.get(log.get(i).userid)+log.get(i).msg;
			//System.out.println(answer[i]);
			}
		return answer;

	}

}
