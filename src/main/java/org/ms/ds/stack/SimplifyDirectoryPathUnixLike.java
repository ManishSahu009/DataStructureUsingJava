package org.ms.ds.stack;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/simplify-directory-path-unix-like/
By looking at examples we can see that the above simplification process just behaves like a stack.
Whenever we encounter any file’s name, we simply push it into the stack.
when we come across ” . ” we do nothing.
When we find “..” in our path, we simply pop the top most element as we have to jump back to parent’s directory.
When we see multiple “////” we just ignore them as they are equivalent to one single “/”.
 */
public class SimplifyDirectoryPathUnixLike {


    static String simplify(String str)
    {
        Stack<String> stack=new Stack<>();
        String result="/";
        int length=str.length();
        // skip all the multiple '/' Eg. "/////""
        for (int i = 0; i < length; i++)
        {

            // we will clear the temporary String
            // every time to accomodate new directory
            // name or command.
            // dir will contain "a", "b", "..", ".";
            String dir = "";

            // skip all the multiple '/' Eg. "/////""
            while (i < length && str.charAt(i) == '/')
                i++;

            // stores directory's name("a", "b" etc.)
            // or commands("."/"..") into dir
            while (i < length && str.charAt(i) != '/')
            {
                dir += str.charAt(i);
                i++;
            }

            // if dir has ".." just pop the topmost
            // element if the Stack is not empty
            // otherwise ignore.
            if (dir.equals("..") == true)
            {
                if (!stack.empty())
                    stack.pop();
            }

            // if dir has "." then simply continue
            // with the process.
            else if (dir.equals(".") == true) {
                continue;
            }

                // pushes if it encounters directory's
                // name("a", "b").
            else if (dir.length() != 0) {
                stack.push(dir);
            }
        }

        // a temporary Stack (st1) which will contain
        // the reverse of original Stack(st).
        Stack<String> st1 = new Stack<String>();
        while (!stack.empty())
        {
            st1.push(stack.pop());
        }


        // the st1 will contain the actual res.
        while (!st1.empty())
        {

            // if it's the last element no need
            // to append "/"
            if (st1.size() != 1) {
                result = result + (st1.pop() + "/");
            }
            else {
                result = result + st1.pop();
            }

        }

        return result;
    }



    public static void main(String []args)
    {
        String str = new String("/a/./b/../../c/");
        String res = simplify(str);
        System.out.println(res);
    }
}
