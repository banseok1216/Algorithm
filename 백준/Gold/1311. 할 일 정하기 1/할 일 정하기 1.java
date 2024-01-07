import java.util.*;

class Edge {
    public int v, c, f, w;
    public Edge rev;

    public Edge(int v, int c, int w) {
        this.v = v;
        this.c = c;
        this.f = 0;
        this.w = w;
    }

    public boolean pos() {
        return c > f;
    }

    public void flow(int mf) {
        f += mf;
        rev.f -= mf;
    }
}

public class Main {
    static List<Edge>[] con;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        con = new ArrayList[42];
        for (int i = 0; i < 42; i++) {
            con[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int w = scanner.nextInt();
                addedge(i, j + n, w);
            }
        }

        int src = 2 * n;
        int snc = 2 * n + 1;

        for (int i = 0; i < n; i++)
            addedge(src, i, 0);

        for (int i = 0; i < n; i++)
            addedge(i + n, snc, 0);

        System.out.println(mcmf(src, snc));
    }

    static void addedge(int u, int v, int w) {
        Edge edge = new Edge(v, 1, w);
        Edge rev = new Edge(u, 0, -w);
        edge.rev = rev;
        rev.rev = edge;
        con[u].add(edge);
        con[v].add(rev);
    }

    static int mcmf(int src, int snc) {
        int res = 0, flow = 0;
        int[] par = new int[42];
        int[] d = new int[42];
        boolean[] in = new boolean[42];
        Edge[] trace = new Edge[42];

        while (true) {
            Arrays.fill(par, -1);
            Arrays.fill(d, -1);
            Arrays.fill(in, false);
            d[src] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(src);

            while (!q.isEmpty()) {
                int u = q.poll();
                in[u] = false;

                for (int i = 0; i < con[u].size(); i++) {
                    Edge edge = con[u].get(i);
                    int v = edge.v, w = edge.w;

                    if (!edge.pos()) continue;

                    if (par[v] < 0 || (d[v] < 0 || d[v] > d[u] + w)) {
                        par[v] = u;
                        d[v] = d[u] + w;
                        trace[v] = edge;

                        if (!in[v]) {
                            in[v] = true;
                            q.add(v);
                        }
                    }
                }
            }

            if (d[snc] < 0) return res;
            res += d[snc];
            flow++;

            for (int cur = snc; cur != src; cur = par[cur])
                trace[cur].flow(1);
        }
    }
}
