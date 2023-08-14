class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>(); 
        Set<Integer> visited = new HashSet<>(); 
        stack.add(0);
        visited.add(0);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int neighbour : rooms.get(current))
                if (!visited.contains(neighbour)) {
                    stack.add(neighbour);
                    visited.add(neighbour);
                    if (rooms.size() == visited.size()) return true;
                }
        }
        return rooms.size() == visited.size();
    }
}