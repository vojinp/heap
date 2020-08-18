package com.vojinp;

public class Main {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);

        heap.insert(23);
        heap.insert(25);
        heap.insert(7);
        heap.insert(3);

        heap.print();
        heap.deleteIdx(1);
        heap.print();
    }
}
