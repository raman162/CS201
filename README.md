NAME: Odrzywolska Sylwia 

Last First

NAME: Walwyn-Venugopal Raman 

Last First

I.  (3 points)   Description of the group.  Answer the following questions: 

a. How often did your group meet? 

Our group met a total of three times. 

      b. List the assigned tasks for each team member.

Sylwia – II, IV, V, VI 

Raman – I, III, VII

      c. Describe how much time each group member spent on this part of the project and what each 

team member contributed. 

____/3

II. (5 points) Describe your application, the input data, and the source of the input data.  Be sure to 

answer the usual questions: who, what, where, and why? Give enough detail so that ANYONE  

reading it would know what your app does and if they would want to purchase your app. 

The application will be used by students to brows through classes offered and pick the classes they 

want to take and add them to their schedule. The application will make sure the classes do not 

interfere with each other and if they do the student will have an option to drop the previous class or 

simply not add the class currently viewed. The input data will be a file containing the course 

information including: major, course number, credit hours, days and times of lecture. The student 

will enter their information so that their schedule will be saved in the system, this will also enable 

the application to check if the correct number of credit hours is being taken based on students' level. 

____/5 

III. DESCRIBE PROGRAMMERS’ TASKS: (12 points)

a. Describe how you will read the input file.

b. Describe how you will process the data from the input file

c. Describe how you will store the data (what objects will you store?)

d. How will you demonstrate polymorphism?

e. How will you add/delete data?

f. How will you search/sort data?

  ____/12

The input file will be a text file with the data for each separate object (Course) on a line. An object 

(inFile) of Scanner will be used with FileReader to read the file. A while loop will be used to make 

sure that all of the lines are read from the input file. The condition for the while loop will be 

inFile.has.next(), this checks to see if the file has a next line, if it is true it will then read the line and 

store it as a string. The string will be split into an array and the data will be used to create a course 

object. The Course object will then be added to the List Array of courses.

 

Polymorphism will be demonstrated when calling the toStringMethod for the student’s schedule and 

also for checking whether a graduate or undergraduate student has minimum or maximum credit 

hours.

Courses will be added to the student’s (user) schedule when choosing the courses that they would 

like to take for the semester. Schedule is an array of courses, when the user selects a course from 

using the menu system, it will make a copy and add it to the array schedule. When a user decides 

to drop a course, the delete function from the array list will be called to delete the specific course 

that the user selects. Another way data is added is when the student uses the program for the first 

time. They will enter their A-number, and if the system doesn’t recognize it they will be prompted to 

enter their information and a new object will be created and added to the student array. 

When the student is selecting a specific course to add to their schedule, the program will then 

search through the List Array of Course objects. A linear search method will be used to see if the 

course is available. The List Array will be sorted in Alphabetical order based on their major and 

numerically afterwards. The List Array will be sorted after all the lines have been read from the input 

file.

 

IV.     CLASSES:

  (5 points)  List the names of the classes in your final project and describe the purpose of each of 

the classes.  Be sure to include the application class; remember to put your name in this file.  You 

can also name this file with your initials.

Student Abstract Superclass – Identifies who the student is so that their schedule can be saved for later 

view/editing and identifies the students level

Graduate/Undergraduate – Student subclasses used to check minimum and maximum credit hours the 

student can take based on the level

Course – Includes all the information about the classes offered such as major, course number, credit 

hours, and when the lecture is

CourseArray – Encapsulated array that allows us to handle the courses as objects, create individual 

schedules, calculate total credits, and checks if days or times overlap

Menu – class that has all the possible options for the student to choose from such as search, add, delete, 

check credit hours, view schedule, return to main menu and exit

Application – Allows student to start a new schedule or look up a previous one by name or A number. 

Calls the Menu class to display and select options, uses the CourseArray to create a new schedule based 

on what the student selects 

____/5 

V.  UML CLASS DIAGRAM:

(10 points)   Draw a UML class diagram that represents the classes above.  Be sure to include all 

attributes, major behaviors, and relationships between classes.  Please submit this as a *.pdf file.

Grading:

10 

points 

8 

points 

4-6 

points 

2 

points 

All classes depicted with all attributes and major behaviors indicated; relationships between 

classes are clearly and correctly indicated. 

All classes depicted with all attributes and major behaviors indicated.  May be missing some 

major behaviors and/or relationships; incorrect relationships may be indicated; 

Most of classes depicted with most of attributes and major behaviors.  May have incorrect or 

missing relationships. 

Most of classes missing or incomplete attributes/behaviors, relationships incorrect or 

missing. 

The Undergraduate/Graduate subclasses seem like they can be part of Student but then we won’t have 

polymorphism so I don’t know how you wan to handle this. Ran into some issues with Menu and 

Application classes so I know they need changing I just haven’t figured out what or how. I’m not certain 

if I connected things correctly, I guess CourseArray needs to be connected to student somehow. I think 

we also need a StudentArray since we’re creating new entries and want to look back at them, but I’m 

giving up on it for tonight. 

____/10 

VI. INPUT FILE:   (5 points) Submit a sample of your input file.

CHE,202,3,1350,TR

CHE,351,3,1350,TR

CHE,301,3,1000,MW

CHE,426,3,1700,M

CS,350,3,1000,MW

CS,435,3,1350,TR

ENVE,485,3,1700,R

MS,201,3,0835,TR

MMAE,305,3,0835,MW

MMAE,320,3,0835,TR 

____/5

VII. TESTING: (10 points) how will you test your application?  Submit a test plan for all possible 

user menu functions and a test plan for using the menu.  You should also include a test plan 

to test the demonstration of polymorphism.   Full points will be given to test plans that test 

