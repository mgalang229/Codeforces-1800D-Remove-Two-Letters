import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

note:
always = original length - 2

------------------------------------

6
aaabcc

abcc
abcc (x)
aacc
aaac
aaab

answer = 4

------------------------------------

7
abacaba

acaba
acaba (x)
ababa
ababa (x)
abaca
abaca (x)

answer = 3

------------------------------------

10
abbaccabba

baccabba
aaccabba
abccabba
abbcabba
abbaabba
abbacbba
abbaccba
abbaccaa
abbaccab

answer = 9

------------------------------------

best = n - 1

12
abbbacccabba

bbacccabba
abacccabba
abacccabba (x)
abbcccabba
abbbccabba
abbbacabba
abbbacabba (x)
abbbaccbba
abbbacccba
abbbacccaa
abbbacccab

answer = 9

------------------------------------

12
acccccccabba

ccccccabba
acccccabba
acccccabba (x)
acccccabba (x)
acccccabba (x)
acccccabba (x)
acccccabba (x)
accccccbba
acccccccba
acccccccaa
acccccccab

answer = 6

= freq[letter] - 2

------------------------------------

5
ababa

aba
aba (x)
aba (x)
aba (x)

answer = 1

------------------------------------

producing duplicates: 

(1) substring with equal letters >= 3,
	
	

(2) 3-letter palindrome,

	i - 2 >= 0 and if a[i] is equal to a[i-2]

 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			char[] s = fs.next().toCharArray();
			int count = 0;
			for (int i = 2; i < n; i++) {
				if (s[i] == s[i-2]) {
					count++;
				}
			}
			System.out.println(n - 1 - count);
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
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
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
