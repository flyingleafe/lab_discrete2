/**
 * Created by flyingleafe on 31.10.13.
 */

import java.util.*;
import java.io.*;

public class D {
    FastScanner in;
    PrintWriter out;

    char[] a;
    int n;

    public void gen(int p, int b) {
        if (p == n) {
            out.write(a);
            out.write("\n");
            return;
        }
        for (char c = '('; c <= ')'; c++) {
            if (((c == '(') && (n - p >= b + 1)) || ((c == ')') && (b - 1 >= 0))) {
                a[p] = c;
                gen(p + 1, b + ((c == '(') ? 1 : -1));
            }
        }
    }

    public void solve() throws IOException {
        n = in.nextInt() * 2;
        a = new char[n];
        gen(0, 0);
    }

    public void run() {
        try {
            in = new FastScanner(new File("brackets.in"));
            out = new PrintWriter(new File("brackets.out"));

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
        new D().run();
    }
}
