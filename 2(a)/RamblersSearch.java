
public class RamblersSearch extends Search{

	private TerrainMap map; //map we're searching
	private int goalY, goalX; //goal destination 
	
	public TerrainMap getMap() {
		return map;
	}

	public int getGoalY() {
		return goalY;
	}
	
	public int getGoalX(){
		return goalX;
	}

	public RamblersSearch(TerrainMap m, Coords coordinates) {
		map = m;
		goalY = coordinates.gety();
		goalX = coordinates.getx();
	}
}
