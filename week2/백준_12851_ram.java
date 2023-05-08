import java.util.*;

public class Main {
    static int N, K;
    static int[] check = new int[100001];
    static int[] count = new int[100001];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        if (N == K) {
            System.out.println(0);
            System.out.println(1);
        } else {
            bfs(N);
        }
    }
    
    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = 1;
        count[n] = 1;
        
        while (!q.isEmpty()) {
            int tmp = q.poll();
            
            for (int i = 0; i < 3; i++) {
                int next;
                
                if (i == 0) {
                    next = tmp + 1;
                } else if (i == 1) {
                    next = tmp - 1;
                } else {
                    next = tmp * 2;
                }
                
                if (next >= 0 && next < check.length) {
                    if (check[next] == 0) {
                        q.add(next);
                        check[next] = check[tmp] + 1;
                        count[next] = count[tmp];
                    } else if (check[next] == check[tmp] + 1) {
                        count[next] += count[tmp];
                    }
                }
            }
        }
        
        System.out.println(check[K] - 1);
        System.out.println(count[K]);
    }
}
