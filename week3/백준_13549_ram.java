
import java.util.*;
// 수빈이는 동생과 숨바꼭질을 하고 있다.
// 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
// 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

// 숨바꼭질 문제 골드4
public class boj13549 {
    // N: 수빈이의 위치, K: 동생의 위치, check: 방문 여부를 저장할 배열
    static int N, K;
    static int[] check = new int[100001];

    // 메인 함수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // 수빈이와 동생이 같은 위치에 있다면, 이동할 필요가 없다.
        if (N == K) {
            System.out.println(0);
        } else {
            // 수빈이와 동생의 위치가 다르다면 bfs 함수를 호출
            bfs(N);
        }
    }

    // 너비 우선 탐색
    static void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n,0}); //여기서 n은 위치,0은 시간을 나타낸다.
        // 자바에서 배열은 객체이므로 생성시킬때마다 생성자 키워드를 사용해서 메모리에 할당해줘야한다.
        check[n] = 1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll(); // 큐에서 하나를 꺼냄
            int position = tmp[0];
            int time = tmp[1];

            // 현재 위치에서 갈 수 있는 경우의 수는 총 3가지입
            for (int i = 0; i < 3; i++) {
                int nextPosition;
                int nextTime;

                // 1. 한 칸 앞으로 이동
                if (i == 0) {
                    nextPosition = position+1;
                    nextTime = time+1;
                }
                // 2. 한 칸 뒤로 이동
                else if (i == 1) {
                    nextPosition = position-1;
                    nextTime = time+1;
                }
                // 3. 순간이동
                else {
                    nextPosition = position * 2;
                    nextTime = time;
                }

                // 동생을 찾았다면 결과를 출력하고 종료
                if (nextPosition == K) {
                    System.out.println(nextTime);
                    return;
                }

                // 다음 위치가 범위 내에 있고, 방문하지 않았다면 큐에 추가
                if (nextPosition >= 0 && nextPosition < check.length && check[nextPosition] == 0) {
                    q.add(new int[]{nextPosition,nextTime});
                    check[nextPosition] = 1;
                }

            }
        }

    }
}
