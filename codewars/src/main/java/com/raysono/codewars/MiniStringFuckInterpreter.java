package com.raysono.codewars;

class MiniStringFuckInterpreter {

	private String code;
	private int memoryCell;

	MiniStringFuckInterpreter(String code) {
		this.code = code;
		memoryCell = 0;
	}

	String interpret() {

		final StringBuilder retval = new StringBuilder();

		final char[] chars = code.toCharArray();
		for (char c : chars) {
			switch (c) {
				case '+':
					incrementMemoryCell();
					break;
				case '.':
					retval.append((char) memoryCell);
					break;
			}
		}

		return retval.toString();
	}

	private void incrementMemoryCell() {
		memoryCell++;
		if (memoryCell == 256) {
			memoryCell = 0;
		}
	}
}
