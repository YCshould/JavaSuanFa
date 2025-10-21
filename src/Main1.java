import java.math.BigDecimal;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        // 类型转换的函数式接口
        // 第一个范式类型规定输入类型，第二个范式类型规定输出类型
//        Function<String,String> fun1=s->s.toUpperCase();
//        Function<String,String> fun2=fun1.andThen(s->s+"_"+s);
//        String str = fun2.apply("hello");
//        System.out.println(str);
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int nextInt2 = scanner.nextInt();
        BigDecimal[] a = new BigDecimal[nextInt];
        for (int i = 0; i < nextInt; i++) {
            a[i] = new BigDecimal(scanner.next());
        }
        for (BigDecimal bigDecimal : a) {
            System.out.println(bigDecimal);
        }
        System.out.println("nextInt=" + nextInt);
        System.out.println("nextInt2=" + nextInt2);
        System.out.println("end");

        System.out.println("git第一次提交");
        System.out.println("git第一次提交");
        System.out.println("git第一次提交");

        System.out.println("git第二次提交");
        System.out.println("git第二次提交");
        System.out.println("git第二次提交");

        System.out.println("git第三次提交");
        System.out.println("git第三次提交");
        System.out.println("git第三次提交");

        System.out.println("git第三次提交");
        System.out.println("git第三次提交");
        System.out.println("git第三次提交");

        System.out.println("branch_1分支的git第一次提交");
        System.out.println("branch_1分支的git第一次提交");
        System.out.println("branch_1分支的git第一次提交");



    }

}


