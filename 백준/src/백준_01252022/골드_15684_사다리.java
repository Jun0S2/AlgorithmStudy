package 백준_01252022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 골드_15684_사다리 {
static int N,M,H;
static boolean visited[][];//가로가 이어진 사다리
static int result[]; //사다리타기 결과

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());//세로
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		visited = new boolean[M+1][N+1];
		print();
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			visited[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		for(int i = 0 ; i<=3 ; i++) { //i " 사다리 개수
			min = i;
			solution(1,1,0);
			if(flag)break;//찾음
		}
		if(!flag) {System.out.println(-1);return;}
		System.out.println(min);
	}
	static int min = Integer.MAX_VALUE;
	static boolean flag = false;
	/**
	 * 
	 * @param moveCnt : 최대치 
	 * @param ladders : 추가한 사다리 횟수
	 * @param px , py : 이전 x,y좌표
	 */
	private static void solution(int px, int py, int moveCnt) {
		if(flag)return;//찾음
		
		if(min ==moveCnt) {
			// 마지막 경우 확인 -> 이때도 못가면 못간거임
			simulation();
			if(itoiCheck()) {//성공한 경우는 px, py줄때도 다르게 줘야하지 않을까...
				min = moveCnt < min ? moveCnt : min ;
				flag = true;
			}
			return;
		}
		for(int i = px; i<=M ; i++) {
			for(int j =py ;j<=N ;j ++) {
				if(visited[i][j])continue;//이미 방문함
				if(i<1||j<1||i>=M+1||j>=N)continue;//맨 마지막에는 추가할 수 없음
				
				if(j>1 && (visited[i][j-1])||( j<M && visited[i][j+1]))continue;//양쪽에 이미 사다리가 있다면 불가*(연속불가조건)
				//이제 방문 가능!
				visited[i][j] = true;
				solution(moveCnt,i+1,j+1);
				visited[i][j] = false;
				
			}
		}
		
	}
	
	/**
	 * i:i 관계를 만족하는 사다리타기 결과가 나왔다면
	 * @return true, else false
	 */
	private static boolean itoiCheck() {
		for(int i = 1 ; i<=N ; i++) {
			if(result[i]!=i)return false;
		}
		return true;
	}
	/**
	 * 사다리타기 : 배열 시뮬레이션
	 * 해당 콜륨의 왼쪽과 오른쪽 원소를 바꾼다
	 */
	private static void simulation() {
		initLadder();
		print();
		for(int i = 1 ; i<= M ; i++ ) {
			for(int j = 1; j<=N ; j++) {
				if(visited[i][j]) { //사다리가 이어져 있는 경우 : 가로-1이 max 좌표
					System.out.println("좌표 : "+i+", "+j);
					int from = j, to = j+1;
					int temp = result[from];
					result[from] = result[to];
					result[to] = temp;//swap
				}
			}
		}
		System.out.println("사다리타기 완료");
		System.out.println(Arrays.toString(result));
	}
	/**
	 * 사다리를 초기화
	 * ex : length ==3 ->{0,1,2,3}
	 */
	private static void initLadder() {
		result = new int[N+1];
		for(int i = 1 ; i<=N ; i++) {
			result[i] = i;
		}
		
	}
	private static void print() {
		for(int i = 1 ; i<=M ; i++) {
			for(int j =1 ;j<=N ; j++) {
				if(visited[i][j]) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println("______________________________");
	}

}
