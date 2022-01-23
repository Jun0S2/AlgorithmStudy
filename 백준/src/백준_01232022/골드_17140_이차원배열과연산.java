package 백준_01232022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 골드 4
 * 삼성 sw 역량평가 기출
 * 
 * PriorityQueue사용
 * 블로그들 많이 찾아보고 풀었다.
 * 행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다. 이 부분을 간과했었다
 * 또, 따로 메서드를 만들어서 0 만난 인덱스 -1 로 최대 row 혹은 col을 구해서
 * 더 큰 숫자인 경우 row면 true col은 false를 리턴했었는데 아래 방식은 바로 열/행 길이를
 * 갱신할 수 있었다...
 * 막상 풀이를 보고나니 쉬운 문제였지만 보기 전까진 감이 잘 안잡힌 문제였다.
 * @author June Park
 *
 */
public class 골드_17140_이차원배열과연산 {
static int [][] map ;
static int time,r,c,k ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		r--;//인덱스 1부터 시작
		c--;
	
		map = new int[101][101];
		
		for(int i = 0 ; i<3 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<3 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//초기화 
		time = -1;
		R = 3;
		C = 3;
		simulation();
	}
	/**
	 * 100초동안 진행
	 */
	static int R,C;
	private static void simulation() {
		for(int i = 0 ; i<=100 ; i++) {
			if(map[r][c]==k) {//찾음
				time = i;
				break;
			}
			if(R>=C) {//R연산
				int nc = 0;
				for(int j = 0 ; j<R ; j++) {
					PriorityQueue<Number>  q = new PriorityQueue<>();
					int[] cnt = new int[101];//각 각 숫자가 몇 개 나왔는지 카운트 값을 저장하는 배열
					for(int k = 0 ; k<C ; k++) {//count 
						cnt[map[j][k]]++;
						map[j][k] = 0;//초기화
					}
					for(int m = 1; m<101 ; m++) {//count한 값을 저장
						if(cnt[m]>0)q.add(new Number(m,cnt[m]));//큐에 해당 숫자와 센 횟수 추가
					}
					int index = 0;//지도 위에 뿌려줄 인덱스
					while(!q.isEmpty()) {//모든 숫자 지도에 뿌려준다
						Number n = q.poll();
					//	System.out.println("숫자 : "+n.num+" 횟수 : "+n.count);
						map[j][index++] = n.num;
						map[j][index++] = n.count;
					}
					if(nc<index) {// 열 길이 갱신
						nc = index;
					}
				}
				C = nc;
			}
			else {//C연산
				int nr = 0;
				for(int j = 0 ; j<C ; j++) {
					PriorityQueue<Number> q2 = new PriorityQueue<>();
					int [] cnt = new int[101];
					for(int k = 0 ; k<R ; k++) {
						cnt[map[k][j]]++;
						map[k][j] = 0;//초기화
					}
					for(int m =  1; m<101 ; m++) if(cnt[m]>0)q2.add(new Number(m,cnt[m]));
					int index = 0;
					while(!q2.isEmpty()) {
						Number n = q2.poll();
						//	System.out.println("숫자 : "+n.num+" 횟수 : "+n.count);
						map[index++][j] = n.num;
						map[index++][j] = n.count;
					}
					if(nr<index)nr = index;//행 갱싲
				}
				R = nr;
			}//end of else
		}//end of for
		System.out.println(time);
	}
	
	
	public static class Number implements Comparable<Number>{
		int num, count;
		Number(int num, int count){
			this.num = num;
			this.count =  count;
		}
		@Override
		public int compareTo(Number o) {
			//등장횟수가 커지는 순으로
			if(o.count == this.count) {//등장 횟수가 같다면 숫자가 커지는 순으로
				return this.num - o.num;
			}
			return this.count - o.count;
		}
	}

}
