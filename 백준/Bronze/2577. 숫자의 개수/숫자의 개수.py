num = 1
for i in range(3) :
    a = int(input())
    num = num*a

k = list(str(num))

for i in range(10) :
    print(k.count(str(i)))