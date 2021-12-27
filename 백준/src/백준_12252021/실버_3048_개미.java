package 백준_12252021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 실버_3048_개미 {
	/**Ants
	 * name : 개미의 letters
	 * group : 
	 * 		-group1 - 초기 상태에서 우측으로 가고있는 개미들
	 * 		-group2 - 초기 상태에서 좌측으로 가고있는 개미들
	 * */
	public static class Ants {
		char name;
		int group;

		Ants(int group, char name) {
			this.name = name;
			this.group = group;
		}
	}

	public static ArrayList<Ants> ants; //ArrayList에 개미의 정보를 담는다

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		br.readLine();// arraylist를 사용하기 때문에 따로 input의 사이즈는 저장하지 않고 넘긴다
		
		String input1 = br.readLine();
		String input2 = br.readLine();
		int T = Integer.parseInt(br.readLine());
		br.close();
		
		//ArrayList에 input으로 받은 개미들 저장
		ants = new ArrayList<>();

		for (int i = input1.length() - 1; i >= 0; i--)ants.add(new Ants(1, input1.charAt(i)));
		for (int i = 0; i < input2.length(); i++) ants.add(new Ants(2, input2.charAt(i)));
		

		// 구현
		// 본인 index의 group이 1이고, index+1의 group이 2인 경우를 저장
		int[] swap_index;//점프할 개미들의 index를 저장할 배열
		while (T > 0) {
			//초기화
			swap_index = new int[ants.size()];
			for (int i = 0; i < swap_index.length; i++) swap_index[i] = -1; 
			int index_cnt = 0;
			
			//앞의 개미가 다른 그룹의 개미일 경우 swap_index에 현재 개미의 위치 저장
			for (int i = 0; i < ants.size(); i++) {
				if (encounter(i))swap_index[index_cnt] = i;
				index_cnt++;
			}

			//저장된 위치들의 개미와 위치+1의 개미들을 서로 swap
			for (int i = 0; i < index_cnt; i++) {
				if (swap_index[i] >= 0) swap(swap_index[i]);	
			}
			
			T--;
		}

		// 출력
		for (int i = 0; i < ants.size(); i++) {
			bw.write(ants.get(i).name);
		}
		bw.flush();
		bw.close();
	}

	/**Encounter(index)
	 * 서로 다른 그룹의 개미를 만났을 때, 
	 * 현재 index의 개미가 1그룹의 개미라면 return true
	 * else false
	 */
	public static boolean encounter(int i) {
		if (i == ants.size() - 1)
			return false;// 맨 마지막 개미일때는 비교할것 없음
		if (ants.get(i).group == 2)
			return false; // group 2는 신경쓰지 말기
		if (ants.get(i).group != ants.get(i + 1).group)
			return true;
		return false;
	}

	/**Swap(index)
	 * ants(index)와 ants(index+1)의 개미의 위치를 바꾸는 메서드
	 * swap A and B
	 */
	public static void swap(int index) {
		char temp = ants.get(index).name;
		ants.get(index).name = ants.get(index + 1).name;
		ants.get(index + 1).name = temp;
		ants.get(index).group = 2;
		ants.get(index + 1).group = 1;

	}

}
