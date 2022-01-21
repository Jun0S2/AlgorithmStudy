package 백준_01202022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 골드 4단계
 * 삼성 기출문제
 * @author June Park
 * 문제 자체는 이해하기 쉬우나 시간초과가 날까봐 조마조마 했다.
 * 혹여나 시간초과 날까봐 priority queue는 
 * 많이 혹사시키지 않기 위해 일반 큐를 사용하여 죽은 나무, 새로 생길 나무, 한살 더 먹은 나무를
 * 지속적으로 비워주었다.
 * 첫 시도때 틀려서 디버깅했는데 천년 예제를 통해 comparable 조건을 단순히 age를 했을 때
 * 맞는 것을 확인하였다.
 * 소요 시간 :3시간 +
 *
 */
public class 골드_16235_나무재태크 {
	static int N, M, K, nutrients[][], add[][];
	public static class Tree {
		int x, y, age;

		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
	
	static PriorityQueue<Tree> trees = new PriorityQueue<>(new Comparator<Tree>() {
		@Override
		public int compare(Tree o1, Tree o2) {
			return o1.age-o2.age;
		}
	});
	static Queue<Tree> dead = new LinkedList<>();
	static Queue<Tree> born = new LinkedList<>();
	static Queue<Tree> aged = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 나무의 개수
		K = Integer.parseInt(st.nextToken()); // 년수

		nutrients = new int[N + 1][N + 1];
		add = new int[N + 1][N + 1];// 영양재 줄 때애 사용

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				 add[i][j] = Integer.parseInt(st.nextToken());
				 nutrients[i][j] = 5;//초기양분은 5
			}
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, age));

		}
		simulation();
		bw.write(trees.size()+"\n");
		bw.close();
		trees.clear();
	}

	private static void simulation() {
		while (K > 0) {
			Spring();
			Summer();
			Fall();
			Winter();
			K--;	
		}
	}
	/**
	 * 로봇이 처음에 입력받은 initial 영양분을 현재 맵에 더해준다
	 */
	public static void Winter() {
		for(int i = 1 ; i<=N ; i++) {
			for(int j =1 ;j <=N ;j++) {
				nutrients[i][j] += add[i][j];
			}
		}
//		printArr(nutrients);
	}
	public static void Spring() {
		while(!trees.isEmpty()) {
			Tree t = trees.poll();
			if(t.age > nutrients[t.x][t.y]) { //필요한 영양분 충족 x 죽는다
				dead.add(new Tree(t.x,t.y,t.age/2));// for summer
			}
			else {
				nutrients[t.x][t.y]-=t.age;
				if((t.age+1)%5==0)born.add(new Tree(t.x,t.y,t.age+1)); //가을에 새로 태어날 수 있다				
				aged.add(new Tree(t.x,t.y,t.age+1));//나이 한살 더먹는다
			}
		}
		//한살 더 먹은 나무들 다시 집어넣기
		while(!aged.isEmpty()) {
			Tree t = aged.poll();
			trees.add(t);
		}
		
	}
	public static void Summer() {//죽는다
		while(!dead.isEmpty()) {
			Tree t = dead.poll();
	//		System.out.println("죽은 나무  : "+t.x+","+t.y+"은 향년 "+t.age+"양분을 주셨다");
			nutrients[t.x][t.y] += t.age;
		}
	//	printArr(nutrients);
	}
	static int dx [] = {-1,-1,-1, 0,0, 1,1,1};
	static int dy [] = {-1, 0, 1,-1,1,-1,0,1};

	
	public static void Fall() {
		while(!born.isEmpty()) {
			Tree b = born.poll();
//			System.out.println("어르신의 좌표 : "+b.x+", "+b.y+"나이 : "+b.age);
			for(int d = 0 ; d<8 ; d++) {
				int nx = b.x + dx[d];
				int ny = b.y + dy[d];
				if(nx<1||ny<1||nx>=N+1||ny>=N+1)continue;//범위 out이면 dont add
				//else
				trees.add(new Tree(nx,ny,1));//새 나무 더한다
			}
			
		}
	}
	/**
	 * Utilities: print 2D Array
	 */
	public static void printArr(int[][] arr) {
		for(int i =1 ;i <=N ; i++) {
			for(int j = 1; j<= N ;j ++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
