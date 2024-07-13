public class Main2 {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        tree.inorder(); // Çıktı: 20 30 40 50 60 70 80
    }

    public static class AVLNode {
        int value, height;
        AVLNode left, right;

        AVLNode(int d) {
            value = d;
            height = 1;
        }
    }

    public static class AVLTree {
        AVLNode root;

        int height(AVLNode N) {
            if (N == null)
                return 0;
            return N.height;
        }

        int max(int a, int b) {
            return (a > b) ? a : b;
        }

        AVLNode rightRotate(AVLNode y) {
            AVLNode x = y.left;
            AVLNode T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;

            return x;
        }

        AVLNode leftRotate(AVLNode x) {
            AVLNode y = x.right;
            AVLNode T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;

            return y;
        }

        int getBalance(AVLNode N) {
            if (N == null)
                return 0;
            return height(N.left) - height(N.right);
        }

        AVLNode insert(AVLNode node, int value) {
            if (node == null)
                return new AVLNode(value);

            if (value < node.value)
                node.left = insert(node.left, value);
            else if (value > node.value)
                node.right = insert(node.right, value);
            else
                return node;

            node.height = 1 + max(height(node.left), height(node.right));

            int balance = getBalance(node);

            if (balance > 1 && value < node.left.value)
                return rightRotate(node);

            if (balance < -1 && value > node.right.value)
                return leftRotate(node);

            if (balance > 1 && value > node.left.value) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balance < -1 && value < node.right.value) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        void inorder() {
            inorderRec(root);
        }

        void inorderRec(AVLNode root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.value + " ");
                inorderRec(root.right);
            }
        }

        AVLNode singlerotateright(AVLNode p) {
            AVLNode lc = p.left;
            p.left = lc.right;
            lc.right = p;
            p.height = max(height(p.left), height(p.right)) + 1;
            lc.height = max(height(lc.left), lc.height) + 1;
            return lc;
        }

        AVLNode singlerotateleft(AVLNode p) {
            AVLNode rc = p.right;
            p.right = rc.left;
            rc.left = p;
            p.height = max(height(p.left), height(p.right)) + 1;
            rc.height = max(height(rc.right), rc.height) + 1;
            return rc;
        }

        AVLNode doublerotateright(AVLNode p) {
            p.left = singlerotateleft(p.left);
            return singlerotateright(p);
        }

        AVLNode doublerotateleft(AVLNode p) {
            p.right = singlerotateright(p.right);
            return singlerotateleft(p);
        }
    }
}