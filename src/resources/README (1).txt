README for HW9 5004
Nano Liklikadze


When I started working on Homework 9 I realized that I had to change few things in my model to make sure that my views and controller would work with my model. 
Previously I had designed my IShape interface  with width and height parameters as types double, so I had to modify them to integers. I also had another enum class for the color that took rgb values but I decided to omit that class and simply give the shapes int r g b values. I also realized that my method in the Canvas model was not saving the shapes while creating them but rather it had a method that would add the created shapes to the canvas later upon calling that method. I realized that this would not be optimal for the requirements given in the hw spec.
These were the only changes I had to made in my model and then I was ready to design my views and controller. 


Controller


I wanted to keep my controller nice and simple, so I decided to make a helper class called ReadFile that I placed in the utility package. This class parsed the input file accordingly. ReadFile has one method called manageFiles which is called inside the go method of my controller class.
I have two parameters to my controller the IView and the ICanvasModel. So controller parsed the input file using the utility class communicates the information to the model in order to create/move/change shapes asks the views to display these shapes accordingly. This is all my controller does. I tried to give it one task to respect MVC principles.


VIEWS


I designed the interface IView that has only one method called Display it takes it the snapshot list and renders the view. 
WEB - using FileWriter and Bufferedwriter  the display method in iterates through the list of shapes in the different snapshots and writes to the file that is outputed as an HTML file.


Graphical View 
My graphical view also has a display method that does the most heavy lifting in the entire class. It creates the frame, the panels the buttons etc, and i have actionPerormed method which takes care of the button functionalities.
The display method is quite long in my graphical view class but I made this design trade decision because breaking it apart broke my program. I was also very new to Swing library and due to the limited time we had given for this assignment I was not able to make my code more glamorous. 


I also have a snapshot painter class which is a helper class of my Graphical view. SnapshotPainter is responsible for painting the shapes in the graphical view.