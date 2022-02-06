package 백준_02072022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 인풋을 받을 때, 회전하는 애들도 같이 저장해준다!
 * 먼저 다 받고 회전 x -> 받으면서 그 대칭되는 좌표에 찍음
 * 예상 좌표 : 다음 방향저장
 * @author June Park
 *
 */
public class 골드_15685_드래곤커브 {

	static int[] dy = {0,-1,0,1};//우 상 하 좌
	static int[] dx = {1,0,-1,0};
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map =  new boolean[101][101];//맵 -> 거꾸로 되어있음y,x
		int x, y ,d ,g;

		for(int i = 0 ; i < N ; i ++ ) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());//x좌표
			y = Integer.parseInt(st.nextToken());//y좌표
			d = Integer.parseInt(st.nextToken());//direction
			g = Integer.parseInt(st.nextToken());//generation
			solution(x,y,d,g);
		}//end of input + 좌표
		
		br.close();
		bw.write(count()+"\n");
		bw.flush();
		bw.close();
	}
	
	public static void solution(int x, int y ,int d, int g){
		int[] curve = new int[1024];//커브 방향을 저장 2^10
		int curve_size = 0;//커브의 인덱스
		
		curve[curve_size++] = d;//커브의 방향 저장->index 포인터 다음으로
		map[y][x] = true;		//방문처리
		
		//커브 방향 넣기
		for(int j = 0 ; j < g ; j++) {//세대 수 만큼 커브 돌기 -> 0이면 점하나, 1이면 한번...
		//	System.out.println("curve size "+curve_size);
			for(int k = curve_size-1; k>=0; k--) {//역순으로 회전하기 때문에 거꾸로 돈다
				curve[curve_size++] = (curve[k]+1) % 4;//현재 커브 방향에 1을 더하면 90도 회전한 방향이 나옴(4로나눠서 범위지킴)
			}
		}
		//커브 방향에 따라서 맵에 찍기
		for(int j = 0 ; j< curve_size;j++) {
			x += dx[curve[j]];
			y += dy[curve[j]];
			if(x<0||y<0||x>=101||y>=101)continue;//범위 out
		//	System.out.println(x+","+y);
			map[y][x] = true;//else 좌표 찍기
		}
	}
	
	/**
	 * util
	 * @return
	 */
	public static int count() {
		int cnt = 0;//count answer
		for(int i = 0 ; i<100 ; i++) {		//꼭짓점이 모두 드래곤 커브 -> 정사각형 찾기
			for(int j = 0 ; j<100 ; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					cnt++;
					//System.out.printf("%d,%d %d,%d %d,%d %d,%d\n",i,j,(i+1),j,(i),(j+1),(i+1),(j+1));
				}
			}
		}
		return cnt;
	}

}
