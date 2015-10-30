package SORWV_CSFinalProject;

import java.io.*;

public class SORWV_FinalProjectTest {

public static void main(String[] args) {
	SORWV_CourseArray allCourses = new SORWV_CourseArray();
allCourses = SORWV_ReadAndWrite.allCourseRead();
SORWV_CourseArray sylwiaSchedule = new SORWV_CourseArray();
sylwiaSchedule = SORWV_ReadAndWrite.personalScheduleRead("A20250522");
SORWV_Course course1 = allCourses.getObject(32);
SORWV_Course course2 = allCourses.getObject(17);
try{
FileWriter fileOut = new FileWriter("SORWV_TestResults.txt");
BufferedWriter outFile = new BufferedWriter(fileOut);
outFile.write("First we see the schedule we are beginning with " );
for(int i = 0; i < sylwiaSchedule.getIndex();i++){
outFile.newLine();
outFile.write(sylwiaSchedule.toString(i));
}
outFile.newLine();
outFile.write(" ");
outFile.newLine();	
outFile.write("Our course1 is " + course1.toString());
outFile.newLine();
outFile.write(" ");
outFile.newLine();
sylwiaSchedule.add(course1);
outFile.write("This is the schedule with course1 added ");
for(int i = 0; i < sylwiaSchedule.getIndex();i++){
outFile.newLine();
outFile.write(sylwiaSchedule.toString(i));
}
outFile.newLine();
outFile.write(" ");
outFile.newLine();
sylwiaSchedule.delete(course1);
outFile.write("This is the schedule with course1 deleted ");
for(int i = 0; i < sylwiaSchedule.getIndex();i++){
outFile.newLine();
outFile.write(sylwiaSchedule.toString(i));
}
outFile.newLine();
outFile.write(" ");
outFile.newLine();
outFile.write("Our course2 is " + course2.toString());
outFile.newLine();
outFile.write(" ");
outFile.newLine();
int pos = sylwiaSchedule.isThere(course2);
if(pos > -1){
	SORWV_Course isThereCourse = sylwiaSchedule.getObject(pos);
outFile.write("This is the information corresponding to the position provided by the isThere(course2) method ");
outFile.newLine();
outFile.write(isThereCourse.toString());
}
else{
outFile.write("Course two is not present");
}
SORWV_CourseArray oneMajor = allCourses.majorSearch("MMAE");
outFile.newLine();
outFile.write(" ");
outFile.newLine();
outFile.write("A CourseArray with just MMAE courses was created with the use of majorSearch() method. The following is the result");
for(int i = 0; i < oneMajor.getIndex();i++){
outFile.newLine();
outFile.write(oneMajor.toString(i));
}
outFile.newLine();
outFile.write(" ");
outFile.newLine();
int pos2 = allCourses.directCourseSearch("MMAE", 320);
SORWV_Course directSearchResult = allCourses.getObject(pos2);
outFile.write("This is the information corresponding to the position provided by the directCourseSearch(“MMAE”, 320) method ");
outFile.newLine();
outFile.write(directSearchResult.toString());

outFile.newLine();
outFile.write(" ");
outFile.newLine();
SORWV_StudentsArray allStuds = new SORWV_StudentsArray();
allStuds= SORWV_ReadAndWrite.allStudentsRead();
outFile.write("Here is the list of all the students in the system");
for(int i=0; i<allStuds.getIndex();i++){
outFile.newLine();
outFile.write(allStuds.getObject(i).toString());
}
outFile.newLine();
outFile.write("This displays polymorphism because there are two types of students, undergrad and graduate");
SORWV_Student rasta=new SORWV_Undergraduate("Doe", "John", "M", "A20253542", "MMAE");
SORWV_Student fasta=new SORWV_Graduate("Hawk", "Mike", "C", "A20259567", "CS");
allStuds.add(rasta);
outFile.newLine();
outFile.write(" ");
outFile.newLine();
outFile.write("Showing the adding of a student rasta to the students array");
for(int i=0; i<allStuds.getIndex();i++){
outFile.newLine();
outFile.write(allStuds.getObject(i).toString());
}
outFile.newLine();
outFile.write(" ");
outFile.newLine();
outFile.write("Another form of polymorphism is when the program performs the checkMax and checkMin functions");
rasta.setSched(sylwiaSchedule);
fasta.setSched(sylwiaSchedule);
outFile.newLine();
outFile.write(rasta.checkMin() +" This is the check min value for Undergrad");
outFile.newLine();
outFile.write(fasta.checkMin() +" This is the check min value for Grad");
outFile.newLine();
outFile.write(rasta.checkMax(course1) +" This is the check max value Undergrad");
outFile.newLine();
outFile.write(fasta.checkMax(course1) +" This is the check max value Grad");
outFile.newLine();
outFile.write(" ");
outFile.newLine();
outFile.write("Another form of polymorphism to display is the token string which is used when writing the updated list of students to the file");
for(int i=0; i<allStuds.getIndex();i++){
outFile.newLine();
outFile.write(allStuds.getObject(i).tokenString());
}
outFile.newLine();
outFile.write(" ");
outFile.newLine();
outFile.write("Searaching for a studnet using their anumber");
outFile.newLine();
outFile.write(allStuds.aNumSeqSearch(rasta.getAnum()) +" This is the location of the student in the List");
outFile.newLine();
outFile.write(" ");
outFile.newLine();
outFile.close();

}
catch(IOException ioe){
System.out.println("Error");
}
System.out.println("The file has been created.");
}

}
