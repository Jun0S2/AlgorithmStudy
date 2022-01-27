package 백준_01272022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 큐 대신 리스트를 사용하고 처음에 정렬해놓으면 된다!
 * 
 * @author User
 *
 */
public class 골드_19236_청소년_상어 {
	static int MAX = 0;
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = {  0, -1, -1, -1, 0, 1, 1, 1 };

	static class Fish {
		int num, direction;
		int x, y;
		boolean isAlive = true;

		Fish(int x, int y, int num, int direction, boolean isAlive) {
			this.num = num;
			this.direction = direction;
			this.x = x;
			this.y = y;
			this.isAlive = isAlive;
		}
	}

	static class Shark {
		int x, y, direction, sum;

		Shark(int x, int y, int direction, int sum) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.sum = sum;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] map = new int[4][4];
		List<Fish> fish = new ArrayList<>();
		Shark shark = null;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int no = Integer.parseInt(st.nextToken());// 물고기 번호
				int direction = Integer.parseInt(st.nextToken())-1;// 물고기 방향
				if (i == 0 && j == 0) {
					shark = new Shark(0, 0, direction, no);// 첫번째 물고기는 무조건 먹힘
					fish.add(new Fish(i, j, no, direction, false));
					map[i][j] = -1;// 상어의 위치
				} else {
					fish.add(new Fish(i, j, no, direction, true));
					map[i][j] = no;// map에는 번호를 뿌려준다 , 0은 먹힘 표시
				}
			}
		}
		// 리스트 sort
		Collections.sort(fish, new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				return o1.num - o2.num; // 오름차순 정렬
			}
		});
		 dfs(map,shark,fish);
		//System.out.println(shark.direction);
		 System.out.println(MAX);
	}

	/**
	 * 백트래킹 : 상어가 이동할 수 없을 때 까지 반복
	 * isAlive로 관리 -> 리스트에서 빼면 모든 경우의수 구하기 불편;;
	 */
	private static void dfs(int[][] map, Shark shark, List<Fish> fish) {
		MAX = MAX < shark.sum ? shark.sum : MAX;//max update
		
		fish.forEach(e  -> moveFish(e , map, fish));//오...알고에서 forEach처음써본다
		
		for(int i = 1 ; i <4  ; i++) {//상어 최대 3칸 움직임
			int nx = shark.x + dx[shark.direction] * i;
			int ny = shark.y + dy[shark.direction] * i;
			if(nx<0||ny<0||nx>=4||ny>=4||map[nx][ny]<=0)continue;
			//dfs 하기 위해서 배열 복제
			int[][] copyArr = copyArr(map);
			List<Fish> copyList = copyList(fish);
			
			copyArr[shark.x][shark.y] = 0;//이동
			//System.out.println(map[nx][ny]-1);
			Fish temp = copyList.get(map[nx][ny]-1);//정렬된 리스트(0부터시작)-1 = 인덱스넘버
			Shark newShark = new Shark(temp.x,temp.y,temp.direction, shark.sum + temp.num); //새 상어 경우의 수
			temp.isAlive = false;//x.x
			copyArr[temp.x][temp.y] = -1;//상어
			dfs(copyArr, newShark, copyList);
		}
	}
	/**
	 * 물고기 이동 :
	 * - 현재 방향 체크 -> 이동 if empty. else : 팔방탐색
	 * - if cant move (rangeout) : stay.. 
	 * - d==0 -> d=1 로 세팅. 1~차례로 반시계방향
	 */
	private static void moveFish(Fish fish , int[][]map, List<Fish> list) {
		if(!fish.isAlive) return;//계산할 필요 없음
		
		for(int i = 0; i<8 ; i++) {
			int nd = (fish.direction + i )% 8;//nd하나씩 늘려줌
			int nx = fish.x + dx[nd];
			int ny = fish.y + dy[nd];
			if(nx<0||ny<0||nx>=4||ny>=4||map[nx][ny]==-1)continue;//범위 out or  상어
			
			if(map[nx][ny]==0) {
				map[fish.x][fish.y] = 0;
				fish.x = nx;//fish update
				fish.y = ny;
			}
			else {
				//swap
			//	System.out.println(map[nx][ny]);
				Fish getOut = list.get(map[nx][ny]-1);//list 는 0부터 시작이라..
				getOut.x = fish.x;
				getOut.y = fish.y;
				map[fish.x][fish.y] = getOut.num;//swap
				fish.x = nx;
				fish.y = ny;
			}
			map[nx][ny] = fish.num;//물고기 이동
			fish.direction = nd;
			return;
		}
		
	}

	/**
	 * Utilities
	 */
	public static int[][] copyArr(int[][] arr){
		int temp[][] = new int[4][4];
		for(int i = 0 ; i<4 ; i++) {
			for(int j = 0 ; j<4; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
	public static List<Fish> copyList(List<Fish> list){
		List<Fish> temp = new ArrayList<>();
		list.forEach(e -> temp.add(new Fish(e.x,e.y,e.num, e.direction ,e.isAlive)));
		return temp;
	}

}
