/**
 * Created by flyingleafe on 31.10.13.
 */

import java.util.*;
import java.io.*;

public class A {
    FastScanner in;
    PrintWriter out;

    int[] a;
    int n;
    ArrayList<int[]> vecs;

    public void gen(int p) {
        if (p == n) {
            vecs.add(a.clone());
            return;
        }
        for (int i = 0; i < 2; ++i) {
            if ((i == 0) || (p == 0) || (a[p - 1] == 0)) {
                a[p] = i;
                gen(p + 1);
            }
        }
    }

    public void solve() throws IOException {
        n = in.nextInt();
        a = new int[n];
        vecs = new ArrayList<int[]>();
        gen(0);
        out.printf("%d\n", vecs.size());
        for (int i = 0; i < vecs.size(); ++i) {
            for (int j = 0; j < n; ++j) {
                out.printf("%d", vecs.get(i)[j]);
            }
            out.write("\n");
        }
    }

    public void run() {
        try {
            in = new FastScanner(new File("vectors.in"));
            out = new PrintWriter(new File("vectors.out"));

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
        new A().run();
    }
}
