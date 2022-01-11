package 프로그래머스_01112022;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		print(picture, m, n);
		solution(m, n, picture);
	}

	public static class Node {
		int x, y;// number: 색깔, area : 색깔이 몇개 연속됫엇나

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @param picture BFS 를 사용하여 풀이 if -1 || 0 -> continue 상하좌우에 자신과 같은 숫자가 있다면 영역
	 *                +1, max영역인지 확인
	 */
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	private static int bfs(int x, int y, int m, int n, int[][] picture) {
		int sameArea = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			for(int d = 0 ; d<4 ; d++) {
				int nx = dx[d] + node.x ; 
				int ny = dy[d] + node.y ;
				
				if(nx<0||ny<0||nx>=m||ny>=n)continue;
				if(visited[nx][ny])continue;
				
				//같은 영역인 경우:
				if(picture[nx][ny]==picture[x][y]) {
					visited[nx][ny] = true;
					q.add(new Node(nx,ny));
					sameArea++;
				}
			}
		}
		return sameArea;
	}

	static boolean[][] visited;
	private static void solution(int m, int n, int[][] picture) {
		int numbersOfArea = 0;
		int maxSizeOfOneArea = 0;
		visited = new boolean[m][n];
		for(int i = 0 ; i<m ; i++) {
			for(int j = 0 ; j<n; j++) {
				if(visited[i][j])continue;
				if(picture[i][j]!=0) {//빈칸 x
					int thisMax = bfs(i,j,m,n,picture);
					maxSizeOfOneArea = thisMax > maxSizeOfOneArea ? thisMax : maxSizeOfOneArea;
					numbersOfArea++;
				}
			}
		}
		System.out.println(numbersOfArea);
		System.out.println(maxSizeOfOneArea);
		
	}

	/**
	 * Utilities Print 2D Array
	 */
	private static void print(int[][] arr, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
