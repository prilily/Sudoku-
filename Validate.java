package sudoku;

import javax.swing.JTextField;

public class Validate
{
    JTextField grid[][]=new JTextField[9][9];
     int mat[][] = new int[9][9];
     int value=0;
    Validate(JTextField grid[][], int mat[][], int value)
    {
        this.mat=mat;
        this.grid=grid;
        this.value=value;
    }
       
}
