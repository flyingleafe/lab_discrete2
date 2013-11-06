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
    int[] counts;
    int[][] a;
    boolean[] used;

    public void gen2(int[] c, int) {

    }

    public void gen1(int p, int sum) {
        if (sum == n) {
            gen2(counts.clone(), 0, 0);
            return;
        }
        if (p == k) {
            return;
        }
        for (int i = (p > 0) ? counts[p - 1] : 1; i <= n / k; ++i) {
            counts[p] = i;
            gen1(p + 1, sum + i);
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        k = in.nextInt();
        counts = new int[k];
        used = new boolean[n];
        a = new int[k][n];
        gen1(0, 0);
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
