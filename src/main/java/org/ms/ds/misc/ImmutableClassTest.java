package org.ms.ds.misc;

import java.util.HashMap;

/** ImmutableClass
 * 1) Final class - Make class final so that it cannot be inherited
 */
final class ImmutableClass{

    /**
     * 2) private member variable -> Making fields private ensures that fields
     cannot be accessed outside class.
     * 3) final member variable -> Make field final
     so that they can be assigned only once.
     */
    private final Integer id; //Immutable member variable
    private final String name; //Immutable member variable
    private final HashMap<Integer,String> map; //mutable member variable

    /** 4) Constructor -> Initialize all fields in constructor.
     *            assign all mutable member variable using new keyword.
     */
    public ImmutableClass(Integer id, String name, HashMap<Integer,String> map){
        this.id=id;
        this.name=name;

        //assign all mutable member variable using new keyword.
        this.map=new HashMap<Integer, String>(map);
    }

    /* getter method for id.*/
    public Integer getId() {
        /** 5a) Integer is immutable class,
         *     any changes made to Integer object produces new Integer object.
         *     so return reference variable of Integer.
         */
        return id;
    }

    /* getter method for name.*/
    public String getName() {
        /** 5b) String is immutable class,
         *     any changes made to Sting object produces new String object.
         *     so return reference variable of String.
         */
        return name;
    }

    /* Method returns clone of HashMap. */
    public HashMap<Integer, String> getMap() {
        /** 5c) HashMap is mutable class,
         *     any changes made to HashMap object won't produce new HashMap object.
         *     so return copy/clone of object, not reference variable of HashMap.*/
        return (HashMap<Integer, String>) map.clone();
    }

    /** 6) Don't provide setter methods in class */

}


public class ImmutableClassTest{
    public static void main(String[] args) {

        Integer localId=new Integer(1); //local

        String localName=new String("ankit"); //local

        HashMap<Integer, String> localMap = new HashMap<Integer,String>(); //local
        localMap.put(11, "audi");

        ImmutableClass immutableClass = new ImmutableClass(localId, localName, localMap);


        System.out.println("----Display ImmutableClass members before changing----");
        System.out.println(immutableClass.getName());  // "ankit"
        System.out.println(immutableClass.getId());        // 1
        System.out.println(immutableClass.getMap());   //{11=audi}

        //Comparing ImmutableClass members with local before changing
        System.out.println(localName==immutableClass.getName());  //true
        System.out.println(localId==immutableClass.getId());      //true
        System.out.println(localMap == immutableClass.getMap());  //false


        //change local
        localId = new Integer(2);
        localName = new String("mittal");
        localMap.put(12, "ferarri");


        System.out.println("\n----Display ImmutableClass members after changing----");
        System.out.println(immutableClass.getName());  // "ankit"
        System.out.println(immutableClass.getId());        // 1
        System.out.println(immutableClass.getMap());   //{11=audi}

        //Comparing ImmutableClass members with local after changing
        System.out.println(localName==immutableClass.getName());  //false
        System.out.println(localId==immutableClass.getId());      //false
        System.out.println(localMap == immutableClass.getMap());  //false

    }

}

