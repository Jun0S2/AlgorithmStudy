package 백준_12252021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 실버_3048_개미 {
	public static class Ants {
		char name;
		int group;

		Ants(int group, char name) {
			this.name = name;
			this.group = group;
		}
	}

	public static ArrayList<Ants> ants;
	public static String input2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		br.readLine();// arraylist쓸거라 인풋 저장 안할거임
		String input1 = br.readLine();
		input2 = br.readLine();
		int T = Integer.parseInt(br.readLine());
		br.close();
		ants = new ArrayList<>();

		for (int i = input1.length() - 1; i >= 0; i--)
			ants.add(new Ants(1, input1.charAt(i)));
		for (int i = 0; i < input2.length(); i++) {
			ants.add(new Ants(2, input2.charAt(i)));			
		}

		// 구현
		// 본인 index의 group이 1이고, index+1의 group이 2인 경우를 저장
		int[] swap_index;
		while (T > 0) {
			// String swap_index ="";//이렇게하면 10이 넘어갈때 오류생김
			swap_index = new int[ants.size()];

			int index_cnt = 0;
			for (int i = 0; i < ants.size(); i++) {
				if (encounter(i))
					swap_index[index_cnt] = i;
				index_cnt++;
			}
			// System.out.println(swap_index);

			for (int i = 0; i < index_cnt; i++) {
				swap(swap_index[i]);
			}
			for (int i = 0; i < ants.size(); i++) {
				System.out.print(ants.get(i).name);
			}
			System.out.println();
			//if(done())break;
			
			T--;
		}

		// 출력
		for (int i = 0; i < ants.size(); i++) {
			bw.write(ants.get(i).name);
		}
		bw.flush();
		bw.close();
	}

	public static boolean encounter(int i) {
		if (i == ants.size() - 1)
			return false;// 맨 마지막 개미일때는 비교할것 없음
		if (ants.get(i).group == 2)
			return false; // group 2는 신경쓰지 말기
		if (ants.get(i).group != ants.get(i + 1).group)
			return true;
		return false;
	}

	/**
	 * swap A and B
	 */
	public static void swap(int index) {
		char temp = ants.get(index).name;
		ants.get(index).name = ants.get(index + 1).name;
		ants.get(index + 1).name = temp;
		ants.get(index).group = 2;
		ants.get(index + 1).group = 1;

	}
	public static boolean done() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<input2.length() ;i++) sb.append(ants.get(i).name);
		System.out.println(sb.toString());
		if(input2==sb.toString()) {
			System.out.println("???");
			return true;
		}
			
		else return false;
	}
}
