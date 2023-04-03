package search3;

public class Test {

	public static void main(String[] args) {
	RamblersState test = new RamblersState(5,5,0);
	TerrainMap object = new TerrainMap("tmx.pgm");
	test.calCost(object, 3, 3);
}
}
