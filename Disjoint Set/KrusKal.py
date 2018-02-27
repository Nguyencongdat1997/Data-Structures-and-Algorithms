'''Kruskal 
pseudocode:
class disjointset
A = [(u,v,w)] :array of edges
B = [(u)]: array of nodes type disjointset
sort A accendding
for i in A:
	if B.find(i.u) == B.find(i.v): 
		A.pop(i)
	else:
		B.union(u,v)
print A
'''
class DisjointSets(object):
    '''
    This implements disjoint set data structure
    There are many way to implement disjoint sets, this is just one of them.
    NOTE: Internal methods are prefixed by __
    '''
    def __init__(self, n):
        #n: number of elements initially, all elements are from 0 to n-1
        self.sets = [self.Node(i) for i in range(n)]
 
    def union(self, x, y):
        #this function is exposed to the user
        #so x, y are integers
        x = self.sets[x]
        y = self.sets[y]
        self.__link(self.__find(x), self.__find(y))
 
    def __link(self, x, y):
        if x.rank > y.rank:
            y.p = x
        else:
            x.p = y
            if x.rank == y.rank:
                y.rank += 1
 
    def find(self, x):
        #this function is exposed to the user
        #so x is an integer
 
        #error handling
        if x<0 or x>=len(self.sets): return -1
        x = self.sets[x]
        return self.__find(x).val
 
    def __find(self, x):
        if x.p == None: return x
        x.p = self.__find(x.p)
        return x.p	
class Node(object):
	def __init__(self, i):
		self.val = i
		self.p = None #parent
		self.rank = 0 #this is a heuristic to keep the the set tree shortest 
class Edge(object):
	def __init__(self,u,v,w):
		self.firstNode = u
		self.secondNode = v
		self.weight = w
B = DisjointSets(9)
new_edge = Edge(0,1,4)
A.append(new_edge)
new_edge = Edge(1,2,8)
A.append(new_edge)
new_edge = Edge(1,8,11)
A.append(new_edge)
new_edge = Edge(2,3,7)
A.append(new_edge)
new_edge = Edge(2,5,4)
A.append(new_edge)
new_edge = Edge(3,4,9)
A.append(new_edge)
new_edge = Edge(3,5,14)
A.append(new_edge)
new_edge = Edge(5,4,10)
A.append(new_edge)
new_edge = Edge(5,6,2)
A.append(new_edge)
new_edge = Edge(6,7,1)
A.append(new_edge)
new_edge = Edge(7,8,7)
A.append(new_edge)
print A
for i in range(len(A)-1):
	for j in range(i,len(A)):
		if A[i].w>A[j].w:
			t = A[i]
			A[i] = A[j]
			A[j] = t
i =0
while (i<len(A))
	if B.find(i.firstNode) == B.find(i.secondNode): 
		A.pop(i)
	else:
		B.union(u,v)
print A			