class Node(object):
	"""A node of Suffix Tree has fields:
	1) edge_label: label of the edge which conect this node with his parent. Expressed with 2 value (left_EL,right_EL); the label of this edge will be T[left_EL,left_EL+1,...,right_EL]. edge_label of root will be (0,0).
	2) node_label: this field appears only in a leaf node, presents the starting index of the suffix of that leaf. A node which is not a leaf will have 0 as the value for this field.
	3) children: presents pointer to the child node.!!!!!!!!!!!!!!
	4) parent: presents pointer to the parent node.
	5) path_label: concatenation of edge_labels from root to a node
	6) str_depth: length of path_label
	"""
	def __init__(self):
		self.left_EL = None
		self.right_EL = None
		self.node_label = None
		self.children = set()
		self.parent = None
		self.path_label = None
		self.str_depth = None
		

class SuffixTree1(object):
	"""
	This class will build a suffix tree(T) to represent a string A := a0a1a2a3..a(n-1) with O(n^2) time complexity. *note: Here, string A must be ended with special character $, for more about reason check here: http://www.giaithuatlaptrinh.com/?p=420.
	Some definition:
		- Suffix T[i,i+1,...,n-1] (0<=i<=n-1) is call the i-th suffix of T.
	
	Sequently insert suffixes S0,S1,S2,..,Sn (where Si is the i-th suffix of T) into current suffix tree(CurrentT):
		- Step 1: insert S1 to CurrentT. CurrentT will have only 1 leaf node which presents S0  
		- Step i: insert i-th suffix(Si) to CurrentT as folowing steps:
			+ findPath(P=T[0,1,...,i], CurrentT) :
				- Todo: find a node V so that:
					+ Length of common prefix of V.path_label and Si is greatest.
					+ V is the nearest to Root
				- Return: 
					+ Node V					
					+ The last index of common prefix in P. Name as mpl(matched location of the patern)!!!!!!!!!!!!
					+ The last index of common prefix in T. Name as mpt(matched location of text)!!!!!!!!!!!!!
			+ if mlt < V.right_EL:
				- insert a node X between path which connect V and his parent
				- add a leaf node U to be X's child. Then set Si to U.
			+ if mlt = V.right_EL:
				- add a leaf node U to be V's child. Then set Si to U.
	"""	
	def __init__(self):
		self.root = None
		self.A = None		
		self.n = 0
		#self.CurrentT = None
	def buildSuffixTree(self,original_string):
		self.A = original_string.split()
		self.n = len(self.A)
		self.createSuffixTree()
		for i in range(2,self.n):
			v,mlp,mlt = self.findPath(self.A[i:],0,self.root)
			lv = v.left_EL
			rv = v.right_EL
			if (mlt < rv):
				v.left_EL = mlt
				x = self.makeNode(lv,mlt)

	


	def findPath(self,P,i,CurrentT):
		"""
		"""
		if (P[i] not in CurrentT.children or len(P) == 0):
			return CurrentT,i,CurrentT.right_EL		
		c = CurrentT.children[P[i]]		
		j = c.left_EL
		rc = c.right_EL
		while (i<len(P) and P[i] == self.A[j]):
			i += 1
			j += 1
		if (j> rc):
			return self.findPath(P,i,c)
		else:
			return c,i,j


	def createSuffixTree(self):
		self.root = self.makeNode(0,0)
		u = self.makeLeaf(1,self.n,1)		
		u.parent = self.root
		self.root.children[self.A[1]] = u 

	def makeLeaf(self,i,n,k):A
		"""
			TODO: create a leaf node
			Input:
				i : !!!!!!!!!
				n : length of A
				k : label of the leaf 
		"""
		u = self.makeNode(i,n)
		u.node_label = k
		return u
	def makeNode(self,i,j):
		"""
			TODO: create new node
			Input:
				i : left_EL
				j : right_EL
			Return:
				new node U
		"""
		u = Node()
		u.left_EL = i
		u.right_EL = j
		return u
