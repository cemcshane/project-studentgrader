#!/bin/bash
git clone https://github.com/wustlcse237sp20/project-studentgrader.git
cd project-studentgrader
cd GradingProject
cd src
javac projectfiles/*.java
java projectfiles/GraderHome
