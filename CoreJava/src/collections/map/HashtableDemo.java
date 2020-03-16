package collections.map;

import java.util.Hashtable;

/*
	As the default capacity is 11, so 11 buckets numbered 0 to 10 will be created. Now every Tempr object returns a hashcode and based on that the
	bucket number will be known and object will be stored. If returned hashcode is > 11 then hashcode % 11 will be taken to find the bucket number.
	Note: There can be mutiple entries in 1 bucket.
	
	After buckets are filled the SOP prints the values from Top to Bottom(bucket 10 to 0) and right to left within a bucket
*/

public class HashtableDemo {
	
	public static void main(String[] args)
	{
		Hashtable h = new Hashtable();
		h.put(new Tempr(5), "A");
		h.put(new Tempr(2), "B");
		h.put(new Tempr(6), "C");
		h.put(new Tempr(15),"D");
		h.put(new Tempr(23),"E");
		h.put(new Tempr(16),"F");
		
		System.out.println(h);
	}
}

class Tempr
{
	int i;
	Tempr(int i)
	{
		this.i = i;
	}
	public int hashCode()
	{
		return i;  //If we change hashcode as i%9 the buckets change and hence the SOP output too.
	}
	public String toString()
	{
		return i + "..";
	}
}
