package 백준_01162022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버_14899_스타트와링크 {
	static int N, skills[][];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		skills = new int[N+1][N+1];
		team1 = new int[N/2+1];
		team2 = new int[N/2+1];
		
		visited = new boolean[N+1];
		
		StringTokenizer st;
		for(int i = 1 ;  i<= N ; i++) {
			st = new StringTokenizer (br.readLine());
			for(int j = 1 ; j<= N ; j++) {
				skills[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(1);
		System.out.println(min);
	//	System.out.println("경우의 수 : "+tot);
	}
	static int team1[], team2[];
	static boolean visited[];
	/**
	 * combination  : 1번쨰 사람 ~ N번쨰 사람 -> 반명 뽑아서 조합 구하고 나머지 반명도 left out으로 뽑으면..
	 * 그 후에 브루투포스로 능력치 더하면 되고 min update
	 */
	public static void combination(int depth) {
		if(depth == N/2+1) {
			leftTeam();
			depth = 1;//초기화	
			tot++;
			return;
		}
		for(int i = 1; i <= N ; i++) {
			if(visited[i])continue;
			team1[depth] = i;
			visited[i] = true;
			combination(depth+1);
			visited[i] = false;
		}
	}
	static int tot = 0;
	/**
	 * 남은 팀원들 구하는 메서드 
	 */
	public static void leftTeam() {
		int cnt = 1;
		//visited가 false 인 애들
		for(int i = 1 ; i<= N ; i++) if(!visited[i]) {team2[cnt++]=i;}
		calculate();

	}
	/**
	 * 스킬합 계산
	 */
	public static void calculate() {
		int t1 = 0, t2 = 0;
		//일단 team1 의 합계 계산해보자
		for(int i = 1 ; i <=N ; i++) {
			for(int j = 1; j <= N ; j++) {
				if(i==j)continue;
				if(have(team1,i) && have(team1,j))t1+=skills[i][j];
				
				if(have(team2,i) && have(team2,j))//	if(team2.contains(i) && team2.contains(j)) 
				{
					t2+= skills[i][j];
				}
			}
		}
//		System.out.println("team1 : "+team1.toString());
//		System.out.println("team2 : "+team1.toString());
		min = Math.abs(t1-t2)<min ? Math.abs(t1-t2)  : min;

	}
	public static boolean have(int[] arr, int num) {
		for(int i = 1 ; i<arr.length ; i++) {
			if(arr[i]==num)return true;
		}
		return false;
	}

}
