import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

	public int compare(String a, String b) {
		return a.length() - b.length();
	}

}
