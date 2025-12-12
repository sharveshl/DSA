import heapq
def nearlySorted(self, arr, k):  
        n = len(arr)
        heap = []
        for i in range(k+1):
            heapq.heappush(heap,arr[i])
        ind = 0
        while(k+1<n):
            arr[ind] = heapq.heappop(heap)
            ind+=1
            heapq.heappush(heap,arr[k+1])
            k+=1
        while heap:
            arr[ind] = heapq.heappop(heap)
            ind+=1