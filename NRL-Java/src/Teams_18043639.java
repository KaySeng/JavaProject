
/*
 * Student ID: 18043639
 * Name: Kuong-Iy Seng
 * Campus: Parramatta
 * Tutor Name: Indra Seher
 * Class Day: Thursday
 * Class Time: 12pm
 */

public class Teams_18043639 {
	private String teamName;
	private String mascotName;
	private String homeGroundName;
	private int teamRank; // team position
	private int numberOfGamesPlayed;
	private int numberOfGamesWon;
	private int numberOfGamesDraw;
	private int numberOfGamesLost;
	private int numberOfByes;
	private int pointsScoredFor;
	private int pointsScoredAgainst;
	private int totalCompetitionPoints;
	
	public int getNumberOfGamesDraw(){
		return numberOfGamesDraw;
	}
	public void setNumberOfGamesDraw(int numberOfGamesDraw){
		this.numberOfGamesDraw = numberOfGamesDraw;
	}
	public int getTeamRank() {
		return teamRank;
	}

	public void setTeamRank(int teamRank) {
		this.teamRank = teamRank;
	}

	public int getNumberOfGamesPlayed() {
		return numberOfGamesPlayed;
	}

	public void setNumberOfGamesPlayed(int numberOfGamesPlayed) {
		this.numberOfGamesPlayed = numberOfGamesPlayed;
	}

	public int getNumberOfGamesWon() {
		return numberOfGamesWon;
	}

	public void setNumberOfGamesWon(int numberOfGamesWon) {
		this.numberOfGamesWon = numberOfGamesWon;
	}

	public int getNumberOfGamesLost() {
		return numberOfGamesLost;
	}

	public void setNumberOfGamesLost(int numberOfGamesLost) {
		this.numberOfGamesLost = numberOfGamesLost;
	}

	public int getNumberOfByes() {
		return numberOfByes;
	}

	public void setNumberOfByes(int numberOfByes) {
		this.numberOfByes = numberOfByes;
	}

	public int getPointsScoredFor() {
		return pointsScoredFor;
	}

	public void setPointsScoredFor(int pointsScoredFor) {
		this.pointsScoredFor = pointsScoredFor;
	}

	public int getPointsScoredAgainst() {
		return pointsScoredAgainst;
	}

	public void setPointsScoredAgainst(int pointsScoredAgainst) {
		this.pointsScoredAgainst = pointsScoredAgainst;
	}

	public int getTotalCompetitionPoints() {
		return totalCompetitionPoints;
	}

	public void setTotalCompetitionPoints(int totalCompetitionPoints) {
		this.totalCompetitionPoints = totalCompetitionPoints;
	}

	public Teams_18043639(String tn, String mn, String hgn ){
		teamName = tn;
		mascotName = mn;
		homeGroundName = hgn;
		
	}
	
	public Teams_18043639(){
		teamName = new String();
		mascotName = new String ();
		homeGroundName = new String ();
	}
	
	public void setTeamName(String tn){
		teamName = tn;
	}
	
	public void setMascotName(String mn){
		mascotName = mn;
	}
	
	public void setHomeGroundName (String hgn){
		homeGroundName = hgn;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public String getMascotName(){
		return mascotName;
	}
	
	public String getHomeGroundName(){
		return homeGroundName;
	}
	
}
