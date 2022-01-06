package 백준_01072022;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * 
 * @author June Park silver 5 분류 : 구현 설명 : d(n) = n+ 가장 큰 자릿수 + 다음 자릿수 + ... +
 *         일의 자리수 = x -> 셀프 숫자 : 위에 숫자 다 계산해놓고 없는 수를 배열에 더하면..
 */
public class 실버_4673_셀프넘버 {
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] D = new int[10001];
		for (int i = 1; i < D.length; i++) {
			if(formula(i)<10001)D[formula(i)]++;
		}
		for (int i = 1; i < D.length; i++) {
			if (D[i] < 1) bw.append(i+"\n");
		}
		bw.flush();
		bw.close();
	}

	/**
	 * int n 을 파라미터로 넘겨서, n : 생성자, result : 생성자가 만든 숫자
	 */
	public static int formula(int n) {
		int answer = n;
		// step 1: 숫자 분리 후 계산
		int divideBy = 10000;
		for (int i = 0; i < 5; i++) { // 10000씩 나눌 것
			answer += n / divideBy;
			n -= (n / divideBy) * divideBy;
			divideBy /= 10;
		}
		// System.out.println(answer);
		return answer;
	}
}
