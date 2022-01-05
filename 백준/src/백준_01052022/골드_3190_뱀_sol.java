package 백준_01052022;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 삼성 기출문제 골드 5
 * 
 * @author June
 *
 */
public class 골드_3190_뱀_sol {
	static int[][] map; // 0: 빈칸, 1:사과 2: 뱀
	static int N, K, L;
	static int[][] direction; //방향
	static LinkedList<int[]> snake ; //int[size=2]에 x,y 좌표 저장
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 맵의 크기
		K = Integer.parseInt(br.readLine()); // 사과의 수
		initMap(); // 맵 초기화

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		L = Integer.parseInt(br.readLine());
		direction = new int[L][2];
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			direction[l][0] = t;
			direction[l][1] = c=='L'?-1:1;
		}
		/*----------------------------------------------------------*/
		snake = new LinkedList<>();
		snake.add(new int[] {1,1});
		playtime = 0;
		simulation();
		System.out.println(playtime);
	}

	static int playtime;
	static int x,y;// 뱀의 머리 위치
	static int curr_direction;
	
	public static void simulation() {
		int turn = 0;
		
		while(true) {
			playtime++;
			int nx = x + dx[curr_direction];
			int ny = y + dy[curr_direction];
			
			if(GameOver(nx,ny))break;
			//사과를 먹으면 꼬리 위치는 그대로지만 먹지 못한경우에는 꼬리 이동
			if(map[nx][ny]==0) snake.remove(0); 
			if(map[nx][ny]==1) map[nx][ny]=0;//사과 먹으면 없애야함(실패요인이엿음)
			
			snake.add(new int[] {nx,ny});	   //새 머리
			
			x = nx;//머리 위치 변경
			y = ny;
			
			if(turn<L) {		
				if(playtime==direction[turn][0]) { //시간에 도달할 경우 방향 전환
					Turn(direction[turn][1]);
					turn++;
				}
			}
			
		}
	}
	private static boolean GameOver(int nx, int ny) {
		if(nx<1||nx>=N+1||ny<1||ny>=N+1) return true;
		for(int i = 0 ; i<snake.size() ;i++) { //몸통박치기
			int[] s = snake.get(i);
			if(s[0]==nx && s[1]==ny)return true;
		}
		return false;
	}
//상하좌우0123
	private static void Turn(int dir) {
		switch (dir) {
		case -1://L
			if (curr_direction == 3) curr_direction = 0;//우-> 상
			else if (curr_direction == 0) curr_direction = 2;// 상 -> 좌
			else if (curr_direction == 1)curr_direction = 3; // 하 -> 우
			else if (curr_direction == 2) curr_direction = 1;			
			break;
		case 1://D
			if (curr_direction == 3) curr_direction = 1; // 우 -> 하
			else if (curr_direction == 0) curr_direction = 3; // 상 ->우
			else if (curr_direction == 1) curr_direction = 2; // 하 -> 좌
			else if (curr_direction == 2) curr_direction = 0; // 좌 ->상
			break;
		}
	}

	public static int[] dx = { -1, 1, 0, 0 };// 상하좌우
	public static int[] dy = { 0, 0, -1, 1 };// 0123

	/** Utilities */
	public static void initMap() {
		map = new int[N + 1][N + 1];
		curr_direction = 3;//오른쪽 향함
		x=1;//x좌표
		y=1;//y좌표
	}



}
