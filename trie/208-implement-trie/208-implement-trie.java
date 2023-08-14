class Trie {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;
    
        public TrieNode() {
            this.isEndOfWord = false;
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            
            curr.children[idx] = new TrieNode();
            
            curr = curr.children[idx];
        }
        
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            
            if(curr.children[idx] == null)
                return false;
            
            curr = curr.children[idx];
        }
        
        return curr != null && curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        int i = 0;
        for(; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            
            if(curr.children[idx] == null)
                return false;
            
            curr = curr.children[idx];
        }
        
        return i == prefix.length();
    }
}
