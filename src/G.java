/**
 * Created with IntelliJ IDEA.
 * User: flyingleafe
 * Date: 03.11.13
 * Time: 0:25
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
import java.io.*;

public class G {
    FastScanner in;
    PrintWriter out;

    int n;
    int k;
    int[] bl;

    public void output() {
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < n; ++j) {
                if (bl[j] == i)
                    out.printf("%d ", j + 1);
            }
            out.write('\n');
        }
        out.write('\n');
    }

    public void gen(int p, int max) {
        if (p == n) {
            output();
            return;
        }
        int s = 0;
        if (n - p == k - max) {
            s = max;
        }
        for (int i = s; i <= Math.min(max, k - 1); ++i) {
            bl[p] = i;
            gen(p + 1, Math.max(max, i + 1));
        }
    }


    public void solve() throws IOException {
        n = in.nextInt();
        k = in.nextInt();
        bl = new int[n];
        gen(0, 0);
    }

    public void run() {
        try {
            in = new FastScanner(new File("part2sets.in"));
            out = new PrintWriter(new File("part2sets.out"));

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
        new G().run();
    }
}
