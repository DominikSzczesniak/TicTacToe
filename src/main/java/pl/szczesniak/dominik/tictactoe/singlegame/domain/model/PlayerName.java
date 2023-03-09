package pl.szczesniak.dominik.tictactoe.singlegame.domain.model;

import pl.szczesniak.dominik.tictactoe.singlegame.domain.exceptions.IncorrectPlayerNameException;

import java.util.Objects;

public class PlayerName {

	private final String value;

	public PlayerName(final String name) {
		this.value = name;
		boolean valid = validateName(name);
		if (!valid) {
			throw new IncorrectPlayerNameException();
		}

	}

	public static boolean validateName(String name){
		return name.matches("(?i)[a-z](.{0,23}[a-z])?");
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Name{" +
				"name='" + value + '\'' +
				'}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final PlayerName playerName1 = (PlayerName) o;
		return Objects.equals(value, playerName1.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
