import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Student ID: 18043639
 * Name: Kuong-Iy Seng
 * Campus: Parramatta
 * Tutor Name: Indra Seher
 * Class Day: Thursday
 * Class Time: 12pm
 */

public class MainClass_18043639 {

	public static void main(String[] args) throws IOException {

		int teamArraySize; // team file size
		int fixtureArraySize; // fixture file size
		int userInputSize = 0; // current round input
		int roundSize = 0; // count rounds size

		String teamFile = "Teams.txt";
		String fixtureFile = "Fixtures.txt";
		String roundFile = "AllRound.txt";

		teamArraySize = readArraySize(teamFile); // to count the array size
		fixtureArraySize = readArraySize(fixtureFile);
		userInputSize = validate(userInputSize);
		roundSize = readRoundSize(roundSize, userInputSize);

		// Object Arrays for these classes
		Teams_18043639[] teams = new Teams_18043639[teamArraySize];
		Fixtures_18043639[] fixtures = new Fixtures_18043639[fixtureArraySize];
		Round_18043639[] rounds = new Round_18043639[roundSize];
		
		readTeamFile(teamFile, teams);
		readFixtureFile(fixtureFile, fixtures);
		readRoundArray2(roundFile, rounds);
		displayMenuMainAndSub(teams, fixtures, rounds, userInputSize, roundFile); // Display menu
	}
	/*
	 * To read the round files and set it to its particular fields  by the use of a delimiter
	 * @param roundFile - the round file to be loaded into an object array
	 */
	public static void readRoundArray2(String roundFile, Round_18043639[] rounds) throws IOException {
		File inFile = new File(roundFile);
		String Str;
		String[] tokens;

		if (inFile.exists()) {
			Scanner inputFile = new Scanner(inFile);

			for (int i = 0; i < rounds.length; i++) {
				Str = inputFile.nextLine();
				tokens = Str.split(",");
				rounds[i] = new Round_18043639();
				rounds[i].setMatchNumber(Integer.parseInt(tokens[0]));
				rounds[i].setHomeTeamScore(Integer.parseInt(tokens[1]));
				rounds[i].setAwayTeamScore(Integer.parseInt(tokens[2]));

			}

		}
	}
	/*
	 * To validate the user input for option from the display menu
	 * @param option - the integer number to be validated. This parameter must have a value
	 * @return the validated integer number
	 */
	public static int validateOption(int option){
		if (option > 5 || option < 0){
			System.out.println("Please select an option:");
			System.out.println("1. Display Match Schedule");
			System.out.println("2. Enter Round Results");
			System.out.println("3. Display Ladder");
			System.out.println("4. Team Results");
			System.out.println("5. Exit Program");
			
		}
		return option;
	}
	
	/*
	 * To validate the sub-menu from the display menu
	 * @param choice - the integer number to be validated. This parameter must have a value
	 * @return the validate integer number
	 */
	public static int validateUserChoice(int choice){
		while (choice > 2 || choice < 1){
			Scanner kb = new Scanner(System.in);
			System.out.println("Do you want to view all the schedule for all round?");
			System.out.println("1. Yes, I want to view all the schedule");
			System.out.println("2. No, I just want the current round");
			choice = kb.nextInt();
			
		}
		return choice;
	}
	
