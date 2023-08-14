class Solution {
    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
        
       if(digits.length() == 0) return res;
        
       Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        f(0, digits, map, res, new StringBuilder());
        return res;
    }

    private static void f(int idx,  String digits, Map<Character, String> map, List<String>res, StringBuilder sb){

       if (idx == digits.length()) {

            res.add(sb.toString());
            
            return;
       }
        
        String curr = map.get(digits.charAt(idx));

        for (int i = 0; i < curr.length(); i++){

            sb.append(curr.charAt(i));

            f(idx + 1, digits, map, res, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}