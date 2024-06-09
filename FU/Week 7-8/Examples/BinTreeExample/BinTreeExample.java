// Source code is decompiled from a .class file using FernFlower decompiler.
class Node {
   int data;
   Node left;
   Node right;
   Node(int var1) {
      this.data = var1;
      this.left = this.right = null;
   }
}

// Source code is decompiled from a .class file using FernFlower decompiler.
class Tree {
   Node root = null;
   Tree() {
   }
   void insert(int var1) {
      this.root = this.insertRec(this.root, var1);
   }
   Node insertRec(Node var1, int var2) {
      if (var1 == null) {
         var1 = new Node(var2);
         return var1;
      } else {
         if (var2 < var1.data) {
               var1.left = this.insertRec(var1.left, var2);
         } else if (var2 > var1.data) {
               var1.right = this.insertRec(var1.right, var2);
         }
         return var1;
      }
   }

   void inOrder(Node var1) {
      if (var1 != null) {
            this.inOrder(var1.left);
            System.out.print(var1.data + " ");
            this.inOrder(var1.right);
      }
   }

   void preOrder(Node var1) {
      if (var1 != null) {
            System.out.print(var1.data + " ");
            this.preOrder(var1.left);
            this.preOrder(var1.right);
      }
   }

   void postOrder(Node var1) {
      if (var1 != null) {
            this.postOrder(var1.left);
            this.postOrder(var1.right);
            System.out.print(var1.data + " ");
      }
   }

   Node getRoot() {
      return this.root;
   }
}

public class BinTreeExample {
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

   class Node {
      int data;
      Node left;
      Node right;
      public Node(int data) {
            this.data = data;
            left = null;
            right = null;
      }
   }
}
