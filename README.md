# Moonlander
Report and testing output

Part a)

 
 ![](https://github.com/guyjac/moonlander/blob/main/md/1.png)
Fig. 1: Loading the game


My game starts by drawing the landing platform (bottom right), the sun (top left) and the stars (of which five are currently on screen). 
The landing platform and stars are placed on random X and Y coordinates at runtime and change upon level reset. The sun is statically placed.
My student registration can be seen in the title window, as specified.
 
Part b)

 ![](https://github.com/guyjac/moonlander/blob/main/md/2.png)
Fig. 2: Navigating via key input


My screenshot above (taken during gameplay), displays the following shapes: Circle, Rectangle, Square, Triangle and Pie. (
The background is a square object drawn with an image, the sun is a circle, the landing platform is made from several rectangles, the wings of the rocket are made from pie and the stars are made up of three Triangles.
 
 ![](https://github.com/guyjac/moonlander/blob/main/md/3.png)
Fig. 2.1: Collection of objects


The above screenshot shows that stars are stored as a collection of triangles which in turn are an abstraction of shape (as are all other shape classes mentioned above).


Part c)
Upon launch, the game is in a paused state (defined by: boolean playing=false;) and will not commence until a left click is captured by the MyMouseListener class.
Once a left click is captured, the Boolean is set to true which in turn leads to methods in the timer being invoked. This commences the game.
Once the game has commenced, a loop runs within the timer which registers UP, LEFT AND RIGHT key commands, through use of Booleans and integers defined within the MyKeyListener class.
In my screenshot above (Fig. 2), you can observe that I have navigated my rocket to the left, after starting the game with a left click.


Part D)
 
  ![](https://github.com/guyjac/moonlander/blob/main/md/3.png)
Fig. 3: Entering and recording a score

A method within my code will check the X and Y coordinates against the platform, to see if a successful landing was performed. If the landing was successful, a pop up window will appear and prompt the user to enter their name (in my example screenshot, I entered the name “student”). If however, the rocket object is travelling too fast (defined by a gravity variable within his object), the landing will be unsuccessful and he will crash. Crashes also occur when he missed the landing platform.


 ![](https://github.com/guyjac/moonlander/blob/main/md/4.png)
Fig. 4: Recording a score upon loss

Collisions can also be detected (with either the ground, or with stars) via collision detection method. Both of these events will also bring the game to an end, and prompt for a username (although the score will be 0).
This name will then be passed to the ScoreHandler class, where it will be appended to the score.txt file. Details recorded in score.txt are: Name, Fuel. Where Fuel represents score.
Exception handling was necessary, as it is possible for users to click cancel (which results in a null string). The exception handling which I implemented checks to see if a string is null or blank and will replace it with “aaa” if it is.

 
 ![](https://github.com/guyjac/moonlander/blob/main/md/5.png)
Fig. 5: The leader board

Upon entering a username, a method is invoked within the ScoreHandler class which loads score.txt into an array. Upon loading, a sorting algorithm is performed to place the highest scores at the top. The newly assorted array is then concatenated into a string, which is then returned and displayed via a jLabel. 
In the scenario that the file is unable to be opened (due to not being found, or being in use by another program) an exception clause is invoked. The exception clause will attempt to create a new score.txt file. If it fails to create the file, this is then caught. 

 ![](https://github.com/guyjac/moonlander/blob/main/md/6.png)
 
Fig. 6: File handling and exception handling
The screenshot above shows a scenario where a new score.txt has been created due to a file loading issue (hence one score) and where the username was not specified (hence “aaa”).


