def process_matrix(A):
    n = len(A)  # Размерность квадратной матрицы
    
    # Преобразуем матрицу согласно условию задачи
    for i in range(n):
        for j in range(n):
            if A[i][j] < 0:
                A[i][j] = 0
            elif A[i][j] > 0:
                A[i][j] = 1
    
    # Формируем нижнюю треугольную матрицу
    lower_triangular = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(i + 1):
            lower_triangular[i][j] = A[i][j]
    
    return lower_triangular

# Пример использования функции
A = [
    [1, -2, 3],
    [4, 5, -6],
    [7, 8, 9]
]
lower_triangular = process_matrix(A)
for row in lower_triangular:
    print(row)
