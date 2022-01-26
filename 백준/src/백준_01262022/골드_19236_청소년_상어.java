package 백준_01262022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드_19236_청소년_상어 {
static int MAX = 0;
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
		
		
		System.out.println("초기 상어 정보 : 방향 - "+shark.direction);
		simulation();
		System.out.println(MAX);
	}
	
	private static void simulation() {
		//이동할 수 있는 칸이 없을 때 멈춤
		while(!stop) {
			fishSwim();// 물고기 이동
			System.out.println("물고기 이동 끗~~");
			System.out.println(pq.isEmpty());
			System.out.println("-------------------------------------------------------------------------");
			//System.out.println("물고기 리스트");
			//printList();
			System.out.println("-------------------------------------------------------------------------");
			
			int no = maxCheck();	// 상어 이동 ->여기서 break인지 아닌지 확인//미친..여기서 dfs를 해야해..
			updateFishInfo(no);	// map에서 물고기 배열 업데이트
			updateMap();//새 맵과 pq 업뎃
			//stop = true;
		}
		
	}
	
	/**
	 * 지도 및 pq 업데이트
	 */
	public static void updateMap() {
		initMap();
		while(!temp.isEmpty()) {
			Fish t = temp.poll();
			map[t.x][t.y] = t.num;
			pq.add(new Fish(t.num, t.direction , t.x , t.y , 0));
		}
		System.out.println("다시 시작하기 전 점검 : "+pq.size()+"마리 남음"+temp.size()+"탬프비움");
	}
	/**
	 * 먹힌 물고기와 상어의 새 방향을 지정
	 * @param no : 먹힌 번호
	 */
	public static void updateFishInfo(int no) {
		for(int i = 0 ; i<temp.size() ;i ++) {
			if(temp.get(i).num==no) {
				System.out.println(no+"가 먹혔다고 들었습니당...");
				Fish eaten = temp.remove(i);
				shark = new Shark(eaten.x, eaten.y, eaten.direction);
				System.out.println("상어의 새 위치: "+eaten.x +", " +eaten.y +"새 방향 : "+eaten.direction);
				break;
			}
		}
	}
	/**
	 * 상어가 먹을 수 있는 물고기 번호의 최대를 체크한다
	 */
	static boolean stop = false;
	public static int maxCheck() {
		boolean stuck = true;//현재 위치에서 꼼짝 못하는 경우 집에가야..
		int maxNo = -1;
		//갈 수 있는 칸은 최대 3개임..
		int nx = shark.x + dx[shark.direction];
		int ny = shark.y + dx[shark.direction];
		for(int i = 0 ; i<3 ; i++) {
			nx = nx+ dx[shark.direction];
			ny = ny + dx[shark.direction];
			if(nx<0||ny<0||nx>=4||ny>=4)break;
			stuck = false;//이동 가능
			System.out.println(map[nx][ny]);
			maxNo = maxNo < map[nx][ny] ? map[nx][ny]:maxNo;//갱신
		}
		if(stuck) stop = true;
		System.out.println("뀨?"+maxNo);
		MAX+=maxNo;//먹은 물고기 넘버 업뎃
		return maxNo;
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
	static int dx[] = {0,-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,0,-1,-1,-1,0,1,1,1};
	public static void fishSwim() {
		int cnt = 0;
		while(!pq.isEmpty()) {
			Fish fish = pq.poll();
			int fish_dir = fish.direction;//옮겨진 물고기들의 방향은 변하지 않았다
			if(fish_dir<0) {//옮겨진 적이 있다 ->dir 이 음수가 아닐때까지 팦하고 온다
				System.out.println("옹ㅇㅇ");
				System.out.println("가장 마지막..에 업됫된 좌표 : "+ fish.x +", "+fish.y);
				fish_dir = findPrev(fish.num);//이렇게 하면, 방향받고, 계속 이동하던 물고기정보는 앞쪽에 생겨서 유지됨
				System.out.println(fish_dir);
			}
			//System.out.println("다음 물고기 넘버 : "+pq.peek().num);
			System.out.println("현재 물고기의 번호  :"+fish.num + " 좌표 : "+fish.x+", "+fish.y+" 방향 : "+fish_dir);
			
			boolean flag = true;//이동불가능 하면 true
			
			int nd = fish_dir;
			int nx = fish.x + dx[nd];
			int ny = fish.y + dy[nd];
			System.out.println("처음 방향으로 이동하면 : "+nx+", "+ny+"이다");
		
			for(int i = 0 ; i<8 ; i++) {
				System.out.println("원래 좌표 : "+fish.x+","+fish.y+"방향 : "+nd);
				if(nx<0||ny<0||nx>=4||ny>=4||(nx==shark.x&&ny==shark.y)) { //이동불가
					if(nx==shark.x && ny==shark.y)System.out.println( "아기 상어 뚜루뚜루뚜");
					System.out.println("이동불가 삐삐삐삐삐삐삐삐");
					nd++;
					if(nd==9)nd=1;
					nx = fish.x + dx[nd];//새 좌표
					ny = fish.y + dy[nd];
					System.out.println("새방향  :"+nd+"예상 좌표 : "+nx+", "+ny);
					continue; 
				}
				else {
					flag = false;
					if(map[nx][ny]!=0) { //이미 지도에 물고기가 있는 경우 그 물고기의 번호가 현재 물고기보다 큰지 판단
						//맵 업데이트
						int no = map[nx][ny];				
						map[nx][ny] = fish.num;
						map[fish.x][fish.y] = no;//기존 물고기
						System.out.println(no+"번 물고기가 이미 있당");
						if(no<fish.num) {//swap 이미 temp 배열에 들어온 애들
							System.out.println("이미 이사하셧엇는데..");
							swapList(nx,ny,fish.x,fish.y);
							temp.add(new Fish(fish.num, nd, nx, ny,0));
							
						}
						else {
							System.out.println("바꾸려는 물고기는 계속 로그가 남아야한다");
							cnt++;
							temp.add(new Fish(fish.num, nd, nx, ny,0));
							System.out.println(fish.num+"물고기는 잘 들어갓다~");
							
							System.out.println(no+"번 물고기님은 다시 큐에 넣어드립니당"+fish.x + " , "+fish.y +" " +cnt);
							pq.add(new Fish(no,-1,fish.x,fish.y,cnt));//direction에 -1을 넣는다 -> 방향이 -1이면 updated가 큰순으로 리턴해서 좌표만 정할거고
							
						}
					}
					else {//0일떄
						map[nx][ny]=fish.num;
						map[fish.x][fish.y] = 0;
						temp.add(new Fish(fish.num, nd, nx, ny,0));//빈칸일 경우
					}
					
					 break;
				}//end of else

			}//end of for loop
			if(flag)temp.add(new Fish(fish.num, fish_dir, fish.x, fish.y,0));//이동 못함
			printMap();
		}
	}
	/**
	 * 가장 기존의 물고기를 찾는다 -> 방향때문에...
	 */
	private static int findPrev(int num) {
		int dir = -1;
		System.out.println("이전 기록...");
		while(dir<0) {
			if(pq.peek().num==num) {				
			Fish p = pq.poll();
			dir = p.direction;
			System.out.println(p.x+", "+p.y);
			if(dir>=0)break;
			}else break;
		}
		 System.out.println("thje end..");
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
	public static void printList() {
		for(int i = 0 ; i<temp.size() ; i++) {
			Fish t = temp.get(i);
			System.out.println(t.num+" 번 물고기의 위치 - "+t.x+","+t.y+" 방향 - "+t.direction);
		}
	}
	public static void printMap() {
		for(int i = 0 ; i<4 ; i++) {
			for(int j = 0 ; j<4 ;j ++) {
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("+====================================+");
		
	}
}
