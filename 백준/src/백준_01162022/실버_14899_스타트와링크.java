package 백준_01162022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버_14899_스타트와링크 {
	static int N, skills[][];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		skills = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st;
		for(int i = 1 ;  i<= N ; i++) {
			st = new StringTokenizer (br.readLine());
			for(int j = 1 ; j<= N ; j++) {
				skills[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(1,1);
		bw.write(Integer.toString(min));
		bw.flush();
		
	}
	static boolean visited[];
	/**
	 * combination  : 1번쨰 사람 ~ N번쨰 사람 -> 반명 뽑아서 조합 구하고 나머지 반명도 left out으로 뽑으면..
	 * 그 후에 브루투포스로 능력치 더하면 되고 min update
	 */
	static int sum1,sum2;
	public static void combination(int start, int depth) {
		if(depth == N/2+1) {
			//System.out.println(Arrays.toString(visited));
			int diff = Team();
			if(diff==0) {System.out.println("0"); System.exit(0);}
			min = diff<min? diff:min;
			return;
		}
		
		for(int i = start ;i <= N ; i++) {
			if(visited[i])continue;
			visited[i] = true;
			combination(i+1 , depth+1);
			visited[i] = false; 
		}
		
	}

	/**
	//team 1 : visited가 true인 경우
	//team 2 : visited가 false 인 경운
	 * @return 
	 */
	public static int Team() {
		int t1= 0 , t2 = 0;
		for(int i = 1; i <= N ; i ++) {
			for(int j = i+1; j<= N ; j++) {
				if(visited[i] && visited[j]) {//team1
					t1+=(skills[i][j]+skills[j][i]);
				}
				else if(!visited[i]&& !visited[j]) { //team2
					t2+=(skills[i][j]+skills[j][i]);	
				}
			}
		}
		return Math.abs(t1-t2);
	}
	


}
