package 백준_01222022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/**
 * 01/22/2022
 * 소요시간 : 3hrs
 * @author June Park
 * 범위를 기울기 왼쪽과 오른쪽으로 나누어서 풀이
 * 처음에는 조건으로 복잡하게 풀었다가 디버깅이 어려워서 인터넷에 찾아보니 대부분 visited배열로
 * ramp 기울기가 \인지 /  인지 나눠서 풀었다.
 * 훨씬 간편하고 디버깅도 쉬웠다
 *
 */
public class 골드_14890_경사로 {
	static int N, L, map[][];
	static int answer;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); // limit
		map = new int[N][N];
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	
			}
		}
		solution();
		
	}
	public static void solution() {
		int row[] = new int[N];
		int col[] = new int[N];
		
		for(int i = 0 ;i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				row[j] = map[i][j];
				col[j] = map[j][i];
			}
			if(checkRow(row))answer++;
			if(checkRow(col))answer++;
		}
		System.out.println(answer);
		
	}

	public static boolean checkRow(int[]arr) {
		visited = new boolean[N]; //경사로 놓았는지 확인하는 배열
		for(int i = 1 ; i<N ; i++) {
			int diff = arr[i] - arr[i-1]; //현재 - 이전
			if(diff==0)continue;
			if(Math.abs(diff)>1)return false;
			
			if(diff==1) {//  경사로 방향 -  /
				//현재 ~ L 길이 만큼 이전 칸들을 검사해야한다
				for(int j = i-1; j >= i-L ; j--) {
					//arr[i]의 왼쪽 (arr[i]-1) 과 높이가 같지 않거나 이미 경사로 있고, 범위 out -> x
					if(j<0||arr[j]!=arr[i]-1 || visited[j])return false;//높이가 다름
					visited[j] = true;//방문처리 -> 경사로를 세웠다는 표시
				}
			}else if (diff==-1) { //    경사로 방향 - \
				for(int j = i ; j<i+L ; j++) {
					//arr[i] 이후의 애들은 arr[i]와 높이 같아야함
					if(j>=N||arr[j]!=arr[i]||visited[j])return false;//높이가 달라 경사로 x
					visited[j] = true;
				}
			}
			
		}
		return true;
	}
}
