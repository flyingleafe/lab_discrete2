/**
 * Created by flyingleafe on 31.10.13.
 */

import java.util.*;
import java.io.*;

public class B {
    FastScanner in;
    PrintWriter out;

    int[] a;
    boolean[] used;
    int n;

    public void output() {
        for (int i = 0; i < n; ++i)
            out.printf("%d ", a[i]);
        out.write("\n");
    }

    public void gen(int p) {
        if (p == n) {
            output();
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (!used[i - 1]) {
                a[p] = i;
                used[i - 1] = true;
                gen(p + 1);
                used[i - 1] = false;
            }
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        a = new int[n];
        used = new boolean[n];
        gen(0);
    }

    public void run() {
        try {
            in = new FastScanner(new File("permutations.in"));
            out = new PrintWriter(new File("permutations.out"));

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
        new B().run();
    }
}
