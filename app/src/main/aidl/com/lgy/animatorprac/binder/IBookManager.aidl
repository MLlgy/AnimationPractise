// IBookManager.aidl
package com.lgy.animatorprac.binder;

// Declare any non-default types here with import statements
import com.lgy.animatorprac.binder.Book;
interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);

       List<Book> getBookL();
       void addBook(in Book book);
}
