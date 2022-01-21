package 백준_01212022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드_16236_아기상어 {

	static int N, map[][],copyArr[][];
	static boolean visited[][];
	static Shark babyShark;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		copyArr = new int [N][N];
		
		int x = 0; int y = 0;//초기 상어의 좌표
		
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N ;j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {babyShark = new Shark(i,j,0);}
			}
		}
		
		answer = 0;//잡은 물고기의 수
		sharkSize = 2;
		simulation();
//		System.out.println("상어 사이즈 : "+sharkSize);
	}
	
	static PriorityQueue<Shark> distance = new PriorityQueue<>(new Comparator<Shark>() {
		@Override
		public int compare(Shark o1, Shark o2) {
			//1.
			if(o1.distance!=o2.distance) return o1.distance - o2.distance;//최단거리
			else if (o1.y!= o2.y) return o1.y - o2.y;
			return o1.x - o2.x;
		}
	});
	/**
	 * 한칸 이동하는데  1초 걸림
	 * 물고기 1마리 이상이면 먹음
	 * 아니면 sos
	 */
	private static void simulation() {
		int time = 0;//초
		while(true) {
			int sec = swim();
			if(sec==0) {System.out.println("도와줘용");break;}//물고기가 한마리도 없는 경우			
			else {
				time +=sec;
			}
		}
		System.out.println(time+"초");
	}
	/**
	 * 상어부터 시작해서 bfs를 돌리는게 아니라 물고기가 상어에게 찾아오는걸로 bfs를 돌려서
	 * 모든 가능한 경우를 리스트에 담는다
	 * 최단거리 리턴
	 */
	private static int swim() {
		boolean sos = true;
		int min = Integer.MAX_VALUE;
		int nx = 0, ny = 0;
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j<N ;j ++) {
				if(map[i][j]==0)continue;
				else if (map[i][j]==9)continue;
				else{ //물고기 발견
					sos = false;
					System.out.println("물고기 발견 @ "+i+", "+j);
					int distance = bfs(i,j);
					if(min>distance) {
						min = distance;
						nx = i; ny = j;
					}
				}
			}
		}
		if(sos) { System.out.println("도와주세요.");return 0;}
		if(min!=0) {
			sharkSize++;
			map[babyShark.x][babyShark.y] = 0;
			map[nx][ny]=9;//상어 이동함. 상어 사이즈는 변수가 관리중
		}
		//while로 큐에있는애들 다 빼서 최소 거리 알아냄 -> 만약 최소거리가 0보다 크면 상어 사이즈 올리셈
		System.out.println("최단경로 : " +min +"at : "+nx+", "+ny+"물고기를 먹을경우");//일단 거리라도 맞으면 그 다음에 좌표 업뎃하쟈꾸낭..
		return  min;
	}
	static int sharkSize;
	private static int bfs(int i, int j) {
		visited = new boolean[N][N];
		distance.add(new Shark(i,j,0));//물고기의 좌표와 거리
		int min = 0;
		while(!distance.isEmpty()) {	//물고기가 상어찾으면 돌아옴-> 빌때까지 하는거자나..그치?
			Shark fish = distance.poll();
			for(int d = 0 ; d<4 ; d++) {
				int nx = fish.x + dx[d];
				int ny = fish.y + dy[d];
			//	System.out.println("왓니..? "+nx+","+ny);
				
				if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny])continue;
				
				
				if(map[nx][ny]==0 ) {//통로 -> <= 여야할까? 
					visited[nx][ny] = true;
					distance.add(new Shark(nx,ny,fish.distance+1));//한칸 더 간다...상어야 기다룡..ㅜ
				}
				else if (map[nx][ny] == 9) {//상어님..
					visited[nx][ny] = true;
					distance.add(new Shark(nx,ny,fish.distance+1));
					min = fish.distance+1;
					
				}
			}
	}
		return min;
	}	
	static int answer;

		
	
	static int [] dx = {-1,0,1,0};//상좌 하우priority  :dx[0]->dx[1]
	static int [] dy = {0,-1,0,1};


	public static class Shark{
		int x ;
		int y;
		int distance;
		Shark(int x, int y , int distance ){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		@Override
		public String toString() {
			return "최단 경로 : "+this.distance;
		}
	}
	public static void copyArr() {
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ;j ++) {
			copyArr[i][j] = map[i][j];
			}
		}
	}

	/** 물고기가 맵에 남아있는지 알려준다
	 * return 1 : 한마리만 남아있다 -> 과정을 끝내고 먹은 물고기 +1
	 * return 0 : 엄마에게 sos
	 * return 2 : 두마리 이상 남아있는 경우 -> start exploration
	 */
	private static int leftFish() {		
		int cnt = 0;
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ;j ++) {
				if(map[i][j]==9)continue;
				else if(map[i][j]!=0) {
					cnt++;
					if(cnt>2) return 2;//아직 안끝나
				}
			}
		}
		if(cnt==1)return 1;
		else return 0;
	}

}

