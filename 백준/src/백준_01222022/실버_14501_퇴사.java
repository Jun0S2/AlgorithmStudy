package 백준_01222022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버3
 * 삼성 역량 평가 기출 문제
 * 전형적인 DP 문제
 * @author June Park
 *
 */
public class 실버_14501_퇴사 {
	static int N,days[],wage[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		days = new int[N+1];
		wage = new int[N+1];
		
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			wage[i] = Integer.parseInt(st.nextToken());
		}
		int[] D = new int[N+2];
		
		for(int i = 0; i<=N ; i++) {
			if(i+days[i]<=N+1) {//오늘 + 소요시간이 퇴사일보다 적어야함
				D[days[i]+i] = Math.max(D[i+days[i]], D[i]+wage[i]);
			}
			D[i+1] = Math.max(D[i+1], D[i]);
		}
		System.out.println(D[N+1]);
	
	}


}
