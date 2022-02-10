import heapq
heap = []

nums = [4,1,7,3,8,5]

for num in nums:
    heapq.heappush(heap , (-num,num))
print(heap)
print(heap[0])

while heap:
    print(heapq.heappop(heap)[1])

