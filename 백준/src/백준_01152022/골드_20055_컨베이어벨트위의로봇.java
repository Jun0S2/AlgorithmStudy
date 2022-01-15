package 백준_01152022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 골드_20055_컨베이어벨트위의로봇 {
	static int N, K;	//맵 사이즈, 다쓴개수최대치
	static int[] map;	//내구도 맵
	static ArrayList<Integer> robot; //로봇의 좌표를 담은 arraylist 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[(2*N)+1];
		robot = new ArrayList<>();
		
		st = new StringTokenizer (br.readLine());
		for(int i = 1 ; i<= 2*N ; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(Integer.toString(simulation()));
		bw.flush();
	}
	public static int simulation () {
		int stage = 0;
		while(true) {//step 4 : 내구도가 0 인 칸의 개수가 K 개 이상이라면 반복
			//1. rotate
			rotate();
			//2. move
			move();
			//3. 로봇 올림
			setRobot();
			stage++;//단계++
			if(exit()==K) break;
		}
		//System.out.println(stage);
		return stage;
	}
	/**
	 * Step 1
	 * 컨베이어벨트를 회전하는 메서드
	 * 컨베이어벨트와 함께 로봇도 이동시킨단
	 * 1~2*N-1번째 컨베이어 & 로봇 : +1칸 우측
	 * 2N번쨰 컨베이어 & 로봇 : 첫째 칸으로 이동
	 * 컨베이어벨트와 함께 이동하기 때문에 내구도는 깍이지 않는다.
	 */
	public static void rotate() {
		//1. 내구도 맵 옮기기
		int usage_lastToFirst = map[2*N];//마지막칸의 내구도를 미리 빼놓는다
		for(int i =2*N-1 ; i>=1 ; i-- ) {
			int temp = map[i];
			map[i] = map[i+1];
			map[i+1] = temp;
		}
		map[1] = usage_lastToFirst;
		//2. 로봇 한칸씩 옮기기
		for(int i = 0 ; i<robot.size() ; i++ ) {
			if(robot.get(i)==2*N) {//로봇이 마지막 칸 위에 있는 경우
				robot.set(i,1);	//제일 처음 칸으로 이동
			}
			else robot.set(i, robot.get(i)+1);
		}
		getOff();
	}
	/**
	 * Step 2
	 * 로봇이 이동할 수 있는지 판단한 후 로봇을 이동시킨다
	 * 이때 이동은 로봇이 자력으로 움직이는 것이므로 내구도를 깍는다.
	 */
	public static void move () {
		for(int i = 0; i <robot.size() ; i++) {
			int curr_robot_index = robot.get(i);
			//로봇이 맨 마지막 칸에 있는 경우(indexoutofbound용)
			if(curr_robot_index==2*N) {
				if(isClear(1) && map[1]>0) {
					robot.set(i, 1);//로봇 이동
					map[1]--;		//내구도 감소
				}
			}
			//일반 경우
			else {
				if(isClear(curr_robot_index+1) &&  map[curr_robot_index+1]>0) {//이동하려는 위치 비어있고 내구도 남아있음
					robot.set(i, curr_robot_index+1); //로봇 이동
					map[curr_robot_index+1]--;			//내구도 감소
				}
			}
		}
		getOff();
	}
	/**
	 * Step 3
	 * 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇 올림
	 * (index0이 올리는 위치*)
	 */
	public static void setRobot() {
		if(map[1]>0) {
			map[1]--;
			robot.add(1);//1번 위치에 올림
		}
	}
	/**
	 * 로봇이 이동하려는 칸에 로봇이 있는지 없는지 판단
	 * 로봇이 있으면 false : not clear
	 * 로봇이 없으면 true : clear
	 * @return result
	 */
	public static boolean isClear(int index) {
		for(int i = 0 ; i < robot.size() ; i++) {
			if(robot.get(i)== index) return false;
		}
		return true;
	}
	public static int exit() {
		int cnt = 0;
		for(int i = 1 ; i<=2*N ; i++) {
			if(map[i]==0)cnt++;
		}
		return cnt;
	}
	/**
	 * 로봇이 내리는 메서드 
	 * 로봇의 위치가 N 이면 getsOff
	 * 자주 쓰여서 메서드로 뺐다.
	 */
	public static void getOff() {
		int initialRobotSize = robot.size();
		for(int i = 0 ; i < initialRobotSize ; i++) {
			if(robot.get(i)==N) {
				robot.remove(i);
				initialRobotSize--;
			}
		}
	}
/**Utilities
 * 
 */
	public static void printRobot() {
		System.out.println("RObot 위치 ");
		for(int i = 0 ; i< robot.size() ; i++ ) {
			System.out.print(robot.get(i)+" , ");
		}
		System.out.println();
	}
}
