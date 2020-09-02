package org.ms.ds.heap;
/*

https://thecodingsimplified.com/heap-introduction/
following formula can be applied on heap (implemented using array) to find left and right child or parent of any node
left_child_pos = 2* parent_pos + 1
right_child_pos = 2* parent_pos + 2

 */

public class MaxHeap {

    int size;
    int[] arr = new int[20];

    public void insertNewValue(int value) {
        arr[size]=value;
        int index=size;
        int parent=(index-1)/2;
        while(parent >=0 && arr[parent] < arr[index]){
              int t=arr[parent];
              arr[parent]=arr[index];
              arr[index]=t;

              index=parent;
              parent=(index-1)/2;
        }
        size++;
    }

    public int getMax() {
       return arr[0];
    }

    public int removeMax() {
        int max=arr[0];
        arr[0]=arr[size-1];
        size=size-1;
        maxHeapify(0);
        return max;
    }

    public void maxHeapify(int index) {
        int l,r;
        l=2 * index+1;
        r=2 * index+2;
        int largest=index;
        if(l < this.size && arr[l] > arr[largest]){
            largest=l;
        }
        if(r < this.size && arr[r] > arr[largest]){
            largest=r;
        }
        if(largest!=index){
            int t = arr[largest];
            arr[largest] = arr[index];
            arr[index] = t;

            maxHeapify(largest);
        }

    }

    public void buildMaxHeap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;

        for(int i = size/2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }
    
}

class MaxHeapTest{

    public static void main(String[] args) {

        MaxHeap a = new MaxHeap();
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};

        a.insertNewValue(arr[0]);
        a.insertNewValue(arr[1]);
        a.insertNewValue(arr[2]);

        System.out.println(a.getMax());

        a.insertNewValue(arr[3]);
        a.insertNewValue(arr[4]);
        System.out.println(a.getMax());

        a.insertNewValue(arr[5]);
        System.out.println(a.getMax());

        a.insertNewValue(arr[6]);
        a.insertNewValue(arr[7]);
        System.out.println(a.getMax());

        a.removeMax();
        System.out.println(a.getMax());

        a.buildMaxHeap(arr);

    }
}
