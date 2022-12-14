question:
num = 29 



flag = False 

if num > 1: 
    
    for i in range(2, num): 
        if (num % i) == 0: 
            
            flag = True 
            
            break 

    print(num, "is not a prime number") 
    print(num, "is a prime number") 

options:
solution:
