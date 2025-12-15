def lengthOfEachSubArray(size):
    arr = [None] * size

    for i in range(size):
        length = 0
        for j in range(size):
            if j >= i and j >= size - i - 1 and j >= size / 2:
                length += 1
        arr[i] = [""] * length

    return arr

def printMatrix(arr, symbol, size, file):
    print("Результат матриці")

    with open(file, "w", encoding="utf-8") as writer:
        for i in range(size):
            index_j = 0
            for j in range(size):
                if j >= i and j >= size - i - 1 and j >= size / 2:
                    arr[i][index_j] = symbol
                    writer.write(arr[i][index_j] + " ")
                    print(arr[i][index_j], end=" ")
                    index_j += 1
                else:
                    writer.write("  ")
                    print("  ", end="")
            print()
            writer.write("\n")
        writer.flush()

if __name__ == '__main__':
    size = int(input("Введіть розмір матриці: "))
    symbol = input("Введіть символ заповнювач: ")

    if len(symbol) != 1:
        print("Введіть коректний символ заповнювач")
    else:
        arr = lengthOfEachSubArray(size)
        file_name = "matrix_output.txt"
        printMatrix(arr, symbol, size, file_name)

