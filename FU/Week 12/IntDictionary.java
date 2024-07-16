public abstract class IntDictionary {
    protected int size; // Number of keys in the dictionary

    // Returns the number of keys in the dictionary
    public int size() {
        return size;
    }

    // Abstract method to find a key
    public abstract boolean find(int key);

    // Abstract method to insert a key
    public abstract void insert(int key);

    // Abstract method to print the tree
    public abstract void printTree();
}