package org.ms.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieImplementation {
    public static void main (String[] args)
    {
        Trie head = new Trie();

        head.insert("techie");
        head.insert("techi");
        head.insert("tech");

        System.out.println(head.search("tech"));			// print true
        System.out.println(head.search("techi"));			// print true
        System.out.println(head.search("techie"));			// print true
        System.out.println(head.search("techiedelight"));	// print false

        head.insert("techiedelight");

        System.out.println(head.search("tech"));			// print true
        System.out.println(head.search("techi"));			// print true
        System.out.println(head.search("techie"));			// print true
        System.out.println(head.search("techiedelight"));	// print true
    }
}


class Trie
{
    boolean isLeaf;
    Map<Character, Trie> children;

    Trie() {
        isLeaf = false;
        children = new HashMap();
    }


    public void insert(String key)
    {
        System.out.println("Inserting \"" + key + "\"");
        Trie curr = this;
        for (int i = 0; i < key.length(); i++)
        {
            if (curr.children.get(key.charAt(i)) == null)
                curr.children.put(key.charAt(i), new Trie());
            curr = curr.children.get(key.charAt(i));
        }
        curr.isLeaf = true;
    }

    public boolean search(String key)
    {
        System.out.print("Searching \"" + key + "\" : ");
        Trie curr = this;
        for (int i = 0; i < key.length(); i++)
        {
            curr = curr.children.get(key.charAt(i));
            if (curr == null)
                return false;
        }
        return curr.isLeaf;
    }
};

