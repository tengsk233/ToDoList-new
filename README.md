# ToDoList-new  
## Background  
### 1. The purpose of developing this project  
Complete a lightweight to-do list that supports customization and management of to-do items.  
Understand the basic process of Android development, familiar with the use of Android Jetpack.  
### 2. Function overview  
Ability to customize to-dos and manage them.  
The user is supported to set the time to be done, but the system will remind the user when the time arrives.  
### 3. Characteristic overview  
Supports to-do import and export, can share to-do among different users, and helps users to migrate data.  
## Development Conditions  
1. Programming language: kotlin  
2. Database: Jetpack Room  
3. IDE: Android srudio  
4. Android SDK: 32  
5. UI writing: Jetpack compose 1.01  
## System Structure
The system is developed using the MVVM architecture, as shown in the figure  
![image](https://user-images.githubusercontent.com/66411810/210151930-2c3bdd42-c401-486d-92c9-bf7a1e3db6f2.png)  
The Model layer is mainly responsible for the provision of data. The Model layer provides the data structure of business logic (for example, entity class), provides data acquisition (from the local database), and provides data storage.  
The View layer is mainly responsible for the display of the interface. The View layer does not involve any business logic processing, it holds a reference to the ViewModel layer, and notifies the ViewModel layer when business logic processing is required.  
The ViewModel layer is mainly responsible for the processing of business logic. The ViewModel layer does not involve any view operations. Data binding is realized through Android compose, and changes in the data in the ViewModel layer can automatically notify the View layer to update, so the ViewModel layer does not need to hold a reference to the View layer.  
## Functional module division
![image](https://user-images.githubusercontent.com/66411810/210152011-021c01e9-b50a-48f3-913e-7b884deaa47e.png)
## Achievements  
![image](https://user-images.githubusercontent.com/66411810/210152052-0f8a07ae-2259-403a-a666-3c7013106131.png)![image](https://user-images.githubusercontent.com/66411810/210152056-10d12884-74db-4484-9230-a64b2a6d3960.png)
![image](https://user-images.githubusercontent.com/66411810/210152060-3312c2b5-d223-4964-bf0d-4214734faa2c.png)![image](https://user-images.githubusercontent.com/66411810/210152063-11bcb0db-4e4f-4f97-a7de-8940d27b0574.png)
![image](https://user-images.githubusercontent.com/66411810/210152069-dcec6917-f180-4518-b249-0cb80266bbae.png)
