package org.ms.ds.recursion;

public class TowerOfHanoi {
    static void towerOfHanoi(int n, char source, char destination, char helper)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  source + " to rod " + destination);
            return;
        }
        towerOfHanoi(n-1, source, helper, destination);
        System.out.println("Move disk " + n + " from rod " +  source + " to rod " + destination);
        towerOfHanoi(n-1, helper, destination, source);
    }

    //  Driver method
    public static void main(String args[])
    {
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}
