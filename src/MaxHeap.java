public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            boolean add = add(data[i]);
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        if (data.length == 0)
            return;

        size = data.length;

        for (int i = (size/2)-1; i >= 0; i--) {
            maxHeapify(data,i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        if (this.size == this.data.length)
            return false;

        this.data[size] = item;
        int n = size;
        this.size++;

        while (n != 0 && this.data[n] > this.data[(n-1)/2]) {
            int temp = this.data[(n-1)/2];
            this.data[(n-1)/2] = this.data[n];
            this.data[n] = temp;
            n = (n-1)/2;
        }

        return false;
    }

    public void maxHeapify(Integer[] data, int i) {
        //
        int left = 2*i + data.length%2;
        int right = 2*i + 1 + data.length%2;
        int largest = i;

        if (left < data.length && data[left] > data[right])
            largest = left;

        if (right < data.length && data[right] > data[left])
            largest = right;

        if (largest != i) {
            int temp = data[i];
            data[i] = data[largest];
            data[largest] = temp;

            maxHeapify(data, largest);
        }
    }

    // return the max item in the heap
    public Integer get() {
        if (this.size == 0)
            return null;

        return this.data[0];
    }

    // remove the root item
    public Integer pop() {
        if (this.size == 0)
            return null;

        int returnInt = this.data[0];

        for (int i = 0; i < this.size - 1; i++) {
            data[i] = data[i+1];
        }

        size--;

        return returnInt;
    }

    public boolean equals (Integer[] data) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != data[i])
                return false;
        }

        return true;
    }

    public String toString() {
        String returnString = "[";
        for (int i = 0; i < size; i++) {
            returnString = returnString + this.data[i];
            if (i != size -1)
                returnString += " ";
        }
        returnString += "]";
        return returnString;
    }
}
