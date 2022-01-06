package 백준_01072022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author June Park 실버5 compareto 문제
 */
public class 실버_10814_나이순정렬 {
	public static class Users implements Comparable<Users> {
		int regOrder, age;
		String name; // 가입일, 나이, 이름

		public Users(int regOrder, int age, String name) {
			this.regOrder = regOrder;
			this.age = age;
			this.name = name;
		}

		/**
		 * 나이순, 가입일 순 (나이가 작은순 ->오름차순)
		 */
		@Override
		public int compareTo(Users o) {
			// 1. 나이순으로 정렬
			if (o.age != this.age)
				return this.age - o.age;
			// 2. 가입일로 정렬
			return this.regOrder - o.regOrder;
		}
		
		@Override
		public String toString() {
			return age+" "+name;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Users> userList = new ArrayList<>();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t<T ; t++) {
			st = new StringTokenizer(br.readLine());
			userList.add(new Users(t,Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(userList);
		for(int i = 0 ; i<userList.size(); i++) {
			bw.append(userList.get(i).toString());
			bw.append("\n");
		}
		bw.flush();
	}

}
