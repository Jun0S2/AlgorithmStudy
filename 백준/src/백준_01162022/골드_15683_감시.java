package 백준_01162022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 골드_15683_감시 {
	static int N, M, map[][], coverage[][];
	static class CCTV{
		int x, y, type,direction;
		CCTV(int x, int y ,int type,int direction){
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.type = type;
		}
	}
	static ArrayList<CCTV> cctv = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		coverage = new int[N][M]; //cctv가 커버하는 영역들

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 & map[i][j]!=6) cctv.add(new CCTV(i,j,map[i][j],0));
			}
		}

		simulation(0);
		bw.write(Integer.toString(min));
		bw.flush();
	}
	//우하좌상
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	//초기화
	private static void init() {
		for(int i = 0 ;i<N ; i++) {
			for(int j = 0 ; j<M ; j++){
				coverage[i][j] = map[i][j];
			}
		}
	}
	private static void simulation(int index) {
		if(index >= cctv.size()) {//백트랙킹 마침
			init();//배열 초기화
			for(int i = 0 ; i<cctv.size() ; i++) {//cctv  발견하면 move 메서드를 실행
				move(cctv.get(i));
			}
			int cnt = count();//count 세기
			min = cnt < min ? cnt : min;//min
			return;
		}
		for(int i = 0 ; i<4 ;i ++) {//우하좌상 : 백트래킹은 항상 이러네..
			cctv.get(index).direction = i;//우하좌상으로 모든 방향을 생각해본다
			simulation(index+1);
 		}
		
	}
	private static void move(CCTV cctv) {
		int nx = cctv.x, ny = cctv.y;
		switch (cctv.type) {
		case 1://left right up or down
			while(true) {
				nx = nx+ dx[cctv.direction];//계속 이어나가야하기때문에 nx로 더한것
				ny = ny + dy[cctv.direction];
				if(!valid(nx,ny))break;
				if(coverage[nx][ny]==0) coverage[nx][ny] = -1;
			}
			break;
		case 2://양방
			for(int i = 0 ; i<3 ; i+=2) {// 양옆	
				nx = cctv.x;
				ny = cctv.y;
				while(true) {
					nx =  nx + dx[(cctv.direction+i)%4];
					ny =  ny + dy[(cctv.direction+i)%4];
					if(!valid(nx,ny))break;
					if(coverage[nx][ny]==0)coverage[nx][ny] = -1;
				}	
			}
			break;
		case 3://ㄴ
			for(int i = 0 ; i<2 ; i++) {
				nx = cctv.x;
				ny = cctv.y;
				while(true) {
					nx =  nx + dx[(cctv.direction+i)%4];
					ny =  ny + dy[(cctv.direction+i)%4];
					if(!valid(nx,ny))break;
					if(coverage[nx][ny]==0)coverage[nx][ny] = -1;
				}	
			}
			break;
		case 4://ㅗ
			for(int i = 0 ; i<3 ; i++) {
				nx = cctv.x;
				ny = cctv.y;
				while(true) {
					nx =  nx + dx[(cctv.direction+i)%4];
					ny =  ny + dy[(cctv.direction+i)%4];
					if(!valid(nx,ny))break;
					if(coverage[nx][ny]==0)coverage[nx][ny] = -1;
				}
			}
			break;
		case 5://+
			for(int i = 0 ; i <4 ; i++) { //모든방향 다해야함
				nx = cctv.x;
				ny = cctv.y;
				while(true) {
					nx =  nx + dx[(cctv.direction+i)%4];
					ny =  ny + dy[(cctv.direction+i)%4];
					if(!valid(nx,ny))break;
					if(coverage[nx][ny]==0)coverage[nx][ny] = -1;
				}	
			}
			break;
		}
	}
	private static boolean valid(int nx, int ny) {
		if(nx<0||ny<0||nx>=N||ny>=M)return false;
		if(coverage[nx][ny] == 6 )return false;
		else return true;
	}
	static int min = Integer.MAX_VALUE;
	/**
	 * 사각지대 카운트
	 * 
	 * @return
	 */
	private static int count() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (coverage[i][j] == 0)count++;
			}
		}
		return count;
	}

}
