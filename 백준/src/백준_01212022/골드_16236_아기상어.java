package 백준_01212022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드_16236_아기상어 {

	static int N, map[][],copyArr[][];
	static boolean visited[][];
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
				if(map[i][j] == 9) {x = i; y = j;}
			}
		}
		
		answer = 0;//잡은 물고기의 수
		simulation(x,y,2);
		System.out.println(answer);
		
	}
	static int answer;
	private static void simulation(int x, int y ,int size) {
		int done = 5;
		int cnt = 0;
		while(cnt < 10) {
			done = leftFish();
			if(done == 0 )return;
			else if (done ==1) {answer++; return;}
			else {//물고기가 두마리 이상 남아있는 경우:
				Shark res  = bfs(x,y,size);
				if(size==res.size) {//먹을수있는 물고기가 없다
					done = 0;
				}
				//else : 
				map[res.x][res.y]=0;//맵 업데이트
				/*아기상어값 업데이트*/
				x = res.x;
				y = res.y;
				size = res.size;
				answer++;//먹은 물고기수 ++<-초에 distance 더하면 됨
			}
			cnt++;
		}
		
		
	}
	static int [] dx = {-1,0,1,0};//상좌 하우priority  :dx[0]->dx[1]
	static int [] dy = {0,-1,0,1};
	/**
	 * 상어와 물고기의 최단거리를 찾는다
	 * @param x , y : 상어의 좌표, size : 현재 상어의 크기
	 * - 조건 1 : 상어와 물고기의 최단 거리가 여러개일 경우  : 가장 위쪽에 있는 경로로 이동한다
	 * - 조건 2 : 조건 1을 만족하는 물고기가 여러개인 경우 가장 왼쪽에 있는 물고기에게 이동한다
	 * return 최단거리일경우의 상어 status  -> 이제 맵에서 그 좌표만 직접 물고기 없애면 된다
	 */
	public static Shark bfs(int x, int y , int size) {
		Queue<Shark> q = new LinkedList<>();
		q.add(new Shark(x,y,size));
		visited = new boolean[N][N];
		visited[x][y] = true;//방문 처리
		
		copyArr();//배열 복제하여 계산 ㄱ
		
		int min_distance = Integer.MAX_VALUE;
		int distance = 0;
		
		Shark result = new Shark(min_distance,min_distance,0);
		System.out.println("시작 상어의 좌표 : "+x+","+y+" . 상어의 사이즈 : "+size);

		while(!q.isEmpty()) {
			Shark baby = q.poll();
			for(int d = 0 ; d<4 ; d++) {
				
				int nx = baby.x + dx[d];
				int ny = baby.y + dy[d];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;	//범위 out
				if(visited[nx][ny])continue;			//이미 방문
				
				if(copyArr[nx][ny]> baby.size )continue;	//물고기> 상어
				if(min_distance<distance+1) continue;	//만약 현재 진행중인 거리가 최소 거리보다 크면 for loop 탈출하시는걸 추천드림 : 어차피 distance+1되는 운명임
				
				
				if(copyArr[nx][ny]==baby.size || copyArr[nx][ny]==0) {	//먹지는 못하고 이동만 가능
					visited[nx][ny] = true;				//방문 처리
					q.add(new Shark(nx,ny,baby.size));	//새 좌표, 현재 사이즈 유지
					distance++;							//이동거리++
				}
				else if (copyArr[nx][ny]<baby.size) {		//물고기<상어 : can eat
					copyArr[nx][ny] = 0;					//yum..
					visited[nx][ny] = true;				//방문처리
					q.add(new Shark(nx,ny,baby.size+1));//사이즈++
					distance++;
					
					/* 상어를 먹었다면 최단거리 판단 */
					if(distance>min_distance) {distance = 0; }//초기화
					else if(distance<min_distance) {//만약 이전에 먹었다면 최소 거리인지 가늠해보자!
						min_distance = distance;
						result = new Shark(nx,ny, baby.size+1);//갱신
					}
					else if( distance == min_distance) { //최단거리와 같을 경우 -> 상->좌판단
							if(result.y > ny) {//baby의 y좌표가 더 작을 경우
								result = new Shark(nx,ny, baby.size+1);//갱신						
							}else if (result.y==ny && result.x>ny) {//y좌표는 같은데, 현재 이동햇던 x좌표가더 작은 경우
								result = new Shark(nx,ny, baby.size+1);//갱신												
							}
						}
						distance = 0;//초기화
					}
	
			}
		}
	
		return result;
	}

	public static class Shark{
		int x ;
		int y;
		int size;
		Shark(int x, int y , int size ){
			this.x = x;
			this.y = y;
			this.size = size;
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

