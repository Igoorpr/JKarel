import jkarel.World;    
import jkarel.Robot; 
 
   public class Guia0003 extends Robot {

   public Guia0003 ( int avenue, int street, int direction, int beepers )     {      
        
      super( avenue, street, direction, beepers );    
   } // end Guia0003( ) 
   
    public static void createWorld( String nome )     {              
        World.reset( );           
                                   
        World.setTrace( false );    
         
        World.placeNSWall ( 2, 3, 4 );
        
        World.placeNSWall ( 5, 3, 3 ); 
     
        World.placeEWWall ( 3, 6, 3 );
         
        World.placeEWWall ( 3, 2, 3 ); 
        
        World.placeBeepers( 5, 3, 6 ); 

        World.saveWorld( nome );     
                 
     } // end createWorld( )
     
     public void turnRight( )     {      

         turnLeft( );         
         turnLeft( );         
         turnLeft( );     
     } // end turnRight( )
     
     public void moveN( int steps )     {      

           int step;     

           for ( step = 1; step <= steps; step = step + 1 ) {                        
                move( );         
           } // end for     
     } // end moveN( ) 
 
      public void doTask( )     {  
         moveN( 5 );
         turnLeft( );
         moveN( 5 );
         turnLeft( );
         moveN( 1 );
         turnLeft( );
         moveN( 3 );
         pickBeeper();
         pickBeeper();
         pickBeeper();
         pickBeeper();
         pickBeeper();
         pickBeeper();
         turnLeft( );
         turnLeft( );
         moveN( 3 );
         turnRight( );
         moveN( 1 );
         turnRight( );
         moveN( 4 );
         turnRight( );
         moveN( 4 );
         turnRight( );
         moveN( 1 );
         putBeeper();      
         moveN( 4 );
         turnRight( );
         moveN( 2 );
         putBeeper();
         putBeeper();
         moveN( 2 );
         turnRight( );
         moveN( 4 );
         putBeeper();
         putBeeper();
         putBeeper();
         moveN( 2 );
         turnRight( );
         moveN( 5 );
         turnRight( );
         turnRight( );
         
     } // end doTask( )
      
  public static void main( String [ ] args )     {      
       
      createWorld( "Guia0003.txt" ); 
                 
       World.reset( );          
       World.setSpeed ( 7 );         
       World.readWorld( "Guia0003.txt" );  
             
       Guia0003 JK = new Guia0003( 1, 1, World.EAST, 0 );
             
       JK.doTask( );   
      } // end main( ) 
} // end class 
 
