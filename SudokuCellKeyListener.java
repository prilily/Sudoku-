
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.JTextField;

public class SudokuCellKeyListener implements  java.awt.event.KeyListener
{
    private final Celldisplay grid;

    Generator sudoku = Generator.getInstance();//singleton class function. to use same object

    //in constructor grid is passed as an argument
    SudokuCellKeyListener(Celldisplay grid)
    {
        this.grid=grid;
    }


    public void keyTyped(KeyEvent e)
    {   
        int i,j;
        char c= e.getKeyChar();//gets the character typed
        JTextField tf=(JTextField)e.getSource();


        if(!(Character.isDigit(c))  || (c==KeyEvent.VK_DELETE))
               { //to check if entered key is not digit
                 e.consume(); }

        String s= ""+grid.getDimension();
        int digits= s.length();

        if(tf.getText().length()>=digits)
            e.consume();//length of string entered between 1-9
            

        //System.out.println("Key Typed : "+ e.getKeyChar());
        
        Point l=grid.getIndex(tf);

        j=l.x;
        i=l.y;

        char a=(char)(sudoku.mat[i][j]+'0'); //convert int value of the mat[i][j to char and use it to compare with entered value 
       int compare = Character.compare(a,c); 
       if(compare==0)//both are equal
       {   // a<c -ve or a>c so +ve
           //same values : green
           tf.setText(""+sudoku.mat[i][j]);
           tf.setBackground(Color.decode("#90EE90"));
           tf.setEditable(false);
       }
       else if(compare <0)
       {//entered value is greater thann actual answer :tomato red
           tf.setBackground(Color.decode("#FF7F50"));
       }
       else
       {//entered value is less thann actual answer :coral
           tf.setBackground(Color.decode("#FFDAB9"));
       }
 }


    public void keyReleased(KeyEvent k)
    {
    }
    public void keyPressed(KeyEvent k)
    {
    }
}
