# How to run the model:

# How to run the view:

## Reflection:
### Changed from our specification:
Some of the changes since the specifications are that we added a method for the win condition because we realize the way we had it in the spec did not have an isolated method for the win condition. We also changed the movement from the cardinal directions of going north, east, south and west and we are now using forward and turning left and right because we think this will increase the difficulty of the game for the user.

### Did the model really stand alone? Was there anything you had to move across the model/view line to make it run, or anything in the model that still knows about the view?


### Our unknowns: 
We listed that we didn't know how to add colors to the user interface, we ended up using unicode characters instead of color as we found this made it most readable. We listed how to most efficiently implement a queue in the scenario, we were able to successfully figured this out. We listed what GUI system would we use and how would it be implemented, we have not attempted to implement a GUI yet, so this is still unknown for us. We listed how to create an algorithm that will randomly generate a map, we have not attempted to implement a random maps yet, so this is still unknown for us.    

### What doesn't work yet? MVP features, bad-input cases, or tests that are missing or failing.


## New Steps: 
### What is left to finish the MVP? The remaining features and fixes, in the order you will do them.


### Non-trivial change feature:
Our non-trivial change feature is to add interactable items to the map that the user will have to either pick up or flip a lever or press a button before getting to the end. This will probably touch the model, view and controller classes because the model has to have the logic of the player interacting with the items, the controller will have to send if the user interacted it to the view and the view will have to display if the user interacted with the items.

### Stretch goals:
We are going to attempt our stretch goal of adding mechanics that the user can interact with. We are going to drop our stretch goals of a graphical user interface and randomly generated maps.

### What new tests will you need? The methods and bad-input cases the added work must cover.


### Who does what? Which team member owns each remaining item.


## Attribution: 

| Class / File | Contribution / Role |
| :--- | :--- |
| Main | Chris |
| Map | Blake |
| Display | Tyler |
| Queue | Written by Chris, GenAI debugged methods |
| QueueTest | Written by Chris |
| Node | Written by Chris |
| NodeTest | Written by Chris |

### GenAI:
GenAI was used to debug specific methods. GenAI was used to format this README file.