import jkarel.World;    
import jkarel.Robot;        
import IO.*; 
 
/**   
   * Classe JKarel.   
*/ 

public class Guia0002 extends Robot {  
   
   public Guia0002( int avenue, int street, int direction, int beepers )  {      

      super( avenue, street, direction, beepers );     
   
   } // end Guia0002( ) 
 
   public static void createWorld( String nome )  {             
      World.reset( );            
                                 
      World.setTrace( false );     
 
      World.placeNSWall ( 2, 2, 7, World.BLACK );
      World.placeNSWall ( 5, 2, 7, World.BLACK );
      World.placeNSWall ( 4, 2, 6, World.BLACK );
      World.placeNSWall ( 3, 2, 6, World.BLACK );
      
      World.placeEWWall ( 3, 1, 3, World.BLACK );
      World.placeEWWall ( 3, 8, 1, World.BLACK );
      World.placeEWWall ( 5, 8, 1, World.BLACK );
              
      World.placeBeepers( 5, 2, 3, World.BLACK ); 
      World.placeBeepers( 4, 2, 3, World.BLACK );
      World.placeBeepers( 4, 3, 2, World.BLACK );
      World.placeBeepers( 3, 2, 3, World.BLACK );
      World.placeBeepers( 3, 3, 2, World.BLACK );
      World.placeBeepers( 3, 4, 1, World.BLACK );
            
      World.saveWorld( nome );         
      
   } // end createWorld( ) 
  
   public void turnRight( )  {      
       
      int vezes = 1;     
                            
      while ( vezes <= 3 )  {                      
         turnLeft( );              
         vezes = vezes + 1;         
      } // end while     
   } // end turnRight( )  
     
   public void moveN (int vezes) {            
      
      while ( vezes > 0 )  {           
         // mover-se uma vez ...             
          move ( );                      
          vezes = vezes - 1;         
      } // end while     
    } // end moveN( )
    
    public void pickBeepers() {
		int contador = 0;
		
      while( nextToABeeper()){
			pickBeeper();
			contador = contador + 1;
		} // end while
		
      if (contador > 0){
			int x, y;
			
         x = avenue();
			y = street();
			FILE arquivo = new FILE (FILE.APPEND, "Tarefa0002b.txt");
			
         IO.println("Beepers = " + contador);
			arquivo.println("" + x);
			arquivo.println("" + y);
			arquivo.close();
		} // end if
	} // pickBeepers
   
    public void PutBeeper(int x) {    
		   while (x > 0){
			   putBeeper();
			   x = x - 1;
		   } // end while
	} // end PutBeeper
   
   public void TurnOff() {
         turnOff();
     } // end TurnOff
      
   public static void main( String [ ] args )  {          
     createWorld( "Guia0002.txt" ); 
 
     World.reset( );          
     World.setSpeed ( 7 );          
     World.readWorld( "Guia0002.txt" );  
      
      Guia0002 JK = new Guia0002( 1, 1, World.EAST, 0 ); 
 
     // executar acoes
     JK.moveN(1);
     JK.turnLeft(); 
     JK.moveN(8);
     JK.turnRight();
     JK.moveN(2);      
     JK.turnRight();
     JK.moveN(1);
     JK.turnRight();
     JK.moveN(1);
     JK.turnLeft();
     JK.moveN(4);
     JK.pickBeepers(); 
     JK.moveN(1);   
     JK.pickBeepers();
     JK.turnRight();
     JK.turnRight();
     JK.moveN(5);
     JK.turnRight();
     JK.moveN(1);
     
     JK.turnRight();
     JK.moveN(5);
     JK.pickBeepers();
     JK.moveN(1);
     JK.pickBeepers();
     JK.turnRight();
     JK.turnRight();
     JK.moveN(6);
     
     JK.turnRight();
     JK.moveN(1);
     JK.turnRight();
     JK.moveN(6);
     JK.turnRight();
     JK.turnRight();
     JK.pickBeepers();
     JK.moveN(6);
     
     JK.turnLeft();
     JK.moveN(2);
     JK.turnLeft();
     JK.moveN(6);
     JK.turnLeft();
     JK.turnLeft();
     JK.pickBeepers();
     JK.moveN(6);
     
     JK.turnRight();
     JK.moveN(1);
     JK.turnLeft();
     JK.moveN(1);
     JK.turnRight();
     JK.moveN(3);
     JK.turnRight();
     JK.moveN(8);
     JK.PutBeeper(14);
     JK.turnRight();
     JK.moveN(6);
     JK.turnRight();
     JK.turnRight();
     
     JK.turnOff();
     
  } // end main( ) 
} // end class 


