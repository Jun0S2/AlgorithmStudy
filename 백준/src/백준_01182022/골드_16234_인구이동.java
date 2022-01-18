package 백준_01182022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드_16234_인구이동 {
static int N,L,R,map[][];
static boolean visited[][];
static Queue<int[]> q; 
static List<int[]> unions;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean [N][N];
		q = new LinkedList<>();
		unions = new LinkedList<>();

		
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
		boolean moveNext = false;
		
		while(true) {
			resetVisit();//방문배열 리샛
			moveNext = false;
			for(int i = 0 ; i <N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					if(visited[i][j])continue;//이미 방문함
					if(bfs(i,j)) moveNext = true;//연합국 존재 여부
				}
			}
			if(moveNext) days++;//연합국 존재
			else return days;
		}
	}

	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};


	public static boolean bfs(int a, int  b) {
		//초기화
		q.clear();
		unions.clear();
		
		q.add(new int[] {a,b});
		unions.add(new int[] {a,b});
		visited[a][b] = true;
		
		int sum = map[a][b]; //평균을  구하기 위해 합
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
				for(int d = 0 ; d<4 ; d++) {
					int nx = node[0] + dx[d];
					int ny = node[1] + dy[d];

					if(nx<0||ny<0||nx>=N||ny>=N)continue;//범위 out
					if(visited[nx][ny])continue;
					
					int difference = Math.abs(map[node[0]][node[1]]- map[nx][ny]);
					if(difference<L || difference>R)continue;
					//Else : 국경선 열 수 있음
						sum += map[nx][ny]; //합
						q.add(new int[] {nx,ny});
						unions.add(new int[] {nx,ny});//연결된 국가를 연합국리스트에 올린다
						visited[nx][ny] = true;
				}
		}
		
		if(unions.size()==1) return false;//연합국이 없다
		int average = sum / unions.size();//평균
		for(int i = 0 ; i<unions.size(); i++ ) {
			int[] temp = unions.get(i);//연합군의 좌표를 담은 배
			map[temp[0]][temp[1]] = average;
		}
		
		return true;
	}
	
	/**
	 * Reset Union : 연합 상태 해지
	 */
	public static void resetVisit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j]= false;
			}
		}
	}

	/**
	 * Utilities
	 * @param arr
	 */
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
