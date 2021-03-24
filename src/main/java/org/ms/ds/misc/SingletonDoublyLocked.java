package org.ms.ds.misc;

public class SingletonDoublyLocked {

    private static SingletonDoublyLocked INSTANCE;

    private SingletonDoublyLocked() {
    }

    public static SingletonDoublyLocked getInstance() {
        //First check - To avoid more than one instance creation of Singleton class.
        if (INSTANCE == null) {
            synchronized (SingletonDoublyLocked.class) {
                //Second check - To avoid more than one instance creation of
                //Singleton class.
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoublyLocked();
                }
            }
        }
        return INSTANCE;
    }
}
