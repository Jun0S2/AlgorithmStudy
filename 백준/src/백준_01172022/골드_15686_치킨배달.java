package 백준_01172022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 
 * 처음 : backtracking + bfs
 * 수정 : backtracking & bruteforce
 * @author User
 *
 */
public class 골드_15686_치킨배달 {
	static int N, map[][], M;
	static int answer; // 도시의 m개 치킨 거리의 최솟값
	static boolean visited[];// chicken 집 방문 했는지 판단-> 치킨집들의 최댓값 조합 구하는거니까
	static ArrayList<Node> chicken;
	static ArrayList<Node> houses ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chicken = new ArrayList<>();
		houses = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					houses.add(new Node(i, j));
				else if (map[i][j] == 2)
					chicken.add(new Node(i, j));
			}
		}
		visited = new boolean[chicken.size()];
		
		answer = Integer.MAX_VALUE;
		
		dfs(0,0);
		bw.write(answer+"\n");
		bw.flush();
		bw.close();
	}
	public static void dfs(int start, int depth) {
		if(depth==M) {
			int curr_min = 0;
			for(int i = 0 ; i<houses.size(); i++) {//집-> 치킨집 거리 
				int minDistance = Integer.MAX_VALUE;
				for(int j = 0 ; j<chicken.size() ;j++) {//치킨집
					if(!visited[j])continue;			//선택 안된 치킨집
					int distance = Math.abs(houses.get(i).x - chicken.get(j).x) + Math.abs(houses.get(i).y- chicken.get(j).y);//문제에서 주어진  치킨거리
					minDistance = Math.min(distance, minDistance);//최소 거리를 구한다
				}
				curr_min +=minDistance;//최소합들의 합 ==현재의 최소 거리 합
			}
			answer = Math.min(curr_min, answer);
			return;
		}
		for(int i = start ; i<chicken.size() ;i++) {
			visited[i] = true;//i번째 치킨집 방문
			dfs(i+1,depth+1);
			visited[i] = false;
		}
	}
/**
 * Utilities
 * 
 */
	public static void print() {
		for(int i = 0 ; i<houses.size() ; i++) {
			System.out.print(houses.get(i).x+" , "+houses.get(i).y);
		}
		for(int i = 0 ; i<chicken.size() ; i++) {
			System.out.print(chicken.get(i).x+" , "+chicken.get(i).y);
		}
	}
	/**
	 * 노드클래스 x , y : 좌표
	 * 
	 * @author User
	 *
	 */
	public static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
