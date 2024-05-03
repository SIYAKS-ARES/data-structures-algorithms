package datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    public void BFS() {
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(root);

        while (myQueue.size() > 0) {
            Node currentNode = myQueue.remove();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                myQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                myQueue.add(currentNode.right);
            }
        }
    }

    private void DFSPreOrder(Node currentNode) {
        System.out.print(currentNode.value + " ");
        if (currentNode.left != null) {
            DFSPreOrder(currentNode.left);
        }
        if (currentNode.right != null) {
            DFSPreOrder(currentNode.right);
        }
    }
    public void DFSPreOrder() { DFSPreOrder(root); }


    private void DFSPostOrder(Node currentNode) {
        if (currentNode.left != null) {
            DFSPostOrder(currentNode.left);
        }
        if (currentNode.right != null) {
            DFSPostOrder(currentNode.right);
        }
        System.out.print(currentNode.value + " ");
    }
    public void DFSPostOrder() { DFSPostOrder(root); }


    private void DFSInOrder(Node currentNode) {
        if (currentNode.left != null) {
            DFSInOrder(currentNode.left);
        }
        System.out.print(currentNode.value + " ");
        if (currentNode.right != null) {
            DFSInOrder(currentNode.right);
        }
    }
    public void DFSInOrder() { DFSInOrder(root); }






    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }
    public boolean rContains(int value) { return rContains(root, value); }



    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }


    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

}
















