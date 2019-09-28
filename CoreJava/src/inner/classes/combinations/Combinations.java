/*
 1. Class inside Class - Certainly possible. Without existing one type of object if there is no chance of existing another type of object - Inner classes
 2. Interface inside Class - Yes. If implementations of this interface can't exist without existing Outer class then it is effectively point 1 only.
 							 This interface is surely static but public/private depends on the developer requirement
 3. Class inside Interface - Allowed to provide default implementation of the interface OR when functionality of class is closely associated with the class
 4. Interface inside Interface - Yes. But since interfaces are public static entities while implementing Inner interface you may not implement Outer and vice versa.
*/

