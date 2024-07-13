class AVLNode {
    int value, height;
    AVLNode left, right;

    AVLNode(int d) {
        value = d;
        height = 1;
    }
}

class AVLTree {
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
}

public class Main {
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
}

/*BinaryTree ile Farklar
Denge Kontrolü:

İkili ağaçta herhangi bir denge kontrolü yapılmaz. Bu nedenle ağacın dengesiz hale gelme olasılığı
yüksektir.
AVL ağaçlarında her ekleme veya silme işleminden sonra ağacın dengesi kontrol edilir ve gerekirse
ağacın dengesi sağlanır.
Dönüş İşlemleri:

İkili ağaçlarda dönüş işlemleri yoktur.
AVL ağaçlarında dönüş işlemleri (sağ ve sol dönüşler) ağacın dengeli kalması için kullanılır.
Performans:

İkili ağaçlar dengesiz hale geldiğinde arama, ekleme ve silme işlemlerinin performansı
𝑂(𝑛)
O(n) olabilir.
AVL ağaçları her zaman dengeli olduğu için bu işlemlerin performansı
𝑂(log𝑛)
O(logn) olur.
Bu kod örnekleriyle farkları ve çalışma mantığını görebilirsin.
Her iki ağaç türünü de belirli ihtiyaçlara göre seçip kullanabilirsin. */

/*Bu AVL Tree kodu, Binary Tree'den farklı olarak, ekleme işlemleri sırasında dengeyi korumak için
gerekli dönüş (rotate) işlemlerini gerçekleştirir.
height, get_balance, left_rotate ve right_rotate fonksiyonları, AVL ağacının dengesini sağlamak için
kullanılır. AVL Tree'de, her ekleme işleminden sonra ağacın dengesi kontrol edilir ve gerekirse dönüş
işlemleri yapılır.

Özetle, AVL Tree'ye geçiş yaparken dikkat etmen gereken en önemli noktalar:

Her ekleme ve silme işleminden sonra ağacın dengesini kontrol etmek.
Denge faktörünü hesaplayarak gerekli dönüş işlemlerini gerçekleştirmek.
Bu geçiş sırasında, AVL Tree'nin kendi kendini dengeleyen yapısının getirdiği ek karmaşıklıkları
anlamak önemlidir. Kod örnekleri üzerinde pratik yaparak bu farkları daha iyi kavrayabilirsin. */