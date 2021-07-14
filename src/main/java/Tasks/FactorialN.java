package Tasks;

public class FactorialN {


    private static long rez = 0;
    private static long n = 3;

    public static void main(String[] args) {
        System.out.println(func(n));

    }

    public static long func(long n) {
        if (n <= 1) {
            return 1;
        }else
            rez = 1;
        for (int i = 2; i<=n; i++)
            rez = rez * i;
        return rez;
    }

}

