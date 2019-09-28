/*
   Comparable vs Comparator
   
   1. For predefined comparable classes default natural sorting order already available. If we are not satisfied with that DNSO then we can 
      define our own sorting by using comparator.
   2. For predefined non-comparable classes like StringBuffer DNSO is not already available. Hence we can define own sorting by using a
      comparator.
      
      Note: In case of predefined classes whether comparable or not we have to write a comparator only as we cant change predefined Java or
      3rd party API classes.
       
   3. For our own classes like employee, the person who is writing the class is responsible to define default natural sorting order by 
      implementing comparable interface.
      The person who is using our class if he is not satisfied with DNSO then he can define his own sorting by using comparator.
      
      So in a nut-shell apart from our own objects where we implement Comparable we will always be writing comparators for Java/3rd party 
      API classes even if they don't implement Comparable.
      
    Comparison
    
	    1. Comparable is meant for DNSO while comparator is meant for custom sorting order.
	    2. Comparable is present in java.lang package while Comparator is present in java.util package.
	    3. Comparable has only 1 method compareTo while Comparator defines 2 methods compare() and equals().
	    4. String and all wrapper classes implement Comparable interface while the only classes implementing Comparator are Collator & RuleBasedCollator(GUI based classes)
	    5. With Comparable objects must be comparable and homogeneous but with comparator as we defined our own comparison they need not be
	       homogeneous or comparable.
 */
