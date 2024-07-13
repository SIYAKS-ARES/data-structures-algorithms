import java.util.*;

public class Main {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        TreeNode root;

        public BinaryTree() {
            root = null;
        }

        // Düğüm ekleme
        public void add(int value) {
            root = addRecursive(root, value);
        }

        private TreeNode addRecursive(TreeNode current, int value) {
            if (current == null) {
                return new TreeNode(value);
            }

            if (value < current.value) {
                current.left = addRecursive(current.left, value);
            } else if (value > current.value) {
                current.right = addRecursive(current.right, value);
            }

            return current;
        }

        // Ağaçta bir değerin bulunup bulunmadığını kontrol etme
        public boolean containsNode(int value) {
            return containsNodeRecursive(root, value);
        }

        private boolean containsNodeRecursive(TreeNode current, int value) {
            if (current == null) {
                return false;
            }

            if (value == current.value) {
                return true;
            }

            return value < current.value
                    ? containsNodeRecursive(current.left, value)
                    : containsNodeRecursive(current.right, value);
        }

        // Önceden sırayla gezinme (Pre-order Traversal)
        public void traversePreOrder(TreeNode node) {
            if (node != null) {
                System.out.print(" " + node.value);
                traversePreOrder(node.left);
                traversePreOrder(node.right);
            }
        }

        // Sıralı gezinme (In-order Traversal)
        public void traverseInOrder(TreeNode node) {
            if (node != null) {
                traverseInOrder(node.left);
                System.out.print(" " + node.value);
                traverseInOrder(node.right);
            }
        }

        // Sonradan sırayla gezinme (Post-order Traversal)
        public void traversePostOrder(TreeNode node) {
            if (node != null) {
                traversePostOrder(node.left);
                traversePostOrder(node.right);
                System.out.print(" " + node.value);
            }
        }

        // Ağaçtaki en küçük değeri bulma
        public int findMin() {
            return findMinRecursive(root);
        }

        private int findMinRecursive(TreeNode current) {
            return current.left == null ? current.value : findMinRecursive(current.left);
        }

        // Ağaçtaki en büyük değeri bulma
        public int findMax() {
            return findMaxRecursive(root);
        }

        private int findMaxRecursive(TreeNode current) {
            return current.right == null ? current.value : findMaxRecursive(current.right);
        }
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        System.out.println("In-order traversal:");
        tree.traverseInOrder(tree.root);
        System.out.println();

        System.out.println("Pre-order traversal:");
        tree.traversePreOrder(tree.root);
        System.out.println();

        System.out.println("Post-order traversal:");
        tree.traversePostOrder(tree.root);
        System.out.println();

        System.out.println("Tree contains 5: " + tree.containsNode(5));
        System.out.println("Tree contains 10: " + tree.containsNode(10));

        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSeçiminizi yapın: 1. Ekle, 2. Getir, 3. Kaldır, 4. In-order Gezin, 5. Pre-order Gezin, 6. Post-order Gezin, 7. En küçük değeri bul, 8. En büyük değeri bul, 9. Çıkış");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Anahtar: ");
                    int keyToAdd = scanner.nextInt();
                    tree.add(keyToAdd);
                    break;

                case 2:
                    System.out.print("Anahtar: ");
                    int keyToGet = scanner.nextInt();
                    boolean found = tree.containsNode(keyToGet);
                    if (found) {
                        System.out.println("Anahtar bulundu.");
                    } else {
                        System.out.println("Anahtar bulunamadı.");
                    }
                    break;

                case 3:
                    System.out.println("Kaldırma işlemi henüz uygulanmadı.");
                    break;

                case 4:
                    System.out.println("In-order traversal:");
                    tree.traverseInOrder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Pre-order traversal:");
                    tree.traversePreOrder(tree.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Post-order traversal:");
                    tree.traversePostOrder(tree.root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Minimum value: " + tree.findMin());
                    break;

                case 8:
                    System.out.println("Maximum value: " + tree.findMax());
                    break;

                case 9:
                    scanner.close();
                    System.out.println("Çıkış yapılıyor.");
                    return;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}