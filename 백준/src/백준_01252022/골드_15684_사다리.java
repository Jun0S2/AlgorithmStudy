package 백준_01252022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 01/25/2022
 * 골드 4
 * 삼성 SW 역량 기출 문제
 * @author June Park
 * 
 * 처음부터 끝까지 문제를 잘 못 이해해서 어려움을  겪은 것 외에는 로직은 전부 맞았다
 * 1. 3회 이상도-> -1 따라서 3이 max 임을 자세히 읽지 않았다
 * 2. visited[][]의 범위 오류 : NxM 배열인줄 알았지만, 세로선 N개가 주어진 다는 뜻이였고 
 * 	    실제 배열은 H+1xM 배열이었다.
 * 백 트래킹 i범위는 돼지개발자님의 블로그를 참고하였다
 * 아직 백 트래킹이 약간씩 헷갈린다.
 *
 */
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
		
		visited = new boolean[H+2][N+1];

		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			visited[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		for(int i = 0 ; i<=3 ; i++) { //i " 사다리 개수
			min = i;
			solution(1,1,0);
			if(flag)break;//찾음
		}
		System.out.println(flag?min:-1);
	}
	static int min;
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
				flag = true;
			}
			return;
		}
		for(int i = (py<N ? px:px+1); i<=H; i++) {
			for(int j =1 ;j<N ;j ++) {
				if(visited[i][j])continue;//이미 방문함
				if(visited[i][j-1]||visited[i][j+1])continue;//양쪽에 이미 사다리가 있다면 불가*(연속불가조건)
				//이제 방문 가능!
				visited[i][j] = true;
				solution(i,j,moveCnt+1);
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
//		print();
		for(int i = 1 ; i<= H+1 ; i++ ) {
			for(int j = 1; j<=N ; j++) {
				if(visited[i][j]) { //사다리가 이어져 있는 경우 : 가로-1이 max 좌표
//					System.out.println("좌표 : "+i+", "+j);
					int from = j, to = j+1;
					int temp = result[from];
					result[from] = result[to];
					result[to] = temp;//swap
				}
			}
		}
	//	System.out.println("사다리타기 완료");
	//	System.out.println(Arrays.toString(result));
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
	/*private static void print() {
		for(int i = 1 ; i<=H+1; i++) {
			for(int j =1 ;j<=N ; j++) {
				if(visited[i][j]) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println("______________________________");
	}*/

}
