class Solution {
    private final List<Character> left = Arrays.asList('(', '[', '{');
    private final List<Character> right = Arrays.asList(')', ']', '}');
    
    public boolean isValid(String str) {
        var stack = new Stack<Character>();

        for (char ch : str.toCharArray()) {
          if (isLeft(ch))
            stack.push(ch);

          if (isRight(ch)) {
            if (stack.isEmpty())
              return false;

            var top = stack.pop();
            if (!bracketsMatch(top, ch))
              return false;
          }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char ch) {
        return left.contains(ch);
    }

    private boolean isRight(char ch) {
      return right.contains(ch);
    }

    private boolean bracketsMatch(char l, char r) {
      return left.indexOf(l) == right.indexOf(r);
    }
    
}