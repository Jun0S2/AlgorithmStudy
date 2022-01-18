package 백준_01172022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 골드 5
 * @author June Park
 * Simulation, 팔방탐색
 * 3hr 20 min
 */
public class 골드_21610_상어와비바라기 {
static int N, map[][];
static boolean cloud[][],copy[][];//구름
static Queue <Magic> q;//마법 주문을 저장할 큐
	public static class Magic {
		int dir;
		int moveAmount ;
		public Magic(int dir, int moveAmount) {
			this.dir = dir;
			this.moveAmount = moveAmount;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		cloud = new boolean[N+1][N+1];
		copy = new boolean[N+1][N+1];
		q = new LinkedList<>();
		
		for(int i = 1 ; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<=N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		for(int i = 0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			q.add(new Magic(d,m));
		}
		
		//cloud 배열 초기화
		cloud[N][1] = true;
		cloud[N][2] = true;
		cloud[N-1][1] = true;
		cloud[N-1][2] = true;

		simulation(M);
		bw.write(countRain()+"\n");
		bw.flush();
		bw.close();
		
	}
	/*					0,좌,좌위,위,우위,우,우하,하,좌하*/
	static int [] dx = {0, 0,-1,-1, -1, 0, 1,1, 1};
	static int [] dy = {0,-1,-1, 0,  1, 1, 1,0,-1};
	
	public static void simulation(int M ) {
		while(M>0) {
		//1. 구름이동
			cloudMigration();
		//2. 구름 있는 칸 비 +1
			rainOnCloud();
		//3. 물복사 마법
			rainDiag();
		//4. resetCloud() : 원래는 2에서 해야하지만 3에서 2범위의 애들만 물복사해야해서 후에 리셋
		//5. 구름생성 where 빗물>=2
			getCloud();
			M--;
		}
	}

	/**
	 * STEP 5
	 * map을 iterate하여 물의 양이 2 이상인 칸에 구름이 생긴다
	 * Cloud 배열을  세팅하고 구름이 생긴 맵의 장소는 -2 처리해준다
	 */
	public static void getCloud() {
		//구름 있는 칸에 비를 하나씩 더해준다
		copyArr();
		resetCloud();

		for(int i = 1 ; i<=N ; i++) {
			for(int j =1 ; j<=N ; j++) {
				if(copy[i][j])continue;//3에서 사라진 cloud는 못생긴다
				if(map[i][j]>=2) {
					map[i][j]-=2;
					cloud[i][j] = true;
				}
			}
		}
		
	}
	public static void rainDiag() {
		//대각선에  비가 2이상인 넘들
		for(int i = 1 ; i<=N ; i++) {
			for(int j =1 ; j<=N ; j++) {
				if(cloud[i][j]) {
					map[i][j]+=countDiag(i,j);
				}
			}
		}		
	}
	/**
	 * STEP 2 & 3
	 * 구름있는 칸 비++
	 */
	public static void rainOnCloud() {
		//구름 있는 칸에 비를 하나씩 더해준다
		for(int i = 1 ; i<=N ; i++) {
			for(int j =1 ; j<=N ; j++) {
				if(cloud[i][j]) {
					map[i][j]++;
				}
			}
		}
	}
	/**
	 * 대각선 방향에 비의 양이 2 이상인 칸이 몇개인지 리턴하는 함수
	 */
	public static int countDiag(int x, int y) {
		int cnt = 0 ;
		int [] zx = {-1, -1, 1, 1};
		int [] zy = {-1,  1, 1,-1};
		//왼쪽 위
		for(int d = 0 ; d<4 ; d++) {
			int nx = x, ny = y;
			nx = x + zx[d];
			ny = y + zy[d];
			if(nx<1 || nx>=N+1||ny<1 ||ny>=N+1 )continue;
			else if(map[nx][ny]>0) {cnt++;}
		}
		return cnt;
	}
	
	/**
	 * STEP 1
	 * 구름이 이동
	 */
	public static void cloudMigration() {
		Magic magic = q.poll();
		int direction = magic.dir; //구름이 이동할 방향
		int moveCnt = magic.moveAmount; //구름이 얼만큼 이동할것인지
		//System.out.println("direction : "+direction+"방향으로 "+moveCnt+"이동");
		copyArr();//copy에 원본 cloud를 놓고 cloud에는 새 구름을 준다
		resetCloud();

		//각칸마다 이동한다
		for(int i = 1 ;i<=N ;i++) {
			for(int j =1; j<=N ; j++) {
				if(copy[i][j]==true) {//구름이 있다면
					moveCloud(direction,moveCnt, i,j);//클라우드 열씸히 쌓음
				}
			}
		}
		setCloud();
	}
	/**
	 * 스택에 받은 구름을 맵에 뿌리면서 비운다
	 */
	public static void setCloud() {
		while(!history.isEmpty()) {
			Position c = history.pop();
			cloud[c.x][c.y]= true;
		}
	}
	public static class Position{
		int x, y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	/**
	 * 구름 이동
	 * @param direction
	 * @param moveCnt
	 * @param x , y : 현재 좌표
	 * 중복 처리를 어떻게 할까..
	 */
	static Stack<Position> history  = new Stack<>();//=index, x,y
	//움직이려는 방향으로 한칸 moveCnt 만큼 이동한다
	public static void moveCloud(int direction , int moveCnt, int  x, int y ){
		history.add(new Position(x,y));
		//중복처리때문에 자료구조가 필요할 것 같다..
			for(int i = 0 ; i<moveCnt ; i++) {
				Position po = history.pop();
				int nx = po.x;
				int ny = po.y;
				
				nx = nx + dx[direction];
				ny = ny + dy[direction];
				
				if(!validBoundary(nx)) nx=rollOver(nx);//바운데리 넘는 경우
				if(!validBoundary(ny)) ny=rollOver(ny);
				
				history.add(new Position(nx,ny));
		}//큐에는 클라우드의 개수만큼만 쌓이게 되겟징..
	}
	/**
	 * 1번과 N번행을 연결
	 * @param nx
	 * @param ny
	 * @return false 일 경우에는 if nx==0->nx=N, nx==N -> nx=1로 세팅한다
	 * row와 col 둘 다 적용되는 메서드
	 */
	public static boolean validBoundary(int nx) {
		if(nx<1||nx>=N+1) return false;
		return true;
	}
	public static int rollOver(int nx) {
		if(nx==0)return N;
		else return 1;
	}
/**
 * Utilities
 * copy array
 * reset array
 */
	public static void copyArr(){
		for(int i = 1 ; i<=N ;i++) {
			for(int j = 1 ; j<=N ;j++) {
				copy[i][j] = cloud[i][j];
			}			
		}
	}
	public static void resetCloud(){
		for(int i = 1 ; i<=N ;i++) {
			for(int j = 1 ; j<=N ;j++) {
				cloud[i][j]=false;
			}			
		}
	}
	public static void print(boolean[][] arr) {
		for(int i = 1 ; i<=N ; i++) {
			for(int j = 1 ; j<=N ; j++) {
				System.out.print(arr[i][j]);
			}			
			System.out.println();
		}
	}
	public static void printMap() {
		//대각선에  비가 2이상인 넘들
		for(int i = 1 ; i<=N ; i++) {
			for(int j =1 ; j<=N ; j++) {
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static int countRain() {
		int sum = 0;
		for(int i = 1 ; i<=N ; i++) {
			for(int j =1 ; j<=N ; j++) {
				sum +=map[i][j];
			}
		}
		return sum;
		
	}
}
