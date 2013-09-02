package com.rosenthal.retrogame.entities;

import java.net.InetAddress;

import com.rosenthal.retrogame.InputHandler;
import com.rosenthal.retrogame.level.Level;

public class PlayerMP extends Player {

	public InetAddress ipAddress;
	public int port;
	
	public PlayerMP(Level level, int x, int y, InputHandler input, String username, InetAddress ipAddress, int port) {
		super(level, x, y, input, username);
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	
	public PlayerMP(Level level, int x, int y, String username, InetAddress ipAddress, int port) {
		super(level, x, y, null, username);
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	@Override
	public void tick(){
		super.tick();
	}

}
