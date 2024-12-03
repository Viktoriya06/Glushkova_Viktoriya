def find_min_max_sum_rows(matrix):
    """Finds the rows with minimum and maximum sums in a matrix."""
    if not matrix:  # Handle empty matrix case
        return None, None, None, None

    min_row_index = 0
    max_row_index = 0
    min_sum = sum(matrix[0])
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


def read_matrix_from_file(filename):
    """Reads a matrix from a file. Handles errors."""
    try:
        with open(filename, 'r') as f:
            matrix = []
            for line in f:
                row = list(map(int, line.strip().split()))
                matrix.append(row)
            return matrix
    except FileNotFoundError:
        print(f"Error: File '{filename}' not found.")
        return None
    except ValueError:
        print(f"Error: Invalid data format in file '{filename}'. Numbers must be space-separated.")
        return None
    except Exception as e:
        print(f"An unexpected error occurred while reading the file: {e}")
        return None


def write_results_to_file(filename, min_row, min_sum, max_row, max_sum):
    """Writes results to a file. Handles errors."""
    try:
        with open(filename, 'w') as f:
            f.write(f"Min row: {min_row}, Sum: {min_sum}\n")
            f.write(f"Max row: {max_row}, Sum: {max_sum}\n")
    except Exception as e:
        print(f"Error writing to file '{filename}': {e}")


input_filename = "Глушкова_Виктория_Денисовна_У-243_ввод.txt"
output_filename = "Глушкова_Виктория_Денисовна_У-243_vivod.txt"

matrix = read_matrix_from_file(input_filename)

if matrix is not None:
    min_row, min_sum, max_row, max_sum = find_min_max_sum_rows(matrix)
    if min_row is not None:  # Check for empty matrix
        write_results_to_file(output_filename, min_row, min_sum, max_row, max_sum)
        print(f"Results written to '{output_filename}'")
        print(f"Min row: {min_row}, Sum: {min_sum}")
        print(f"Max row: {max_row}, Sum: {max_sum}")
