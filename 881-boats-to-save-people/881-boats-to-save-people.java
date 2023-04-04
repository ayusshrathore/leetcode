class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int min = 0, max = people.length-1, ships = 0;
        
        while(min <= max) {            
            if(people[min] + people[max] <= limit)
                min = min + 1;
            
            max = max - 1; // since heavy person can't be paired with anyone & would need 1 extra boat
            ships++;
        }
        
        return ships;
    }
}
