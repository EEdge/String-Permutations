/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package stringpermutations;
import java.util.ArrayList;


/**
 *
 * @author Evan Edge and Iain Raleigh
 */
public class StringPermutations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string = "abcdef";
        ArrayList<String> outputList = permutations(string);
        for (int i = 0; i<outputList.size(); i++){
            if(outputList.get(i).length()!=6) outputList.remove(i);
        }
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
            if(substring3.length() == 1){
                String newSub1 = substring1 + substring3;
                String newSub2 = substring3 + substring1;
                list.add(newSub1);
                list.add(newSub2);
            }
            else{
                
                for (int j = 0; j <= substring3.length(); j++) {
                    String subBegin = substring3.substring(0, j);
                    String subEnd = substring3.substring(j);
                    String newSub = subBegin + substring1 + subEnd;
                    list.add(newSub);
                }
            }
        }
        
        return list;
        
    }
    
}
