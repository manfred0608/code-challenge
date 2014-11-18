import java.util.Stack;;
public class ValidBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int)(Math.sqrt(4)));
		System.out.println(validateString("{[}]"));
	}
	static String validateString(String value) {
        if(value == null || value.length() == 0)
            return "YES";
        char[] array = value.toCharArray();
        Stack<String> s = new Stack<String>();
        
        int[] left = new int[3];
        
        try{
        	
        }catch(Exception e){
        	return "SS";
        }
        int B1 = 0;
        int B2 = 1;
        int B3 = 2;
        
        for(int i = 0; i < array.length; i++){
            char c = array[i];
            if(c == '(' || c == '{' || c == '['){
                s.push(String.valueOf(c));
                if(c == '('){
                    left[B1]++;
                }else if(c == '{'){
                    left[B2]++;
                }else{
                    left[B3]++;
                }
            }else if(c == ')' || c == '}' || c == ']'){
            	if(s.isEmpty())
            		return "NO";
                if(c == ')'){
                	if(!s.peek().equals("(") || left[B1] == 0)
                		return "NO";
                	s.pop();
                	left[B1]--;
                }else if(c == '}'){
                	if(!s.peek().equals("{") || left[B2] == 0)
                		return "NO";
                	s.pop();
                	left[B2]--;
                }else{
                	if(!s.peek().equals("[") || left[B3] == 0)
                		return "NO";
                	s.pop();
                	left[B3]--;
                }
            }else{
            	return "NO";
            }
        }
        if(left[B1] == 0 && left[B2] == 0 && left[B3] == 0)
        	return "YES";
        else
        	return "NO";
	}
}
