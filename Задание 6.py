def replace_and_count(input_string):
    count_a=input_string.count('a')
    modified_string=input_string.replace('a', 'o')
    total_characters= len(input_string)
    return modified_string, count_a,total_characters
input_string = "Пример строки с буквами а."
modified_string, count_a, total_characters = replace_and_count(input_string)
print("Модифицированная строка:", modified_string)
print("Количество замен:", count_a)
print("Количество символов в строке:", total_characters)
