/**
 * Created by yuan on 2018/2/17.
 */
public class  test<T> {
    static long j = 123L;
    static final int i = 12;
    static int ii = 9123;
    static final String strJ = "asdfasdf";
    static Double dJ = 12.3456;
    boolean flag;
    T gg;
    public  void f(int x){
        x ++;
        x --;
        System.out.println(x);
    }

    public <T> void g(T x) {

    }
    public static void main(String[] args) {
        System.out.println(1 == new Integer(1));
    }
}
