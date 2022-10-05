# FoodGrid Android App in Java
This project is an Android application written in Java ☕. This application is a sample application developed to test SQLite, and programming paradigms. The application consist of restaurants and their food product. The user can add any products to the cart and checkout. The user has to register or login when doing checkout transactions. The user can view their order history and cost breakdown of each of their orders. Restaurants and customers data are store in the database.

## Functionalities

 - Can scroll through the restaurants and food item list and select each item.
 - The customer can select a food item and add it to their cart, they can select how many servings they want.
 - Once all the food items are added to the bucket, the customer can check out. If the customer wants to edit/remove their orders, they can do so until they press the checkout button.
 - The checkout button asks for login/ register if the customer is not logged in. The registration/login requires a valid email and password. A successful checkout is stored in the ordered history.
 - A logged customer can view their order history, e.g., time of orders and costs, which are scrollable. They can also check the order details, i.e., ordered food items and cost breakdown.
 - When the application starts, it will never ask for login or registration. The home page of the app will include a random list of food items from different restaurants.

## How To Add A Restaurant

 1. Open the project in android studio
 2. First copy and paste the restaurant image to `res` > `drawable` folder so it’ll be easier to refer later
 3. Then go to directory, `java` > `edu.curtin.foodgrid` > `database`
 4. Open DataHelper.java
 5. Find `insertData(SQLiteDatabase resDb)` method
 6. Add a new line under the last line inside the method as `addRes(new ResData(<restaurant id>, <”restaurant name”>, R.drawable.<restaurant image>), resDb);`
 
 ![add restaurant example](https://i.imgur.com/huFplx6.png)
 
7. Make sure to clear the data of the app to rebuild the database with new data.

## How To Add Food To A Restaurant

 1. First copy and paste the food image to `res` > `drawable` folder to it’ll be easier to refer later.
 2. Then go to directory, `java` > `edu.curtin.foodgrid`
 3. Open MainActivity.java
 4. Scroll down to find the `setFood(ArrayList<ResData> resList)` method
 5. You will see bunch of if condition, this is to recognize the respective restaurant id. Add a new `else if` condition clause to the last `else if` condition
 6. Add `“(res.getId() == <new restaurant id>)”` inside the else if clause
 7. Add new line `res.addFood(new FoodData(<food id>, <”food name”>, <price>, getResources().getDrawable(R.drawable.<food image>)));`


![add food example](https://i.imgur.com/vaHX1B8.png)

 8. Rebuild the app and check to see the food items added to the corresponding restaurant.

## How To Run The Program
 To run the program, open the project in Android Studio and debug the program in any Android version higher than Android 5.0 Lollipop.

### Indexed in Turn-It In Global Referencing Scheme

***This project should not be used for any coursework related activity and all codes have been submitted to `Turn-It In global referencing platform`, where usage of this code may be caught for Plagiarism.***
