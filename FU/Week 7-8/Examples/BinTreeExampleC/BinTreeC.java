import java.util.Scanner;

class TNode {
    int data;
    TNode leftChild;
    TNode rightChild;

    public TNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinarySearchTree {
    private TNode root;

    // Düğüm ekleme
    public TNode insert(TNode root, int val) {
        System.out.println("Ağaca eklendi");

        TNode temp1 = root;
        TNode temp2 = null;

        if (root == null) {
            root = new TNode(val);
            if (root == null) {
                System.out.println("Erişim izni yok");
                System.exit(0);
            }
            return root;
        }

        while (temp1 != null) {
            temp2 = temp1;
            if (temp1.data > val) {
                temp1 = temp1.leftChild;
            } else {
                temp1 = temp1.rightChild;
            }
        }

        if (temp2.data > val) {
            temp2.leftChild = new TNode(val);
            temp2 = temp2.leftChild;
            if (temp2 == null) {
                System.out.println("Erişim izni yok");
                System.exit(0);
            }
            temp2.data = val;
            temp2.leftChild = null;
            temp2.rightChild = null;
        } else {
            temp2.rightChild = new TNode(val);
            temp2 = temp2.rightChild;
            if (temp2 == null) {
                System.out.println("Erişim izni yok");
                System.exit(0);
            }
            temp2.data = val;
            temp2.leftChild = null;
            temp2.rightChild = null;
        }

        return root;
    }

    // Düğüm silme
    public TNode delete1(TNode root, int val) {
        TNode[] result = getPtr(root, val);
        TNode x = result[0];
        TNode y = result[1];
        TNode temp;

        if (x == null) {
            System.out.println("Düğüm mevcut değil");
            return root;
        } else {
            // Kök düğümü silme
            if (x == root) {
                System.out.println("Kök düğüm siliniyor");
                temp = x.leftChild;
                y = x.rightChild;
                root = temp;

                while (temp.rightChild != null) {
                    temp = temp.rightChild;
                }

                temp.rightChild = y;
                free(x);
                return root;
            }

            // Birden fazla çocuğu olan düğümü silme
            if (x.leftChild != null && x.rightChild != null) {
                if (y.leftChild == x) {
                    temp = x.leftChild;
                    y.leftChild = x.leftChild;

                    while (temp.rightChild != null) {
                        temp = temp.rightChild;
                    }

                    temp.rightChild = x.rightChild;
                    x.leftChild = null;
                    x.rightChild = null;
                } else {
                    temp = x.rightChild;
                    y.rightChild = x.rightChild;

                    while (temp.leftChild != null) {
                        temp = temp.leftChild;
                    }

                    temp.leftChild = x.leftChild;
                    x.leftChild = null;
                    x.rightChild = null;
                }

                free(x);
                return root;
            }

            // Bir tane çocuğu veya hiç çocuğu olmayan düğümü silme
            if (x.leftChild == null && x.rightChild != null) {
                if (y.leftChild == x) {
                    y.leftChild = x.rightChild;
                } else {
                    y.rightChild = x.rightChild;
                }

                x.rightChild = null;
                free(x);
                return root;
            }

            if (x.leftChild != null && x.rightChild == null) {
                if (y.leftChild == x) {
                    y.leftChild = x.leftChild;
                } else {
                    y.rightChild = x.leftChild;
                }

                x.leftChild = null;
                free(x);
                return root;
            }
        }
        return root; // Added to ensure all paths return a value
    }

    // Inorder Dolaşma
    public void inorder1(TNode root) {
        TNode[] stack = new TNode[100]; // Changed stack to store TNode objects
        int top = -1;

        if (root != null) {
            stack[++top] = root;
            root = root.leftChild;

            while (top >= 0) {
                while (root != null) {
                    stack[++top] = root;
                    root = root.leftChild;
                }

                root = stack[top];
                top--;
                System.out.print(root.data + " ");
                root = root.rightChild;

                if (root != null) {
                    stack[++top] = root;
                    root = root.leftChild;
                }
            }
        }
    }

    // Yardımcı fonksiyonlar
    private TNode[] getPtr(TNode root, int val) {
        TNode y = null;
        while (root != null && root.data != val) {
            y = root;
            if (root.data > val) {
                root = root.leftChild;
            } else {
                root = root.rightChild;
            }
        }

        return new TNode[]{root, y};
    }

    private void free(TNode node) {
        // Java'da garbage collector otomatik olarak bellek tahsisini serbest bırakır.
        // C++'daki gibi manuel bellek yönetimi gerekmez.
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        TNode root = null;

        int n, x;

        System.out.print("Ağaca eklenecek düğüm sayısını giriniz:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Eklenecek değeri giriniz:");
            x = scanner.nextInt();
            root = tree.insert(root, x);
        }

        System.out.println("\nOluşturulan ağaç:");
        tree.inorder1(root);

        System.out.print("\nSilinecek düğümün değerini giriniz:");
        x = scanner.nextInt();
        root = tree.delete1(root, x);

        System.out.println("\nDüğüm silindikten sonra ağaç:");
        tree.inorder1(root);
        scanner.close();
    }
}