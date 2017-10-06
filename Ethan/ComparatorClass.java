import java.util.Comparator;


public class ComparatorClass implements Comparator<String>
{

	public int compare(String a, String b)
	{
		return a.compareTo(b);
	}
	
	public boolean equals(String a, String b)
	{
		return a.equals(b);
	}

}