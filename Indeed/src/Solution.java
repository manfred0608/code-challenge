import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        if(args.length < 2)
            return;
        int N = Integer.valueOf(args[0]);
        int M = Integer.valueOf(args[1]);
        
        int res = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        int i = 0;
        while(i < N){
            int value = Integer.valueOf(args[3 + i * 2]);
            map.put(args[2 + i * 2], value);
            i++;
        }        
        
        int offset = 2 * N + 2;
        i = 0;
        while(i < M){
            if(map.containsKey(args[offset + 2 * i])){
                int value = Integer.valueOf(args[offset + 2 * i + 1]);
                res += (map.get(args[offset + 2 * i]) * value);
            }
            i++;
        }
        System.out.println(res);
    }
}