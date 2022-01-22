package 백준_01212022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 백준 12시 이전 커밋 스트라이크 용
 * @author June Park
 *
 */
public class 브론즈_4344_평균은넘겠지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		int[] arr;
		int sum;
		int n;
		
		for(int i = 0 ; i<C ; i++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			sum = 0;
			
			int cnt = 0;//평균을 넘는 학생들
			
			for(int j = 0 ; j<n ; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			
			sum/=n;
			
			for(int j = 0 ;j<n; j++) if(arr[j]>sum) cnt++;
			bw.write(String.format("%.03f", (double)cnt/n*100)+"%\n");
		}//end of for loop
		
		bw.flush();
	}

}
