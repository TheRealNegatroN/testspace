package com.raysono.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Bundesliga {

	public static String table(String[] results) {

		final List<Club> table = new ArrayList<>();

		for (final String game : results) {

			final String goalsClub1 = game.substring(0, 1);
			final String goalsClub2 = game.substring(2, 3);
			final int posDivider = game.lastIndexOf("-");
			final String nameClub1 = game.substring(4, posDivider - 1);
			final String nameClub2 = game.substring(posDivider + 2);

			if (goalsClub1.equals("-")) {
				final Club club1 = new Club(nameClub1, 0, 0, 0, 0, 0, 0, 0);
				table.add(club1);
				final Club club2 = new Club(nameClub2, 0, 0, 0, 0, 0, 0, 0);
				table.add(club2);
			} else {
				final int goals1 = Integer.parseInt(goalsClub1);
				final int goals2 = Integer.parseInt(goalsClub2);

				int points1 = 1;
				int points2 = 1;
				int won1 = 0;
				int won2 = 0;
				int tie1 = 1;
				int tie2 = 1;
				int lost1 = 0;
				int lost2 = 0;

				if (goals1 > goals2) {
					points1 = 3;
					points2 = 0;
					won1++;
					tie1--;
					tie2--;
					lost2++;
				} else if (goals1 < goals2) {
					points1 = 0;
					points2 = 3;
					won2++;
					tie1--;
					tie2--;
					lost1++;
				}

				final Club club1 = new Club(nameClub1, 1, won1, tie1, lost1, goals1, goals2, points1);
				table.add(club1);
				final Club club2 = new Club(nameClub2, 1, won2, tie2, lost2, goals2, goals1, points2);
				table.add(club2);
			}
		}

		Collections.sort(table);

		return formatTable(table);
	}

	private static String formatTable(final List<Club> table) {
		final StringBuilder result = new StringBuilder();
		Club lastresult = null;
		int lastPos = -1;
		for (int i = 0; i < table.size(); i++) {

			final Club club = table.get(i);

			int position = i+1;

			if (club.equals(lastresult)){
				position = lastPos;
			} else {
				lastPos = position;
				lastresult = club;
			}

			if (position < 10) {
				result.append(" ");
			}
			result.append(position);
			result.append(". ");
			result.append(formatClubName(club.getName()));
			result.append("  ");
			result.append(club.getGames());
			result.append("  ");
			result.append(club.getWon());
			result.append("  ");
			result.append(club.getTie());
			result.append("  ");
			result.append(club.getLost());
			result.append("  ");
			result.append(club.getGoalsShot());
			result.append(":");
			result.append(club.getGoalsRecieved());
			result.append("  ");
			result.append(club.getPoints());
			if (i < (table.size()-1))
				result.append("\n");
		}

		return result.toString();
	}

	private static String formatClubName(String clubName) {

		final int desiredLength = 30;

		String nameFormatted;

		final int length = clubName.length();
		if (length > desiredLength) {
			nameFormatted = clubName.substring(0, desiredLength);
		} else {
			nameFormatted = clubName;
			while (nameFormatted.length() < desiredLength-2) {
				nameFormatted += " ";
			}
		}

		return nameFormatted;
	}
}

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
