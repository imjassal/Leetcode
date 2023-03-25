public class TrieImplementation {
    private TrieNode root;
    public TrieImplementation() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        String[] data={"addWord","addWord","addWord","search","search","search"};
        String[][] params={{"bad"},{"dad"},{"mad"},{"pad"},{"bad"},{".ad"}};
        TrieImplementation obj=new TrieImplementation();
        obj.addWord("bad");
        obj.addWord("dad");
        boolean x = obj.search("bad");
        System.out.println(x);
//        x = obj.search("pad");
//        System.out.println(x);
//        x = obj.search(".ad");
//        System.out.println(x);

    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }
}