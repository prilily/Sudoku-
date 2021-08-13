

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Main extends Frame
{
    private static final Font FONT = new Font("Verdana",Font.CENTER_BASELINE,20);
    private static final Font bFONT = new Font("Verdana",Font.CENTER_BASELINE,16);

    Main()
    {
        addWindowListener(new WindowAdapter ()
    {
        public void windowClosing (WindowEvent we)
        {
            System.exit(0);
        }
    }
    );

    this.setLayout(new BorderLayout());
   Label welcome= new Label("WELCOME TO THE SUDOKU", Label.CENTER);
   welcome.setFont(FONT);
   welcome.setForeground(Color.BLACK);
   add(welcome);
   Button easy= new Button("EASY");
   Button meduim= new Button("MEDIUM");
   Button hard= new Button("HARD");
   Button advanced= new Button("ADVANCED");

   easy.setFont(bFONT);
   meduim.setFont(bFONT);
   hard.setFont(bFONT);
   advanced.setFont(bFONT);

   Panel buttons= new Panel();
   buttons.setLayout(new GridLayout(2,2,4,4));
   add(buttons,"South");
   buttons.add(easy);
   buttons.add(meduim);
   buttons.add(hard);
   buttons.add(advanced);


  /*Action listeners for the buttons direct them to the game page. for every level we pass a parameter 'K' to the constructor of Celldisplay which decides how many cells will be visible for each game. as the levels advance 'K' decreases.*/
  
   easy.addActionListener(new ActionListener()
   {
       public void actionPerformed(ActionEvent e)
       {
        dispose();
        Celldisplay r = new Celldisplay(28);
        Generator sudoku= Generator.getInstance();
         //for admin reference
        Celldisplay.generate(sudoku,r);
        r.setSize(new Dimension (500,600));
        r.setBackground(Color.WHITE);
        r.setTitle("SUDOKU SOLVER");
        r.setVisible(true);
       }
    });

    meduim.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
    {
        dispose();
        Celldisplay r = new Celldisplay(19);
        Generator sudoku= Generator.getInstance();
         //for admin reference
        Celldisplay.generate(sudoku,r);
        r.setSize(new Dimension (500,600));
        r.setBackground(Color.WHITE);
        r.setTitle("SUDOKU SOLVER");
        r.setVisible(true);
    }
    });

    hard.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
        dispose();
        Celldisplay r = new Celldisplay(14);
        Generator sudoku= Generator.getInstance();
         //for admin reference
        Celldisplay.generate(sudoku,r);
        r.setSize(new Dimension (500,600));
        r.setBackground(Color.WHITE);
        r.setTitle("SUDOKU SOLVER");
        r.setVisible(true);
    }    
    });

    advanced.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
        dispose();
        Celldisplay r = new Celldisplay(12);
        Generator sudoku= Generator.getInstance();
         //for admin reference
        Celldisplay.generate(sudoku,r);
        r.setSize(new Dimension (500,600));
        r.setBackground(Color.WHITE);
        r.setTitle("SUDOKU SOLVER");
        r.setVisible(true);
    }
    });




}

public Insets getInsets()
{
  //for border layout
    return new Insets(15,10,60,10);
}

    public static void main(String[] args) {
        Main r = new Main();
        r.setSize(new Dimension (500,300));
        r.setBackground(Color.WHITE);
        r.setTitle("SUDOKU");
        r.setVisible(true); 
    }
}
