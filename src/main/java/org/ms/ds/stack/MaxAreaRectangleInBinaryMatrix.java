package org.ms.ds.stack;

import java.util.Arrays;
import java.util.Collections;

/*
https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
Please refer Max Area Histogram program to solve this
Input:
0  1  1  0
1  1  1  1
1  1  1  1
1  1  0  0
Output :
1  1  1  1
1  1  1  1
we need to convert this problem into small problem
so we will convert this matrix as 4 histogram
H1:
0  1  1  0
H2:
0  1  1  0
1  1  1  1
H3:
0  1  1  0
1  1  1  1
1  1  1  1
H4: (will not consider histogram with base as 0)
0  1
1  1
1  1
1  1
MARBM answer = max(H1,H2,H3,H4)

 */
public class MaxAreaRectangleInBinaryMatrix {

    Integer getMARBM(Integer[][] ba) {
        MaxAreaHistogram maxAreaHistogram=new MaxAreaHistogram();
        Integer max=Integer.MIN_VALUE;
        Integer[] tempArray= new Integer[ba.length];
        Arrays.fill(tempArray,0);
        for (int i=0;i<ba.length;i++) {
            for (int j=0;j<ba[i].length;j++) {
                if(ba[i][j] ==0){
                    tempArray[j]=0;
                }else {
                    tempArray[j] = tempArray[j] + ba[i][j];
                }
            }
           Integer mah=maxAreaHistogram.getMAH(Arrays.asList(tempArray));
           max=Integer.max(mah,max);
        }
        return max;
    }


    public static void main(String[] args) {
        Integer[][] ba = new Integer[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        MaxAreaRectangleInBinaryMatrix maxAreaRectangleInBinaryMatrix=new MaxAreaRectangleInBinaryMatrix();
        System.out.println("MaxAreaRectangleInBinaryMatrix " + maxAreaRectangleInBinaryMatrix.getMARBM(ba));
    }

}


