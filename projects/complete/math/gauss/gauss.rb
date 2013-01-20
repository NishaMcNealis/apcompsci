def remove_col(matrix, num)
  matrix.each {|row|
    row = row.delete_at num
  }
  return matrix
end

def remove_row(matrix, num)
  matrix.delete_at num
end

def major_cross(matrix, col, row)
  mult = matrix[row][col]
  smaller = remove_col(remove_row(matrix, row), col)
end

def determinant(matrix)
  case matrix.length
  when 2
    return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0]
  when 3
    return 
  end
end
