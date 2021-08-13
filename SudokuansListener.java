
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JTextField;


public class SudokuansListener implements java.awt.event.ActionListener
 { //action listener for solve button
    private final Celldisplay r;
    Generator sudoku = Generator.getInstance();
    SudokuansListener(Celldisplay r)
    {
        this.r=r;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++)
     {
         for(int j=0;j<9;j++)
         {
             //fills unfilled cells in sudoku.
            JTextField jt= r.grid[i][j];
            if(jt.isEditable()==true)
            {
            jt.setText(""+sudoku.mat[i][j]);
            jt.setEditable(false);
            jt.setBackground(Color.decode("#9bf09b"));
            jt.setForeground(Color.BLUE);
            // jt.setBackground(Color.BLACK);
            }
         }
     }
        
    }
}
