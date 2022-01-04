package 백준_12272021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 골드1_이항계수3 {
static long div = 1000000007;
static long [][] memo;//메모이제이션으로
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		br.close();
		
		memo = new long[N+1][N+1];
		
		for(int i = 0 ;i <=N ; i++) {
			for(int j = 0 ; j<=Math.min(i, j);j++) {
				if(j==0||j==i)memo[i][j]=1;//5C0 or 5C5 = 1
				else memo[i][j]= (memo[i-1][j] + memo[i-1][j-1])%div; 
			}
		}
		bw.write(String.valueOf(memo[N][K]));
		bw.flush();
		bw.close();
	}
	

	

}
