package ro.andreiro.anima.game.world;

public enum BlockType {
	GRASS,
	SOIL,
	WATER,
	SAND,
	SMALL_TREE,
	BIG_TREE,
	VEGETATION;
	
	public static BlockType getBlockType(int i) {
		switch(i) {
			case 0:
				return BlockType.GRASS;
			case 1:
				return BlockType.SOIL;
			case 2:
				return BlockType.WATER;
			case 3:
			case 4:
				return BlockType.VEGETATION;
			case 5:
			case 6:
				return BlockType.SMALL_TREE;
			case 7:
			case 8:
				return BlockType.BIG_TREE;
			default:
				return BlockType.SOIL;
		}
	}
	
	public static int getNumber(BlockType t) {
		switch(t) {
			case GRASS:
				return 0;
			case SOIL:
				return 1;
			case WATER:
				return 2;
			case VEGETATION:
				return 3/*4?*/;
			case SMALL_TREE:
				return 5/*5?6?*/;
			case BIG_TREE:
				return 7/*8*/;
			default:
				return 0;
		}
	}
}
