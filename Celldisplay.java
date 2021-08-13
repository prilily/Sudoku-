
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;



public class Celldisplay extends Frame implements java.awt.event.KeyListener
, java.awt.event.ActionListener
{
    static int K;
    
  private static final Font FONT = new Font("Verdana",Font.CENTER_BASELINE,20);
  Panel buttonPanel=new Panel();
  Panel cells= new Panel();
  final JTextField[][] grid;

//to get coordinates/index of a jtextfield. used to match user input in event listener  
  private final Map<JTextField, Point> mapFieldToCoordinates =  new HashMap<>();
  Button newButton=new Button("New Puzzle");
  Button solveButton=new Button("Solve");
  Button clearButton=new Button("Clear");
  Graphics gr;
    Celldisplay(int K)
    { //constructor
        Celldisplay.K=K;
        this.setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter ()
        {
            public void windowClosing (WindowEvent we)
            {
                System.exit(0);
            }
        }
        );
    
    setBackground(Color.WHITE);
    setLayout(new BorderLayout());
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    Dimension fieldDimension = new Dimension(40, 40); //for textfield cells

    add("South", buttonPanel);
    add("North",cells);
    buttonPanel.setLayout(new GridLayout(1,3));
    
    buttonPanel.add(newButton);
    newButton.setFont(FONT);
    clearButton.setFont(FONT);
    solveButton.setFont(FONT);
    
    newButton.setBackground(Color.WHITE);
    buttonPanel.add(solveButton);
    solveButton.setBackground(Color.WHITE);
    buttonPanel.add(clearButton);
    
    clearButton.setBackground(Color.WHITE);

    solveButton.addActionListener(new SudokuansListener(this));

    
    cells.setLayout(new GridLayout(9,9));
    
    this.grid= new JTextField[9][9];

    //for placing cells and their design with event listener
    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            JTextField field = new JTextField();  
            field.setBorder(border);
            field.setFont(FONT);
            field.setHorizontalAlignment(JTextField.CENTER);
            field.setPreferredSize(fieldDimension);         
            grid[i][j] = field;
            mapFieldToCoordinates.put(field, new Point(j, i));
            cells.add(grid[i][j]);
            if((i/3+j/3)%2==0)
            {
                grid[i][j].setBackground(Color.decode("#AFEEEE"));
            }
            else
            {grid[i][j].setBackground(Color.decode("#E0FFFF"));}
            
            grid[i][j].addKeyListener(new SudokuCellKeyListener(this));
            //grid[i][j].addKeyListener(this);

        }    
    }
    
    //clears the cells filled by user which aren't correct
    clearButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if((grid[i][j].isEditable())==true)
                    {
                        if((i/3+j/3)%2==0)
                        {
                              grid[i][j].setBackground(Color.decode("#AFEEEE"));
                        }
                         else
                             {grid[i][j].setBackground(Color.decode("#E0FFFF"));}
                        grid[i][j].setText("");
                    }
                }
            }
        }
    });

   

  
//send back to main page to choose level and start again
    newButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        Main r = new Main();
        r.setSize(new Dimension (500,300));
        r.setBackground(Color.WHITE);
        r.setTitle("SUDOKU");
        r.setVisible(true); 
        }
    });
}

Point getIndex(JTextField field)
{   //use for returning the indexes
    Point coordinates= mapFieldToCoordinates.get(field);
    return coordinates;
}


public static void generate(Generator sudoku,Celldisplay r)
{
  //uses the object from generator class to assign visible cells to user.
    for(int count=K;count>0;count--)
    {
        int a=sudoku.randomGenerator(9)-1;
        int b=sudoku.randomGenerator(9)-1;
        JTextField j =r.grid[a][b];
        j.setText(""+sudoku.mat[a][b]);
        j.setEditable(false);
        j.setBackground(Color.decode("#B0E0E6"));
    }
}

    int getDimension() {
        return 9;
    } 
    
    
    public Insets getInsets()
    {//for border layout.
        return new Insets(70,20,40,20);
    }

       public static void main(String[] args) 
       {
        int K=20; //K manages no of cells shown to user based on their level
        Celldisplay r = new Celldisplay(K); //constructor accepts K
        Generator sudoku= Generator.getInstance();
        //sudoku.printSudoku(); will print it.
        generate(sudoku,r);
        r.setSize(new Dimension (500,600));
        r.setBackground(Color.decode("#F0F8FF"));
        r.setTitle("SUDOKU SOLVER");
        r.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
