def is_point_inside_circle(a, b, R, p1, p2):
    distance_squared = (p1 - a) ** 2 + (p2 - b) ** 2
    return distance_squared < R ** 2

def count_points_inside_circle(a, b, R, points):
    count = 0
    for (p1, p2) in points:
        if is_point_inside_circle(a, b, R, p1, p2):
            count += 1
    return count

# Пример использования
a, b, R = 0, 0, 5  # Центр окружности (0,0) и радиус 5
points = [(1, 1), (2, 2), (6, 6), (0, 3), (-3, -4), (0, 0)]

number_of_points_inside = count_points_inside_circle(a, b, R, points)
print(f"Количество точек внутри окружности: {number_of_points_inside}")
