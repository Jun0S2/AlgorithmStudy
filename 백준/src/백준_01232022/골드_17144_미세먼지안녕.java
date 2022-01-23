package 백준_01232022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 골드 4
 * 삼성 SW 역량 테스트 기출문제
 * @author June Park
 * 풀이 시간 : 2시간 10분
 * Logic : 
 * 미세먼지 -> 큐에 저장 -> 맵 비우고 큐에 저장된 미세먼지를 뿌림 ->  
 * 분열된 미세먼지를 temp큐에 저장 -> temp큐를 빈 맵에 뿌림 -> temp큐에 
 * 공기청정기의 바람 방향에 이해 이동한 먼지들만 다시 저장 -> 맵에서 
 * 공기청정기루트 비움 -> temp에 있던 먼지들 다시 뿌림
 * => 반복
 *
 */
public class 골드_17144_미세먼지안녕 {
	static int map[][], R, C, T;
	static int puriU = 0, puriD = 0;
	static Queue<Dust> q = new LinkedList<>();
	static Queue<Dust> temp = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (puriU == 0)
						puriU = i;// row 저장
					else
						puriD = i;// 아래쪽 공기청정기
				}
			}
		}
		//System.out.println(puriU);
		//System.out.println(puriD);
		simulation();
	}

	private static void simulation() {
		while (T > 0) {
			//System.out.println("먼지를 큐에 넣는다");
			collectDust();// 큐에 현재 좌표의 먼지를 넣는다
			init();// 맵 초기화
		//	System.out.println("맵을 비운다");
		//	printMap();
		//	System.out.println("먼지 증가한걸 맵에 뿌린다");
			spreadDust();// 먼지가 확산된다
			putOnMap();// map에 먼지 뿌리기
		//	printMap();
		//	System.out.println("공기청정기 돌린다");
			purify();//공기청정기를 돌린 후에 이동한 먼지들을 큐에 담는다
			emptyPurifierPath();//길을 터준다
		//	printMap();
		//	System.out.println("일초 후 : ㄴ");
			putOnMap();//공기청정기로인해 순회된 애들만 다시 뿌려준다
		//	printMap();
			T--;
		}
		System.out.println(countDust());
	}

	static int dx[] = { -1, 1, 0, 0 };//상하좌우
	static int dy[] = { 0, 0, -1, 1, };
	/**
	 * 공기청정기가 작동하는 함수
	 * temp배열에 다시 이동한 위치를 넣어준다.
	 */
	private static void purify() {
		//row == 1인 경우 : 왼쪽으로 이동
		moveDown(1);
		moveDown(C);
		moveRight(puriU);
		moveRight(puriD);
		moveLeft(1);
		moveLeft(R);
		moveUp(1);
		moveUp(C);
	}
	/**
	 * 먼지가 아래로 이동하는 경우 : 
	 * col==1~ puriU , puriD ~ R
	 * -> 1과 puriD넣기
	 * @param col
	 */
	private static void moveDown(int col) {
		if(col==1) {
			for(int i =  1 ; i<puriD ; i++) {//puriD전에 있는 애는 어차피 disregarded
				if(map[i][col]!=0) {
					int nr = i + dx[1];//범위체크 안해도 됨
					temp.add(new Dust(nr,col,map[i][col]));
				}
			}
		}
		else if (col==C) {
			for(int i = puriD+1 ; i<R ; i++) {
				if(map[i][col]!=0) {
					int nr = i + dx[1];
					if(nr>=R+1) temp.add(new Dust(R,C-1,map[i][col]));
					else temp.add(new Dust(nr,col,map[i][col]));
				}
			}
		}
	}
	/**
	 * 먼지가 오른쪽으로 이동하는 경우 : 
	 * row ==  purifyU일때와 row==purifyD인경우
	 * @param row
	 */
	private static void moveRight(int row) {
		for(int i = 2;i<=C; i++) {
			if(map[row][i]!=0) {
				int nc = i + dy[3];
				if(nc>C) {
					if(row==puriU)temp.add(new Dust(row-1,C,map[row][i]));//위로 올라감
					else if (row==puriD)temp.add(new Dust(row+1,C,map[row][i]));//아래로 내려감
				}
				else temp.add(new Dust(row,nc,map[row][i]));
			}
		}
	}
	/**
	 * 먼지가 위로 이동하는 경우 : C==1이고 row가 R~D인 상황 과 C==C이고 row가 U~1인 상황
	 * @param col
	 */
	private static void moveUp(int col) {
		if(col==1) {			
			for(int i = R; i >puriD ; i--) {//아래쪽 순환 중 위로 올라감
				if(map[i][1]!=0) {
					int nr = i+dx[0]; 
					if(nr==puriD) continue;//공기청정기에 먹힘{ //위쪽 공기청정 -> 0대신 왼쪽으론 이동
					else temp.add(new Dust(nr,1,map[i][1]));
				}
			}
		}
		else if (col==C) {
			for(int i = puriU-1 ; i>=1; i--) {
				if(map[i][C]!=0) {
					int nr = i+dx[0]; 
					//if(nr<1) temp.add(new Dust(1,C-1,map[i][C]));//왼쪽으로 넘어감			
					temp.add(new Dust(nr,C,map[i][C]));
				}
			}
		}
	}
	/**
	 * 먼지가 왼쪽으로 이동하는 경우 : row ==1 과 row ==R인 경우
	 * @param row
	 */
	private static void moveLeft(int row) {
		for(int i = C ; i>1 ; i--) {//맨 윗줄과 맨 아랫줄
			if(map[row][i]!=0) {
				int nc = i + dy[2];
		//		System.out.println("원래 콜륨 : "+i+"왼쪽으로 한칸 : "+nc);
				temp.add(new Dust(row,nc,map[row][i]));
			}
		}
	}
	/**
	 * spreadDust()에서 증가한 먼지를  맵에 뿌려주는 함수
	 */
	private static void putOnMap() {
		while(!temp.isEmpty()) {
			Dust t = temp.poll();
			if(t.x==puriU && t.y == 1)continue;//공기청정기자리
			if(t.x==puriD && t.y == 1)continue;		
			if(map[t.x][t.y]>0) map[t.x][t.y] +=t.amount;
			else map[t.x][t.y]=t.amount;
		}
	}

	/**
	 * 먼지를 확산하는 함수 
	 * 1. 사방향에 확산 
	 * 2. 인접칸이 공기청정기(-1)이나 범위 out이면 확산 x else cnt함 
	 * 3. 확산 양 :map[i][j]/5 
	 * 4. 원본 위치에 남은 미세먼지의 양 : map[i][j] - map[i][j]/5*cnt
	 */
	private static void spreadDust() {
		while (!q.isEmpty()) {
			Dust dust = q.poll();
			int cnt = 0;
			int newAmount = 0;
			for (int d = 0; d < 4; d++) {
				int nx = dust.x + dx[d];
				int ny = dust.y+ dy[d];
				// 범위 out
				if (nx < 1 || ny < 1 || nx >= R + 1 || ny >= C + 1)continue;
				else if (map[nx][ny] == -1)continue;
				cnt++;
				newAmount = dust.amount/5;
				temp.add(new Dust(nx, ny, newAmount));
			}
			// 원본 먼지 다시 넣기
			int origin = dust.amount - dust.amount/5*cnt;
			temp.add(new Dust(dust.x, dust.y, origin));
		}
	}

	public static void init() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = 0;
			}
		}
		map[puriU][1]=-1;
		map[puriD][1]=-1;
	}
	/**
	 * 공기청정기가 작동할 칸들은 비워준다
	 */
	public static void emptyPurifierPath() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(i==1||j==1||i==R||j==C||i==puriU||i==puriD)map[i][j] = 0;
			}
		}
		map[puriU][1]=-1;
		map[puriD][1]=-1;
	}
	public static void printMap() {	
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

	/**
	 * 맵 위의 먼지를 큐에 넣는 함수
	 */
	public static void collectDust() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] >0 ) q.add(new Dust(i, j, map[i][j]));
			}
		}
	}

	public static int countDust() {
		int cnt = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j]>0)cnt+=map[i][j];
			}
		}
		return cnt;
	}
	public static class Dust {
		int x, y, amount;

		Dust(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}

}
