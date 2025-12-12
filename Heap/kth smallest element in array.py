import heapq
def kthSmallest(self, arr, k):
        heapq.heapify(arr)
        n = len(arr)
        if k<=n:
            for i in range(1,k):
                heapq.heappop(arr)
            return arr[0]
        heap = []
        for i in arr:
            heap.append(-i)
        heapq.heapify(heap)
        for i in range(1,n-k+1):
            heapq.heappop(heap)
        return -heap[0]
        