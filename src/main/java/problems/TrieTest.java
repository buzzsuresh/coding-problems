package problems;


public class TrieTest {

	static class TrieNode {
		private final int SIZE = 4;

		TrieNode[] children;
		char c;
		TrieNode next;
		boolean isEnd;

		public TrieNode() {
			children = new TrieNode[4];
		}

		public TrieNode(char c) {
			this();
			this.c = c;
		}

		public TrieNode child(char ch) {
			TrieNode node = children[ch % SIZE];
			if (node == null) {
				return null;
			} else {
				while (node.next != null) {
					if (node.c == ch) {
						return node;
					}
					node = node.next;
				}

				// Char was at end of list
				if (node.c == ch) {
					return node;
				}

				return null;
			}
		}

		public void addWord(String word) {
			char firstChar = word.charAt(0);
			TrieNode child = child(firstChar);
			if (child == null) {
				child = new TrieNode(firstChar);
				int pos = firstChar % 4;
				if (children[pos] == null) {
					children[pos] = child;
				} else {
					TrieNode node = children[pos];
					while (node.next != null) {
						node = node.next;
					}

					node.next = child;
				}
			}

			if (word.length() > 1) {
				child.addWord(word.substring(1));
			} else {
				child.isEnd = true;
			}
		}

		public void wordsWithPrefix(String prefix, String remainingPrefix, String found) {
			if (remainingPrefix.isEmpty()) {
				// empty, print all words
				for (int i = 0; i < this.children.length; i++) {
					TrieNode node = children[i];
					if (node != null) {						
						node.wordsWithPrefix(prefix, "", found + node.c);
					}
				}
				
				if (this.isEnd) {
					System.out.println(prefix+found);
				}

			} else {
				Character firstChar = remainingPrefix.charAt(0);
				TrieNode child = child(firstChar);
				if (child != null) {
					child.wordsWithPrefix(prefix, remainingPrefix.substring(1), found);
				}

			}
		}

		public void wordsWithPrefix(String prefix) {
			this.wordsWithPrefix(prefix, prefix, "");
		}
	}

	public static void main(String[] args) {
		TrieNode trie = new TrieNode();

		trie.addWord("00X1");
		trie.addWord("00XX2");
		trie.addWord("0");
		
		trie.wordsWithPrefix("0");

	}

}
