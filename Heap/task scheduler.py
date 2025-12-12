import heapq
from typing import List
def leastInterval(self, tasks: List[str], n: int) -> int:
    freq = {}
    for task in tasks:
        freq[task] = freq.get(task, 0) + 1
    maxHeap = []
    for f in freq.values():
        heapq.heappush(maxHeap,-f)
    cycle = n + 1
    time = 0
    while maxHeap:
        arr = []
        i = 0
        while i<cycle and maxHeap:
            f = -heapq.heappop(maxHeap)
            time+=1
            f-=1
            if f>0:
                arr.append(f)
            i+=1
        if (not maxHeap) and (not arr):
            break
        if not maxHeap:
            time+=(cycle-i)
        for f in arr:
            heapq.heappush(maxHeap,-f)
    return time