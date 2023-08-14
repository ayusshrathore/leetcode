class SummaryRanges {
	Set<Integer> set;

	public SummaryRanges() {
		set = new HashSet<>();
	}

	public void addNum(int value) {
		set.add(value);
	}

	public int[][] getIntervals() {
		List<Integer> nums = new LinkedList<>(set);
		Collections.sort(nums);
        
		List<List<Integer>> list = new LinkedList<>();
		for (int i = 0; i < nums.size(); i++) {
			// get left number
			int left = nums.get(i);
            
			while (i < nums.size() - 1 && nums.get(i) + 1 == nums.get(i + 1)) {
				// get right number
				i++;
			}
            
			// add left and right number range
			list.add(Arrays.asList(left, nums.get(i)));
		}

		// convert list of list of integer to int[][]
		int[][] arr = new int[list.size()][];
		
		for (int i = 0; i < list.size(); i++) {
			List<Integer> temp = list.get(i);
			arr[i] = new int[temp.size()];
			for (int j = 0; j < temp.size(); j++) {
				arr[i][j] = temp.get(j);
			}
		}
		return arr;
	}
}