	/*
	 * This is the display menu where user is able select what they wished to view/enter
	 * The display has 5 options to choose from:
	 * 		1. Display Match Schedule - to display the match schedule
	 * 		2. Enter the round Result - where user can enter round result for team that haven't play yet
	 * 		3. Display Ladder - to display the current standing after the current round
	 * 		4. Team Results - where user can view results a team they wish to see
	 * 		5. Exit Program - to Exit the program
	 * This program will continue to run as long as the user doesn't choose option 5
	 */
	public static void displayMenuMainAndSub(Teams_18043639[] teams, Fixtures_18043639[] fixtures, Round_18043639[] rounds, int userInput, String roundFile) throws IOException {
		int userOption; // user choice for the main menu
		int userScheduleChoice; // user choice for schedule menu
		int displayRoundChoice; // user selected round choice
		int roundSize = 0; 
		String getTeamName; 

		Scanner kb = new Scanner(System.in);

		do {
			userInput++;
			roundSize = findRoundSize(roundSize, userInput);
			System.out.println();
			System.out.println("Please select an option:");
			System.out.println("1. Display Match Schedule");
			System.out.println("2. Enter Round Results");
			System.out.println("3. Display Ladder");
			System.out.println("4. Team Results");
			System.out.println("5. Exit Program");

			userOption = kb.nextInt();
			userOption = validateOption(userOption);
			if (userOption == 1) {
				System.out.println("Do you want to view all the schedule for all round?");
				System.out.println("1. Yes, I want to view all the schedule");
				System.out.println("2. No, I just want the current round");
				userScheduleChoice = kb.nextInt();
				userScheduleChoice = validateUserChoice(userScheduleChoice);
				if (userScheduleChoice == 1) {
					System.out.printf("%-10s%-23s%-23s%-23s%-23s\n", "Date","Home Team", "Away Team", "Venue", "Kick off time");
					System.out.println("-------------------------------------------------------------------------------------");
					for (int i = 0; i < fixtures.length; i++) {
						System.out.printf("%-10s%-23s%-23s%-23s%-23s\n",
								fixtures[i].getDate(),
								fixtures[i].getHomeTeam(),
								fixtures[i].getAwayTeam(),
								fixtures[i].getVenue(), fixtures[i].getTime());
					}
					
				} else if (userScheduleChoice == 2) {
					System.out.println("Which round do you wish to display");
					displayRoundChoice = kb.nextInt();
					System.out.println("Round" + displayRoundChoice + "Matches");
					System.out.printf("%-10s%-23s%-23s%-23s%-23s\n", "Date","Home Team", "Away Team", "Venue", "Kick off time");
					System.out.println("-------------------------------------------------------------------------------------");
					for (int i = 0; i < fixtures.length; i++) {
						if (fixtures[i].getRoundNumber() == displayRoundChoice) {
							System.out.printf("%-10s%-23s%-23s%-23s%-23s\n",
									fixtures[i].getDate(),
									fixtures[i].getHomeTeam(),
									fixtures[i].getAwayTeam(),
									fixtures[i].getVenue(),
									fixtures[i].getTime());
						}
					}

				}

			} else if (userOption == 2) {
				int teamPlay = 0; // to count how many team are playing in that particular round
				int matchNumber = 0; 

				for (int i = 0; i < fixtures.length; i++) {
					if (fixtures[i].getRoundNumber() == roundSize) { // -
						matchNumber = fixtures[i].getMatchNumber();
						teamPlay++;
						System.out.println(fixtures[i].getMatchNumber()
								+ fixtures[i].getHomeTeam()
								+ fixtures[i].getAwayTeam());
					}
				}

				PrintWriter outFile = new PrintWriter("Round" + roundSize+ ".txt"); // create a file
				
				int matchNum = 0;
				int homeTeamResult = 0;
				int awayTeamResult = 0;
				matchNum = matchNumber - teamPlay;
				
				System.out.println("Please enter the match results for these rounds");
				
				/*
				 *  Display teams name that played this round
				 *  Asking user to input the results for the teams
				 */
				for (int j = 0; j < teamPlay; j++) {
					matchNum++;
					System.out.println("Please enter the result for the home team");
					homeTeamResult = kb.nextInt();
					
					System.out.println("Please enter the result for the away team");
					awayTeamResult = kb.nextInt();
					
					outFile.print(matchNum + "," + homeTeamResult + "," + awayTeamResult);
				}
				outFile.close(); // close outFile

			} else if (userOption == 3) {
				
				roundSize = findRoundSize(roundSize, userInput); // count round size
				int currentRound; 
				currentRound = roundSize - 1; // to fix off number by 1
				
				/*
				 * Loop through the teams array and get the team name one at the time
				 * Get the number of game play, number of wins, loses, draw, point score to other team
				 * point scored against, and count the number of bye.
				 * And set the result to appropriate objects
				 * 
				 * 2 points for bye
				 * 2 points for win
				 * 1 point for draw
				 * 0 point for loss
				 */
				for (int i = 0; i < teams.length; i++) {
					getTeamName = teams[i].getTeamName();
					int totalPoints = 0;
					int numWin = 0;
					int numLose = 0;
					int numDraw = 0; 
					int pointScoredFor = 0; // point score to the opposite team
					int pointScoredAgainst = 0; // point the opposite team score against
					int gamePlayed = 0;
					int numberOfByes;
					
					for (int j = 0; j < rounds.length; j++) {
						if (getTeamName.equals(fixtures[j].getHomeTeam())) {
							rounds[j].getHomeTeamScore();
							if (rounds[j].getHomeTeamScore() > rounds[j].getAwayTeamScore()) {
								pointScoredFor += rounds[j].getHomeTeamScore();
								pointScoredAgainst += rounds[j].getAwayTeamScore();
								numWin++;
								gamePlayed += 1;
								totalPoints += 2;
								teams[i].setPointsScoredAgainst(pointScoredAgainst);
								teams[i].setPointsScoredFor(pointScoredFor);
								teams[i].setTotalCompetitionPoints(totalPoints);
								teams[i].setNumberOfGamesWon(numWin);
								teams[i].setNumberOfGamesPlayed(gamePlayed);
								
							} else if (rounds[j].getHomeTeamScore() < rounds[j].getAwayTeamScore()) {
								gamePlayed += 1;
								pointScoredFor += rounds[j].getHomeTeamScore();
								pointScoredAgainst += rounds[j].getAwayTeamScore();
								numLose++;
								teams[i].setNumberOfGamesLost(numLose);
								teams[i].setPointsScoredAgainst(pointScoredAgainst);
								teams[i].setPointsScoredFor(pointScoredFor);
								teams[i].setNumberOfGamesPlayed(gamePlayed);
								
							} else if (rounds[j].getHomeTeamScore() == rounds[j].getAwayTeamScore()) {
								gamePlayed += 1;
								pointScoredFor += rounds[j].getHomeTeamScore();
								pointScoredAgainst += rounds[j].getAwayTeamScore();
								numDraw++;
								totalPoints += 1;
								teams[i].setPointsScoredAgainst(pointScoredAgainst);
								teams[i].setPointsScoredFor(pointScoredFor);
								teams[i].setTotalCompetitionPoints(totalPoints);
								teams[i].setNumberOfGamesDraw(numDraw);
								teams[i].setNumberOfGamesPlayed(gamePlayed);
							}

					} else if (getTeamName.equals(fixtures[j].getAwayTeam())) {
							rounds[j].getAwayTeamScore();
							if (rounds[j].getHomeTeamScore() < rounds[j].getAwayTeamScore()) {
								gamePlayed += 1;
								pointScoredFor += rounds[j].getAwayTeamScore();
								pointScoredAgainst += rounds[j].getHomeTeamScore();
								numWin++;
								totalPoints += 2;
								teams[i].setPointsScoredAgainst(pointScoredAgainst);
								teams[i].setPointsScoredFor(pointScoredFor);
								teams[i].setNumberOfGamesWon(numWin);
								teams[i].setTotalCompetitionPoints(totalPoints);
								teams[i].setNumberOfGamesPlayed(gamePlayed);
								
							} else if (rounds[j].getHomeTeamScore() > rounds[j]
									.getAwayTeamScore()) {
								gamePlayed += 1;
								pointScoredFor += rounds[j].getAwayTeamScore();
								pointScoredAgainst += rounds[j]
										.getHomeTeamScore();
								numLose++;
								teams[i].setNumberOfGamesLost(numLose);
								teams[i].setPointsScoredAgainst(pointScoredAgainst);
								teams[i].setPointsScoredFor(pointScoredFor);
								teams[i].setNumberOfGamesPlayed(gamePlayed);
							} else if (rounds[j].getAwayTeamScore() == rounds[j]
									.getHomeTeamScore()) {
								gamePlayed += 1;
								pointScoredFor += rounds[j].getHomeTeamScore();
								pointScoredAgainst += rounds[j]
										.getAwayTeamScore();
								numDraw++;
								totalPoints += 1;
								teams[i].setTotalCompetitionPoints(totalPoints);
								teams[i].setNumberOfGamesDraw(numDraw);
								teams[i].setPointsScoredAgainst(pointScoredAgainst);
								teams[i].setPointsScoredFor(pointScoredFor);
								teams[i].setNumberOfGamesPlayed(gamePlayed);
							}

						}
						// to calculate the byes for each team by getting the 
						// current round number - the number of game played
						numberOfByes = currentRound - teams[i].getNumberOfGamesPlayed();
						teams[i].setNumberOfByes(numberOfByes);

					}

				}
				
				/*
				 * Loop through each team one at the time and add the result for bye into team total points
				 */
				for (int i = 0; i < teams.length; i++) {
					int addByesPoints = 0;
					addByesPoints = teams[i].getTotalCompetitionPoints() + (teams[i].getNumberOfByes() * 2);
					teams[i].setTotalCompetitionPoints(addByesPoints);
				}
				
				/*
				 * A selection sort to arrange the team base on the team total competition points
				 */
				int startAt;
				int j;
				int minIndex;
				Teams_18043639 temp = new Teams_18043639();

				for (startAt = 0; startAt < teams.length - 1; startAt++) {
					minIndex = startAt;
					temp = teams[startAt];

					for (j = startAt + 1; j < teams.length; j++) {
						if (teams[j].getTotalCompetitionPoints() > temp
								.getTotalCompetitionPoints()) {

							temp = teams[j];

							minIndex = j;
						}

					}
					teams[minIndex] = teams[startAt];
					teams[startAt] = temp;
				}
				
				// to display the competition ladder
				System.out.printf("%-5s%-30s%-3s%-3s%-3s%-3s%-3s%-5s%-5s%-10s\n", "Pos.","Team", "P", "W", "L", "D", "B", "F", "A", "Pts");
				System.out.println("----------------------------------------------------------------------------------");
				for (int i = 0; i < teams.length; i++) {
					System.out.printf("%-5s%-30s%-3s%-3s%-3s%-3s%-3s%-5s%-5s%-10s\n",
							i + 1,
							teams[i].getTeamName() + " " + teams[i].getMascotName(),
							teams[i].getNumberOfGamesPlayed(),
							teams[i].getNumberOfGamesWon(),
							teams[i].getNumberOfGamesLost(),
							teams[i].getNumberOfGamesDraw(),
							teams[i].getNumberOfByes(),
							teams[i].getPointsScoredFor(),
							teams[i].getPointsScoredAgainst(),
							teams[i].getTotalCompetitionPoints());
				}
			}

			else if (userOption == 4) {

				Scanner in = new Scanner(System.in);
				
				String userTeamName; // userInput for team name
				String matchResult = null;
				String displayTeam; // display the user input team name
				int currentRound;
				currentRound = roundSize - 1;
				
				System.out.println("Please Enter an NRL team that you wish to view:");
				userTeamName = in.nextLine();

				for (int j = 0; j < teams.length; j++) {
					if (userTeamName.equals(teams[j].getTeamName())) {
						displayTeam = teams[j].getTeamName();
						
						System.out.println(teams[j].getTeamName() + " "+ teams[j].getMascotName());
						System.out.println("Match Results for rounds" + " "+ "1 to" + " " + currentRound + ":");
						System.out.printf("%-10s%-15s%-25s%-10s%-23s\n","Round", "Date", "Team Played", "W/L/D","Score");
						System.out.println("-------------------------------------------------------------------");
						
						/*
						 * Get the home team scores and away team scores to find the winning and losing teams
						 */
						for (int i = 0; i < rounds.length; i++) {
							if (displayTeam.equals(fixtures[i].getHomeTeam())) {
								if (rounds[i].getHomeTeamScore() > rounds[i].getAwayTeamScore()) {
									matchResult = "Win";
									
								} else if (rounds[i].getHomeTeamScore() < rounds[i].getAwayTeamScore()) {
									matchResult = "Loss";
									
								} else if (rounds[i].getHomeTeamScore() == rounds[i].getAwayTeamScore()) {
									matchResult = "Draw";
								}
								
								System.out.printf("%-10s%-15s%-25s%-10s%-20s\n",fixtures[i].getRoundNumber(),fixtures[i].getDate(),fixtures[i].getAwayTeam(), matchResult,rounds[i].getHomeTeamScore() + "-"+ rounds[i].getAwayTeamScore());
								
							} else if (displayTeam.equals(fixtures[i].getAwayTeam())) {
								if (rounds[i].getAwayTeamScore() > rounds[i].getHomeTeamScore()) {
									matchResult = "Win";
									
								} else if (rounds[i].getAwayTeamScore() < rounds[i].getHomeTeamScore()) {
									matchResult = "Loss";
									
								} else if (rounds[i].getHomeTeamScore() == rounds[i].getAwayTeamScore()) {
									matchResult = "Draw";
								}

								System.out.printf("%-10s%-15s%-25s%-10s%-20s\n",
										fixtures[i].getRoundNumber(),
										fixtures[i].getDate(),
										fixtures[i].getHomeTeam(), matchResult,
										rounds[i].getHomeTeamScore() + "-"+ rounds[i].getAwayTeamScore());

							}
						}
					}
				}
			}

		} while (userOption != 5); // exit the Loop

	}
	
