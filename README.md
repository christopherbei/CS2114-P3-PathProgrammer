## How to run the program, both the model and the view:
Download the game folder and run the Main.java file in eclipse or through a terminal.


## Reflection:
### Changed from our specification:
From the spec, we had the same classes, but changed a few methods and implementations. We had to add a method to check for win conditions in the map class and decided to store the player data as its own tile instead of a variable in the map class. We were prompted to make this change because we realized we had nothing planned in the spec for this crucial part of our program. Also, instead of controlling the player with cardinal directions we chose to have the player turn and move forward. We were prompted to make this change because we thought it would increase the difficulty and complexity of the game.

### Did the model really stand alone:
Yes, the model really stood alone. Our model classes are not dependent on the view class or do anything relating to the view, so we did not have to move anything across the model/view line.

### Our unknowns: 
We listed that we didn't know how to add colors to the user interface, we ended up using unicode characters instead of color as we found this made it most readable. We listed how to most efficiently implement a queue in the scenario, we were able to successfully figured this out. We listed what GUI system would we use and how would it be implemented, we have not attempted to implement a GUI yet, so this is still unknown for us. We listed how to create an algorithm that will randomly generate a map, we have not attempted to implement a random maps yet, so this is still unknown for us.    

### What doesn't work yet:
The only part that does not work yet is having a more complex map like how we planned. Currently we have a simple placeholder map that demonstrates the program works as intended, but is very simple to complete.

## New Steps: 
### What is left to finish the MVP:
We need to finish adding a more complex map that will make the user have to put in some effort to think how they will solve it. We will also tweak the output to be more user friendly. Once we have implemented these, then we are also going to complete our stretch goal of adding interactable tiles that the user will have to interact with before getting to the end in order to win.

### Non-trivial change feature:
Our non-trivial change feature is to add interactable items to the map that the user will have to either pick up or flip a lever or press a button before getting to the end. This will probably touch the model, view and controller classes because the model has to have the logic of the player interacting with the items, the controller will have to send if the user interacted it to the view and the view will have to display if the user interacted with the items. We are going to have to add new methods, such as interactWithItem and displayItemStatus, to the classes Main, Map and Display.

### Stretch goals:
We are going to attempt our stretch goal of adding mechanics that the user can interact with. We are going to drop our stretch goals of a graphical user interface and randomly generated maps.

### New tests, methods and bad input cases:
With the addition of interactable tiles, we will have to add tests to check if the user's commands successfully interacted with all of the interactable tiles in order to meet the win condition. We will have to add methods for adding interactable tiles to the map and methods for the user to interact with them. We will have to check for bad input cases such as the user trying to interact when the player is not on an interactable tile.


### Who does what? Which team member owns each remaining item.
Blake is going to implement the more complex map. Tyler is going to work on implementing the view and controller part of the interactable tiles. Chris is going to work on the model part of the interactable tiles. We are all going to work on refining the user interface.

## Attribution: 

| Class / File | Contribution / Role |
| :--- | :--- |
| Main | Written by Chris |
| Map | Written by Blake, debugged with Codex |
| Display | Written by Tyler |
| Queue | Written by Chris, GenAI debugged methods |
| QueueTest | Written by Chris |
| Node | Written by Chris |
| NodeTest | Written by Chris |

## GenAI Note:
GenAI was used to debug specific methods.

GenAI was used to format this README file.
