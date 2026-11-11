## How to run the program:
Download the game folder and run the Main.java file in eclipse or through a terminal.


## Reflection:
### Changed from our specification:
From the spec, we had the same classes, but changed a few methods and implementations. We had to add a method to check for win conditions in the map class and decided to store the player data as its own tile instead of a variable in the map class. Also, instead of controlling the player with cardinal directions we chose to have the player turn and move forward to increase the difficulty and complexity of the game.

### Did the model really stand alone:
Yes, the model really stood alone. Our model classes are not dependent on the view class or do anything relating to the view, so we did not have to move anything across the model/view line.

### Our unknowns: 
We listed that we didn't know how to add colors to the user interface, we ended up using unicode characters instead of color as we found this made it most readable. We listed how to most efficiently implement a queue in the scenario, we were able to successfully figured this out. We listed what GUI system would we use and how would it be implemented, we have not attempted to implement a GUI yet, so this is still unknown for us. We listed how to create an algorithm that will randomly generate a map, we have not attempted to implement a random maps yet, so this is still unknown for us.    

### What doesn't work yet:
[MVP features, bad-input cases, or tests that are missing or failing.]


## New Steps: 
### What is left to finish the MVP:
[The remaining features and fixes, in the order you will do them.]


### Non-trivial change feature:
Our non-trivial change feature is to add interactable items to the map that the user will have to either pick up or flip a lever or press a button before getting to the end. This will probably touch the model, view and controller classes because the model has to have the logic of the player interacting with the items, the controller will have to send if the user interacted it to the view and the view will have to display if the user interacted with the items.

### Stretch goals:
We are going to attempt our stretch goal of adding mechanics that the user can interact with. We are going to drop our stretch goals of a graphical user interface and randomly generated maps.

### New tests, methosd and bad input cases:
With the addition of interactable tiles, we will have to add tests to check if the user's commands successfully interacted with all of the interactable tiles in order to meet the win condition. We will have to add methods for adding interactable tiles to the map and methods for the user to interact with them. We will have to check for bad input cases such as the user trying to interact when the player is not on an interactable tile.


### Who does what? Which team member owns each remaining item.
[placeholder]

## Attribution: 

| Class / File | Contribution / Role |
| :--- | :--- |
| Main | Written by Chris |
| Map | Written by Blake |
| Display | Written by Tyler |
| Queue | Written by Chris, GenAI debugged methods |
| QueueTest | Written by Chris |
| Node | Written by Chris |
| NodeTest | Written by Chris |

## GenAI Note:
GenAI was used to debug specific methods.

GenAI was used to format this README file.
