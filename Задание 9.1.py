def find_min_max_sum_rows(matrix):
    # Инициализация переменных для хранения индексов строк с минимальной и максимальной суммами
    min_row_index = 0
    max_row_index = 0
    
    # Вычисление начальных значений минимальных и максимальных сумм (берем первую строку)
    min_sum = sum(matrix[min_row_index])
    max_sum = min_sum
    
    for i in range(1, len(matrix)):
        current_sum = sum(matrix[i])
        
        if current_sum < min_sum:
            min_sum = current_sum
            min_row_index = i
            
        if current_sum > max_sum:
            max_sum = current_sum
            max_row_index = i
    
    return matrix[min_row_index], min_sum, matrix[max_row_index], max_sum

# Пример использования функции
matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [-7, -8, -9]
]
min_row, min_sum, max_row, max_sum = find_min_max_sum_rows(matrix)
print(f"Строка с минимальной суммой: {min_row}, сумма: {min_sum}")
print(f"Строка с максимальной суммой: {max_row}, сумма: {max_sum}")