	/*
	 * To find how many rounds there are by reading from round files
	 * @param roundSize - the integer for the current round size
	 * @param userInput - data from user input
	 * @ return the number of rounds
	 */
	public static int findRoundSize(int roundSize, int userInput) throws IOException {
		int j = 1;
		int foundAt = -1;
		boolean found = false;

		while (!found && j <= userInput) {
			File myfile = new File("Round" + j + ".txt");

			if (myfile.exists()) {
				j++;
				found = false;
			} else {
				found = true;
				foundAt = j;
			}
		}

		return j;
	}
	
	/*
	 * To validate the user current round input at the beginning of the program
	 * @param userinput - the integer number to be validated - this parameter must have a value
	 * @return the validated integer number
	 */
	public static int validate(int userInput) {

		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the current round number:");
		userInput = kb.nextInt();
		while (userInput > 26 || userInput < 1) {
			System.out.println("Please enter the current round number:");
			userInput = kb.nextInt();
		}

		return userInput;
	}
	
	/*
	 * to read the team file
	 * @param teamFile - the team file name
	 * @param Team[] teams - to stored array object
	 */
	public static void readTeamFile(String teamFile, Teams_18043639[] teams) throws IOException {

		File inFile = new File(teamFile);
		String Str;
		String[] tokens;

		if (inFile.exists()) {
			Scanner inputFile = new Scanner(inFile);

			for (int i = 0; i < teams.length; i++) {
				Str = inputFile.nextLine();
				tokens = Str.split(",");
				teams[i] = new Teams_18043639();
				teams[i].setTeamName(tokens[0]);
				teams[i].setMascotName(tokens[1]);
				teams[i].setHomeGroundName(tokens[2]);

			}

		}
	}

