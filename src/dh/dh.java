package dh;

import java.math.BigInteger;
import java.util.Random;

public class dh {
    // 用于判断一个数是否为素数的方法
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 计算两个数的最大公约数的方法
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    // 计算 b^n mod m 的方法
    public static int ExpMod(int b, int n, int m) {
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = (int)(((long)res * b) % m);
            b = (int)(((long)b * b) % m);
            n /= 2;
        }
        return res;
    }

    // 判断 g 是否为模 p 乘的生成元的方法
    public static boolean isPrimeRoot(int g, int p) {
        if (GCD(g, p) != 1) return false; // 如果 g 和 p 不互质，那么 g 不可能是生成元
        for (int i = 2; i < p; i++) {
            if (ExpMod(g, i, p) == 1) return false; // 如果 g^i ≡ 1 (mod p)，那么 g 不是生成元
        }
        return true;
    }

    public static void main(String[] args) {
        // 随机选择一个素数 p 和一个生成元 g
        Random rnd = new Random();
        BigInteger p, g;
        do {
            p = BigInteger.probablePrime(1024, rnd);
        } while (!isPrime(p.intValue()));
        do {
            g = new BigInteger(p.bitLength(), rnd);
        } while (g.compareTo(p) >= 0 || !isPrimeRoot(g.intValue(), p.intValue()));

        // A 随机选择一个 x，计算 X = g^x mod p
        BigInteger x = new BigInteger(p.bitLength(), rnd);
        BigInteger X = g.modPow(x, p);

        // B 随机选择一个 y，计算 Y = g^y mod p
        BigInteger y = new BigInteger(p.bitLength(), rnd);
        BigInteger Y = g.modPow(y, p);

        // A 计算 k = Y^x mod p，B 计算 k = X^y mod p
        BigInteger k1 = Y.modPow(x, p);
        BigInteger k2 = X.modPow(y, p);

        // A 和 B 得到的 k 应该相等
        if (k1.equals(k2)) {
            System.out.println("Success! A and B have agreed on a secret key: " + k1.toString(16));
        } else {
            System.out.println("Error! A and B have NOT agreed on a secret key.");
        }
    }
}

