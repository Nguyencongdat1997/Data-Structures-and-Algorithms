class DisjointSets(object):
    '''
    This implements disjoint set data structure
    There are many way to implement disjoint sets, this is just one of them.
    NOTE: Internal methods are prefixed by __
    '''
    class Node(object):
        def __init__(self, i):
            self.val = i
            self.p = None #parent
            self.rank = 0 #this is a heuristic to keep the the set tree shortest 
 
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
 
if __name__ == "__main__":
    sets = DisjointSets(11)
    sets.union(1,2)
    sets.union(2,3)
    print sets.find(3)
    sets.union(3,9)
    print sets.find(9)
    print sets.find(1)
    print sets.find(10)