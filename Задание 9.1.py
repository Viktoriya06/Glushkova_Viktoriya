def find_min_max_row(matrix):
    min_sum = float('inf')
    max_sum = float('-inf')
    min_row = 0
    max_row = 0
    
    for i in range(len(matrix)):
        row_sum = sum(matrix[i])
        if row_sum < min_sum:
            min_sum = row_sum
            min_row = i
        if row_sum > max_sum:
            max_sum = row_sum
            max_row = i
    
    return min_row, max_row, min_sum, max_sum

matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]]

min_row, max_row, min_sum, max_sum = find_min_max_row(matrix)

print(f"Строка с наименьшей суммой элементов: {min_row}, сумма элементов: {min_sum}")
print(f"Строка с наибольшей суммой элементов: {max_row}, сумма элементов: {max_sum}")

