def filter_odd_numbers(arr):
    odd_numbers = [num for num in arr if num % 2 != 0]

    if not odd_numbers:
        return "Таких чисел нет."

    odd_numbers.sort(reverse=True)
    return odd_numbers

array = [3, 5, 2, 8, 1, 4]
result = filter_odd_numbers(array)

if isinstance(result, str):
    print(result)  
else:
    print("Массив нечётных чисел в порядке убывания:", result)
