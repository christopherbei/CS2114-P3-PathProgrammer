## How to run the program:
Download the game folder and run the Main.java file in eclipse or through a terminal.

## How to run the tests:
Run the JUnit test on each test file.

## Reflection:
### How did your design absorb the change? List the classes your feature actually touched. Compare that with the prediction in your D3 Next Steps: what matched, what surprised you?
The feature only touched the Map, Main and Display classes in order to add the logic and ability for the program to display the new tiles to the user. This perfectly matches our prediction in D3.

### Did the change cross the model/view line? Did the view have to learn anything new about the model? If a change rippled through layers it shouldn't have, where and why?
No, the change did not cross the model/view line. The logic components were isolated in the model while the new tiles to be displayed to the screen were isolated to the view. 

### What changed from your D3 plan? Features, signatures, validation, or tests that differ from what you said you'd do, and why.
The only things that changed was we decided to be more ambitious and to add more features. We modified the program so that the terminal always displayed the commands so the user would always be able to easily see what commands the user can use. We also added a GUI option, which was one of our stretch goals. We made another small quality of life tweak where you can just type the first letter of a command so that it is faster to type the commands.

### What doesn't work yet? MVP features, bad-input cases, or tests that are missing or failing. All MVP features, bad-input cases, and tests work.
There is nothing that does not work yet in the program. Every MVP feature has been implemented, the stretch goals of adding a GUI and interactable tiles were successfully implemented, every bad input case is accounted for and there is adequate testing for normal cases and bad input cases.

## New Steps: 
### What is left for the final build? Remaining features and fixes, in order.
There are no remaining features for the final build (other than our stretch goal of random map generation, which we will not be adding). The overall look of the GUI could be improved with symbols and effects.

### Which stretch goals are you committing to, and which are you dropping?
The stretch goals we committed to was creating a GUI and implementing interactive elements. The GUI can be modified to include symbols for the player, goal, key, and door. Along with that, more interactive elements can always be added. We dropped the stretch goal of generating random maps because it is too difficult to write the logical for creating maps that are designed fairly and would be fun to play.

### What will your 3-minute demo show? The path you'll walk through, including the new feature.
Our 3 minute demo will show the user inputting commands that will be invalid commands to show bad input handling. Then the user will put in valid commands, but cause the lose condition to demonstrate the lose condition for the program. Then the user will input the correct commands to interact with the required tiles to successfully meet the win condition.

### Who does what? Which team member owns each remaining item.
Chris will enhance the appearance of the GUI by adding more sophisticated graphics. Tyler and Blake will work on refactoring the code and working on any new ideas or issues that come up.


## Attribution: 

| Class / File | Contribution / Role |
| :--- | :--- |
| Main | Written by Chris |
| Map | Written by Blake, debugged with Codex |
| MapTest | Written by Tyler |
| Display | Written by Tyler |
| GraphicDisplay | Written by Chris|
| Queue | Written by Chris, GenAI debugged methods |
| QueueTest | Written by Chris and revised by Tyler |
| Node | Written by Chris |
| NodeTest | Written by Chris and revised by Tyler |

## GenAI Note:
GenAI was used to debug specific methods.

GenAI was used to format this README file.
