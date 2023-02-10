import math
from collections import deque
import copy

def find(N): #소수 판별
    for i in range(2,int(math.sqrt(N))+1):
        if (N%i)== 0:
            return False
    
    return True

N = int(input())

# 1. 맨 앞자리에 소수인 값을 구해서 q에 넣는다.
# 2. q에서 소수를 꺼내고 1,3,5,7,9를 붙이고 소수 판단 반복한다.
# 3. 

dir = [1,3,5,7,9]
q=deque([2,3,5,7])
#q= #앞자리는 이것만 소수 가능
q2=deque()
for _ in range(N-1): #자릿수
    while q:
        value=q.popleft()
        
        for i in dir:
            temp=int(str(value)+str(i))
            if find(temp): #소수이면
                q2.append(temp)
    q=copy.deepcopy(q2)
    q2=deque()

q=list(q)
q.sort()
for i in q:
    print(i)
