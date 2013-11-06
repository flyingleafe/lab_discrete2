/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 02.11.13
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
import java.io.*;

public class F {
    FastScanner in;
    PrintWriter out;

    int[] a;
    int n;

    public void output(int p) {
        for (int i = 0; i < p; ++i)
            out.printf("%d ", a[i]);
        out.write("\n");
    }

    public void gen(int p) {
        if (p == n) {
            return;
        }
        for (int i = (p > 0) ? a[p - 1] + 1 : 1; i <= n; ++i) {
            a[p] = i;
            output(p + 1);
            gen(p + 1);
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        a = new int[n];
        out.write('\n');
        gen(0);
    }

    public void run() {
        try {
            in = new FastScanner(new File("subsets.in"));
            out = new PrintWriter(new File("subsets.out"));

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
        new F().run();
    }
}
