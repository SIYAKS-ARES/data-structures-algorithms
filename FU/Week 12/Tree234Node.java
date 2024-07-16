public class Tree234Node {
    int keys;           // Number of keys in this node
    int key1, key2, key3; // The keys
    Tree234Node child1, child2, child3, child4; // The children
    Tree234Node parent; // The parent

    public Tree234Node(int key) {
        this.key1 = key;
        this.keys = 1;
        this.child1 = null;
        this.child2 = null;
        this.child3 = null;
        this.child4 = null;
        this.parent = null;
    }

    public Tree234Node(Tree234Node parent, int key) {
        this(key);
        this.parent = parent;
    }

    // toString() method to recursively print the tree
    public String toString() {
        String result = "";
        if (child1 != null) {
            result += "(" + child1.toString() + ")";
        } else {
            result += " ";
        }
        result += key1;
        if (child2 != null) {
            result += "(" + child2.toString() + ")";
        } else {
            result += " ";
        }
        if (keys > 1) {
            result += key2;
            if (child3 != null) {
                result += "(" + child3.toString() + ")";
            } else {
                result += " ";
            }
        }
        if (keys > 2) {
            result += key3;
            if (child4 != null) {
                result += "(" + child4.toString() + ")";
            } else {
                result += " ";
            }
        }
        return result;
    }

    // printSubtree() method to print the tree sideways
    public void printSubtree(int depth) {
        if (child4 != null) {
            child4.printSubtree(depth + 1);
        }
        if (keys == 3) {
            for (int i = 0; i < depth; i++) {
                System.out.print("    ");
            }
            System.out.println(key3);
        }
        if (child3 != null) {
            child3.printSubtree(depth + 1);
        }
        if (keys >= 2) {
            for (int i = 0; i < depth; i++) {
                System.out.print("    ");
            }
            System.out.println(key2);
        }
        if (child2 != null) {
            child2.printSubtree(depth + 1);
        }
        if (keys >= 1) {
            for (int i = 0; i < depth; i++) {
                System.out.print("    ");
            }
            System.out.println(key1);
        }
        if (child1 != null) {
            child1.printSubtree(depth + 1);
        }
    }
}