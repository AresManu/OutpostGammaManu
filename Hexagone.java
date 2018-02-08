import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Hexagone extends Polygon {
                  private int Id;
                   private int X;
                   private int Y;
                   private int Z;

                   private int size; //taille d'un coté de l'hexagone
                   private int level; //niveau de terrain -2 pour canal, -1 pour cratère, 0 pour plaine ...

                   private int col;
                   private int row;

                   int nbOfUnit;
                   int isSelected;

//*************   CONSTRUCTEURS *************
                   public Hexagone(int test){
                     Id=test;
                   }
                   public Hexagone(int pX,int pY,int pZ,int psize){
                    X=pX;
                    Y=pY;
                    Z=pZ;
                    size=psize;
                    //level=0;
                    //col=X;
                    //row=Z;
                  }
                  public Hexagone(int _col,int _row,int _id){
                  Id=_id;
                  setCol(_col);
                  setRow(_row);
                   //level=0;
                   //col=X;
                   //row=Z;
                 }

                  /*public void convertTo2D(Hexagone hex){
                    double q = hex.X;
                    double r = hex.Z;
                  }*/
//*************   ACCESSEURS *************
                  public int getId (){
                    return Id;
                  }
                  public int getX (){
                    return X;
                  }
                  public int getY (){
                    return Y;
                  }
                  public int getZ (){
                    return Z;
                  }
                  public int getSize (){
                    return size;
                  }
                  public int getLevel (){
                    return level;
                  }
                  public int getCol (){
                    return col;
                  }
                  public int getRow (){
                    return row;
                  }
//*************   MUTATEURS   *************
                  public void setCol(int nb){
                  col=nb;
                  X=col;
                  Y=-X-Z;
                  }
                  public void setRow(int nb){
                  row=nb;
                  Z=row-(col-(col&1))/2;
                  Y=-X-Z;
                  }
                  // public void setX(int nb){
                  // X=nb;
                  // col=X;
                  // }
                  // public void setY(int nb){
                  // Y=nb;
                  // }
                  // public void setZ(int nb){
                  // Z=nb;
                  // row=Z;
                  // }

}//CLASS Hexagone END
