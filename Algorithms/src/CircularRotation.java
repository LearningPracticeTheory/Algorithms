
public class CircularRotation {
	public static void main(String args[]) {
		String str1 = "ACTGACG";
		String str2 = "TGACGAC";
//System.out.println(str2);
		System.out.print(str1 + " : " + str2 + " -> ");
		System.out.println(matchRotationStr(str1, str2));
	}
	
	public static boolean matchRotationStr(String str1, String str2) {//str2 match str1
		if(str1.length() != str2.length()) {
			return false;
		}
		char c = str2.charAt(0);
		String t = null;
		for(int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) == c) {
				t = str1.substring(i, str1.length()) + str1.substring(0, i);
//System.out.println(str1);
				if(t.equals(str2)) {//cannot just use ==
					return true;//hashCode doesn't same
				}
			}
		}
		return false;
	}
	
}
