class TreeNode // Düğüm Sınıfı
{
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public void displayNode() {
        System.out.print(" " + data + " ");
    }
}

class Tree // Ağaç Sınıfı
{
    private TreeNode root;

    public Tree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    // Ağacın preOrder Dolaşılması
    public void preOrder(TreeNode localRoot) {
        if (localRoot != null) {
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // Ağacın inOrder Dolaşılması
    public void inOrder(TreeNode localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    // Ağacın postOrder Dolaşılması
    public void postOrder(TreeNode localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

    // Ağaca bir düğüm eklemeyi sağlayan metot
    public void insert(int newdata) {
        TreeNode newNode = new TreeNode();
        newNode.data = newdata;
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (newdata < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}

public class BinTree // BinTree Test Sınıfı
{
    public static void main(String[] args) {
        Tree theTree = new Tree();
        // Ağaca 10 tane sayı yerleştirilmesi
        System.out.println("Sayılar: ");
        for (int i = 0; i < 10; ++i) {
            int sayi = (int) (Math.random() * 100);
            System.out.print(sayi + " ");
            theTree.insert(sayi);
        }
        System.out.print("\nAğacın InOrder Dolaşılması: ");
        theTree.inOrder(theTree.getRoot());
        System.out.print("\nAğacın PreOrder Dolaşılması: ");
        theTree.preOrder(theTree.getRoot());
        System.out.print("\nAğacın PostOrder Dolaşılması: ");
        theTree.postOrder(theTree.getRoot());
    }
}
