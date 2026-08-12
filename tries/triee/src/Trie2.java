class Node2 {

    // Each index represents one character:
    // 0 -> 'a', 1 -> 'b', ..., 25 -> 'z'
    Node2[] links = new Node2[26];

    // Number of words that end at this node.
    // Example:
    // insert("apple") twice -> node('e').cntEndWith = 2
    int cntEndWith = 0;

    // Number of words passing through this node.
    // Example:
    // insert("apple"), insert("app")
    // node('p') will have cntPrefix = 2
    int cntPrefix = 0;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node2 get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node2 node) {
        links[ch - 'a'] = node;
    }

    void increaseEnd() {
        cntEndWith++;
    }

    void increasePrefix() {
        cntPrefix++;
    }

    void deleteEnd() {
        cntEndWith--;
    }

    void reducePrefix() {
        cntPrefix--;
    }

    int getEnd() {
        return cntEndWith;
    }

    int getPrefix() {
        return cntPrefix;
    }
}


public class Trie2 {

    private Node2 root;

    public Trie2() {
        root = new Node2();
    }


    // =========================================================
    // INSERT
    // =========================================================
    // Insert a word into the Trie.
    //
    // Example:
    // insert("apple")
    //
    // root
    //   |
    //   a
    //   |
    //   p
    //   |
    //   p
    //   |
    //   l
    //   |
    //   e
    //
    // Time Complexity: O(L)
    // L = length of word
    //
    // Space Complexity: O(L) in the worst case
    // if all characters require new nodes.
    // =========================================================

    public void insert(String word) {

        Node2 node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            // If node for this character doesn't exist,
            // create it.
            if (!node.containsKey(ch)) {
                node.put(ch, new Node2());
            }

            // Move to the character node.
            node = node.get(ch);

            // This word passes through this node.
            node.increasePrefix();
        }

        // The complete word ends at this node.
        node.increaseEnd();
    }


    // =========================================================
    // COUNT WORDS EQUAL TO
    // =========================================================
    //
    // Returns how many times the exact word was inserted.
    //
    // Example:
    //
    // insert("apple")
    // insert("apple")
    // insert("app")
    //
    // countWordsEqualTo("apple") -> 2
    // countWordsEqualTo("app")   -> 1
    //
    // Time Complexity: O(L)
    // Space Complexity: O(1)
    // =========================================================

    public int countWordsEqualTo(String word) {

        Node2 node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            // If the path doesn't exist,
            // the word was never inserted.
            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }

        // We reached the final character.
        // cntEndWith tells us how many words
        // exactly end here.
        return node.getEnd();
    }


    // =========================================================
    // COUNT WORDS STARTING WITH
    // =========================================================
    //
    // Returns how many inserted words have the given prefix.
    //
    // Example:
    //
    // insert("apple")
    // insert("app")
    // insert("application")
    // insert("bat")
    //
    // countWordsStartingWith("app") -> 3
    //
    // Time Complexity: O(L)
    // Space Complexity: O(1)
    // =========================================================

    public int countWordsStartingWith(String word) {

        Node2 node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }

        // cntPrefix contains the number of words
        // passing through this prefix node.
        return node.getPrefix();
    }


    // =========================================================
    // ERASE
    // =========================================================
    //
    // Removes ONE occurrence of the given word.
    //
    // Important:
    // We first check whether the exact word exists.
    //
    // Example:
    //
    // insert("apple")
    // insert("apple")
    //
    // erase("apple")
    //
    // Now:
    // countWordsEqualTo("apple") -> 1
    //
    // Time Complexity: O(L)
    // Space Complexity: O(1)
    // =========================================================

    public void erase(String word) {

        Node2 node = root;

        // First traverse the Trie and check whether
        // the complete word actually exists.

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                // Word does not exist.
                return;
            }

            node = node.get(ch);
        }

        // The path exists, but the exact word may not exist.
        //
        // Example:
        // Trie contains "apple"
        // erase("app")
        //
        // The path "app" exists, but "app" was never
        // inserted.
        if (node.getEnd() == 0) {
            return;
        }


        // Now we know that the word exists.

        node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            node = node.get(ch);

            // One word is being removed from this prefix.
            node.reducePrefix();
        }

        // One occurrence of the complete word is removed.
        node.deleteEnd();
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        Trie2 trie = new Trie2();

        // Insert words
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("bat");


        // -----------------------------------------------------
        // countWordsEqualTo()
        // -----------------------------------------------------

        System.out.println(
                "Words equal to apple: "
                        + trie.countWordsEqualTo("apple")
        );

        System.out.println(
                "Words equal to app: "
                        + trie.countWordsEqualTo("app")
        );

        System.out.println(
                "Words equal to bat: "
                        + trie.countWordsEqualTo("bat")
        );


        // -----------------------------------------------------
        // countWordsStartingWith()
        // -----------------------------------------------------

        System.out.println(
                "Words starting with app: "
                        + trie.countWordsStartingWith("app")
        );

        System.out.println(
                "Words starting with ap: "
                        + trie.countWordsStartingWith("ap")
        );

        System.out.println(
                "Words starting with bat: "
                        + trie.countWordsStartingWith("bat")
        );


        // -----------------------------------------------------
        // ERASE
        // -----------------------------------------------------

        trie.erase("apple");

        System.out.println(
                "After erasing apple once: "
                        + trie.countWordsEqualTo("apple")
        );

        System.out.println(
                "Words starting with app after erase: "
                        + trie.countWordsStartingWith("app")
        );


        // Trying to erase a word that doesn't exist
        trie.erase("xyz");

        System.out.println(
                "Words equal to xyz: "
                        + trie.countWordsEqualTo("xyz")
        );


        // "ap" is a prefix but not necessarily a complete word
        trie.erase("ap");

        System.out.println(
                "Words starting with ap: "
                        + trie.countWordsStartingWith("ap")
        );
    }
}