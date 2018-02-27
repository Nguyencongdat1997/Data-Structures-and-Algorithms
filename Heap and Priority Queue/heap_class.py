class Heap(object):
	def __init__(self,B):
		self.val = B
		self.heap_size = 0
		self.buildMaxHeap()
	def heap(self):
		return self.val
	def heap_maximum(self):
		return self.val[0]
	
	def buildMaxHeap(self):
		self.heap_size = len(self.val)
		for i in range(len(self.val)/2):
			self.maxHeapify(len(self.val)/2 -1 - i)
	def maxHeapify(self,i):
		def exchange(A,i,j):
			A[i] = A[i]+A[j]
			A[j] = A[i]-A[j]
			A[i] = A[i]-A[j]
		def left(i):
			return 2*(i+1) -1
		def right(i):
			return 2*(i+1)+1-1
		l = left(i)
		r = right(i)
		if l< self.heap_size and self.val[l] > self.val[i]:
			largest = l
		else: largest = i
		if r< self.heap_size and self.val[r] > self.val[largest]:
			largest = r
		if largest != i:
			exchange(self.val,i,largest)
			self.maxHeapify(largest)
	def remove_maximum(self):
		if self.heap_size <1 :
			return None
		else:
			maximum = self.val[0]
			self.val[0] = self.val[-1]
			self.val.pop()
			self.heap_size -= 1
			self.maxHeapify(0)
			return maximum
	def insert(self,new_object):
		def parent(i):
			return i / 2
		def exchange(A,i,j):
			A[i] = A[i]+A[j]
			A[j] = A[i]-A[j]
			A[i] = A[i]-A[j]
		
		self.val.append(new_object)
		self.heap_size += 1
		i = self.heap_size-1

		while i>0 and self.val[parent(i)]  < self.val[i]:
			exchange(self.val,parent(i),i)
			i = parent(i)


B =[1,2,3,0,3,4]
heap = Heap(B)
heap.insert(5)
print heap.heap()
print heap.heap_maximum()


