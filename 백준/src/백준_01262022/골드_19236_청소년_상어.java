package 백준_01262022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드_19236_청소년_상어 {
static int MAX = -1;
static int map[][];//물고기를 뿌릴 맵
static Shark shark;
static class Fish{
	int num, direction;
	int x, y;
	int updated;
	Fish(int num, int direction, int x, int y,int updated){
		this.num = num;
		this.direction = direction;
		this.x = x;
		this.y = y;
		this.updated= updated;
	}
}
static class Shark{
	int x,y,direction;
	Shark(int x, int y, int direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}
static PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
	@Override
	public int compare(Fish o1, Fish o2) {
		if(o1.num==o2.num) {//swap한 흔적이 있는 분들..
			return o2.updated - o1.updated;//업데이트 최신순
		}
		return o1.num - o2.num;//번호가 낮은 순으로 정렬
	}});
static LinkedList<Fish> temp = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[4][4];
		
		for(int i = 0 ; i<4 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<4 ;j ++) {
				int no = Integer.parseInt(st.nextToken());//물고기 번호
				int direction = Integer.parseInt(st.nextToken());//물고기 방향
				//상어의 초기 방향
				if(i==0 && j==0) shark = new Shark(i,j, direction);//상어
				else {
					map[i][j] = no;//map에는 번호를 뿌려준다 , 0은 먹힘 표시
					pq.add(new Fish(no,direction,i,j,0));//물고기 큐 업데이트
				}
			}
		}
		simulation();
	}
	
	private static void simulation() {
		//이동할 수 있는 칸이 없을 때 멈춤
		// 물고기 이동
		// map 초기화
		// map 에 뿌리기
		// 상어 이동 ->여기서 break인지 아닌지 확인될거같은데..
		// map에서 물고기 배열 업데이트
	}
	/**
	 * 상어가 먹을 수 있는 물고기 번호의 최대를 체크한다
	 */
	static boolean stop = false;
	public static void MaxCheck() {
		boolean stuck = true;//현재 위치에서 꼼짝 못하는 경우 집에가야..
		//갈 수 있는 칸은 최대 3개임..
		for(int i = 0 ; i<3 ; i++) {
			int nx = shark.x + dx[shark.direction];
			int ny = shark.y + dx[shark.direction];
			if(nx<0||ny<0||nx>=4||ny>=4)break;
		}
		if(stuck) stop = true;
	}
	/**
	 * temp에 있는 물고기를 전부 맵에 방출ㄴ
	 */
	public static void release() {
		initMap();
		for(int i = 0 ; i<temp.size() ;i ++) {
			Fish info = temp.get(i);
			map[info.x][info.y] = info.num;
		}
	}
	
	/**
	 * 맵과 pq를 동시 관리..과연 효율적인걸까..
	 * 물고기 이동 : 해당 방향으로 이동할 수 있으면 한칸 이동 
	 * 			  이동 할 수 있는 경우 : 빈칸 / 물고기가 있는 경우-swap position
	 * 			 swap 할 경우에는 swap당한 물고기는 temp에 넣지 않는다.
	 * 			 근데 어차피 swap 당한 물고기가 좌표에 찍혀있다면,아 맞다...temp는 큐가 아니라 리스트임..
	 * 			 따라서 리스트 한번 훑고 if curr_ num보다 가려는 위치의 num이 작으면 리스트에서 get하면 되지 않ㅇ르까.. 
	 */
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,-1,-1,-1,0,1,1,1};
	public static void fishSwim() {
		int cnt = 0;
		while(!pq.isEmpty()) {
			Fish fish = pq.poll();
			int fish_dir = fish.direction;//옮겨진 물고기들의 방향은 변하지 않았다
			if(fish_dir<0) {//옮겨진 적이 있다 ->dir 이 음수가 아닐때까지 팦하고 온다
				fish_dir = findPrev(fish.num);//이렇게 하면, 방향받고, 계속 이동하던 물고기정보는 앞쪽에 생겨서 유지됨
			}
			
			boolean flag = true;//이동불가능 하면 true
			for(int i = fish.direction ; i<fish.direction+8 ; i++) {
				int nx = fish.x + dx[(i)%8];
				int ny = fish.y + dy[i%8];
				int nd = i%8;
				if(nx<0||ny<0||nx>=4||ny>=4||(nx==shark.x&&ny==shark.y))continue;
				else {
					if(map[nx][ny]!=0) { //이미 지도에 물고기가 있는 경우 그 물고기의 번호가 현재 물고기보다 큰지 판단
						int no = map[nx][ny];
						if(no<fish.num) {//swap 이미 temp 배열에 들어온 애들
							swapList(nx,ny,fish.x,fish.y);
						}
						else {
							cnt++;
							int n = map[nx][ny];
							map[nx][ny] = fish.num;
							temp.add(new Fish(fish.num, nd, nx, ny,0));
							map[fish.x][fish.y] = n;//기존 물고기
							pq.add(new Fish(n,-1,nx,ny,cnt));//direction에 -1을 넣는다 -> 방향이 -1이면 updated가 큰순으로 리턴해서 좌표만 정할거고
						}
					}
					else temp.add(new Fish(fish.num, nd, nx, ny,0));//빈칸일 경우
				}
				flag = false;//이동했다는 표시
			}
			if(flag)temp.add(new Fish(fish.num, fish.direction, fish.x, fish.y,0));//이동 못함
		}
	}
	/**
	 * 가장 기존의 물고기를 찾는다 -> 방향때문에...
	 */
	private static int findPrev(int num) {
		int dir = -1;
		while(dir<0) {
			Fish p = pq.poll();
			dir = p.direction;
			if(dir>=0)break;
		}
		return dir;
	}

	/**
	 * 
	 * @param x,y- temp의 위치
	 * @param nx,ny- temp의 새위치
	 */
	public static void swapList(int x, int y, int nx, int ny) {
		for(int i = 0 ;i<temp.size() ; i++) {
			Fish t = temp.get(i);
			if(t.x == x && t.y ==y) {
				temp.set(i, new Fish(t.num, t.direction, nx, ny,0));
				break;
			}
		}
	}
	
	public static void initMap() {
		for(int i = 0 ; i<4 ; i++) {
			for(int j = 0 ; j<4 ;j ++) {
				map[i][j] = 0;
			}
		}
		
	}
}
