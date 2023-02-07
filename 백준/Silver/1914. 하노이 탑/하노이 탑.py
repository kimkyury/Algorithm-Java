def hanoi(n,f,temp,to):
    if n==1:
        value.append([f,to])
        return
    
    hanoi(n-1,f,to,temp)
    value.append([f,to])
    hanoi(n-1,temp,f,to)



n= int(input())
value=[]
print(2**n-1)
if n<=20:
    hanoi(n,1,2,3)

    
    for i in value:
        print(str(i[0])+" "+str(i[1]))
    

