package net.eduard.curso.projeto.rankup;

import net.eduard.api.lib.database.DBManager;

public class RankSQL {

	public RankSQL() {


	}

	public void createRanksTable() {

		//createTable("ranks", "name varchar(30) , prefix varchar(16),suffix varchar(16), price double , position int ");

	}

	public void createPlayersRankTable() {

		//createTable("players_rank", "player_name varchar(16), player_rank varchar(30)");
	}

	public void createRank(String name, String prefix, String suffix, double price, int position) {

		//insert("ranks", name.toLowerCase(), prefix, suffix, price, position);

	}

	public void deleteRank(String name) {

		//deleteData("ranks", "name = ?", name.toLowerCase());
	}

	public boolean hasRank(String name) {
		//return contains("ranks", "name = ?", name.toLowerCase());
		return false;
	}

	public boolean hasPlayerRank(String playerName) {
		//return contains("players_rank", "player_name = ?", playerName);
		return false;
	}

	public void setRank(String playerName, String rankName) {
		if (hasPlayerRank(playerName)) {
			//change("players_rank", "player_rank = ?", "player_name = ?", rankName, playerName);
		} else {
		//	insert("players_rank", playerName, rankName);
		}
	}

}
