package 백준_01212022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드_16236_아기상어2 {

	static PriorityQueue<Shark> distance = new PriorityQueue<>(new Comparator<Shark>() {
		@Override
		public int compare(Shark o1, Shark o2) {
			// 1.
			if (o1.distance == o2.distance) {
				if (o1.x == o2.x)return o1.y - o2.y;
				else return o1.x - o2.x;
			}
			return o1.distance - o2.distance;
		}
	});

	static int N, map[][], copyArr[][];
	static boolean visited[][];
	static int sharkSize;
	static int count;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		sharkSize = 2;
		count = 0;
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					distance.add(new Shark(i, j, 0));
					map[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		while (!distance.isEmpty()) {
			Shark s = distance.poll();
				// 방금 이동한 곳에 있는 물고기 먹을 수 있음 ?-> 있다면 처음으루
				if (map[s.x][s.y] > 0 && map[s.x][s.y] < sharkSize) {
					map[s.x][s.y] = 0; // yumyum
					count++;// yum
					if (count == sharkSize) {
						sharkSize++;
						count = 0;
					}
					answer += s.distance;
					s.distance =  0;
					distance.clear();
					initVisited();
				}

				for (int d = 0; d < 4; d++) {
				int nx = s.x + dx[d];
				int ny = s.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] > sharkSize)
					continue;

				// 방문처리
				visited[nx][ny] = true;
				distance.add(new Shark(nx, ny, s.distance + 1));
			} // end of for

		}
	}


	static int[] dx = { -1, 0, 0, 1 };// 상좌 우하priority :dx[0]->dx[1]
	static int[] dy = { 0, -1, 1, 0 };

	public static void initVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}

	public static class Shark {
		int x;
		int y;
		int distance;

		Shark(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

	}

}