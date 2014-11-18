public class Solution {
	public static void main(String[] args){
		System.out.println(numDecodings("111111"));
	}
	
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int len = s.length();
        
        int[] res = new int[len + 1];
        
        for(int i = 0; i < res.length; i++){
            if(i != res.length - 1){
                String cur = s.substring(i, i + 1);
                char c = cur.toCharArray()[0];
                
                if(c > '9' || c < '0')
                    return 0;
            }
            if(i == 0)
                res[0] = 1;
            else if(i == 1){
                res[1] = s.substring(0, 1).equals("0")? 0 : 1;
            }else{
                String s1 = s.substring(i - 1, i);
                if(isValid(s1))
                    res[i] += res[i - 1];
                String s2 = s.substring(i - 2, i);
                if(isValid(s2))
                    res[i] += res[i - 2];                
            }
        }
        return res[res.length - 1];
    }
       
       
    public static boolean isValid(String s){
    	boolean isValid = true;
    	
        if(s.length() > 2)
            return false;

        int temp = Integer.parseInt(s);
        if(temp > 26 || temp < 1)
            isValid = false;
        if(temp < 10 && s.length() > 1)
        	return false;
        return isValid;
    }
}