
import sheffield.*;

public class RunRamblersSearch {
	public static void main(String[] args) {
		
	    EasyWriter screen = new EasyWriter();

	    TerrainMap diablo = new TerrainMap("diablo11.pgm");
	    
	    Coords start = new Coords(1, 13);
		Coords end = new Coords(1, 1);
		SearchState initState = (SearchState) new RamblersState (start, 0, 0);
	    RamblersSearch searcher = new RamblersSearch(diablo, end);

	    String res_bb = searcher.runSearch(initState, "AStar");
	    
	    screen.println(res_bb);
	    
	    System.out.println("START : X = "+start.getx() + ", Y ="+ start.gety());
	    System.out.println("END : X = "+end.getx() + ", Y ="+ end.gety());
	    
	    
	
	}
}

