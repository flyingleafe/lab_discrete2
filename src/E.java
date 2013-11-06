/**
 * Created by flyingleafe on 01.11.13.
 */

import java.util.*;
import java.io.*;

public class E {
    FastScanner in;
    PrintWriter out;

    int[] a;
    int n;

    public void output(int p) {
        for (int i = 0; i < p - 1; ++i)
            out.printf("%d+", a[i]);
        out.printf("%d", a[p - 1]);
        out.write("\n");
    }

    public void gen(int p, int sum) {
        if (sum == n) {
            output(p);
            return;
        }
        for (int i = (p > 0) ? a[p - 1] : 1; i <= n - sum; ++i) {
            a[p] = i;
            gen(p + 1, sum + i);
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        a = new int[n];
        gen(0, 0);
    }

    public void run() {
        try {
            in = new FastScanner(new File("partition.in"));
            out = new PrintWriter(new File("partition.out"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new E().run();
    }
}

