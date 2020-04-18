<h1> CSE237 Final Project - StudentGrader </h1>


<h2> What user stories were completed in this iteration? </h2>
<p> For this iteration, we created a user story in which the user can input a grading criteria with percentage weight (eg. Quizzes 25%, Tests 75%) and input multiple assignments for each criteria. The user can also input their recieved grade for each individual assignment, with a section for points awarded and total points possible. </p>

<p> A GUI was also implemented to make the input process easier and more streamlined for the user. JUnit tests were implemented in this iteration, as well. </p>

<h2> What user stories do you intend to complete in the next iteration? </h2>
<p> For the next iteration, we want the user to recieve helpful messages when entering an incorrect input (ex. letters in percentage input). We also want to complete all calculations for the class and print out a final grade for the course. </p>

<h2> Is there anything you implemented but doesn't currently work?</h2>
<p> Mainly, we want to make sure all of the calculations are operating correctly and the user is receiving the correct grade for the course based on their category and assignment inputs. We also want to write a Bash script so that the user can easily run the program via the command line.

<h2> How to access our program:</h2>
4. Clone the repository to your machine via the command line. 
   Open project-studentgrader folder 
   User will input class and grade information into input_file.txt (GradingProject > src > projectfiles)
   cd into the projectfiles folder. (cd GradingProject, cd src, cd projectfiles) via the command line
   java Parser.java input_file.txt (or use java Parser.java testfile.txt to test using our pre-inputed data)

   
   
