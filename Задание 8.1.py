def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def divide_fractions(A, B, C, D):
    numerator = A * D
    denominator = B * C
    common_divisor = gcd(numerator, denominator)
    numerator //= common_divisor
    denominator //= common_divisor

    return numerator, denominator

# Пример использования
A = 1
B = 2
C = 3
D = 4

result_numerator, result_denominator = divide_fractions(A, B, C, D)
print(f"Результат деления: {result_numerator}/{result_denominator}")
