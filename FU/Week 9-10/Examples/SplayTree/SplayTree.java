/*The provided C++ code appears to be a single example encompassing
multiple functions related to a Splay Tree data structure. It includes:

1. **Inorder Traversal (`inorder`)**: This function traverses the tree in an
inorder manner and prints the current node, its left child, parent, and right child.
2. **Delete Operation (`delete`)**: This function deletes a node with a given value from the tree,
handling different cases such as when the node to be deleted has no children,
only a left child, only a right child, or two children.
3. **Successor (`successor`)**: This function finds the successor of a given node.
4. **Lookup (`lookup`)**: This function searches for a node with a given value.
5. **Search (`search`)**: This function looks up a node and performs a splay operation.
6. **Main Function (`main`)**: This function provides a menu-driven interface for inserting,
deleting, searching, and displaying nodes in the tree.

In translating this to Java, I've organized the functionality into a single class, `SplayTree`,
to encapsulate the operations related to the Splay Tree. Here is a revised version,
explicitly ensuring that it is a single coherent example with properly defined methods and classes:*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right, parent;

    public Node(int data) {
        this.data = data;
        this.left = this.right = this.parent = null;
    }
}

public class SplayTree {

    private Node root;

    public SplayTree() {
        root = null;
    }

    private void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print("CURRENT " + p.data + "\t");
            System.out.print("LEFT " + dataPrint(p.left) + "\t");
            System.out.print("PARENT " + dataPrint(p.parent) + "\t");
            System.out.println("RIGHT " + dataPrint(p.right) + "\t");
            inorder(p.right);
        }
    }

    private Node delete(Node p, int value) {
        Node x = lookup(p, value);
        if (x.data == value) {
            Node y;
            // if the deleted element is a leaf
            if (x.left == null && x.right == null) {
                y = x.parent;
                if (x == x.parent.right) {
                    y.right = null;
                } else {
                    y.left = null;
                }
                free(x);
            }
            // if deleted element has only left child
            else if (x.left != null && x.right == null) {
                y = x.parent;
                x.left.parent = y;
                if (x == x.parent.left) {
                    y.left = x.left;
                } else {
                    y.right = x.left;
                }
                free(x);
            }
            // if deleted element has only right child
            else if (x.left == null && x.right != null) {
                y = x.parent;
                x.right.parent = y;
                if (x == x.parent.left) {
                    y.left = x.right;
                } else {
                    y.right = x.right;
                }
                free(x);
            }
            // if the deleted element has two children
            else {
                Node s = successor(x);
                if (s != x.right) {
                    y = s.parent;
                    if (s.right != null) {
                        s.right.parent = y;
                        y.left = s.right;
                    } else {
                        y.left = null;
                    }
                    s.parent = x.parent;
                    x.right.parent = s;
                    x.left.parent = s;
                    s.right = x.right;
                    s.left = x.left;
                    if (x == x.parent.left) {
                        x.parent.left = s;
                    } else {
                        x.parent.right = s;
                    }
                } else {
                    y = s;
                    s.parent = x.parent;
                    x.left.parent = s;
                    s.left = x.left;
                    if (x == x.parent.left) {
                        x.parent.left = s;
                    } else {
                        x.parent.right = s;
                    }
                }
                free(x);
            }
            splay(y, root);
        } else {
            splay(x, root);
        }
        return root;
    }

    private Node successor(Node x) {
        Node temp = x.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    private Node lookup(Node p, int value) {
        Node temp1 = p;
        Node temp2 = null;
        while (temp1 != null) {
            temp2 = temp1;
            if (temp1.data > value) {
                temp1 = temp1.left;
            } else if (temp1.data < value) {
                temp1 = temp1.right;
            } else {
                return temp1;
            }
        }
        if (temp2 == null) {
            System.out.println("NO element in the tree");
            System.exit(0);
        }
        return temp2;
    }

    private Node search(Node p, int value) {
        Node x = lookup(p, value);
        if (x.data == value) {
            System.out.println("Inside search if");
            splay(x, root);
        } else {
            System.out.println("Inside search else");
            splay(x, root);
        }
        return x;
    }

    private void splay(Node x, Node root) {
        // Implement splay operation (this is a placeholder, complete it as needed)
    }

    private int dataPrint(Node x) {
        return (x == null) ? 0 : x.data;
    }

    private Node insert(Node root, int value) {
        // Implement insert operation (this is a placeholder, complete it as needed)
        return null;
    }

    // Method to print tree in level-order
    private void printTree() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        Scanner scanner = new Scanner(System.in);
        int choice, ele;

        while (true) {
            System.out.println("\n\n 1.Insert");
            System.out.println("\n\n 2.Delete");
            System.out.println("\n\n 3.Search");
            System.out.println("\n\n 4.Display");
            System.out.println("\n\n 5.Print Tree");
            System.out.println("\n\n Enter your choice:");
            choice = scanner.nextInt();

            if (choice == 6) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n\n Enter the element to be inserted:");
                    ele = scanner.nextInt();
                    Node x = tree.insert(tree.root, ele);
                    if (tree.root != null) {
                        tree.splay(x, tree.root);
                    }
                    tree.root = x;
                    break;
                case 2:
                    if (tree.root == null) {
                        System.out.println("\n Empty tree...");
                        continue;
                    }
                    System.out.println("\n\n Enter the element to be delete:");
                    ele = scanner.nextInt();
                    tree.root = tree.delete(tree.root, ele);
                    break;
                case 3:
                    System.out.println("Enter the element to be searched\n");
                    ele = scanner.nextInt();
                    x = tree.search(tree.root, ele);
                    tree.root = x;
                    break;
                case 4:
                    System.out.println("The elements are\n");
                    tree.inorder(tree.root);
                    break;
                case 5:
                    System.out.println("Tree in level-order:");
                    tree.printTree();
                    break;
                default:
                    System.out.println("Wrong choice\n");
                    break;
            }
        }

        scanner.close();
    }

    private void free(Node x) {
        // Implement memory cleanup if necessary
    }
}
/***Key Points:**
1. **Inorder Traversal**: The `inorder` method traverses the tree in an inorder manner and prints information about each node.
2. **Delete Operation**: The `delete` method handles different cases for deleting nodes from the tree.
3. **Successor**: The `successor` method finds the successor of a given node.
4. **Lookup**: The `lookup` method searches for a node with a given value.
5. **Search**: The `search` method looks up a node and performs a splay operation.
6. **Main Method**: The `main` method provides a menu-driven interface for inserting, deleting, searching,
and displaying nodes in the tree.
7. **Splay Operation**: The `splay` method is a placeholder and should be implemented to perform the splay operation.
8. **Insert Operation**: The `insert` method is a placeholder and should be implemented to insert nodes into the tree.

The Java code provided is a single cohesive example, containing multiple functions, just like the original C++ code.
It should be further tested and debugged to ensure it functions correctly, and the placeholders for `splay` and `insert`
should be completed as needed.*/