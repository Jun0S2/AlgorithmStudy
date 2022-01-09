package 백준_01102022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @author June Park
 * Bronze 2
 * 삼성 기출문제
 * 풀이 시간 : 15분
 *
 */
public class 브론즈_13458_시험감독 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] classroom = new long[N];
		for(int i = 0 ; i < N; i++) {
			classroom[i]= Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		long supervisor_manager = Long.parseLong(st.nextToken());
		long supervisor_sub = Long.parseLong(st.nextToken());
		
		long min = 0;
		for(int i = 0 ; i<N ; i++) {
			long students = classroom[i];
			min += 1; //supervisor_manager
			students-=supervisor_manager;
			if(students<=0)continue;//처음엔 생각했는데 쓰다보니 까먹었다. 커버 가능한 학생이 남은 학생보다 많아지면 음수가 되므로 다음 반으로 넘어간다
			if(students%supervisor_sub!=0) min+=1; //나머지가 생기면 몫+1
			min += students / supervisor_sub;//몫 만큼 서브 수퍼바이저가 필요함
		}
		System.out.println(min);
	}

}
