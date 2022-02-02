package codingBat;

public class codingBat {
	
	public String wordEnds(String str, String word) {
		
		int len = str.length();
		int wLen = word.length();
		int pos = str.indexOf(word);
		int i = 0;
		
		StringBuilder stbuild = new StringBuilder(len);
		while(pos != -1) {
			i = pos + wLen;
			if(pos >= 1)
				stbuild.append(str.charAt(pos-1));
			if(i < len)
				stbuild.append(str.charAt(pos+wLen));
			pos = str.indexOf(word, i);	
		}
		return stbuild.toString();
		  
	}
}
