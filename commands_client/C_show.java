package commands_client;

public class C_show {
	public static String[][] show(String sb) {
		try {
		//extract each line from the sb by splitting after the newline character \n
        final String[] rows = sb.toString().split("\n");
        //each line represent a row, so the numbers of lines is the number of rows in our matrix
        final int totalRows = rows.length;
        //the lenght of each line, if we replace space with nothing, represents the number of columns
        //columns have the same number of elements for each line so we can read it from the first row, row[0]. it will be the same for all the others 
        final int totalColumns = rows[0].replace(" ", "").length();
        //create matrix with proper size
        final String[][] matrix = new String[totalRows][totalColumns];

        //initialize first row index
        int currentRow = 0;
        //initialize first column index
        int currentColumn = 0;
        //System.out.println(rows);
        for (String row : rows) { //for each row
            row = row.substring(0, row.length() - 1); //remove last space character
            final String[] elements = row.split(";"); //store each element of the row in an array by splitting after the space character
            for (final String element : elements) { //for each element
                //add element in matrix at correct position
                matrix[currentRow][currentColumn] = element; //convert string to int
                //increment column count for the next element
                currentColumn++;
            }
            //increment row count for the next row
            currentRow++;
            //reset column counter for the next row
            currentColumn = 0;
        }
        
//        for (int i = 0; i < totalRows; i++) {
//            for (int j = 0; j < totalColumns; j++) {
//                if (j == 7) {
//                    //if last column add a newline after the element
//                    System.out.print(matrix[i][j] + "\r\n"); // where \r\n = CarriageReturn + LineFeed and is used as a new line character in Windows
//                    //or simply replace the above line with System.out.println(matrix[i][j]);
//                } else {
//                    //if not last column add just a space after the element
//                    System.out.print(matrix[i][j] + " ");
//                }
//            }
//        }
        System.out.println(matrix);
        return matrix;
	}catch(Exception exc) {
		System.out.println("Empty array");
		final String[][] matrix = new String[1][10];
		return matrix; }
	}
}
