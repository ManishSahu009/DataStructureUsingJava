package org.ms.ds.misc;
/*
Area=l*w
R1 -> [(A,B),(C,D)]
R2 -> [(E,F),(G,H)]
R1 Area : (C-A) * (D-E)
R2 Area : (G-E) * (H-F)
Overlapping Area:
max(min(C,G)-max(A,E), 0) * max(min(D,H)-max(B,F), 0)
Note: Here max (X,0) is for non overlapping case
 */

public class RectangleOverlapping {

    public static  int findOverlappingArea(int A, int B, int C, int D,
                            int E, int F, int G, int H){

        int r1Area=(C-A) * (D-E);
        int r2Area = (G-E) * (H-F);
        int overLappingArea=Math.max(Math.min(C,G)-Math.max(A,E), 0) * Math.max(Math.min(D,H)-Math.max(B,F), 0);
        return overLappingArea;

    }

    public static void main(String[] args) {
        System.out.println(findOverlappingArea(-3,0,3,4,0,-1,9,2));
    }
}
