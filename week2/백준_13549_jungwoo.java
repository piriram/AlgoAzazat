import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static final int MAX_SIZE = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX_SIZE];

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(N, 0));

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            visited[cur.pos] = true;

            if (cur.pos == K) {
                System.out.println(cur.depth);
                return;
            }

            int[] dx = {cur.pos, 1, -1};

            for (int i = 0; i < 3; i++) {
                int nx = cur.pos + dx[i];

                if (nx >= 0 && nx < MAX_SIZE && !visited[nx]) {
                    if (i == 0) {
                        queue.offer(new Point(nx, cur.depth));
                    } else {
                        queue.offer(new Point(nx, cur.depth + 1));
                    }
                }
            }
        }
    }
}

class Point implements Comparable<Point> {
    int pos;
    int depth;

    public Point(int pos, int depth) {
        this.pos = pos;
        this.depth = depth;
    }

    @Override
    public int compareTo(Point o) {
        return depth - o.depth;
    }
}
