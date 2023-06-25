import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer, SetNode> sets;

    static int find(int nodeNumber) {
        SetNode temp = sets.get(nodeNumber);
        if (temp.getParent() == nodeNumber) {
            return nodeNumber;
        }

        temp.setParent(find(temp.getParent()));
        return temp.getParent();
    }

    static void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);

        if (rootA == rootB) {
            return;
        }

        SetNode parent = sets.get(rootA);
        SetNode child = sets.get(rootB);

        if (parent.getSize() < child.getSize()) {
            SetNode temp = parent;
            parent = child;
            child = temp;
        }

        child.setParent(parent.getParent());
        parent.addSize(child.getSize());
    }


    public static void main(String[] args) throws IOException {
        sets = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            sets.put(i, new SetNode(i, 1));
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < M - 1; i++) {
            if (root != find(Integer.parseInt(st.nextToken()))) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }
}

class SetNode {
    private int parent;
    private int size;

    SetNode(int parent, int size) {
        this.parent = parent;
        this.size = size;
    }

    public int getParent() {
        return parent;
    }

    public int getSize() {
        return size;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public void addSize(int num) {
        this.size += num;
    }
}
