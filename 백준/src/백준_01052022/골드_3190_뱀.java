package 백준_01052022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 삼성 기출문제 골드 5
 * 
 * @author June
 *
 */
public class 골드_3190_뱀 {
	static int[][] map; // 0: 빈칸, 1:사과 2: 머리 3: 몸통 4: 꼬리
	static int N, K, L;
	static Queue<Move> turn = new LinkedList<>();
	static Queue<Integer> tail_Direction = new LinkedList<>();

	/**
	 * 이동하는 초와 direction을 정함 x 초가 끝난 뒤에 c 방향으로 방향 전환
	 */
	public static class Move {
		int x;
		char c;

		Move(int x, char c) {
			this.x = x;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 맵의 크기
		K = Integer.parseInt(br.readLine()); // 사과의 수
		initMap(); // 맵 초기화

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		L = Integer.parseInt(br.readLine());

		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			turn.offer(new Move(t, c));
		}
		/*----------------------------------------------------------*/
		simulation();

	}

	static char[] heading = { 'L', 'D' }; // L : 왼쪽으로 90도, D : 오른쪽으로 90도 회전

	public static void simulation() {
		while (!turn.isEmpty()) {
			Move a = turn.poll();
			int t = a.x-playtime; // 몇초까지?
			char dir = a.c; // 방향전환
			/* step 1 이동 */
			if (!Move(t)) {
				System.out.println("playtime : " + playtime+1);
			}
			/* step 2 방향전환 */
			Turn(dir); // dir 방향으로 고개를 이동
		}
		System.out.println("playtime : " + playtime);
	}

	public static class Snake {
		int x, y, direction, length;
		int tail_x, tail_y, tail_direction;

		Snake(int x, int y, int length, int direction, int tail_x, int tail_y, int tail_direction) {
			this.x = x;
			this.y = y;
			this.length = length;
			this.direction = direction;
			this.tail_x = tail_x;
			this.tail_y = tail_y;
			this.tail_direction = tail_direction;
		}

	}

	public static Snake snake;
	static int playtime = 1;

	private static boolean Move(int t) {
		// 현재 방향으로 t초동안 주행
		while (t > 0) {
			System.out.println(tail_Direction.toString());
			System.out.println("플레이 초: "+playtime);
			// 몸길이를 늘려 머리를 다음칸(heading방향)에 위치
			// 1. 현재 머리의 위치를 얻어온다
			int x = snake.x;
			int y = snake.y;
			int d = snake.direction;
			int tail_dir = snake.tail_direction;

			// 2. 현재 머리의 방향을 얻어온다
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 3. 맵에 현재 머리 +다음방향 위치를 place 하고 업뎃
			if (nx < 1 || nx >= N + 1 || ny <1 || ny >= N + 1) {
				System.out.println("범위 out");
				return false;
			} else {

				// 4. 사과가 없는 경우
				if (map[nx][ny] == 0) {
					map[nx][ny] = 2;// 새 머리
					// 꼬리나 몸통이 있는 경우는 몸통도 업뎃
					System.out.println("tail: " + snake.tail_x + " " + snake.tail_y);
					if (snake.length > 1) {
						map[x][y] = 3; // 원래 머리는 몸통으로 ㄱ

						map[snake.tail_x][snake.tail_y] = 0; // 맵에서 꼬리 한칸 이동

						int tail_nx = snake.tail_x + dx[tail_dir]; // 뱀 객체 꼬리 한칸 이동
						int tail_ny = snake.tail_y + dy[tail_dir]; // 뱀 객체 꼬리 한칸 이동

						// 꼬리 방향 바꿔야 하는 경우
						if (map[tail_nx][tail_ny] != 3 || tail_nx<1||tail_ny<1||tail_nx>=N+1||tail_ny>=N+1) {
							if(tail_Direction.size()<=1) {System.out.println("꼬리가..");return false;}
							tail_Direction.poll();
							snake.tail_direction =  tail_Direction.peek();//새로운 꼬리 방향
							tail_dir = snake.tail_direction;
							System.out.println("polled : "+tail_Direction.toString());
							
							map[tail_nx][tail_ny]=0;
							
							tail_nx = snake.tail_x + dx[tail_dir];
							tail_ny = snake.tail_y + dy[tail_dir];
							System.out.println("tail_nx : "+tail_nx+" tail_ny: "+tail_ny);
						}
						
						snake.tail_x = tail_nx; //새 꼬리
						snake.tail_y = tail_ny;

					} else if (snake.length == 1) {
						map[x][y] = 0;
						snake.tail_x = snake.x;
						snake.tail_y = snake.y;
					}
				}
				// 5. 사과가 있는 경우 : tail은 그대로
				else if (map[nx][ny] == 1) {
					map[nx][ny] = 2; // 새 머리
					map[x][y] = 3; // 기존 머리는 몸통으로 치환
					snake.length++;
				} else if (map[nx][ny] != 0) {
					System.out.println("몸통박치기");
					return false;
				}

				System.out.println("new tail: " + snake.tail_x + " " + snake.tail_y);
				snake.x = nx;
				snake.y = ny;
			}

			t--;
			playtime++;
			printMap();
			System.out.println("===============================");
		}
		return true;
	}

//상하좌우0123
	private static void Turn(char dir) {
		switch (dir) {
		case 'L':
			if (snake.direction == 3) { // 현재 방향이 오른쪽
				snake.direction = 0;// 상
				tail_Direction.add(0);
			} else if (snake.direction == 0) // 상 -> 좌
			{
				snake.direction = 2;
				tail_Direction.add(2);
			} else if (snake.direction == 1) {// 하 -> 우
				snake.direction = 3;
				tail_Direction.add(3);
			}
			// 좌 -> 하
			else if (snake.direction == 2) {
				snake.direction = 1;
				tail_Direction.add(1);
			}
			System.out.println(tail_Direction.toString());
			break;
		case 'D':
			if (snake.direction == 3) {
				snake.direction = 1; // 우 -> 하
				tail_Direction.add(1);
			} else if (snake.direction == 0) {
				snake.direction = 3; // 상 ->우
				tail_Direction.add(3);
			} else if (snake.direction == 1) {
				snake.direction = 2; // 하 -> 좌
				tail_Direction.add(2);
			} else if (snake.direction == 2) {
				snake.direction = 0; // 좌 ->상
				tail_Direction.add(0);
			}
			System.out.println(tail_Direction.toString());
			break;
		}
	}

	public static int[] dx = { -1, 1, 0, 0 };// 상하좌우
	public static int[] dy = { 0, 0, -1, 1 };// 0123

	/** Utilities */
	public static void initMap() {
		map = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == 0 || j == 0)
					map[i][j] = -1;
			}
		}
		map[1][1] = 2;// 뱀의 시작 위치

		snake = new Snake(1, 1, 1, 3, 1, 1, 3);
		tail_Direction.add(3);
	}

	public static void printMap() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
