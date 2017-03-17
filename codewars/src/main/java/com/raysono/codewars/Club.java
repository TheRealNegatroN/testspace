package com.raysono.codewars;

@SuppressWarnings("WeakerAccess")
class Club implements Comparable<Club> {

	private String name;
	private int games;
	private int won;
	private int tie;
	private int lost;
	private int goalsShot;
	private int goalsRecieved;
	private int points;

	public Club(String name, int games, int won, int tie, int lost, int goalsShot, int goalsRecieved, int points) {
		this.name = name;
		this.games = games;
		this.won = won;
		this.tie = tie;
		this.lost = lost;
		this.goalsShot = goalsShot;
		this.goalsRecieved = goalsRecieved;
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public int getGames() {
		return games;
	}

	public int getWon() {
		return won;
	}

	public int getTie() {
		return tie;
	}

	public int getLost() {
		return lost;
	}

	public int getGoalsShot() {
		return goalsShot;
	}

	public int getPoints() {
		return points;
	}

	public int getGoalsRecieved() {
		return goalsRecieved;
	}

	@Override
	public int compareTo(Club other) {

		if (this.getPoints() > other.getPoints()) {
			return -1;
		}
		if (this.getPoints() < other.getPoints()) {
			return 1;
		}

		if ((this.getGoalsShot() - this.goalsRecieved) > (other.getGoalsShot() - other.goalsRecieved)) {
			return -1;
		}
		if ((this.getGoalsShot() - this.goalsRecieved) < (other.getGoalsShot() - other.goalsRecieved)) {
			return 1;
		}

		if (this.getGoalsShot() > other.getGoalsShot()) {
			return -1;
		}
		if (this.getGoalsShot() < other.getGoalsShot()) {
			return 1;
		}

		if (this.getGoalsRecieved() > other.getGoalsRecieved()) {
			return -1;
		}
		if (this.getGoalsRecieved() < other.getGoalsRecieved()) {
			return 1;
		}


		return this.getName().compareToIgnoreCase(other.getName());
	}

	@SuppressWarnings("RedundantIfStatement")
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Club)) {
			return false;
		}

		Club club = (Club) o;

		if (games != club.games) {
			return false;
		}
		if (won != club.won) {
			return false;
		}
		if (tie != club.tie) {
			return false;
		}
		if (lost != club.lost) {
			return false;
		}
		if (goalsShot != club.goalsShot) {
			return false;
		}
		if (goalsRecieved != club.goalsRecieved) {
			return false;
		}
		if (points != club.points) {
			return false;
		}
		return true;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + games;
		result = 31 * result + won;
		result = 31 * result + tie;
		result = 31 * result + lost;
		result = 31 * result + goalsShot;
		result = 31 * result + goalsRecieved;
		result = 31 * result + points;
		return result;
	}
}
