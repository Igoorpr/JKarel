import jkarel.World;
import jkarel.Robot;
import IO.*;

/**   
   * Classe JKarel.   
*/ 

public class Guia0001 extends Robot {  

   public Guia0001( int avenue, int street, int direction, int beepers )  {      
   
      super( avenue, street, direction, beepers );     
	   
   } 
 
   public static void createWorld( String nome )  {         
		World.reset( );      
									
		World.setTrace( false );  
			
		//Walls NS
		World.placeNSWall(1, 3, 6, World.BLACK);
		World.placeNSWall(2, 4, 4, World.BLACK);
		World.placeNSWall(3, 5, 2, World.BLACK);
		World.placeNSWall(4, 7, 1, World.BLACK);
		World.placeNSWall(4, 5, 1, World.BLACK);
		World.placeNSWall(5, 7, 1, World.BLACK);
		World.placeNSWall(5, 5, 1, World.BLACK);
		World.placeNSWall(6, 5, 2, World.BLACK);
		World.placeNSWall(7, 3, 5, World.BLACK);
		
		//Walls EW
		World.placeEWWall(2, 2, 6, World.BLACK);
		World.placeEWWall(3, 3, 1, World.BLACK);
		World.placeEWWall(5, 4, 1, World.BLACK);
		World.placeEWWall(5, 5, 1, World.BLACK);
		World.placeEWWall(4, 6, 1, World.BLACK);
		World.placeEWWall(6, 6, 1, World.BLACK);
		World.placeEWWall(3, 7, 5, World.BLACK);
		World.placeEWWall(2, 8, 6, World.BLACK);
			
		World.placeBeepers(6, 7, 3);
		World.placeBeepers(5, 6, 2);
		World.placeBeepers(4, 7, 1);
		
		//Save in file
		World.saveWorld( nome );
	}
	
   //Turn Right
	public void turnRight(){
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
   //Read Commands
	public void readCommands( String filename ){
		//Declare variables
		int option;
		FILE archive = new FILE ( FILE.INPUT, filename );
		String line;
		int x, bps = 0;
      
		//Try to read a line
		line = archive.readln();
		
		//Loop for commands quantity
		while(!archive.eof()){
			option = IO.getint(line);
			//Exec
			doCommands(option);
			
			if (option == 7){
				bps = bps + 1;
			}

			//Try to read next line
			line = archive.readln();
		}
		
		//Close the file
		archive.close();
		IO.println("The robot got " + bps + " Beepers");
	}
	
	//Do commands
	public void doCommands( int option){
		switch (option){
			case 0:
				break;

			   case 1:
				   if (leftIsClear()){
					   turnLeft();
				   }
				break;

			      case 2:
			   	   while (! facingSouth()){
					      turnLeft();
				      }
				   break;

			         case 3:
				         if (rightIsClear()){
					         turnRight();
				         }
				      break;

			            case 4:
				            while (! facingWest()){
					            turnLeft();
				            }    
				         break;

			               case 5:
				               if (frontIsClear()){
					               move();
					               IO.println("Robot pass throught (" + avenue() + "," +  street() + ")");				               
                           }  
				            break;

			                  case 6:
				                  while(! facingEast()){
					                  turnLeft();
				                  }
				               break;

			                     case 7:
			                     	if (nextToABeeper()){
					                     pickBeeper();
					                     
					                     IO.println("Beeper found at (" + (x+1) + "," + (y+1) + ")");
					                  }
				                  break;

			                        case 8:
				                        while (! facingNorth()){
				                        	turnLeft();
				                        }
				                     break;

			                           case 9:
			                           	if (anyBeepersInBeeperBag()){
					                           putBeeper();
				                           }
				                        break;
                                    
                                       case 10:
				                              turnAround();
				                           break;

			                                 case 11:
				                                 turnAroundCornerLeft();
				                              break;
                                          
			default:
				IO.println("ERROR: Invalid command.");
			}
	}
	
   //Turn North
	public void turnNorth(){
		while(! facingNorth()){
			turnLeft();
		}
	}
	
	//Turn South
	public void turnSouth(){
		while(! facingSouth()){
			turnLeft();
		}
	}
	
	//Turn East
	public void turnEast(){
		while(! facingEast()){
			turnEast();
		}
	}
	
	//Turn West
	public void turnWest(){
		while(! facingWest()){
			turnLeft();
		}
	}
   
   //Turn Around
	public void turnAround(){
		turnLeft();
		turnLeft();
	}
	
	//Turn Around corner left
	public void turnAroundCornerLeft(){
		moveN(1);
		turnLeft();
		moveN(2);
		turnLeft();
		moveN(1);
	}

   public void moveN( int vezes){
		while(vezes > 0){
			move();
			vezes = vezes - 1;
		}
	}
 
   public void  RightIsClear( ) {
       rightIsClear( );
   } // end  RightIsClear( ) 
 
   public void  FrontIsClear( ) {
        frontIsClear( );
   } // end  FrontIsClear( )
   
	public static void main( String [] args) {

		//Create World
		createWorld("Guia0001.txt");

		//Make world visible
		World.reset();
		World.setSpeed(6);
		World.readWorld("Guia0001.txt");

		//Define agent
		Guia0001 JK = new Guia0001(1, 1, World.EAST, 0);

		//Exec actions
		JK.readCommands("Tarefa0001.txt");
		} // end main
} // end class

 
