/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package stringpermutations;
import java.util.ArrayList;


/**
 *
 * @author evanedge
 */
public class StringPermutations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string = new String();
        string = "abcd";
        ArrayList<String> outputList = permutations(string);
        for(String s: outputList) {
            System.out.println(s);
        }
        
    
    }
    
    public static ArrayList<String> permutations (String string) {
        ArrayList<String> list;
        list = new ArrayList<>();
        if(string.length() == 1) {
            list.add(string);
            return list;
        }
        String substring1 = string.substring(0, 1);
        String substring2 = string.substring(1);
        ArrayList<String> substringList = permutations(substring2);
        
        for(int i = 0; i < substringList.size(); i++) {
            String substring3 = substringList.get(i);
            for (int j = 0; j < substring3.length(); j++) {
                String subBegin = substring3.substring(0, j);
                String subEnd = substring3.substring(j+1);
                String newSub = subBegin + substring1 + subEnd;
                list.add(newSub);
            }

            list.add(substring1 + substring3);
            list.add(substring3 + substring1);
        }
        
        return list;
        
    }
    
}
