package 백준_01092022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @author June Park
 * Gold 2
 * 2048 시뮬레이션 : 큐를 사용했을 때가 보드 2개 사용한 어제 풀이보다 깔끔하고 쉽다
 * 삼성 기출 문제
 * 풀이 시간 : 4시간
 *
 */
public class 골드_12100_2048_EASY {
static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		dfs(0,board);
		bw.append(Integer.toString(answer));
		bw.flush();
	}
	
	static int answer = -1; //가장 큰 블록값을 담을 변수
	
	/**
	 * dfs 를 통하여 각 방향마다 시뮬레이션 -> total 5 하여 depth ==5인 경우 max 블록 확인
	 * @param depth
	 * @param arr
	 */
	private static void dfs(int depth , int [][]arr) {
		if(depth == 5 ) {
			//reset array
			answer = getMaxValue(arr)>answer?getMaxValue(arr):answer;
			return;
		}
		
		for(int i = 0 ; i < 4 ; i++) {//상하좌우
			dfs(depth+1,move(i,arr));
		}
	}
	/**
	 * 
	 * @param direction
	 * @param arr
	 * @return
	 * 큐에 배열의 row/col과 안의 숫자를 다 더해 넣는다 -> merge 배열에서 큐 안에 들은 row 또는 column을 통하여
	 * 방향에 따라 차례대로 merge 여부를 판단하여 넣어준다.
	 * 
	 * 허망하게도 계속 실패했던 원인 -> parameter 에 arr로 안받아서 계속 original array를 받고 있어서
	 * step 1만 반복 하고 있었다..ㅠㅠ
	 */
	private static int[][] move(int direction , int[][] arr) {
		Queue<int[]>q = new LinkedList<>(); //row/col , number
		switch (direction) {
		case 0: //하 -> 상 : 가장 위쪽 부터 합쳐야 한다
			for(int i =0 ; i<N ; i++) { //row: same
				for(int j = 0 ; j<N; j++) {
					if(arr[j][i]!=0) {q.add(new int[] {i,arr[j][i]});}
				}
			}
			break;
		case 1: //상 -> 하 : 가장 아래쪽 부터 합쳐야 한다
			for(int i = 0 ; i< N ; i++) { //row : same
				for(int j =N-1 ; j >=0 ; j--) {
					if(arr[j][i]!=0 ) {q.add(new int[] {i, arr[j][i]});}//row 를 줘바
				}
			}
			break;
		case 2: //우 -> 좌 로 이동: 가장 왼쪽부터 합쳐야 한다
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N; j++) {
					if(arr[i][j]!=0) {
						q.add(new int[] {i,arr[i][j]});//나중에 빼낼 때 : 같은 row인 애가 있으면 그자리에 합치고 index 무브
					}
				}
			}
			break;
		case 3: //좌 -> 우 로 이동 : 가장 오른쪽 부터 합쳐야 한다
			for(int i = 0 ;i<N; i++) {
				for(int j = N-1 ; j>=0 ; j--) { //우->좌
					if(arr[i][j]!=0)q.add(new int[] {i, arr[i][j]}); //row,num
				}
			}
			break;
		}
		return merge(q,direction);
		
	}
	/**
	 * 
	 * @param q
	 * @param direction
	 * @return
	 * move()배열에서 큐에 각 원소들을 담아놨다 -> 이를 토대로 direction에 따라 상하좌우에 빈칸에 뿌려준다
	 * tail : 이미 2 4 8 있는 상태에서 다음 원소가 2면 4 4 8 이 되는걸 방지하기 위해 마지막 원소의 인덱스를 트래킹하여 
	 * 마지막 인덱스랑 같아야만merge 할 수 있다
	 */
	private static int[][] merge(Queue<int[]>q, int direction) {
		int[][] newboard = new int [N][N];
		boolean merged = false ;// 한번 머지되면 다음애로 넘어가야함, else 이미 있는애에 더함
		int tail = -1; //merge 되기 전에 테일에 있는지 확인
		int [] a;
		int row,col;
		switch (direction) {
		case 0: //하 -> 상으로 이동 : 위에서 부터 합쳐야함
			while(!q.isEmpty()) {
			a = q.poll();
			col = a[0];
				for(int i = 0 ; i<N ; i++) { //row
				//	System.out.println("row : "+i+"col : "+col+": "+a[1]);
					if(newboard[i][col]==0) {newboard[i][col] = a[1]; merged = false;tail = i; break;}
					else {
						if(!merged) {
							if(newboard[i][col]==a[1] &&tail ==i ) {newboard[i][col]=2*a[1]; merged=true;tail = i; break;}
							else {merged = false; continue; }//다음 row가서 합침
						}
					}
				}
			}
			break;
		case 1: //상 -> 하 로 이동 : 아래에서 부터 합쳐야함
			while(!q.isEmpty()) {
				a = q.poll();
				col = a[0];
				//System.out.println("col: "+a[0]+"number : "+a[1]);
				for(int i =N-1 ; i>=0 ; i--) { //row
					if(newboard[i][col]==0) {newboard[i][col] = a[1]; merged = false; tail = i; break;}
					else {
						//System.out.println("이미 있어~ :row, : "+i+", "+col+": "+board[i][col]);
						if(!merged) {
							if(newboard[i][col]==a[1] && tail == i) {newboard[i][col]=2*a[1]; merged=true;tail = i; break;}
							else {merged = false; continue; }//다음 row가서 합침
						}
					}
					
				}
			}
			break;
		case 2: //우 -> 좌 로 이동
			while (!q.isEmpty()) {
				a = q.poll();
				row = a[0];
				//System.out.println("row: "+a[0]+"number : "+a[1]);
				for(int i = 0 ; i<N; i++) {
					if(newboard[row][i]==0) {newboard[row][i]=a[1];merged = false;tail = i; break;}
					else {
						if(!merged) {
							if(newboard[row][i]==a[1]&&tail  ==i) {merged = true; newboard[row][i]=2*a[1];tail = i;break;}
							else {merged = false; continue;}//이미 다른애가 들어가 있는 경우 continue-> 다음 자리 알아보셈
						}
					}
				}			
			}
			break;
		case 3:
			while(!q.isEmpty()) {
				a = q.poll();
				row = a[0];
				for(int i = N-1 ; i>=0; i--) {//거꾸로 채워야함 우->좌
					if(newboard[row][i]==0) {newboard[row][i]=a[1];merged = false; tail = i; break;}
					else {
						if(!merged) {
							if(newboard[row][i]==a[1] && tail == i) {merged = true; tail = i;newboard[row][i]=2*a[1];break;}
							else {merged = false; continue;}//이미 다른애가 들어가 있는 경우 continue-> 다음 자리 알아보셈
						}
					}
				}
			}
			break;
		}
		return newboard;
	}	

	/** Utilities
	 * @param board
	 * board 배열에서 가장 큰 블록을 찾는다
	 */
	private static int getMaxValue(int[][] board) {
		int max = 0;
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				max = max<board[i][j]?board[i][j]:max;
			}
		}
		return max;
	}
	/**
	 * @param board
	 * board 배열을 프린트 한다
	 */
	private static void print(int[][] board) {
		for(int i = 0 ; i <N ; i ++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("===========");
	}
}
