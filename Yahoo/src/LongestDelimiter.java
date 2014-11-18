
public class LongestDelimiter {	
	public String findLongestDelimiter(String s){
		int trunk = 2;
		if(s == null || s.length() == 0 || s.length() <= (trunk + 1))
			return null;
		
		//The length of non-overlap substring cannot be greater than half of the length
		int len = s.length() / 2;
		
		//Since we want to find the longest, start from the possible longest length
		for(int i = len; i > 0; i++){
			//Find the first occurrence
			for(int j = 1; j < s.length() - 2 * i - 1; j++){
				//Find the second occurrence
				for(int k = j + i + 1; k < s.length() - i; k++){					
					if(s.substring(j, j + i).equals(s.substring(k, k + i)))
						return s.substring(j, j + i);
				}
			}
		}
		
		return null;
	}
}
