## Utalk

Our group want to make an online discussion forum based on course for students, professors and faculties in the University of Toronto. 

Important: 
1. Our program needs version 17 JDK to run 
   File -> Project Structure -> Project -> Project SDK set to 17
                                           Project language level 17 - Sealed types, always-strict floating-point semantics
   setting language level to 17
   File -> Project Structure -> Modules -> language level set to 17
   
2. Please change the path in the FilePathHelper to your absolute path for our program down to the database package, after that it should be able to run.

3. Please empty the csv files when you run test cases as user and commentable user are written by different functions, therefore running the test cases will cause a misallignment in them.

4. our specification is the first section of our design document, our project accessibility report is included just before our progress report in our design document, and our progress report is the last section. 

5. Please run the executer to compile our codes. 

6. Add "JUnit4" to classpath to run the junit test


Basic function include: 

Student: add comment, delete one's own comment, enroll course, drop course, present course page, present postpage 

Faculty: add course, update course

Professor: add comment, delete comment, enroll course, drop course, present course page, present postpage 

Reader and writer: read and write into csvs.

JavaStorage: record all the information stored in it into Arraylists so that we can write them to csvs. 
