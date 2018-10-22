import java.util.Scanner;


/**
 * 二叉树回溯求幂集
 * 注意点:
 *     1. Math 是在java.lang
 */
public class PowerSet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] tree = new String[(int)Math.pow(2, n + 1) - 1];
        tree[0] = "";
        for (int i = 0; i < n; i++) {
            // 上一层的起始下标
            int s = (int)Math.pow(2, i) - 1;
            int l = (int)Math.pow(2, i + 1) - 2;
            int e = in.nextInt();
            for(int j = s; j <= l; j++) {
                tree[j * 2 + 1] = tree[j] + e;
                tree[j * 2 + 2] = tree[j];
            }
        }

        in.close();
        tree[(int)Math.pow(2, n + 1) - 2] = "NIL";
        for(int i = (int)Math.pow(2, n) - 1; i < (int)Math.pow(2, n + 1) - 1; i++){
            System.out.println(tree[i]);
        }
    }

}