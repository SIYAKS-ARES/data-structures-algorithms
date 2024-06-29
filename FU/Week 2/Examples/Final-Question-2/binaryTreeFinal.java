class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class binaryTreeFinal {
    /*
     * Verilen ağacın sol alt ağaç değerler toplamı çift ve sağ alt ağaç değerler toplamı tek ise 1 değilse 0 döndüren kod
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(checkTree(root));
    }

    /**
     * Verilen ağacın sol alt ağaç değerler toplamı çift ve sağ alt ağaç değerler toplamı tek ise 1 değilse 0 döndüren metot
     * @param root Kök düğüm
     * @return Sonuç (1 veya 0)
     */
    public static int checkTree(TreeNode root) {
        int leftSum = sumTree(root.left); // Sol alt ağacın değerlerinin toplamını al
        int rightSum = sumTree(root.right); // Sağ alt ağacın değerlerinin toplamını al

        // Sol alt ağacın toplamı çift ve sağ alt ağacın toplamı tek ise 1 döndür, aksi halde 0 döndür
        if (leftSum % 2 == 0 && rightSum % 2 != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Verilen düğüm altındaki tüm değerlerin toplamını hesaplayan metot
     * @param node Başlangıç düğümü
     * @return Toplam değer
     */
    public static int sumTree(TreeNode node) {
        if (node == null) {
            return 0; // Düğüm null ise 0 döndür
        }
        // Düğümün değeri + sol alt ağacın toplamı + sağ alt ağacın toplamı
        return node.val + sumTree(node.left) + sumTree(node.right);
    }
}