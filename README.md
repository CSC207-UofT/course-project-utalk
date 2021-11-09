## Utalk Hanqi

This is the branch for member Hanqi of Utalk. 

For Phase1, I am responsible for the AddCourse method, UpdateCourse and EditCourse. 

I choose to combine the latter two by checking whether the year == current_year to deduce whether the client wants to edit info or start a new course semester. 
As all three methods take in the same input: course_code, course_year, course_description, I use the facade design pattern to implement these methods. I create two classes for AddCourse and UpdateCourse and let the Faculty call instances of them to complete the add_course and update_course method. 
(TBC: decisions for Getinput and GetinputIn) 