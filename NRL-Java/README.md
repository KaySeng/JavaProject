# NRL (National Rugby League)-Java

NRL is a Rugby League competition played by professional players in sixteen teams from three states of Australia and Newland.

This programming project was to create an object-oriented menu-driven java program that is able to generate the competition ladder for any chosen rounds.

# Main Menu Item Functionality
  
# 1. Display Match Schedule
  When this menu option is selected the program should determine from the user if they want to view the schedule for all rounds of the competition or just a selected round.
  
# 2. Enter Round Results
  When this menu option is selected the program should allow the user to enter the match results for a particular round. The program will need to display the details for each match in the given round and obtain the score for the home team and the away team for each match. The round to be processed by the user should be the next round which should be determined automatically by the program (ie, if rounds 1 to 5 have already been loaded/entered then the next round to be processed would be round 6). The results of the round should also be applied to the Team objects array so that each Team object is up to date thus ensuring that any output generated via menu option 3 is correct.
  
 # 3. Display Ladder
 When this menu item is selected the program should display to the screen the current competition ladder. This will show the ranking of each team according to the match/round results that have been loaded/entered. This menu item cannot be chosen by the user if no rounds have been loaded/entered.
 
 # 4. Team Results 
 When this menu item is selected the program obtains from the user the name of an NRL team for which they wish to view full match results from round 1 to the current round of the competition.
 
 # 5. Exit Program 
 The program should terminate when this menu item is selected. The program should not terminate until this option is chosen. At other times the program should return to display the Main menu after completing the chosen menu option.
