def find_max_and_index(arr):
    if not arr:
        return None, None  
    max_element = arr[0]
    max_index = 0
    for i in range(1, len(arr)):
        if arr[i] > max_element:
            max_element = arr[i]
            max_index = i
    return max_element, max_index
array = [3, 5, 1, 8, 6]
max_element, max_index = find_max_and_index(array)
print(f'Максимальный элемент: {max_element}, его порядковый номер: {max_index}')
