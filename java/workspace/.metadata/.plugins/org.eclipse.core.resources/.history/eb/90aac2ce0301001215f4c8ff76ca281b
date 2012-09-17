/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.grid.UnboundedGrid;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{
	public static void movebug(Bug bug, int n) {
		for (int i = 0; i < n; i++) {
			if (bug.canMove()) {
				bug.move();
			}
			else {
				bug.turn();
			}
		}
	}
	
	public static int getrandrange(int range) {
		return (int) (range*Math.random());
	}
	
	public static void randombug(Bug bug, int step) {
		int i;
		for (i = 0; i < step; i++) {
			int dir = getrandrange(4);
			switch(dir) {
				case 1: {
					bug.turn();
					bug.turn();
				};
				case 2: {
					for (i = 0; i < 4; i++) {
						bug.turn();
					}
				};
				case 3: {
					for	(i = 0; i < 6; i++) {
						bug.turn();
					}
				};
			}
			movebug(bug, step);
		}
	}
	
    public static void main(String[] args)
    {
    	ActorWorld world = new ActorWorld(new UnboundedGrid());
        Bug redbug = new Bug();
        world.add(redbug);
        randombug(redbug, 10);
        world.add(new Rock());
        world.show();
    }
}
