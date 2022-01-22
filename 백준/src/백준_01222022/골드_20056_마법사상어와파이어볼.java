package 백준_01222022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 01/22/2022
 * 골드 4
 * 삼성전자기출문제
 * @author June Park
 * 풀이 방식 : 
 * 1. 이동
 * 파이어볼을 큐에 저장 -> 이동시킨 파이어볼을 temp 리스트에 저장 + 카운트맵에 추가
 * 2. 중복 제거
 * 카운트 맵의 한 칸에 파이어볼이 1개보다 많다면 중복이 존잰
 * 리스트 돌면서 같은 좌표일 경우 : mass,speed,odd/even 계산 후 제거
 * -> 더이상 리스트에 같은 좌표가 없으면 mass/5, speed/n, direction정함
 * 3. temp리스트에 아직 남아있는 파이어볼을 다시 파이어볼큐에 옮겨 담고
 * 
 * K-- -> 1부터 반복
 */
public class 골드_20056_마법사상어와파이어볼 {
	static int N, M, K, map[][];

	static class Fireball {
		int r, c, m, s, d;

		Fireball(int r, int c, int m, int s, int d) {
			this.r = r; // x좌표
			this.c = c; // y좌표
			this.m = m; // 질량 mass
			this.s = s; // 속도 speed
			this.d = d; // 방향 direction
		}
	}

	static Queue<Fireball> commands = new LinkedList<>();
	static ArrayList<Fireball> temp = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 맵의 크기
		M = Integer.parseInt(st.nextToken());// 파이어볼의 정보 (r,c,m,s,d)로 이루어져있단
		K = Integer.parseInt(st.nextToken());// 명령의 개수 -> while K-->0에 쓰이는..

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {// 파이어볼의 정보 -> this will be spreaded on the map
			st = new StringTokenizer(br.readLine());
			commands.add(new Fireball(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		
		simulation();
		bw.write(countMass()+"\n");
		bw.flush();
	}

	private static void simulation() {
		while(K>0) {
			move();
			merge();
			moveAll();
			K--;
		}
	}
	static int dx[] = {-1,-1,0,1, 1, 1, 0,-1};//상 우상 우 우하 하 하좌 좌 좌상
	static int dy[] = { 0, 1,1,1, 0,-1,-1,-1};
	/** 상어가 파이어볼에게 명령하면 이동
	 *  Step 1 : 모든 파이어볼들이 자신의 방향 di로 속력 si 칸 만큼 이동한다
	 *  commands ->  temp 로 이동한다
	 */
	private static void move() {
		init();
		while(!commands.isEmpty()) {
			Fireball fire = commands.poll();
			int nx = fire.r;
			int ny = fire.c;
			for(int i = 0 ; i<fire.s ; i++) {//스피드==거리만큼 이동
				nx = nx + dx[fire.d];
				ny = ny + dy[fire.d];
				nx = rollOver(nx);//만약 범위를 넘는 경우 올바른 범위로 안내해준다
				ny = rollOver(ny);
			}//end of 이동 -> 이동한 좌표를 저장할 수 있다.
			map[nx][ny]++;//해당 좌표에 파이어볼이 몇개 남아있는지 표시해둔다
			temp.add(new Fireball(nx,ny,fire.m, fire.s,fire.d));//아직까진 좌표 외에 변하는 것 없음
		}
	}//이동한 좌표를 temp에 저장 완료, commands는 비워둠
	
	/**
	 * nx 와 ny가 범위를 벗어날  경우 재설정해주는 메서드
	 * @param nx,ny
	 */
	private static int rollOver( int n) {
		if(n<1) {
			return N;
		}
		else if (n>=N+1) {
			return 1;
		}
		return n; //범위 안에 드는 경우
	}

	/**
	 * 파이어볼들이 두개 이상인 곳에서는 합쳐진다.
	 * temp -> commands 로 finalize
	 */
	private static void merge() {
		boolean allOdd, allEven; //-> 둘다 해서 하나라도 true로 남아있으면 odd면 1357 even이면 0246
		int massSum , num, speedSum;

		for(int i = 1 ; i<=N; i ++) {
			for(int j =1 ; j<=N; j++) {
				if(map[i][j]>1) {
					allOdd = true; allEven = true; massSum = 0;//파이어볼 질량의 합
					num = 0;//파이어볼의 갯수
					speedSum = 0;//파이어볼 속력의 합-> 스피드 = 파이어볼 속력의 합 / 파이어볼의 개순
					int size = temp.size();
					for(int k = 0 ; k< size ; k++) {
						Fireball t = temp.get(k);
						if(t.r == i && t.c == j) {//해당 좌표의 파이어볼 찾음
							if(t.d%2!=0)allEven = false;
							if (t.d%2==0) allOdd = false;//이렇게되면 even은 true로 남아있음
							massSum += t.m;
							speedSum += t.s;
							num++;
							temp.remove(k);		//합쳐져야 하는 파이어볼이라면 리스트에서 제거한다.
							k--;
							size--;
						}
					}//end of for -> 중복된 애들 찾음
					
					int mass = massSum/5;
					int speed = speedSum/num;//속력

					if(mass==0)continue;//질량이 0인 파이어볼은 소멸되어 없어짐
					
					
					int dir = 1;//일반은 1 3 5 7
					if(allEven || allOdd) dir = 0;//짝수이거나 전부 홀수이면 0 2 4 6
					
					for(int d=0;d<4; d++) {
						commands.add(new Fireball(i,j,mass,speed,dir));	
						dir+=2;
					}
		
				}
			}
		}
	}
	
	/**
	 * 중복이 아닌 파이어볼들도 마저 옮긴다 commands에 옮긴다
	 */
	private static void moveAll() {
		for(int i = 0 ; i<temp.size() ;i++) {
			commands.add(temp.get(i));
		}
		temp.clear();
	}
	/**
	 * 
	 * 숫자를 카운트 했던 맵을 초기화 시킨다
	 */
	private static void init() {
		for(int i =1 ; i<=N ; i++ ) {
			for(int j = 1;  j<= N ; j++) {
				map[i][j] = 0;
			}
		}
	}

	/**
	 * 끝나고 남은 파이어볼의 질량을 세는 함수
	 */
	private static int countMass() {
		int sum = 0;
		while(!commands.isEmpty()) {
			Fireball f = commands.poll();
			sum += f.m;
		}
		return sum;
	}

}
