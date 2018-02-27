"""
trie class
"""
class Trie:
	def __init__ (self,a):
		self.val = a
		self.words = 0
		self.prefixe = 0
		self.descendants = [None]*26
def addWord(a_trie_node, word):
	if len(word) == 0 :
		a_trie_node.prefixe += 1
		a_trie_node.words += 1
	else:
		a_trie_node.prefixe += 1
		k = word[0]
		word = word[1:]
		if a_trie_node.descendants[ord(k)-97] == None:
			a_trie_node.descendants[ord(k)-97] = Trie(k)
		addWord(a_trie_node.descendants[ord(k)-97],word)
def countWord(a_trie_node, word):
	if len(word) == 0 :
		return a_trie_node.words
	else:
		k = word[0]
		word = word[1:]
		if a_trie_node.descendants[ord(k)-97] == None:
			return 0
		else:
			return countWord(a_trie_node.descendants[ord(k)-97],word)
def countPrefixes(a_trie_node, prefixe):
	if len(prefixe) == 0 :
		return a_trie_node.prefixe
	else:
		k = prefixe[0]
		prefixe = prefixe[1:]
		if a_trie_node.descendants[ord(k)-97] == None:
			return 0
		else:
			return countPrefixes(a_trie_node.descendants[ord(k)-97],prefixe)


root = Trie('')
addWord(root,"meo")
addWord(root,"gau")
addWord(root,"utit")
addWord(root,"meo")
addWord(root,"meomeomeo")
print countWord(root,"meo")
print countPrefixes(root,"meo")
