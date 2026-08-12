public class Main {

    public static void main(String[] args) {

        // Create an empty Trie
        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("bat");
        trie.insert("ball");


        // Search for complete words
        System.out.println(trie.search("apple"));
        // true

        System.out.println(trie.search("app"));
        // true

        System.out.println(trie.search("application"));
        // true

        System.out.println(trie.search("ap"));
        // false

        System.out.println(trie.search("banana"));
        // false


        // Check prefixes
        System.out.println(trie.startsWith("app"));
        // true

        System.out.println(trie.startsWith("appl"));
        // true

        System.out.println(trie.startsWith("ban"));
        // false

        System.out.println(trie.startsWith("ba"));
        // true
    }
}