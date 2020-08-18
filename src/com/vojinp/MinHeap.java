package com.vojinp;

import java.util.Arrays;

public class MinHeap {
    public static final int INT_MIN = Integer.MIN_VALUE;
    private int[] arr;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        arr = new int[maxSize];
        this.maxSize = maxSize;
        this.size = 0;
    }

    private int getParent(int i) {
        return (i-1)/2;
    }

    private int getLeftChild(int i) {
        return 2*i + 1;
    }

    private int getRightChild(int i) {
        return 2*i + 2;
    }

    private void swapValues(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void deleteIdx(int i) {
        decreaseIdx(i, INT_MIN);
        extractMin();
    }

    private void extractMin() {
        arr[0] = arr[size - 1];
        size--;

        heapify(0);
    }

    private void heapify(int i) {
        int l = getLeftChild(i);
        int r = getRightChild(i);
        int smallest = i;
        if (l < size && arr[l] < arr[i]) {
            smallest = l;
        }
        if (r < size && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swapValues(i, smallest);
            heapify(smallest);
        }
    }

    private void decreaseIdx(int i, int intMin) {
        arr[i] = intMin;
        while(i != 0 && arr[getParent(i)] > arr[i]) {
            swapValues(i, getParent(i));
            i = getParent(i);
        }
    }

    public void insert(int value) {
        if (size == maxSize) {
            System.out.println("Heap is full.");
            return;
        }

        int i = size;
        arr[i] = value;
        int j;
        while((j = getParent(i)) >= 0) {
            if (arr[i] < arr[j]) {
                swapValues(i, j);
            } else {
                break;
            }
            i = j;
        }
        size++;
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }
}
