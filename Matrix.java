public class Matrix {

    public int rows, collumns;
    private Number[][] matrix;

    public Matrix(int row, int collumn){
        rows = row;
        collumns = collumn;
        matrix = new Number[row][collumn];
    }

    public Matrix fill(Number... numbers){
        if (numbers.length > (rows * collumns)){
            throw new NumberFormatException("To much input");
        }

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < collumns; c++){
                if (numbers.length <= r * c){
                    matrix[r][c] = numbers[r * c];
                }else {
                    matrix[r][c] = 0;
                }
            }
        }

        return this;
    }

    public Number get(int row, int collumn){
        return matrix[row][collumn];
    }

    public Matrix multiply(Number number){
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < collumns; c++){

            }
        }
        return this;
    }
}
