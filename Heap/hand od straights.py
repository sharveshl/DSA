from typing import List
import heapq
def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        n = len(hand)
        if n%groupSize!=0:
            return False
        freq = {}
        for i in hand:
            freq[i] = freq.get(i,0)+1
        heap = []
        for i in freq:
            heapq.heappush(heap,i)
        while heap:
            val = heap[0]
            if freq[val]==0:
                heapq.heappop(heap)
            else:
                freq[val]-=1
                for j in range(groupSize-1):
                    val+=1
                    if val not in freq or freq[val]==0:
                        return False
                    else:
                        freq[val]-=1
        return True