	/*
	 * to read the fixtures file
	 * @param fixtureFile - the fixtures file name
	 * @param Fixture[] fixtures - to stored array object
	 */
	public static void readFixtureFile(String fixtureFile, Fixtures_18043639[] fixtures) throws IOException {

		File inFile = new File(fixtureFile);
		String Str;
		int roundNumber = 0;
		String[] tokens;

		if (inFile.exists()) {
			Scanner inputFile = new Scanner(inFile);

			for (int i = 0; i < fixtures.length; i++) {
				Str = inputFile.nextLine();
				tokens = Str.split(",");
				fixtures[i] = new Fixtures_18043639();
				fixtures[i].setRoundNumber(Integer.parseInt(tokens[0]));
				fixtures[i].setMatchNumber(Integer.parseInt(tokens[1]));
				fixtures[i].setHomeTeam(tokens[2]);
				fixtures[i].setAwayTeam(tokens[3]);
				fixtures[i].setVenue(tokens[4]);
				fixtures[i].setTime(tokens[5]);
				fixtures[i].setDate(tokens[6]);

			}

		}

	}
	
	/*
	 * A method that read the team and fixtures file size
	 * @param inputFile - file to be read
	 * @return the size of the file
	 */
	public static int readArraySize(String inputFile) throws IOException {
		int arraySize = 0;

		File inFile = new File(inputFile);

		if (inFile.exists()) {
			Scanner fileSize = new Scanner(inFile);

			while (fileSize.hasNext()) {
				arraySize++;
				fileSize.nextLine();
			}
			fileSize.close();
		}
		return arraySize;
	}
	
	/*
	 * A method that read the round size base on userInput
	 * @param roundSize - the size to be read
	 * @param inputFile - userInput
	 * @return the size of the file
	 */
	public static int readRoundSize(int roundSize, int userInput) throws IOException {
		PrintWriter outFile = new PrintWriter("AllRound.txt");
		String round;

		for (int i = 1; i <= userInput; i++) {
			File myfile = new File("Round" + i + ".txt");

			if (myfile.exists()) {
				Scanner input = new Scanner(myfile);

				while (input.hasNext()) {
					roundSize++;
					round = input.nextLine();
					outFile.println(round);
				}

				input.close();
			}

			else {
				System.out.println("round" + i + "doesn't exists");
			}

		}
		outFile.close();
		return roundSize;
	}
}
