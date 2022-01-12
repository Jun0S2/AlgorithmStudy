package 백준_01122022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author June Park 
 * 골드 5 BFS 문제
 * 풀이 시간 : 58:58
 * 35분 이후 -> 코집사님 블로그 참고 => DFS 사용해야하는거 배움
 * - 1.DFS 사용해야 할것같긴 했었는데 좀 확실해진 것 같음
 *   In this case : wall == 3 -> depth ==3 즉 리미테이션 주어지면 dfs
 * - 2.구현 문제에서 static으로 맵 두고 초기화 하는 작업이 아직은 낯설다. 자꾸 배열 copy을 어느 시점에 해야하는지가 헷갈린다
 * 
 */

public class 골드_14502_연구소 {

	static int N, M, map[][];// 가로, 세로, 지도

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(maxSafe);

	}

	/**
	 * map : 0 빈칸, 1: 벽 , 2: virus bfs : finds maximum 2 바이러스인 경우에만 들어오신다..
	 */
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int maxSafe = 0;
	/**
	 * 벽 세우기
	 * 
	 * @param depth 벽은 3개까지 세울 수 있다 -> depth == 3s
	 */
	private static void dfs(int depth) {
		if (depth == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {// 벽을 세울 수 있다
					map[i][j] = 1; // 벽 세움
					dfs(depth + 1); // next
					map[i][j] = 0; // 다시 돌려 놓는다
				}
			}
		}
	}

	/**
	 * 바이러스 감염
	 * 
	 * @param x
	 * @param y
	 * @param board
	 */
	private static void bfs() {
		Queue<Node> q = new LinkedList<>(); // 바이러스 노드
		
		int[][] infected = new int[N][M];
		  	for(int i = 0 ; i < N ;i ++) {
			for(int j = 0 ; j< M;j++) {
				infected[i][j]=map[i][j];
				if (infected[i][j] == 2) q.add(new Node(i, j)); //바이러스인 경우 큐에 삽입
			}
		}


		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)continue;// 범위 out
				if (infected[nx][ny]==0) {					
					infected[nx][ny] = 2; // 전염
					q.offer(new Node(nx, ny));
				}

			} // end of 사방탐색
		} // end of While loop
		//print(infected);
		
		countSafe(infected);
	}

	/**
	 * 안전 지대를 세는 arr
	 * 
	 * @param arr
	 */
	private static void countSafe(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		maxSafe = maxSafe>cnt ? maxSafe : cnt;
	}

	public static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	/**
	 * Utilities 배열을 프린트 하는 메서드
	 */
	private static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
