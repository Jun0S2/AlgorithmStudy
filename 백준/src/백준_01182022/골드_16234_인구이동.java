package 백준_01182022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 골드_16234_인구이동 {
static int N,L,R,map[][];
static boolean union[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		union = new boolean[N][N];

		
		for(int i =0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bw.write(solution()+"\n");
		bw.flush();
	}

	private static int solution() {
		int days = 0;
		while(true) {
			//1. 인구차이에 따라 국경 통합 지대 취합
			unionCountries();
			System.out.println("국경 통합 지대 취합: ");
			printMap();
			printUnions();
			//2. 인구이동 시작
			int avg = averagePopulation();
			if(avg==0)break;//avg population이 0이란 소리는 인접한 국가가 하나도 없다는 소리(종료)
			
			imigrate(avg);

			System.out.println("인구이동 완료");
			printMap();
			printUnions();
			
			//if(!status())break;//if boolean map == all false -> the end..종료조건
			//3. 연합 해제 국경선 닫기
			resetUnion();
			System.out.println("초기화 및 현재 결론 : ");
			printMap();
			printUnions();
			days++;
		}
		return days;
	}
	/**
	 * Status Check
	 * 연합이 그 ㅇ ㅓ떤곳도 없으면 더이상 진행 멈춰도 된다.
	 */
	public static boolean status() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(union[i][j])return true;
			}
		}
		return false;
	}
	/**
	 * Step 2 
	 * 인구이동 시작
	 * 소숫점 버림 -> int형으로 계산
	 */
	public static void imigrate(int average) {
		for(int i = 0 ; i<N ;i++) {
			for(int j = 0 ; j<N ;j++) {
				if(union[i][j]) map[i][j] = average;
			}
		}
	}
	public static int averageResidents(int total, int cnt) {
		return total/cnt;
	}
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	/**
	 * Step 1 
	 * 인구차이에 따른 국경 통합 지대 취합
	 */
	public static void unionCountries() {
		int populations = 0;
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				if(union[i][j])continue;//이미 국경 오픈 지역
				for(int d = 0 ; d<4 ; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(nx<0||ny<0||nx>=N||ny>=N)continue;//범위 out
					
					int difference = Math.abs(map[i][j]- map[nx][ny]);
					if(difference>=L && difference<=R) {//국경선 열 수 있음
						union[i][j] = true;
						union[nx][ny] = true;
					}
				}
			}
		}
	}
	
	/**
	 * Reset Union : 연합 상태 해지
	 */
	public static void resetUnion() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				union[i][j]= false;
			}
		}
	}
	/**
	 * Utilities
	 * count true
	 */
	public static int countUnion() {
		int unions = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(union[i][j]) unions++;
			}
		}
		return unions;
	}
	public static int averagePopulation() {
		int pop = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(union[i][j]) {
					pop+=map[i][j];
					cnt++;
				}
			}
		}
		if(cnt==0)return 0;
		return pop/cnt;
	}
	
	public static void printUnions() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(union[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
