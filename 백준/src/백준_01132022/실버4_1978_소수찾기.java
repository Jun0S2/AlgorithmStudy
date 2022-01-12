package 백준_01132022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * 시간 제한 : 2초
 * @author June Park
 *
 */
public class 실버4_1978_소수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N =Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0;
		//주어진 숫자 중 소수 개수 확인
		for(int i= 0 ; i< N ; i++) {
			cnt += isPrime(Integer.parseInt(st.nextToken()));
			
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		
	}

	/**
	 * 주어진 숫자가 소수인지 아닌지 판단하는 메서드
	 * @param number
	 * @return 0:소수x, 1: 소수
	 */
	private static int isPrime(int number) {
		if(number == 1 || number ==0) return 0;
		boolean prime = true;
		for(int i = 2; i*i<=number; i++){
			if(number%i==0) prime = false;
		}
		return prime ? 1:0;//소수면 1 더하고 아니면 0 더함
	}

}
