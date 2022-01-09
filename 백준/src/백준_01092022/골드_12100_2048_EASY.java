package 백준_01092022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 골드_12100_2048_EASY {
static int N, original[][],board[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		original = new int[N][N] ; 
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				original[i][j] = input;
				board[i][j] = input;
			}
		}
		dfs(0,board);
		//int newArr[][] = move(3);
		//print(newArr);
		System.out.println(answer);
	}
	static int answer = -1;
	private static void dfs(int depth , int [][]board) {
		if(depth == 5 ) {
			//reset array
			answer = getMaxValue(board)>answer?getMaxValue(board):answer;
			print(board);
			board = reset(board);
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {//상하좌우
			int newArr[][] = move(i);
			dfs(depth+1,newArr );
		}
	}
	private static int[][] move(int direction) {
		Queue<int[]>q = new LinkedList<>(); //row/col , number
		switch (direction) {
		case 0: //하 -> 상 : 가장 위쪽 부터 합쳐야 한다
			for(int i =0 ; i<N ; i++) { //row: same
				for(int j = 0 ; j<N; j++) {
					if(board[j][i]!=0) {q.add(new int[] {j,board[j][i]});}
				}
			}
			break;
		case 1: //상 -> 하 : 가장 아래쪽 부터 합쳐야 한다
			for(int i = 0 ; i< N ; i++) { //row : same
				for(int j =N-1 ; j >=0 ; j--) {
					if(board[j][i]!=0 ) {q.add(new int[] {i, board[j][i]});}//row 를 줘바
				}
			}
			break;
		case 2: //우 -> 좌 로 이동: 가장 왼쪽부터 합쳐야 한다
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0 ; j<N; j++) {
					if(board[i][j]!=0) {
						q.add(new int[] {i,board[i][j]});//나중에 빼낼 때 : 같은 row인 애가 있으면 그자리에 합치고 index 무브
					}
				}
			}
			break;
		case 3: //좌 -> 우 로 이동 : 가장 오른쪽 부터 합쳐야 한다
			for(int i = 0 ;i<N; i++) {
				for(int j = N-1 ; j>=0 ; j--) { //우->좌
					if(board[i][j]!=0)q.add(new int[] {i, board[i][j]}); //row,num
				}
			}
			break;
		}
		return merge(q,direction);
		
	}
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
					if(newboard[i][col]==0) {newboard[i][col] = a[1]; merged = false; tail = i; break;}
					else {
						if(!merged) {
							if(newboard[i][col]==a[1] && tail == i) {newboard[i][col]=2*a[1]; tail =i; merged=true; break;}
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

	/**
	 * board 를 처음 배열로 되돌린다
	 */
	private static int[][] reset(int[][]board) {
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				board[i][j] = original[i][j];
			}
		}
		return board;
	}
	/** 
	 * 가장 큰 블록을 찾는다
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
