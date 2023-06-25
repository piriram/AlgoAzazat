import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] budget;

    static boolean isPossible(int value) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (budget[i] <= value) {
                sum += budget[i];
            } else {
                sum += value;
            }
            if (sum > M) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        int maxBudget = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budget[i]);
        }

        M = Integer.parseInt(br.readLine());

        int lo = 1;
        int hi = maxBudget;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(hi);
    }
}