the test condition with various possible inputs. Fewer points will be given to test plans that 

do not stringently test your program.  (Note: if your program is working well, there is very 

little time difference in running 3-4 tests vs. running 20 tests.  However, running 20 tests 

could uncover potential problems in your program.)  Plan to run your test plan and create an 

output file with the results of your test plan.

Test Case Sample Data Expected Result Results 

Course add/drop 

menu functions 

addCourse( obj 

course)             

Add(course1) viewSchedule () for 

delete (obj course) delete(course1) viewSchedule() 

isThere(obj course) IsThere(course2) Searches the list of 

viewSchedule() None Shows user their 

Schedule shows 

course1 is added to 

the schedule for the 

student 

shows that course1 

from the student’s 

schedule 

courses to see if it 

is available and 

returns course info 

if available and 

error message if not 

current schedule 

searchCourses(String 

major) 

searchCourses(MMAE) Displays all the 

MMAE courses to 

the user. Prompts 

user to select a 

course num 

isThere(obj course) isThere(mmae350) Displays the days, 

time and professor 

of course and 

prompts user to add 

or cancel 

selectCourse(int num) selectCourse(001) 

searchCourses(string 

major) 

searchCourses(CSCE) Displays error 

showCourses() None Shows the user all 

checkMaxCreditHours(

) 

None Called everytime 

checkMinCreditHours() none Displays the 

message to user 

stating that it isn’t a 

major 

the courses 

available sorted. 

(toString() of list of 

courses available 

student tries to add 

course to schedule

Returns an int, if the 

int is greater than 0 

then the student 

can’t take the 

course they 

attempted to add 

(polymorphism) 

minimum amount of 

credit hours a 

student needs 

(polymorphism 

because there are 

both undergrad and 

graduate students) 

Menu Interface for 

student add/drop 

courses 

Initial menu interface 

offers user to search 

for a direct course(1), 

search by major(2),

View all available 

courses (3),

view schedule(4), 

remove courses(5)

Exit(6) 

User selects input 1 User is prompted to 

User enters course CS, 201 Shows user the 

User adds course 1 Checks to see if 

User enters course CDCEF, 023 Displays error 

User selects input 2 Prompts user to enter 

User enters major HUM Displays all the 

User selects to enter 

course num 

102 Shows user the 

User selects invalid 

option 

3 Tells user that it is an 

enter course (for 

eg. MMAE, 350) 

course info and 

prompts to add(1) 

or cancel(2)

over max credit 

hours and if it can fit 

in their schedule if 

not course is added 

to schedule, returns 

to original menu 

screen 

message of course 

not available and 

returns to user 

a major of their 

choice 

humanity courses 

available and prompts 

user to enter course 

num(1) or cancel(2) 

course info and 

prompts to add(1) 

or cancel(2) 

invalid option and 

prompts whether they 

want to add or cancel 

again. 

User selects cancel 2 Returns to the original 

User selects to search by 

major 

User enters major CCAE Error shows up saying 

2 Prompts user to enter 

User selects to see al 

courses 

3 A list of all the 

menu 

major name 

major doesn’t exist 

and returms to main 

menu 

courses available 

show up with the 

available times. User 

is prompted to add a 

course(1) or cancel(2) 

User selects cancel 2 Returns to main menu 

User selects to view 

schedule 

4 Displays the student’s 

User selects to remove 

courses 

5 Displays the list of 

User selects course 3 3 Deletes course 3 and 

To see if user adds a 

course and credit hours 

are over max 

Add(CS201) Doesn’t add the 

To see if user adds a 

course and there is a 

conflict in times 

Add(CS201) Doesn’t add the 

Users selects 1 to remove 

old course and add new 

one 

1 Old vourse is deleted, 

User selects invalid 

option 

User selects to exit the 

system 

Menu for student login 

User enters A number A55555555 Checks to see if 

9 Dispalys invalid 

10 Displays a goodbye 

schedule of courses 

and credit hours and 

returns to main menu. 

courses with a 

number next to each 

one. Prompts user to 

enter number of the 

course they want to 

delete r -1 to cancel 

displays the current 

schedule and returns 

to the main menu. 

course and tells user 

because it went “x” 

credits over 

maximum 

course but gives the 

user the option to 

delete the course 

conflicting and add 

the new one(1) or 

cancel the add(2) 

new one is added, 

schedule is displayed 

and returns to original 

menu 

option and returns to 

original menu 

message and closes. 

number is in Student 

array, it is not, so 

User enters whether they 

are undergrad(1) or 

grad(2) 

User enter first name John Prompts for last name 

User enters last name Doe Prompts for middle 

User enters middle name Mike Prompts for the major 

User enters major MMAE Adds student to the 

1 Prompts user for first 

prompts user to enter 

information 

name 

name 

3 Displays invalid 

array of undergrad 

and goes to course 

add/drop menu 

option and the 

Prompts user if 

underdraguate(1) or 

graduate(2) 

Student login functions 

checkAnumber(string 

anum) 

checkAnumber(A55555555

) 

Add(String anum, String 

first, String last, String 

middle, String major) 

Student.checkmin() John.checkmin() toString(to show if 

Add(John, Doe, Mike, 

MMAE) 

Goes through the 

student array to see if 

the student exists, no 

student, so prompts to 

add information 

toString() of array of 

Students to show that 

the student was added 

to the list 

student is over 

minimum credits and 

how many credits is 

needed) 

Student.checkmax() John.checkmax() toString()to show if 

student is over max 

credits and how many 

credits he is over 

isAnumValid(String 

anum) 

isAnumValid(String 

anum) 

isAnumValid(A55555555) toString() Returns 

isAnumValid(B54543) toString() returns 

true 

false