// A Node represents one character/position in the Trie.
class Node {

    // Each node can have at most 26 children:
    // index 0  -> 'a'
    // index 1  -> 'b'
    // ...
    // index 25 -> 'z'
    Node[] links = new Node[26];

    // true means that a complete word ends at this node.
    // Example:
    // If we insert "apple", the node representing 'e'
    // will have flag = true.
    boolean flag = false;

    // Constructor
    public Node() {
        // links is already initialized above.
        // Initially, all 26 positions contain null.
    }

    // Checks whether a child node exists for the given character.
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Returns the child node corresponding to the character.
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Creates/connects a child node for the given character.
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Marks the current node as the end of a complete word.
    void setEnd() {
        flag = true;
    }

    // Checks whether a complete word ends at the current node.
    boolean isEnd() {
        return flag;
    }
}


public class Trie {

    // Root is the starting point of the Trie.
    // It does NOT represent any character.
    private Node root;

    // Constructor creates an empty Trie.
    public Trie() {
        root = new Node();
    }


    // Inserts a word into the Trie.
    public void insert(String word) {

        // Start from the root.
        Node node = root;

        // Traverse every character of the word.
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            // If the current character does not have
            // a corresponding node, create a new node.
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            // Move to the node representing the current character.
            node = node.get(ch);
        }

        // After processing all characters,
        // mark the last node as the end of the word.
        node.setEnd();
    }


    // Searches for an exact word in the Trie.
    public boolean search(String word) {

        // Start from the root.
        Node node = root;

        // Traverse every character.
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            // If a character is missing,
            // the word does not exist.
            if (!node.containsKey(ch)) {
                return false;
            }

            // Move to the next node.
            node = node.get(ch);
        }

        // We found all characters.
        // But we still need to check whether
        // this node represents the END of a word.
        return node.isEnd();
    }


    // Checks whether any word in the Trie starts
    // with the given prefix.
    public boolean startsWith(String prefix) {

        // Start from the root.
        Node node = root;

        // Traverse every character of the prefix.
        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            // If any character is missing,
            // no word starts with this prefix.
            if (!node.containsKey(ch)) {
                return false;
            }

            // Move to the next node.
            node = node.get(ch);
        }

        // We successfully traversed the entire prefix.
        return true;
    }
}