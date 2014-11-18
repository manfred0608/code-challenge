import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MinCost {

	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        if(args.length == 0){
            System.out.println("0");
            return;
        }
            
        if(args.length == 1){
            System.out.println(args[0]);
            return;
        }           
        
        List<Set<Integer>> res = new ArrayList<Set<Integer>>();
        int numOfPair = 0;
        int numOfPerson = 0;
        try{
            numOfPair = Integer.valueOf(args[1]);
            numOfPerson = Integer.valueOf(args[0]);
        }catch(Exception e){
            System.out.println("Input Format Error!");
            return;
        }
        
        for(int i = 0; i < numOfPair; i++){
            int i1 = 0;
            int i2 = 0;
            try{
                i1 = Integer.valueOf(args[2 * i + 2]);
                i2 = Integer.valueOf(args[2 * i + 3]);
                
                if(i == 0){
            		Set<Integer> set = new HashSet<Integer>();
            		set.add(i1);
            		set.add(i2);
            		res.add(set);
            		continue;
                }
                for(int j = 0; j < res.size(); j++){
                    if(res.get(j).contains(i1) || res.get(j).contains(i2)){
                        res.get(i1).add(i1);
                        res.get(i2).add(i2);
                    }else{
                    	Set<Integer> set = new HashSet<Integer>();
                    	set.add(i2);
                    	set.add(i1);
                    	res.add(set);
                    }
                }
            }catch(Exception e){
                System.out.println("Input Format Error");
                return;
            }
        }
        
        int cost = 0;
        int numOfGroup = res.size();
        int numOfNotAlone = 0;
        
        for(int i = 0; i < numOfGroup; i++){
        	int size = res.get(i).size();
        	double real = Math.sqrt(size);
        	int K = (int)Math.sqrt(size);
        	
        	if(real - K >= 0.00001)
        		K++;
        	cost += K * K;
        	numOfNotAlone += size;
        }
        
        System.out.println((numOfPerson - numOfNotAlone + cost));
        
    }

}
