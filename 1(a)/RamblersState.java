import java.util.ArrayList;

public class RamblersState extends SearchState{
     
	// the variables we're using for rambler
	 private int cY, cX;
	 
	// constructor
	 public RamblersState (Coords coordinates, int c){
		 	cY = coordinates.gety();
		 	cX = coordinates.getx();
	        localCost = c;
	 }
	 
	// accessors  
	 public int getY() {return cY;};
	 public int getX() {return cX;};
	
	// goalp
	 public boolean goalP(Search searcher) {
		 RamblersSearch rsearcher = (RamblersSearch) searcher; // cast as RamblersSearch
		 int tarY = rsearcher.getGoalY(); // get target Y goal
		 int tarX = rsearcher.getGoalX(); // get target X goal 
		 return ((cY == tarY) && (cX == tarX));
	 }
	 
	// function for calculating local cost 
	 public int calCost(TerrainMap nMap, int nY, int nX){
		 int nextHeight = nMap.getTmap()[nY][nX];
		 int height = nMap.getTmap()[cY][cX];
		 int cost = 0;
		 
		 //calculating
		 if (nextHeight <= height)
			 cost = 1;
		 else
			 cost = 1 + Math.abs(nextHeight - height);
		 return cost;
	 }
	 
	// getSuccessors
	 public ArrayList<SearchState> getSuccessors (Search searcher){
		 RamblersSearch rsearcher = (RamblersSearch) searcher; //cast
		 TerrainMap nMap = rsearcher.getMap();
		 
		 ArrayList<SearchState> succs = new ArrayList<SearchState>();
		 ArrayList<Coords> Coordinates = new ArrayList<Coords>();
		 
 		 int cost;
		 
		 int currentX = cX;
		 int currentY = cY;
		 int newX;
		 int newY;
		 int y;
		 int x;
		 
		 
		 // goes north 
		 if ( currentY > 0 ) {
			newY = currentY - 1;
		    Coords coordinatesNew = new Coords(newY, currentX);
			Coordinates.add(coordinatesNew);
		 }
		 
		 // goes south 
		 if ( currentY < nMap.getDepth() - 1 ) {
			newY = currentY + 1;
		    Coords coordinatesNew = new Coords(newY, currentX);
			Coordinates.add(coordinatesNew);
		 }

		 // goes east 
		 if ( currentX < nMap.getWidth() - 1) {
			newX = currentX + 1;
			Coords coordinatesNew = new Coords(currentY, newX);
			Coordinates.add(coordinatesNew);
		 }
		 
		 // goes west 
		 if ( currentX > 0 ) {
			 newX = currentX - 1;
			 Coords coordinatesNew = new Coords(currentY, newX);
			 Coordinates.add(coordinatesNew);
		 }
		 for (Coords coordinates : Coordinates) {
			 y = coordinates.gety();
		 	 x = coordinates.getx();
			 cost = calCost(nMap, y, x);
		 	 succs.add(new RamblersState(coordinates, cost));
		 }
		 return succs;
	 } 
	 
	// sameState
	 public boolean sameState (SearchState s2) {
		 RamblersState rs2 = (RamblersState) s2;
		 return ((cY == rs2.getY()) && (cX == rs2.getX()));
	 }
	 
	 
	 public String toString() {
		 return "Y: " + getY() + ", X " + getX();
	 }
	 
}
