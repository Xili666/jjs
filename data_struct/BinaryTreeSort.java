public class BinaryTreeSort {

    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 5, 2, 1, 4, 6, 3, 2, 5, 7, 89, 2, 1, 4, 6, 0, 1};
        sort(array);
    }

    private static void sort(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            insert(root, array[i]);
        }
        travelInTree(root);
    }

    private static void travelInTree(TreeNode root) {
        if (root == null) {
            return;
        }
        travelInTree(root.lChild);
        System.out.print(root.data);
        travelInTree(root.rChild);
    }

    private static void insert(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (root.data > i) {
            if (root.lChild != null) {
                insert(root.lChild, i);
            } else {
                root.lChild = new TreeNode(i);
            }
        } else if (root.data < i) {
            if (root.rChild != null) {
                insert(root.rChild, i);
            } else {
                root.rChild = new TreeNode(i);
            }
        }
    }

    private static void debugLine(int[] array) {
        for (int h : array) {
            System.out.print(h + " ");
        }
        System.out.println();
    }

    static class TreeNode {
        int data;
        TreeNode lChild;
        TreeNode rChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}