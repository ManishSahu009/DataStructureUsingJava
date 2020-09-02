package org.ms.ds.heap;
/*

https://thecodingsimplified.com/heap-introduction/
following formula can be applied on heap (implemented using array) to find left and right child or parent of any node
left_child_pos = 2* parent_pos + 1
right_child_pos = 2* parent_pos + 2

 */

public class MinHeap {

    int size;
    int[] arr = new int[20];

    public void insertNewValue(int value) {
        arr[size]=value;
        int index=size;
        int parent=(index-1)/2;
        while(parent >=0 && arr[parent] > arr[index]){
            int t=arr[parent];
            arr[parent]=arr[index];
            arr[index]=t;

            index=parent;
            parent=(index-1)/2;
        }
        size++;
    }

    public int getMin() {
        return arr[0];
    }

    public int removeMin() {
        int min=arr[0];
        arr[0]=arr[size-1];
        size=size-1;
        minHeapify(0);
        return min;
    }

    public void minHeapify(int index) {
        int l,r;

        l=2 * index+1;
        r=2 * index+2;
        int smallest=index;
        if(l < this.size && arr[l] < arr[smallest]){
            smallest=l;
        }
        if(r < this.size && arr[r] < arr[smallest]){
            smallest=r;
        }
        if(smallest!=index){
            int t = arr[smallest];
            arr[smallest] = arr[index];
            arr[index] = t;

            minHeapify(smallest);
        }

    }

    public void buildMinHeap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;

        for(int i = size/2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

}

class MinHeapTest{

    public static void main(String[] args) {

        MinHeap a = new MinHeap();
        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};

        a.insertNewValue(arr[0]);
        a.insertNewValue(arr[1]);
        a.insertNewValue(arr[2]);

        System.out.println(a.getMin());

        a.insertNewValue(arr[3]);
        a.insertNewValue(arr[4]);
        System.out.println(a.getMin());

        a.insertNewValue(arr[5]);
        System.out.println(a.getMin());

        a.insertNewValue(arr[6]);
        a.insertNewValue(arr[7]);
        System.out.println(a.getMin());

        a.removeMin();
        System.out.println(a.getMin());

        a.buildMinHeap(arr);

    }
}
