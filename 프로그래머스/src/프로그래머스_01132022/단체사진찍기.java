package 프로그래머스_01132022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 단체사진찍기 {

	public static void main(String[] args) {
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };
		단체사진찍기 d = new 단체사진찍기();
		d.solution(n, data);
	}

	/**
	 * 조합을 구한다
	 * 
	 * @param n
	 * @param data data : N~F=0, R~T>2
	 * @return
	 */
	public int solution(int n, String[] data) {
		int answer = 0;
		int condition1_space = data[0].charAt(4) - '0';
		int condition2_space = data[1].charAt(4) - '0';

		char[] characters = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
		return answer;

	}
	

	/**
	 * A와 B의 거리 in arr 가 conditionspace와 같은가?
	 * 
	 * @param conditionSpace
	 * @param arr
	 * @param A
	 */
	public static int compare(char[] arr, char A, char B) {
		boolean found = false;
		int space = 0;
		for (int i = 0; i < 8; i++) {
			if (found)
				break;// B까지 찾았으면 break loop
			if (arr[i] == A) {// A를 찾음
				for (int j = 0; j < 8; j++) {// B찾기 시작
					if (arr[j] == B) {
						found = true;
						break;
					} // B 찾음
					else
						space++;// 찾지 않았다면 거리 ++
				}
			}
		}
		return space;
	}

	public static boolean conditionMet(int conditionSpace, int space, String operator) {
		if (operator.equals("=")) {
			if (conditionSpace == space)
				return true;
			else
				return false;
		} else if (operator.equals("<")) {
			if (conditionSpace >= space)
				return true;
			else
				return false;
		} else {
			if (conditionSpace <= space)
				return true;
			else
				return false;
		}
	}
}
