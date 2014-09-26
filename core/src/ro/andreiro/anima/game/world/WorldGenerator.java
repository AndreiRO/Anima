package ro.andreiro.anima.game.world;

public class WorldGenerator {
	private int width;
	private int height;
	private int map[][];
	private int mainCategories;
	private int secondaryCategories;
	/*
	 * 	GRASS,
	SOIL,
	WATER,
	SAND,
	TREE,
	VEGETATION
	 * */
	private Category[] categories;
	

	public enum MapType {
		MAIN,
		SECONDARY
	}
	
	public class Category {
		private BlockType blockType;
		private MapType mapType;
		private int value;
		public int percentage;
		public int complete;
		
		public Category(BlockType blType, MapType mT, int value, int percentage) {
			blockType = blType;
			mapType = mT;
			this.value = value;
			this.percentage = percentage;
			this.percentage = 0;
		}
	}
	
	public WorldGenerator(int width, int height, int prefs[]) {
		this.width = width;
		this.height=height;
		this.map = new int[width][height];
		categories = new Category[6];

		categories[0] = new Category(BlockType.GRASS, MapType.SECONDARY, 0, prefs[0]);
		categories[1] = new Category(BlockType.SOIL, MapType.MAIN, 0, prefs[1]);
		categories[2] = new Category(BlockType.WATER, MapType.MAIN, 0, prefs[2]);
		categories[3] = new Category(BlockType.VEGETATION, MapType.SECONDARY, 0, prefs[3]);
		categories[4] = new Category(BlockType.SMALL_TREE, MapType.SECONDARY, 0, prefs[4]);
		categories[5] = new Category(BlockType.BIG_TREE, MapType.SECONDARY, 0, prefs[5]);
		
		mainCategories = 2;
		secondaryCategories = 4;
	}
	
	
	public int[][] generateMap() {
		
		int map[][] = new int[width][height];
		int maxIndex = 0;
		
		for(int i = 1; i < mainCategories+secondaryCategories; ++ i) {
			if(categories[i].percentage > categories[maxIndex].percentage) maxIndex = i;
		}
		
		for(int i = 0; i < width; ++ i) {
			for(int j = 0; j < height; ++ j) {
				map[i][j] = categories[maxIndex].value;
			}
		}

		
		
		return map;
	}
	
}
