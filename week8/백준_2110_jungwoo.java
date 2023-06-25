import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int C;
    static int[] house;

    static boolean isPossible(int value) {
        int cur = house[0];
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (house[i] - cur >= value) {
                count++;
                cur = house[i];
            }
        }
        return count >= C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int lo = 1;
        int hi = house[N - 1] - house[0] + 1;

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
