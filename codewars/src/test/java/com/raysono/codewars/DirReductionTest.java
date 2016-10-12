package com.raysono.codewars;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DirReductionTest {

	@Test
	public void testSimpleDirReduc0() throws Exception {
		assertArrayEquals(new String[]{"WEST"},
				DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
	}

	@Test
	public void testSimpleDirReduc1() throws Exception {
		assertArrayEquals(new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
				DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
	}

	@Test
	public void testSimpleDirReduc2() throws Exception {
		assertArrayEquals(new String[]{},
				DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
	}

}