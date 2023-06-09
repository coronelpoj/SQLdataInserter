
import java.util.Scanner;

public class SQLdataInserter {
    
    public static void main(String[] args) {
        int row = 0;
        int maxrow = 0;
        int col = 0;
        int maxcol = 0;
        String value = "";
        String tableName = "";

        System.out.println("Welcome to SQL data inserter generator");
        System.out.print("Input the name of the table: ");
        Scanner tn = new Scanner(System.in);
        tableName = tn.nextLine();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many rows?: ");
        row = sc.nextInt();
        maxrow = row;
        System.out.print("How many columns?: ");
        col = sc.nextInt();
        maxcol = col;

        String[] colname = new String[col];
        String[][] rowcol = new String[row][col];

        Scanner val = new Scanner(System.in);
        Scanner ColumnName = new Scanner(System.in);

        for(int i = 0; i < col; i++){
            System.out.print("Write colunm name " + (i+1) + ":");    
            colname[i] = ColumnName.nextLine();
        }
        
        for(int i = 0; i < row ; i++){
            System.out.println("For row number " + (i+1));

            for(int j = 0;j < col; j++){
                System.out.println("Insert for the column " + colname[j]);
                value = val.nextLine();
                rowcol[i][j] = value;
                
            }
            System.out.println();
            
        }

        // PRINTING OF THE QUERY
        System.out.print("INSERT INTO " + tableName + "(");
        for(int i = 0; i < col; i++){
            if(i == maxcol-1){
                System.out.print(colname[i]);
                
            }else{
            System.out.print(colname[i] + ",");
            }
        }
        System.out.println(")");

       System.out.print("VALUES");
         for(int i = 0; i < row; i++){
            System.out.print("(");

            for(int j = 0; j < col; j++){
                if((i == maxrow-1 && j == maxcol-1) || j == maxcol-1){
                    System.out.print("'" + rowcol[i][j] + "'");
                }
                else{
                System.out.print("'" + rowcol[i][j] + "'");
                System.out.print(",");
                 }
            }
            if(i == maxrow - 1){
                System.out.print(")");
                System.out.print(";");
            }else{
            System.out.println("),");
            }

        }
        
        sc.close();
        val.close();
        ColumnName.close();
        tn.close();
    }
   
    
}
