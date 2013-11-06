/**
 * Created by flyingleafe on 31.10.13.
 */

import java.util.*;
import java.io.*;

public class C {
    FastScanner in;
    PrintWriter out;

    int[] a;
    int n;
    int k;

    public void output() {
        for (int i = 0; i < k; ++i)
            out.printf("%d ", a[i]);
        out.write("\n");
    }

    public void gen(int p) {
        if (p == k) {
            output();
            return;
        }
        for (int i = (p > 0) ? a[p - 1] + 1 : 1; i <= p + 1 + n - k; ++i) {
            a[p] = i;
            gen(p + 1);
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        k = in.nextInt();
        a = new int[k];
        gen(0);
    }

    public void run() {
        try {
            in = new FastScanner(new File("choose.in"));
            out = new PrintWriter(new File("choose.out"));

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
        new C().run();
    }
}

