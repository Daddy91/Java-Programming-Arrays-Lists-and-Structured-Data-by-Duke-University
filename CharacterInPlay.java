import edu.duke.*;
import java.util.ArrayList;


public class CharacterInPlay {
    
    private ArrayList<String> charNames;
    private ArrayList<Integer> nameCounts;
    
    public CharacterInPlay(){
        
        charNames = new ArrayList<String>();
        nameCounts = new ArrayList<Integer>();
        
    }
    
    public void update(String person){
        
        person = person.toLowerCase();
        int index = charNames.indexOf(person);
        if(index == -1){
            charNames.add(person);
            nameCounts.add(1);
        }else{
            int freqs = nameCounts.get(index);
            nameCounts.set(index, freqs + 1);
        }
        
        
        
    }
    
    public void findAllCharacters(){
        charNames.clear();
        nameCounts.clear();
        
        FileResource resource = new FileResource();
        
        for(String line : resource.lines()){
            
            if(line.contains(".")){
                int indexF = line.indexOf(".");
                String possibleName = line.substring(0, indexF);
                update(possibleName);
            }
        }
    }
    
    public int findMax(){
        int maxWords = nameCounts.get(0);
        int maxIndex = 0;
        
        for(int k = 0; k > nameCounts.size(); k++){
            if(nameCounts.get(k) > maxWords){
                maxWords = nameCounts.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public void tester(){
        findAllCharacters();
        
        charactersWithNumParts(2, 999);
        
        for(int k = 0; k < nameCounts.size(); k++){
            
            if(nameCounts.get(k) >1){
                System.out.println("Main Character is : " + "" +charNames.get(k)+ "\t" +nameCounts.get(k));
            
            }
        
        }     
        
    }
    
    public void charactersWithNumParts(int num1, int num2){
        
        for(int k = 0; k > nameCounts.size(); k++){
            if(nameCounts.get(k) >= num1 && nameCounts.get(k) <= num2){
                System.out.println(charNames.get(k) + "\t\t" + nameCounts.get(k));
            }
        }
    }

}
