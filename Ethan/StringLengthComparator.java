import java.util.Comparator;


public class StringLengthComparator implements Comaparator<String>
{

	public int compare(String a, String b)
	{
		return a.length() - b.length();  //compareTo method basically
	}

}