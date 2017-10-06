import java.util.Comparator;

public class StringRevLexiComparator implements Comparator<String>
{
	public int compare(String a, String b)
	{
		if(a.compareTo(b) < 0)
			return -1;
		if(a.compareTo(b) > 0)
			return 1;
		if(a.compareTo(b) == 0)
			return 0;
	}
	
}