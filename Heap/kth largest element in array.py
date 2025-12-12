import heapq
from typing import List
def findKthLargest(self, nums: List[int], k: int) -> int:
    heap = []
    for i in nums:
        heapq.heappush(heap,-i)
    for i in range(1,k):
        heapq.heappop(heap)
    return -heap[0]