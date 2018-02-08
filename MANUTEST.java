//package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;
import java.awt.Graphics2D;

public class MANUTEST  extends JPanel implements ActionListener{ //=======================================

//----------------------------------Settings du board---------------------------
static int nbligne=10;
static int nbcolumn=20;
static double size=35;
static int identify=0;
//------------------------------------------------------------------------------
Paint Couleur=Color.black;
Hexagone myGrid[][] = new Hexagone[nbligne][nbcolumn];
Hexagone SelectedHex[]=new Hexagone[1];
double horizontalAlignement=50;
double verticalAlignement=50;

GridLayout experimentLayout = new GridLayout(4,3,5,5);
JLabel label1 = new JLabel("Mouvement du pion selectionne");
JLabel label2 = new JLabel();
JLabel label3 = new JLabel();
JButton b1 = new JButton();
JButton b2 = new JButton();
JButton b3 = new JButton();
JButton b4 = new JButton();
JButton b5 = new JButton();
JButton b6 = new JButton();
JButton b7 = new JButton();
JButton b8 = new JButton();
JComboBox cb1=new JComboBox();

//---------------------------Constructeur de MANUTEST---------------------------
public MANUTEST(){
  final JPanel context = this;
  this.addMouseListener(new MouseAdapter(){
    @Override
    public void mouseClicked(MouseEvent arg0) {
      for(Hexagone[] h: myGrid){
        for(Hexagone j: h){
          if(j.contains(arg0.getPoint())){
          //System.out.println("click");
          System.out.println("Id de l'hexa: " +j.getId()+ " Col: "+j.getCol()+" Row: "+j.getRow());
            if (SwingUtilities.isLeftMouseButton(arg0) && myGrid[j.getRow()][j.getCol()].isSelected!=1) {
               myGrid[j.getRow()][j.getCol()].isSelected=1;
               SelectedHex[0]=myGrid[j.getRow()][j.getCol()];
             }
            else if (SwingUtilities.isLeftMouseButton(arg0) && myGrid[j.getRow()][j.getCol()].isSelected==1) {
                myGrid[j.getRow()][j.getCol()].isSelected=0;
                SelectedHex[0]=null;
            }
            context.repaint();
          }
        }
      }
    }
  });
}

//------------------------------DEBUT PAINT COMPONENT---------------------------

