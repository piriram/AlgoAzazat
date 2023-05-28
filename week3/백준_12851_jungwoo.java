import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] count = new int[100001];

        Arrays.fill(count, INF);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(N, 0));
        boolean findMinDist = false;
        int minDist = 0;
        int result = 0;
        count[N] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.remove();

            if (findMinDist) { // 최단거리를 이미 찾은상황에서 다른 노드들도 확인.
                if (cur.depth > minDist) {
                    break;
                }

                if (cur.pos == K) {
                    result ++;
                }
            }

            if (cur.pos == K && !findMinDist) { // 처음 최단거리를 찾으면
                minDist = cur.depth;
                findMinDist = true;
                result ++;
            }

            int[] dx = {cur.pos, -1, 1};
            for (int i = 0; i < 3; i++) {
                int nx = cur.pos + dx[i];

                if (nx >= 0 && nx < 100001) {
                    if (count[cur.pos] + 1 <= count[nx] ) {
                        count[nx] = count[cur.pos] + 1;
                        queue.offer(new Point(nx, cur.depth + 1));
                    }
                }
            }
        }
        System.out.println(minDist);
        System.out.println(result);
    }
}

class Point {
    int pos;
    int depth;

    public Point(int pos, int depth) {
        this.pos = pos;
        this.depth = depth;
    }
}
