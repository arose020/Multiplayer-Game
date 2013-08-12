package com.rosenthal.retrogame.level.tiles;

import com.rosenthal.retrogame.graphics.Colours;
import com.rosenthal.retrogame.graphics.Screen;
import com.rosenthal.retrogame.level.Level;

public abstract class Tile {

	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colours.get(000, -1, -1, -1), 0xFF000000);
	public static final Tile STONE = new BasicSolidTile(1, 1, 0, Colours.get(-1, 333, -1, -1), 0xFF555555);
	public static final Tile GRASS = new BasicTile(2, 2, 0, Colours.get(-1, 131, 141, -1), 0xFF00FF00);
	public static final Tile WATTER = new AnimatedTile(3, new int[][] { { 0, 2 }, { 1, 2 }, { 2, 2 }, { 1, 2 } },
			Colours.get(-1, 004, 114, -1), 0xFF0000FF, 1000 /*Use 500 for faster W/O hurting the fps*/);
	
	protected byte id;
	protected boolean solid;
	protected boolean emitter;

	private int levelColour;

	/*
	 * AKA index color (levelColour in files) that is displayed on the image
	 * This way it references that it is referring to the level class
	 */

	public Tile(int id, boolean isSolid, boolean isEmitter, int levelColour) {
		this.id = (byte) id;
		if (tiles[id] != null) throw new RuntimeException("DUPLICATE TILE ID ON" + id);
		this.solid = isSolid;
		this.emitter = isEmitter;
		this.levelColour = levelColour;
		tiles[id] = this;
	}

	public byte getId() {
		return id;
	}

	public boolean isSolid() {
		return solid;
	}

	public boolean isEmitter() {
		return emitter;
	}

	public int getLevelColour() {
		return levelColour;
	}

	public abstract void tick();

	public abstract void render(Screen screen, Level level, int x, int y);

}
