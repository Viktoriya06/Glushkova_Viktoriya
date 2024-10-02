def length_of_laces(a, b, l, N):
    # Определяем общее расстояние между дырочками в вертикальных рядах
    vertical_distance = (N-1)*a

    # Определяем общее расстояние между дырочками по горизонтали
    horizontal_distance = (N-1)*b

    # Вычисляем длину одного элемента шнурка для прохождения через дырочку и движение в другой ряд
    lace_element_length = (vertical_distance + horizontal_distance)*2

    # Вычисляем общую длину шнурка с учётом оставшейся части для бантика
    total_lace_length = lace_element_length + 1

    return total_lace_length

# Считываем значение a, b, l  и N
a = int(input("Введите расстояние  между рядами дырочек (a): "))
b = int(input("Ввведите расстояние между дырочками в ряду (b): "))
l = int(input("Введите длину свободного конца шнурка (l): "))
N = int(input("Введите количество дырочек в каждом ряду (N): "))

# Вызываем функцию и выводим результат
result = length_of_laces(a, b, l, N)
print("Итоговая длина шнурка:", result)
