class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> count = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i = 0 ; i < t.length(); i++){
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = count.size(); 
        int minLen = Integer.MAX_VALUE;
        int [] res = {-1,-1};
        int l = 0; //start of the window

        for(int r = 0 ; r < s.length(); r++){

            char c = s.charAt(r);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if(count.containsKey(c) && window.get(c).equals(count.get(c))){
                have++;
            }

            while(have == need){
                
                if((r-l+1) < minLen){
                    minLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                //we try to minimize the window size
                window.put(leftChar, window.get(leftChar) - 1);

                if(count.containsKey(leftChar) && window.get(leftChar) < count.get(leftChar)){
                    have --;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]+ 1);
    }
}
