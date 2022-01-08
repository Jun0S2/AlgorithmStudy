package 백준_01082022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 골드_12100_2048_EASY {
static int [][] board,original ;
static int N;
static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st ;

		N = Integer.parseInt(br.readLine());

		original= new int [N][N];
		board = new int[N][N];
		
		for(int i = 0 ; i<N ; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N ; j++) {
				int input = Integer.parseInt(st.nextToken());
				original[i][j]=input; board[i][j] =input;
			}
		}
		dfs(0);
		System.out.println(answer);
	}
	
	static int answer = 0;
	
	private static void dfs(int depth) {
		if(depth == 5) {
			answer = getMaxValue()>answer?getMaxValue():answer;
			reset();
			return;
		}
		else {
			for(int i = 0 ; i < 4 ; i++) { //상하좌우
				move(i);
				dfs(depth+1);
			}			
		}
	}
	
	/**
	 * step 1 : 반대 방향으로 이동하여 merge if merged continue 
	 *  @param direction : 이동할 방향
	 *  0: 상
	 *  1: 하
	 *  2: 좌
	 *  3: 우
	 *  if command 짝수 : -1 else +1 한 후에 이동 
	 */
	private static void move(int direction) {
		int moveDirection  = (direction%2==0)? direction+1 : direction -1;
//		System.out.println(moveDirection);
		flag = false;
		int row, col;
		switch (moveDirection) {
		case 0: //위로 이동
			col =N-1;
			while(col>=0) {
				for(int i = N-1 ;i>=0 ; i--) {//하->상 : board[col][col] -> board[i][col-1]
//					System.out.println("col : "+ col);
//					System.out.println(flag);
					if(!stop(col,i,col-1,i)) {
						board[col][i] = board[col-1][i];
						board[col][i] = 0;
					}
					else {
						if(flag) {print();flag=false;col--;continue;}
					}
				}
				col--;
			}
			break;
		case 1://아래로 이동
			row = 0;
			while(row<N) {
				for(int i = 0 ; i<N ; i++) { //상 -> 하 : board[row][i] -> board[row+1][i]
//					System.out.println("row : "+ row);
//					System.out.println(flag);
					//if(flag) {flag = false;}
					if(!stop(row,i,row+1,i)) {
						board[i][row] = board[row+1][i];
						board[i][row] = 0;
					}
					else {
						if(flag) {flag = false ;row++;continue;}
					}

				}
				row++;
			}
			break;
		case 2://좌측으로 이동
			col = N-1;
			while(col>=0) {
				for(int j = N-1 ; j>=0 ;j--) { //우 -> 좌 : board[j][col] -> board[j][col-1]
//					System.out.println("col : "+ col);
//					System.out.println(flag);
					if(!stop(j,col,j,col-1)) {
						board[j][col] = board[j][col-1];
						board[j][col] = 0;
					}
					else if(flag) {col--; flag = false;continue;}
				}
				col--;
			}
			break;
		case 3://오른쪽 이동
			//오른쪽  : col 고정 
			row =0;
			while(row<N) {
			for(int i = 0 ; i<N ;i ++) {//i: col board[row][i] -> board[row][i+1]
	//			System.out.println("row: "+row+", flag "+flag);
					if(!stop(row,i,row,i+1)) { //이동 가능
						board[row][i]= board[row][i+1];
						board[row][i] = 0;
					}
					else if(flag) {flag = false; row ++; continue;} //merge 하면 멈추고 다음애 이동
				}
				row++;
			}
			break;
		}
		arrange(direction);
	}
	
	/**
	 * move function 실행 후, 원래 이동하려던 방향으로 원소들을 옮긴다
	 * @param direction
	 * 0: 상
	 * 1: 하
	 * 2: 좌
	 * 3: 우
	 */
	private static void arrange(int direction) {
		switch (direction) {
		case 0: //하->상
			
			for(int i =0 ; i<N ;i++) { //가장 밑이랑 가까운 애들부터 봐야지 아래를 본다
				for(int j =0 ; j<N;j++) {
					if(board[i][j]!=0) {
						int endRow = end(0,0,j);//row를 찾고 col은 준다
						if(endRow==-1)continue;
					//	System.out.println("가장 왼쪽 의 빈칸 좌표 : row: "+endRow+" , col: "+j);
						if(endRow<i) {
							board[endRow][j] = board[i][j];
							board[i][j]=0;
						}
						
					}
				}
			}
			break;
		case 1://상->하
			for(int i = N-1 ; i>=0 ; i--) { //가장 밑이랑 가까운 애들부터 봐야지 아래를 본다
				for(int j = N-1 ; j>=0 ; j--) {
					if(board[i][j]!=0) {
						int endRow = end(1,0,j);//row를 찾고 col은 준다
						if(endRow==-1)continue;
						//System.out.println("가장 왼쪽 의 빈칸 좌표 : row: "+endRow+" , col: "+j);
						if(endRow>i) {
							board[endRow][j] = board[i][j];
							board[i][j]=0;
						}
						
					}
				}
			}
			
			break;
		case 2://우->좌
			for(int i = 0 ; i<N ; i++) {
				for(int j = 0  ; j<N ; j++) {
					if(board[i][j]!=0) {//비어있지 않다면 가장 오른쪽으로 푸쉬푸쉬
						int endIndex = end(2,i,0);
						if(endIndex==-1)continue;
						//System.out.println("가장 왼쪽 의 빈칸 좌표 : row: "+i+" , col: "+endIndex);
						if(endIndex<j) {
							board[i][endIndex] = board[i][j];
							board[i][j]=0;
						}
					}
				}
			}
			break;
		case 3:	//좌 -> 우
			for(int i = N-1 ; i>=0 ; i--) {//row
				for(int j = N-1 ; j>=0 ; j--) {
					if(board[i][j]!=0) { //비어있지 않은 경우 가장 끝으로 밀어버린다
						int endIndex = end(3,i,0);
						if(endIndex==-1)continue;
						if(endIndex>j) {
							//System.out.println("가장 오른쪽으 ㅣ빈칸 좌표 : row: "+i+" , col: "+endIndex);
							board[i][endIndex] = board[i][j];
							board[i][j] = 0;
						}
					}
				}
			}
			break;
		}
//		print();
	}
	
	/**
	 * 방향이 주어진 경우, 가장 끝에 있는 좌표를 구해주는 메서든
	 * */
	private static int end(int direction , int row, int col) {
		switch (direction) {
		case 0:
			for(int i = 0 ; i<N; i++) {
				if(board[i][col]==0)return i;
			}
			break;
		case 1: //아래로 이동
			for(int i = N-1 ; i>=0 ; i--) {
				if(board[i][col]==0)return i;
			}
			break;
		case 2: //왼쪽으로 이동
			for(int i = 0 ; i<N ; i++) {
				if(board[row][i]==0)return i;
			}
			break;
		case 3: //오른쪽으로 이동해야함
			for(int i = N-1 ; i>=0 ; i--) {
				if(board[row][i]==0)return i;
			}
			break;
		}
		return -1;
	}
	/**
	 * 벽이나 다른 블록이 있으면 이동할 수 없다
	 */
	private static boolean stop(int x, int y, int nx, int ny) {
		if(nx<0||nx>=N ||ny<0|| ny>=N) return true; //벽
		else if(board[nx][ny]!=0) {					//블록
			if(board[x][y]==board[nx][ny]) 			//같은 블록이 있는 경우
				{
					board[x][y] = 0 ;
					board[nx][ny] *= 2;
					flag = true;
					return true;
				}
			else {
				return true; 						//다른 블록이 있는 경우
			}
		}
		return false; 								//움직일 수 있음
	}
	/**
	 * Utilities
	 * Prints Board
	 */
	private static void print() {
		for(int i = 0 ; i<N ; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("============");
	}
	/*
	private static void reset() {
		
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				board[i][j] = original[i][j];
			}
		}
	}
	*/
	/** 
	 * 가장 큰 블록을 찾는다
	 */
	private static int getMaxValue() {
		int max = 0;
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				max = max<board[i][j]?board[i][j]:max;
			}
		}
		return max;
	}
	/**
	 * board 를 처음 배열로 되돌린다
	 */
	private static void reset() {
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				board[i][j] = original[i][j];
			}
		}
	}
}
