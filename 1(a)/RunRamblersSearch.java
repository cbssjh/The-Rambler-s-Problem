
import sheffield.*;

public class RunRamblersSearch {
	public static void main(String[] args) {
		
	    EasyWriter screen = new EasyWriter();

	   //TerrainMap map1 = new TerrainMap("tmx.pgm");
	    TerrainMap diablo = new TerrainMap("diablo11.pgm");
	  
	    Coords start = new Coords(15, 15);
		Coords end = new Coords(0, 0);
		SearchState initState = (SearchState) new RamblersState (start, 0);
	    RamblersSearch searcher = new RamblersSearch(diablo, end);

	    String res_bb = searcher.runSearch(initState, "branchAndBound");
	    screen.println(res_bb);
	    
	    
	
	}
}

