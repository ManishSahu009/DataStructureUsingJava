package org.ms.ds.stack;

import java.util.*;

public class MergingOverlappingIntervals {

    public static void mergeIntervals(List<Interval> intervals)
    {
        Collections.sort(intervals, Comparator.comparingInt(a -> a.begin));

        Stack<Interval> stack = new Stack<>();

        for (Interval curr: intervals)
        {
            if (stack.empty() || curr.begin > stack.peek().end) {
                stack.push(curr);
            }
            if (stack.peek().end < curr.end) {
                stack.peek().end = curr.end;
            }
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args)
    {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5), new Interval(2, 3),
                new Interval(4, 6), new Interval(7, 8),
                new Interval(8, 10), new Interval(12, 15)
        );

        mergeIntervals(intervals);
    }
}

class Interval
{
    int begin, end;

    Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + begin + "," + end + "}";
    }
}
