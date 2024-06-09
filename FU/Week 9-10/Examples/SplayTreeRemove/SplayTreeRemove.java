// Java implementation to delete a node from Splay Tree
class SplayTree {
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // This function brings the key at root if key is present in tree.
    // If key is not present, then it brings the last accessed item at
    // root. This function modifies the tree and returns the new root.
    Node splay(Node root, int key) {
        // Base cases: root is NULL or key is present at root
        if (root == null || root.key == key)
            return root;

        // Key lies in left subtree
        if (root.key > key) {
            // Key is not in tree, we are done
            if (root.left == null)
                return root;

            // Zig-Zig (Left Left)
            if (root.left.key > key) {
                // First recursively bring the key as root of left-left
                root.left.left = splay(root.left.left, key);
                // Do first rotation for root, second rotation is
                // done after else
                root = rightRotate(root);
            } else if (root.left.key < key) { // Zig-Zag (Left Right)
                // First recursively bring the key as root of left-right
                root.left.right = splay(root.left.right, key);
                // Do first rotation for root.left
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }

            // Do second rotation for root
            return (root.left == null) ? root : rightRotate(root);
        } else { // Key lies in right subtree
            // Key is not in tree, we are done
            if (root.right == null)
                return root;

            // Zag-Zig (Right Left)
            if (root.right.key > key) {
                // Bring the key as root of right-left
                root.right.left = splay(root.right.left, key);
                // Do first rotation for root.right
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            } else if (root.right.key < key) { // Zag-Zag (Right Right)
                // Bring the key as root of right-right and do
                // first rotation
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            }
            // Do second rotation for root
            return (root.right == null) ? root : leftRotate(root);
        }
    }

    // The delete function for Splay tree.
    // Note that this function returns the new root of Splay Tree after removing the key.
    Node deleteKey(Node root, int key) {
        Node temp;
        if (root == null)
            return null;
        // Splay the given key
        root = splay(root, key);
        // If key is not present, then return root
        if (key != root.key)
            return root;
        // If key is present
        // If left child of root does not exist,
        // make root->right as root
        if (root.left == null) {
            temp = root;
            root = root.right;
        }
        // Else if left child exists
        else {
            temp = root;
            root = splay(root.left, key);
            // Make right child of previous root as
            // new root's right child
            root.right = temp.right;
        }
        // free the previous root node, that is,
        // the node containing the key
        return root;
    }

    // A utility function to print preorder traversal of the tree.
    // The function also prints height of every node
    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        Node root = new Node(6);
        root.left = new Node(1);
        root.right = new Node(9);
        root.left.right = new Node(4);
        root.left.right.left = new Node(2);
        root.right.left = new Node(7);
        int key = 4;
        root = tree.deleteKey(root, key);
        System.out.println("Preorder traversal of the modified Splay tree is ");
        tree.preOrder(root);
    }
}

/*This Java code mirrors the functionality of the provided C++ code. It defines a
Splay Tree structure with methods to rotate nodes, splay the tree, and delete a node.
Finally, it includes a `main` function to test the functionality of the implemented methods.*/