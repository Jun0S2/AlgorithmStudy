package 백준_01202022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드_14499_주사위굴리기 {
	static int N,M,X,Y,K,map[][];
	static int back, bottom, front, top, right, left; //다이스의 면에 적힌 숫자를 저장할  변수
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		Queue<Integer> directions = new LinkedList<>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		back = 0; bottom = 0; front = 0; top = 0; right = 0; left = 0;//초기화
		
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M ;j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<K ; i++) {
			directions.add(Integer.parseInt(st.nextToken()));
		} //end of input
		//여기서 while loop 진행
		while(!directions.isEmpty()) {
			int dir = directions.poll();
			if(!moveDice(dir))continue;//주사위를 이동시킨다/. if 범위 out : continue -> 프린트 안한다
			//범위에 들 경우-> X,Y좌표 업데이트함
			updateDice(dir);//다이스에 적힌 숫자를 변경한다
			updateMap();//맵에 적힌 숫자와 다이스 밑면의 숫자를 변경한다.
			//System.out.println(top);//맨 위의 숫자를 뿌린다
			bw.write(top+"\n");
		}
		bw.flush();
	}
	static int [] dx = {0,0,0,-1,1}; // 우 좌 상 하
	static int [] dy = {0,1,-1,0,0};
	
	/**
	 * 다이스를 맵에서 옮긴다 : 해당 방향으로 옮길 수 없다면 false를 리턴 있다면 true를 리턴
	 * @param direction
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean moveDice(int direction) {
		int nx = X + dx[direction];
		int ny = Y + dy[direction];
		if(nx<0|| ny<0|| nx>=N||ny>=M)return false;
		X = nx;//좌표 업데이트
		Y = ny;
		return true;
	} 
	/**
	 * step 1 : update dice
	 * direction 방향으로 다이스를 옮길 때 -> 다이스 면 업데이트
	 * @param direction: 우 1 , 좌 2 , 위 3, 아래 4
	 */
	public static void updateDice(int direction) {
		int prevTop = top, prevBottom = bottom, prevRight = right, 
			prevLeft = left, prevFront = front, prevBack = back;//previous 값 저장
		switch (direction) {
		case 1: //우측 이동
			top = prevLeft;
			bottom = prevRight;
			left = prevBottom ;
			right = prevTop; //나머지 유지
			break;
		case 2://왼쪽 이동
			top = prevRight;
			bottom = prevLeft;
			left = prevTop;
			right = prevBottom;
			break;
		case 3: //위로 : 날개유지 한칸씩 밑으로
			back = prevTop;
			bottom = prevBack;
			front = prevBottom;
			top = prevFront;
			break;
		case 4: //아래로 : 날개유지 한칸씩 위로
			back = prevBottom;
			bottom = prevFront;
			front = prevTop;
			top = prevBack;
			break;
		}
	}
	/**
	 * step 2 : check the bottom 
	 * 맵의 숫자가 0인 경우		- 주사위 bottom이 칸에 복사된다.
	 * 맵의 숫자가 0이 아닐 경우	- 칸에 쓰여있는 숫자가 주사위의 bottom 이  된다. 칸은 0이 된다
	 */
	public static void updateMap() {
		int landed = map[X][Y];//도착한 숫자
		if(landed ==0 ) { //주사위의 bottom이 복사된다
			map[X][Y]= bottom; 
		}
		else {
			map[X][Y] = 0;//칸은 0이 된다
			bottom = landed;//주사위 바닥에 그 칸의 숫자가 복사된다
		}
	}
	
	

}
