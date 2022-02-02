package 백준_02022022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드_17142_연구소3 {
	static class Virus{
		int x, y, time;//x,y : 좌표 , time : 시간
		Virus(int x, int y){
			this.x = x;
			this.y = y;
		}
		Virus(int x, int y , int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int N, M, map[][], ZEROS;
	static boolean visited[];//백트랙킹에서 사용할 방문 배열
	static ArrayList<Virus> virus = new ArrayList<>();
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for( int i = 1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			for( int j = 1; j<=N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) ZEROS++;//전염될 수 있는 영역 수
				else if (map[i][j]==2) virus.add(new Virus(i,j));//바이러스
			}
		}
		if(ZEROS==0) {System.out.println(0);return;}
		visited = new boolean[virus.size()];
		solution(0,0);
		MIN = MIN==Integer.MAX_VALUE ? -1 : MIN;
		System.out.println(MIN);
	}
	static int MIN = Integer.MAX_VALUE;//최솟시간
	/**
	 * solution : 백트랙킹-> "최소 시간/횟수"구하기
	 * @param start
	 * @param cnt
	 */
	private static void solution(int start, int cnt) {
		if(cnt == M) {
//			System.out.println("cut");
			MIN = Math.min(MIN, bfs()); //update MIN
//			System.out.println(MIN);
		}
		
		for(int i = start ; i<virus.size(); i++) {
			if(visited[i])continue;
			visited[i] = true;//방문 처리
	//		System.out.println("방문중 : "+virus.get(i).x+","+virus.get(i).y);
			solution(i+1 , cnt+1);//다음 바이러스 픽
			visited[i]= false;//방문 처리
		}
		
	}
/**
 * bfs : 활성화된 바이러스를 큐에 넣고 바이러스가 전부 퍼질때 까지 탐색
 * -> 탐색 후, 확산 가능했던 (input) ZEROS와 확산 시킨 범위가 같은지 확인하고 맞다면 걸린 횟수 리턴
 * @return
 */
	private static int bfs() {
		Queue<Virus> q = new LinkedList<>();//활성화된 바이러스 큐
		boolean visitedMap[][] = new boolean[N+1][N+1];//맵 방문 배열
		for(int i = 0 ; i<virus.size() ;i ++) {//현재 백트랭킹에서 픽된 바이러스면 큐에 더함
			if(visited[i]) { 
				q.add(new Virus(virus.get(i).x, virus.get(i).y , 0));
			}
		}
		int minTime = 0;//현재 픽에서의 최소 시간 트랙 -> 가지치기용..min보다 크면 cut
		int zeroCnt = 0;//확인용
		while(!q.isEmpty()) {
			Virus v = q.poll();
			if(minTime>MIN)return Integer.MAX_VALUE;// 가지치기
			for(int d = 0 ; d<4 ; d++) { //사방 동시에 퍼짐-> 큐에 넣는다
				int nx = v.x + dx[d];
				int ny = v.y + dy[d];
				
				/*방문 out*/
				if(nx<1||ny<1||nx>=N+1||ny>=N+1)continue;//범위 out
				if(visitedMap[nx][ny])continue;//이미 방문
				if(map[nx][ny]==1)continue;//벽
				
				//Else : 2인 경우도 큐에 넣고, 0인 경우는 zerocnt늘린다
				if(map[nx][ny]==0) {
					zeroCnt++;
					minTime = v.time+1;//바이러스가 활성화 되는건 시간에 안넣는다..!아..					
				}
				visitedMap[nx][ny] = true;//방문처리
				q.add(new Virus(nx,ny, v.time+1));//새 좌표와 시간++을 큐에 넣음
			}
		}
		if(zeroCnt == ZEROS) {//모두 확산 완료
			return minTime;
		}
		return Integer.MAX_VALUE;//확산 불가
	}

}
