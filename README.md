# fitness-tracker
This project was study-related (3rd semester). My task was to write a GUI application which would allow users to create and edit excercises which then can be used to make workouts by grouping excercises. The trainings can be logged and user can define goals (and their progress can be viewed as a graph) which will be pinned to an excercise.

<br>

![image](https://github.com/user-attachments/assets/5d260984-6da1-414b-9c38-e95af115d3c7)
*The view right after start*

<br>

## Detailed info
*   The app's GUI was written using the **Java Swing**.
*   I used the MVC programming model to organize my project.
*   Data is saved in serialized form into a file.
*   I used the ![jfreechart](https://www.jfree.org/jfreechart/) library for chart functionality
*   Every single input is validated (including date)
*   No *What You See Is What You Get* Swing editor was used for this project (except for the button layout using the IntelliJ built-in functionality) 

## Overview and screenshots
This application provides a progress tracker functionality:
*   adding, editing and deleting excercises
*   creating and managing workouts made with different excercises
*   creating and managing user-specified goals
*   starting workouts, logging workout sessions and goal progress

## Workout tab
![image](https://github.com/user-attachments/assets/c7a924c5-cd5e-47b8-80b8-b062f87ce2e1)
*Workout tab*

### Excercises
![image](https://github.com/user-attachments/assets/0e8f5c06-f938-49fb-bf00-00fe8beb1edd)
*Excercises view*

<br>

In this menu you can browse, add or delete excercises. Each excercise is defined by it's **Name**, **Description**, **Can be weighted?**, **Reps counted** and **Reps timed** fields.
<br>
<br>
The **Can be weighted field** is set to true if the excercise requires, a weight to be added while creating a workout.
<br>
<br>
The **Reps counted** and **Reps timed** fields specify whether the excercise is about counting the number of repetitons done or counting the time of excercising (A plank would be **Reps timed** and curls would be **Reps counted**).
<br>
<br>
To delete an excercise - select the desired excercise with left mouse button and click **Delete** button.
<br>
<br>
Clicking the **Add excercise** button brings up this pop up window:

![image](https://github.com/user-attachments/assets/04edc742-36e9-49bb-8808-16b7ef1cd013)

*Add excercise pop up window*

### Browse Workouts
![image](https://github.com/user-attachments/assets/d0fceabb-9c33-4359-a421-09878ff79870)
*Browse workouts view*

<br>

In this menu you can browse, edit or delete workouts.

### Add Workout
![image](https://github.com/user-attachments/assets/7249fa3d-08bc-432d-a143-ffcbc1b99db9)
*Add workout view*

<br>

In this menu you can create workouts by selecting excercises form the **left window**.
<br>
<br>
Some of the selected excercises require additional information connected with how the excercise was created (e.g. info about weight or duration time). In this scenario the following pop up window will emerge:

<br>

![image](https://github.com/user-attachments/assets/333028a3-2c50-4d48-8b14-4137a3193c98)
<br>
*Promp for specifying additional information regarding adding a new excercise*

<br>
<br>

Added excercises will be shown in the **right window**. You can also remove added excercises by selecting them and clicking a button on the lower right side of the window.

<br>
<br>

After clicking **Create workout** button the following prompt will show up:

<br>

![image](https://github.com/user-attachments/assets/698add6a-5ca8-41d1-bfa1-2cce1129ea68)
*Prompt for confirming and naming your new workout*

## Goals tab
![image](https://github.com/user-attachments/assets/19178d83-9e0c-49d5-a167-65e579d7df19)
*Goals tab*

### Create goal
![image](https://github.com/user-attachments/assets/a387d823-cb8b-4bc8-a537-8033559dd463)
*Create goal view*

<br>

In this menu you can create a goal to which logs can be added later as you progress.

### Browse goals
![image](https://github.com/user-attachments/assets/b7b202ac-422c-4c71-a587-5d348e510f8f)
*Browse goals view*

<br>

In this menu you can browse, edit, delete log your progress and show the progress of each of your goals

<br>
<br>

When clicking the **Log your progress** button the following windows shows up:

![image](https://github.com/user-attachments/assets/e650ddbd-5c98-468a-8578-331f0cc35d4a)
<br>
*Log goal view*

<br>
<br>

By clicking the **Show goal** button you can view a chart that visualize your progress in a chart form:

![image](https://github.com/user-attachments/assets/f0ca55a4-a7e7-4195-8ef5-9832b741b2b2)
*Show goal view*

<br>

## Workout sessions tab
![image](https://github.com/user-attachments/assets/0ddb94c8-470a-478a-8302-193fd0e3411c)
*Workouts sessions tab*

<br>

### Browse Workout sessions
![image](https://github.com/user-attachments/assets/9913c1f4-3356-4d2e-8200-8678e8ecd687)
*Browse workout sessions view*

<br>

You can view all of the previous logged workout sessions here.

<br>
<br>

### Start workout
![image](https://github.com/user-attachments/assets/86cdb994-85a8-43a2-9445-d1e3903ccc19)
*Start workout view*

<br>
<br>

You can choose your workout from the list of created workouts.

<br>
<br>

After selecting a workout and clicking the start button you will be shown all of the excercises in user specified order and information:

![image](https://github.com/user-attachments/assets/e6bc7081-d775-47e6-a202-3624e50d7dcc)
*Starting a workout view*
