import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    final static int SIZE = 100000;
    static boolean[] visited = new boolean[SIZE + 1];

    static class Point {
        private int position;
        private int count;

        public Point(int position, int count) {
            this.position = position;
            this.count = count;
        }

        public int getPosition() {
            return position;
        }

        public int getCount() {
            return count;
        }
    }

    static void bfs(int start, int end) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start, 0));
        visited[start] = true;
        int[] dx;

        while (!queue.isEmpty()) {
            Point next = queue.remove();
            int cnt = next.getCount();

            if (next.getPosition() == end) {
                System.out.println(cnt);
                return;
            }

            dx = new int[]{1, -1, next.getPosition()};

            for (int i = 0; i < dx.length; i++) {
                int nx = next.getPosition() + dx[i];

                if (nx >= 0 && nx <= SIZE && !visited[nx]) {
                    queue.offer(new Point(nx, cnt + 1));
                    visited[nx] = true;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);
    }
}
