package 백준_01182022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드_16234_인구이동 {
static int N,L,R,map[][];
static boolean union[][];
static boolean stop;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		union = new boolean [N][N];
		

		
		for(int i =0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bw.write(solution()+"\n");
		bw.flush();
	}
	static int area;
	private static int solution() {
		int days = 0;
		area = 0;
		stop = false;
		while(!stop) {
			//1. 인구차이에 따라 국경 통합 지대 취합
			getUnions();//국경지대 뽑고 인구이동
			printMap();
			//2. 인구이동 시작
			resetArr(union);
			// if(stop)break; 국경선이 안열렸을 경우 break
			days++;
		}
		return days;
	}

	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	/**
	 * Step 1 
	 * 인구차이에 따른 국경 통합 지대 취합
	 * 색칠하기 같은 방식
	 * a,b에서 한붓그리기 가능한 구역 -> ab의 연합국
	 */
	public static void getUnions() {
		int  cnt = 0;
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				if(!union[i][j]) {//연합인지 체크 안해봄
					union[i][j]=true;
					cnt += bfs(i,j);
				}
			}
		}
		if(cnt==0) stop = true;
	}
	public static int bfs(int a, int  b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,b});
		boolean visited [][] = new boolean[N][N];
		visited[a][b] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
				for(int d = 0 ; d<4 ; d++) {
					int nx = node[0] + dx[d];
					int ny = node[1] + dy[d];
					if(nx<0||ny<0||nx>=N||ny>=N)continue;//범위 out
					if(visited[nx][ny])continue;
					int difference = Math.abs(map[node[0]][node[1]]- map[nx][ny]);
					if(difference>=L && difference<=R) {//국경선 열 수 있음
						q.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						union[nx][ny] = true;//연합국 체크했는지의 방문배열
					}
				}
		}
		
		printArr(visited);
		
		//현재 visited 배열에는 한개의 연합국지도가 찍혀있다 -> update map
		int count = 0; int sum = 0;
		for(int i= 0 ; i< N ; i++) {
			for(int j = 0 ; j<N ;j ++) {
				if(visited[i][j]) {
					count++;
					sum+=map[i][j];
					map[nx][ny] = area;
				}
			}
		}
		if(count==1)return 0 ;//a,b위치에서 연합국 존재하지 x
		else stop = false;
		int avg = sum/count;
		for(int i= 0 ; i< N ; i++) {
			for(int j = 0 ; j<N ;j ++) {
				if(visited[i][j]) {
					map[i][j] = avg ;
				}
			}
		}//: 지도를 업데이트 한다
		printMap();
		return count;
	}
	
	/**
	 * Reset Union : 연합 상태 해지
	 */
	public static void resetArr(boolean[][] union2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				union2[i][j]= false;
			}
		}
	}

	
	public static void printArr(boolean arr[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + "  ");
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