  public void paintComponent(Graphics g) { //===================================
  super.paintComponent(g);
  Graphics2D g2d = (Graphics2D) g;
  g2d.setPaint(Couleur);
  //ImageIcon d= new ImageIcon(getClass().getResource("Plateau.png"));
  //Image img = d.getImage();
  // g.drawImage(img,0,0,1300,1000,null);

//----Initialisation du l'ensemble de la grille +dessin ------------------------
  for (int i = 0; i <nbligne; i++){
    for (int l=0;l<nbcolumn;l++) {
//----Création de l'objet hexagone----------------------------------------------
Color RedColor = new Color(206, 48, 48,200);
Color LightGreenColor = new Color(0,255,128,70);
        //identify=identify+1;
        //myGrid[i][l] = new Hexagone(l,i,identify);
      // System.out.println("Loading Grid Cell number: " +myGrid[i][l].getId());

//----Position hexagone---------------------------------------------------------
      if(l==0){
      horizontalAlignement=size;
      verticalAlignement=size+(i*2*size*0.850);
      }
      else if(l%2>0){
        horizontalAlignement=horizontalAlignement+size*2*0.75;
        verticalAlignement=verticalAlignement+Math.sqrt(3)/2*size;
      }
      else{
        horizontalAlignement=horizontalAlignement+size*2*0.75;
        verticalAlignement=size+(i*2*size*0.850);
      }
//----Draw hexagone-------------------------------------------------------------
      myGrid[i][l].reset();
      for (int o = 0; o < 6; o++){
        myGrid[i][l].addPoint((int) (horizontalAlignement + size * Math.cos(o * 2 * Math.PI / 6)),
        (int) (verticalAlignement + size * Math.sin(o * 2 * Math.PI / 6)));}

      if (myGrid[i][l].isSelected==1 && l%2==0) {
        g2d.setPaint(RedColor);
        g2d.fill(myGrid[i][l]);
        System.out.println("Info: Id: " +myGrid[i][l].getId()+" X:"+myGrid[i][l].getX()+" Y:"+myGrid[i][l].getY()+" Z:"+myGrid[i][l].getZ()+" Col:"+myGrid[i][l].getCol()+" Row:"+myGrid[i][l].getRow());
        g2d.setPaint(LightGreenColor);
        //i>=0 && i<=nbligne && l>=0 && l<nbcolumn
        if(i+1>=0 && i+1<nbligne && l>=0 && l<nbcolumn){g2d.fill(myGrid[i+1][l]);} //sud
        if(i-1>=0 && i-1<nbligne && l>=0 && l<nbcolumn){g2d.fill(myGrid[i-1][l]);} //nord
        if(i-1>=0 && i-1<nbligne && l+1>=0 && l+1<nbcolumn){g2d.fill(myGrid[i-1][l+1]);} //nord-est
        if(i>=0 && i<nbligne && l+1>=0 && l+1<nbcolumn){g2d.fill(myGrid[i][l+1]);} //sud-est
        if(i-1>=0 && i-1<nbligne && l-1>=0 && l-1<nbcolumn){g2d.fill(myGrid[i-1][l-1]);} //nord-ouest
        if(i>=0 && i<nbligne && l-1>=0 && l-1<nbcolumn){g2d.fill(myGrid[i][l-1]);} //sud-ouest
        g2d.setPaint(Couleur);
      }
      if (myGrid[i][l].isSelected==1 && l%2!=0) {
        g2d.setPaint(RedColor);
        g2d.fill(myGrid[i][l]);
        System.out.println("Info: Id: " +myGrid[i][l].getId()+" X:"+myGrid[i][l].getX()+" Y:"+myGrid[i][l].getY()+" Z:"+myGrid[i][l].getZ()+" Col:"+myGrid[i][l].getCol()+" Row:"+myGrid[i][l].getRow());
        g2d.setPaint(LightGreenColor);
        if(i+1>=0 && i+1<nbligne && l>=0 && l<nbcolumn){g2d.fill(myGrid[i+1][l]);} //sud
        if(i-1>=0 && i-1<nbligne && l>=0 && l<nbcolumn){g2d.fill(myGrid[i-1][l]);} //nord
        if(i>=0 && i<nbligne && l+1>=0 && l+1<nbcolumn){g2d.fill(myGrid[i][l+1]);} //nord-est
        if(i+1>=0 && i+1<nbligne && l+1>=0 && l+1<nbcolumn){g2d.fill(myGrid[i+1][l+1]);} //sud-est
        if(i>=0 && i<nbligne && l-1>=0 && l-1<nbcolumn){g2d.fill(myGrid[i][l-1]);} //nord-ouest
        if(i+1>=0 && i+1<nbligne && l-1>=0 && l-1<nbcolumn){g2d.fill(myGrid[i+1][l-1]);}//sud-ouest
        g2d.setPaint(Couleur);
      }

      if(myGrid[i][l].nbOfUnit>0){
        //g2d.setPaint(Color.yellow);
        g2d.setPaint(Color.yellow);
        g2d.fill(myGrid[i][l]);
        g2d.setPaint(Couleur);
        System.out.println("L'hexagone: "+myGrid[i][l].getId()+" possede "+myGrid[i][l].nbOfUnit+" unites.");
      }
        g2d.drawPolygon(myGrid[i][l]);



    }//-------------------fin gestion ligne-------------------------------------
  }//-------------------fin gestion column--------------------------------------

}//-------------------------FIN PAINT COMPONENT----------------------------------


public static void main(String[] args) {

JFrame frame = new JFrame();
frame.setTitle("Outpost Gamma");
frame.setSize(1200,900);
//frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

JFrame Menu = new JFrame();
Menu.setTitle("Menu");
Menu.setBounds(1200,30,500,700);


frame.addWindowListener(new WindowAdapter() {
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }
});

MANUTEST wololo =new MANUTEST();

for (int _i=0;_i<nbligne ;_i++ ) {
  for (int _l=0;_l<nbcolumn ;_l++ ) {
    identify=identify+1;
    wololo.myGrid[_i][_l] = new Hexagone(_l,_i,identify);
    wololo.myGrid[_i][_l].nbOfUnit=0;
    System.out.println("Loading Grid Cell number: " +wololo.myGrid[_i][_l]+" Is selected: "+wololo.myGrid[_i][_l].isSelected);
  }
}

//------------GESTION De la frame MENU------------------------------------------
    Menu.setLayout(wololo.experimentLayout);
    wololo.b1.setText("Nord-Ouest");
    wololo.b2.setText("Nord");
    wololo.b3.setText("Nord-Est");
    wololo.b4.setText("Sud-Ouest");
    wololo.b5.setText("Sud");
    wololo.b6.setText("Sud-Est");
    wololo.b7.setText("Ajouter unite");
    wololo.b8.setText("Retirer unite");
    wololo.cb1.addItem("Legionnaire");
    wololo.cb1.addItem("Legionnaire Lourd");
    wololo.cb1.addItem("Legionnaire Commandant");
    Menu.add(wololo.label1);
    Menu.add(wololo.label2);
    Menu.add(wololo.label3);
    Menu.add(wololo.b1);
    Menu.add(wololo.b2);
    Menu.add(wololo.b3);
    Menu.add(wololo.b4);
    Menu.add(wololo.b5);
    Menu.add(wololo.b6);
    Menu.add(wololo.b7);
    Menu.add(wololo.b8);
    Menu.add(wololo.cb1);

wololo.b1.addActionListener(wololo);
wololo.b2.addActionListener(wololo);
wololo.b3.addActionListener(wololo);
wololo.b4.addActionListener(wololo);
wololo.b5.addActionListener(wololo);
wololo.b6.addActionListener(wololo);
wololo.b7.addActionListener(wololo);
wololo.b8.addActionListener(wololo);

frame.add(wololo);
frame.setVisible(true);
Menu.setVisible(true);

}//main END
public void actionPerformed(ActionEvent e) {
  int PaireIndiceColLY=0;
  int PaireIndiceRowX=0;
  int ImpaireIndiceColY=0;
  int ImpaireIndiceRowX=0;
  int fired=0;
  if(e.getSource() == b1){
  System.out.println("Nord-Ouest");
  PaireIndiceRowX=-1;
  PaireIndiceColLY=-1;
  ImpaireIndiceColY=-1;
  ImpaireIndiceRowX=0;
  }
  if(e.getSource() == b2){
  System.out.println("Nord");
  PaireIndiceRowX=-1;
  PaireIndiceColLY=0;
  ImpaireIndiceRowX=-1;
  ImpaireIndiceColY=0;
  }
  if(e.getSource() == b3){
  System.out.println("Nord-Est");
  PaireIndiceRowX=-1;
  PaireIndiceColLY=+1;
  ImpaireIndiceColY=+1;
  }
  if(e.getSource() == b4){
  System.out.println("Sud-Ouest");
  PaireIndiceColLY=-1;
  ImpaireIndiceRowX=+1;
  ImpaireIndiceColY=-1;
  }
  if(e.getSource() == b5){
  System.out.println("Sud");
  PaireIndiceRowX=+1;
  ImpaireIndiceRowX=+1;
  }
  if(e.getSource() == b6){
  System.out.println("Sud-Est");
  PaireIndiceColLY=+1;
  ImpaireIndiceColY=+1;
  ImpaireIndiceRowX=+1;
  }
  for(Hexagone[] _h: myGrid){
    for(Hexagone _j: _h){
      if(myGrid[_j.getRow()][_j.getCol()].isSelected==1 && _j.getCol()%2==0 && fired==0 && myGrid[_j.getRow()][_j.getCol()].nbOfUnit>0 ){
        System.out.println("Paire" +_j.getCol());
        //myGrid[i-1][l-1]
        if(_j.getRow()+PaireIndiceRowX>=0 && _j.getRow()+PaireIndiceRowX<nbligne && _j.getCol()+PaireIndiceColLY>=0 && _j.getCol()+PaireIndiceColLY<nbcolumn){
        myGrid[_j.getRow()+PaireIndiceRowX][_j.getCol()+PaireIndiceColLY].isSelected=1;
        myGrid[_j.getRow()+PaireIndiceRowX][_j.getCol()+PaireIndiceColLY].nbOfUnit+=1;
        myGrid[_j.getRow()][_j.getCol()].isSelected=0;}
        myGrid[_j.getRow()][_j.getCol()].nbOfUnit-=1;
        fired=1;
        this.repaint();
      }else
      if(myGrid[_j.getRow()][_j.getCol()].isSelected==1 && _j.getCol()%2==1 && fired==0 && myGrid[_j.getRow()][_j.getCol()].nbOfUnit>0){
        System.out.println("Impaire"+_j.getCol());
        //myGrid[i][l-1])
        if(_j.getRow()+ImpaireIndiceRowX>=0 && _j.getRow()+ImpaireIndiceRowX<nbligne && _j.getCol()+ImpaireIndiceColY>=0 && _j.getCol()+ImpaireIndiceColY<nbcolumn){
        myGrid[_j.getRow()+ImpaireIndiceRowX][_j.getCol()+ImpaireIndiceColY].isSelected=1;
        myGrid[_j.getRow()+ImpaireIndiceRowX][_j.getCol()+ImpaireIndiceColY].nbOfUnit+=1;
        myGrid[_j.getRow()][_j.getCol()].isSelected=0;}
        myGrid[_j.getRow()][_j.getCol()].nbOfUnit-=1;
        fired=1;
        this.repaint();
      }
    }
  }
  if(e.getSource() == b7){
    for (int index=0;index<1 ;index++ ) {
      SelectedHex[index].nbOfUnit+=1;
    }
  }
  if(e.getSource() == b8){
    for (int index=0;index<1 ;index++ ) {
      SelectedHex[index].nbOfUnit-=1;
    }
  }
}

}//CLASS END
