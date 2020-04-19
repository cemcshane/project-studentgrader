<h1> CSE237 Final Project - StudentGrader </h1>


<h2> What user stories were completed in this iteration? </h2>
<p> For this iteration, we created a user story in which the user can input a grading criteria with percentage weight (eg. Quizzes 25%, Tests 75%) and input multiple assignments for each criteria. The user can also input their recieved grade for each individual assignment, with a section for points awarded and total points possible. </p>

<p> A GUI was also implemented to make the input process easier and more streamlined for the user. JUnit tests were implemented in this iteration, as well. </p>

<h2> What user stories do you intend to complete in the next iteration? </h2>
<p> For the next iteration, we want the user to recieve helpful messages when entering an incorrect input (ex. letters in percentage input), and be able to store classes and calculate to get a whole semester GPA. </p>

<h2> Is there anything you implemented but doesn't currently work?</h2>
<p> Mainly, we want to make sure all of the calculations are operating correctly and the user is receiving the correct grade for the course and semester based on their category and assignment inputs. We also want to write a Bash script so that the user can easily run the program via the command line. </p>

<h2> How to access our program:</h2>
<ol>
   <li> Clone the repository to your device via the command line. NOTE: If you're a Windows user, go to Start and type cmd into your search bar, then hit enter.  You will need to use this terminal.</li>
   <li> Navigate to the src folder (cd project-studentgrader/GradingProject/src) </li>
   <li> Run the command javac projectfiles/*.java (if this gives you trouble, you might not have Java properly installed on your machine--https://stackoverflow.com/questions/7709041/javac-is-not-recognized-as-an-internal-or-external-command-operable-program-or may help)</li>
   <li> Run the command java projectfiles/GraderHome (final program output will be printed to the console, not GUI) </li>
</ol>
   
   
