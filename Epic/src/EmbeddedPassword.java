import java.util.ArrayList;


public class EmbeddedPassword {

	public ArrayList<String> embeddedPassword(String s){
		int N = 4;
		if(s == null || s.length() < N * N)
			return new ArrayList<String>();
		
		ArrayList<String> res = new ArrayList<String>();
		int end = (int)Math.sqrt(s.length());
		
		for(int i = N; i <= end; i++){
			StringBuilder sb = new StringBuilder();
			
			for(int j = 1; j <= i; j++){
				sb.append(s.charAt(j * N - 1));
			}
			
			if(isValid(sb.toString()))
				sb.append(sb.toString());
		}
		return res;
	}
		
	public boolean isValid(String s){
		if(s.length() < 4 || s == null)
			return false;

		char cs = s.charAt(0);
		char ce = s.charAt(s.length() - 1);
		if(cs > 'Z' || cs < 'A' || ce > 'Z' || ce < 'A')
			return false;
		return false;
	}
}
