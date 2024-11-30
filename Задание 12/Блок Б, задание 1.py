def find_max():
    n = int(input("Введите число: "))
   
    if n == 0:
        return 0
    
    max_in_rest = find_max()
    
    return max(n, max_in_rest)


print("Наибольшее число в последовательности:", find_max())
