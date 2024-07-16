class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {
    public static void main(String[] args) {
        // Ağacı oluştur
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Fonksiyonu çağır ve sonucu yazdır
        int result = checkTree(root);
        System.out.println(result);
    }

    public static int checkTree(TreeNode root) {
        // Sol alt ağacın toplamını hesapla
        int leftSum = sumTree(root.left);

        // Sağ alt ağacın toplamını hesapla
        int rightSum = sumTree(root.right);

        // Sol alt ağaç toplamı çift ve sağ alt ağaç toplamı tek ise 1, aksi takdirde 0 döndür
        if (leftSum % 2 == 0 && rightSum % 2 != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // Ağaçtaki tüm düğümlerin toplamını hesaplayan yardımcı fonksiyon
    private static int sumTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sumTree(node.left) + sumTree(node.right);
    }
}