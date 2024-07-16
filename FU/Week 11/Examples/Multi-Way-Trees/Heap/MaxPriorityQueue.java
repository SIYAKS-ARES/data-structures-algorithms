public class MaxPriorityQueue {
    private int[] heap;
    private int heapSize;

    public MaxPriorityQueue(int capacity) {
        heap = new int[capacity];
        heapSize = 0;
    }

    // Check if the heap is empty
    public boolean isHeapEmpty() {
        return heapSize == 0;
    }

    // Get index of left child
    private int left(int i) {
        return 2 * (i + 1) - 1;
    }

    // Get index of right child
    private int right(int i) {
        return 2 * (i + 1);
    }

    // Get index of parent
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Insert an element into the heap
    public void heapInsert(int key) {
        if (heapSize == heap.length) {
            System.out.println("Heap overflow");
            return;
        }
        int i = heapSize;
        heapSize++;
        while (i > 0 && heap[parent(i)] < key) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = key;
    }

    // Build the heap
    public void buildHeap(int[] array) {
        heap = array;
        heapSize = array.length;
        for (int i = (heapSize / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Heapify the heap
    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;

        if (left < heapSize && heap[left] > heap[i]) {
            largest = left;
        }
        if (right < heapSize && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            heapify(largest);
        }
    }

    // Extract the maximum element (for heap sort)
    public void heapExtractOrSort() {
        buildHeap(heap);
        for (int i = heapSize - 1; i > 0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapSize--;
            heapify(0);
        }
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 10, 3, 5, 1};
        MaxPriorityQueue maxHeap = new MaxPriorityQueue(array.length);
        maxHeap.buildHeap(array);
        maxHeap.printHeap();

        maxHeap.heapInsert(15);
        maxHeap.printHeap();

        maxHeap.heapExtractOrSort();
        maxHeap.printHeap();
    }
}

/*Explanation:

	1.	isHeapEmpty(): Checks if the heap is empty by comparing heapSize to zero.
	2.	left(int i): Returns the index of the left child of the node at index i.
	3.	right(int i): Returns the index of the right child of the node at index i.
	4.	parent(int i): Returns the index of the parent of the node at index i.
	5.	heapInsert(int key): Inserts a new key into the heap, maintaining the max-heap property.
	6.	buildHeap(int[] array): Builds a max-heap from an unsorted array.
	7.	heapify(int i): Ensures the subtree rooted at index i satisfies the max-heap property.
	8.	heapExtractOrSort(): Extracts the maximum element from the heap and performs heap sort.
	9.	printHeap(): Prints the current state of the heap.

The main method demonstrates building a heap from an array, inserting a new element,
and performing heap sort.
Adjust the capacity and array in the main method as needed for different test cases. */