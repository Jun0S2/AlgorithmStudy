package 백준_01142022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 * @author User
 *
 */
public class 골드_14503_로봇청소기 {
static int N, M , map[][];
static int r,c,d;
static boolean visited[][];
	public static void main(String[] args) throws  Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());//로봇의 처음 r 위치 
		c = Integer.parseInt(st.nextToken());//로봇의 처음 c 위치
		d = Integer.parseInt(st.nextToken()); //로봇의 direction 방향
		
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt++;
		visited[r][c] = true;
		bfs();
		System.out.println(cnt);

	}
	public static class Robot{
		int x,y,direction;
		Robot(int x, int y, int direction){
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
	static int[] dx = {-1,0,1,0};//d :상우하좌  0123 북동남서
	static int[] dy = {0,1,0,-1};
	
	static int cnt;
	
	private static void bfs() {
		Queue<Robot> q = new LinkedList<>();
		q.offer(new Robot(r,c,d));
		
		while(!q.isEmpty()) {
			Robot robo = q.poll();
			int x = robo.x; 
			int y = robo.y ; 
			int dir = robo.direction;
			
			int nextDir = dir;//다음 방향
			boolean flag = false;//stuck == 4
			
			for(int i = 0 ; i<4 ; i++) {
				
				nextDir = turnLeft(nextDir);//왼쪽으로 회전
				int nx = x + dx[nextDir];
				int ny = y + dy[nextDir];
				
				if(nx<0||ny<0||nx>=N||ny>=M)continue;//범위 out
				if(visited[nx][ny])continue; //이미 방문했으면 넘김
				
				if(map[nx][ny]==0) {//빈칸
					q.add(new Robot(nx,ny,nextDir));
					visited[nx][ny] = true;
					cnt ++;
					flag = true;//즉 네번 다 이동 가능하면 flag==true
					break;//이동하면  후진하므로 중지
				}
				
			}//end of for
			
			if(!flag) {//네번 다 이동 못하는 경우
				nextDir = goBack(dir);//원래 보던 방향에서 -1 : 후진 -> 원래 방향에서 후진해야하므로 dir
				int nx = x + dx[nextDir];
				int ny = y + dy[nextDir];
				if(nx<0||ny<0||nx>=N||ny>=M)return;//범위 out->오도가도 못함
				if(map[nx][ny]==0) {
					q.offer(new Robot(nx,ny,dir));//후진하는 경우는 방향을 유지한 채로 이동..이것때매..
				}
				//else stops
			}
		}

		
	}
	/*Utilities*/

	/**
	 * 왼쪽으로 방향 회전
	 * @return
	 *  상 -> 좌
	 *  좌 -> 하
	 *  하 -> 우
	 *  우 -> 상
	 */
	public static int turnLeft(int dir) {
		switch (dir) {
		case 0:
			return 3;
		case 1:
			return 0;
		case 2:
			return 1;
		case 3: 
			return 2;
		}return 0;
	}
	
	/**
	 * 후진
	 * @param nextDir
	 * @return 후진방향
	 * 상 -> 하
	 * 하 -> 상
	 * 좌 -> 우
	 * 우 -> 좌
	 */
	public static int goBack(int nextDir) {
		switch (nextDir) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3: return 1;
		}return 0;
	}
	


}
