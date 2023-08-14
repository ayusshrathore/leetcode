class Solution { // BitMask DP O(n*m)
    private int n, m, targetMask;
    private List<Integer> result;
    private Map<String, Integer> dp;
    
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        this.n = req_skills.length;
        this.m = people.size();
        this.result = new ArrayList<>();
        this.dp = new HashMap<>();
        
        Map<String, Integer> mp = new HashMap<>(); // skills -> unqiue idx number
        
        for(int i = 0; i < n; i++) { // calculating unique id's for each skills
            String skillName = req_skills[i];
            mp.put(skillName, i);
        }
        
        List<Integer> peopleSkill = new ArrayList<>();
        for(List<String> skills: people) { // convert each skills into relevant decimal respresentation using bit maipulation
            
            int skillBit = 0;
            for(String skill : skills) {
                skillBit = skillBit | (1 << mp.get(skill)); // left shifting with the corresponding idx of this skill in req_skills
            }
            
            peopleSkill.add(skillBit);
        }
        
        this.targetMask = (1 << n) - 1;
        
        List<Integer> tmp = new ArrayList<>();
        
        solve(peopleSkill, 0, tmp, 0); // starting mask = 0;
        
        int[] sufficientTeams = new int[result.size()];
        int i = 0;
        for(int teams : result) {
            sufficientTeams[i++] = teams;
        }

        return sufficientTeams;
    }
    public void solve(List<Integer> peopleSkill, int idx, List<Integer> tmp, int mask) {
        if(idx >= peopleSkill.size()) {
            if(mask == targetMask) { // all bit 1 '1111'
                if(result.size() == 0 || result.size() >= tmp.size()) {
                    result = new ArrayList<>(tmp);
                }
            }
            return;
        }
        
        String key = Integer.toString(idx) + "_" + Integer.toString(mask);
        
        if(dp.containsKey(key)) {
            if(dp.get(key) <= tmp.size()) { // a better result than previous ones
                return;
            }
        }
        
        if(result.size() != 0 && tmp.size() >= result.size()) return; // pruning as we don't need result with larger size than curr result
        
        solve(peopleSkill, idx+1, tmp, mask); // notTake
        
        if((peopleSkill.get(idx) | mask) != mask) {
            tmp.add(idx); // take
        
            solve(peopleSkill, idx+1, tmp, (mask | peopleSkill.get(idx)));
        
            tmp.remove(tmp.size()-1);
            
            dp.put(key, tmp.size() != 0 ? tmp.size() : -1);
        }
        
        
    }
}