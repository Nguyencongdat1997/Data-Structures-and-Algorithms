def exchange(A,i,j):
	A[i] = A[i]+A[j]
	A[j] = A[i]-A[j]
	A[i] = A[i]-A[j]
def left(i):
	return 2*(i+1) -1
def right(i):
	return 2*(i+1)+1-1 
def heapSort(A):
	
	def maxHeapify(A,i):
		l = left(i)
		r = right(i)
		if l< heap_size[0] and A[l] > A[i]:
			largest = l
		else: largest = i
		if r< heap_size[0] and A[r] > A[largest]:
			largest = r
		if largest != i:
			exchange(A,i,largest)
			maxHeapify(A,largest)
	def buildMaxHeap(A):
		heap_size[0] = len(A)
		for i in range(len(A)/2):
			maxHeapify(A,len(A)/2 -1 - i)
	heap_size = [0]
	buildMaxHeap(A)
	for i in range(len(A)-1):
		j = len(A)-1 - i
		exchange(A,0,j)
		heap_size[0] -= 1
		maxHeapify(A,0)

A = [1,2,3,5,8,7,6,4,10,11,12,13,14,15,4,2]
heapSort(A)
print A