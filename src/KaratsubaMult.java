
public class KaratsubaMult {

    public static long Karatsuba(long x, long y){
        if(x < 10 || y < 10) return x*y;
        int maxBase = (int) Math.max(Math.log10(x), Math.log10(y)) + 1;
        int halfMax = (maxBase/2) + (maxBase%2);
        long a = x / (int) Math.pow(10, halfMax);
        long b = x % (int) Math.pow(10, halfMax);
        long c = y / (int) Math.pow(10, halfMax);
        long d = y % (int) Math.pow(10, halfMax);

        long ac =Karatsuba(a, c);
        long bd = Karatsuba(b, d);
        long abcd = Karatsuba((a+b), (c+d));
        abcd = abcd - ac - bd;

        return (long) ((ac*Math.pow(10, (2*halfMax))) + (abcd*Math.pow(10, halfMax)) + bd);
    }
}
