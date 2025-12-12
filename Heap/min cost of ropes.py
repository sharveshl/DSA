import heapq
from typing import List
class Solution:
   def minCost(self, arr):
    # code here
    if len(arr)==1:
        return 0
    heap = []
    for i in arr:
        heapq.heappush(heap,i)
    cost = 0
    while len(heap)>1:
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        cost+=(a+b)
        heapq.heappush(heap,a+b)
    return cost