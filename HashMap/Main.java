import java.util.HashMap;
class Main{
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer>need = new HashMap<>();
        HashMap<Character,Integer>have = new HashMap<>();

      need.put('b',1);
      need.put('a',1);
      need.put('l',2);
      need.put('o',2);
      need.put('o',2);
      need.put('n',1);
      int ans = Integer.MAX_VALUE;

      for(char c : text.toCharArray){
        have.put(c,have.getOrDefault(c,0)+1);
      }

      for(char c : need.keySet){
        int fneed = need.get(c);
        int fhave = have.get(c);
        ans = Math.min(ans,fhave/fneed);
      }
      return ans;


    }
    public static void main(String[] args) {
        
    }
}