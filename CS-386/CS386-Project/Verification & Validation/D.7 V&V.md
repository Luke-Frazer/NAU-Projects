# D.7 Verification and Validation #

## Description ##

MyGroceryHelper is a free, simple, and organized way to help you manage shopping and budget with no headaches. The software includes an intuitive menu system that is very easy to operate. The main functions are a calendar that you can manually enter events in and over time the app will learn your shopping habits and schedule them for you. The next main feature is the portfolio. This is a list of everything that you buy and how frequently. This tab also contains information on the best place to shop for the best deals on these items.

*GitHub Link:* https://github.com/Luke-Frazer/CS386-Project

## Verification (tests) ##

### Unit Test ###

#### Test Framework ####

JUnit 5 was used for the Unit tests of this app.

#### Link to Automated Tests ####

#### Example Test Case ####

#### A Print Screen ####

### Acceptance Test ###

#### Test Framework Used ####

JUnit 5 was used for the Unit tests of this app.

#### Link to Automated Tests ####

https://github.com/Luke-Frazer/CS386-Project/blob/main/Verification%20%26%20Validation/ExampleInstrumentedTest.java

#### Example Acceptance Test ####

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.calendarapp", appContext.getPackageName());
    }
}

The code above launches the calendar and verifies that it is running.

#### A Print Screen ####

![image](https://user-images.githubusercontent.com/71099197/165417331-f2aaa3dd-933c-4e31-b358-373e84da1825.png)

## Validation (User Eval) ##

The data I’m collecting is whether or not it’s simple to use like the user interviews requested, data on the visuals, features they think should be added, and other standard app-company questions. 

### Script ###

Screenshared the app over discord, and asked them to describe where to go and what to do. As we cannot currently put the app on an android store, user directions were given to the interviewer as to what to do in the app (i.e ‘click on that button’ or ‘scroll to this’). They control what we do, I’m simply there to click for them. Then asked them the questions below in sequential order.

### Results ###

User: Beth Dufek
Interviewer: Justin Eggan
When: Wednesday, 27/4/2022, 12:15PM

1) How would you describe each page of our app?
    - The home page could’ve used an icon or logo.
    - The login page is missing a login button?
    - The product page is a scroll list of products. Nothing too interesting but you don’t need to change it.
    - The calendar is nice and simple.
2) What do you think is the hardest to use segment of our app?
    - Nothing is particularly “hard” to use. The app is built simply enough.
3) If our app were fleshed out more and completed, do you think you would use it?
    - Maybe. 
4) What do you think of the visuals of our app?
    - It’s missing… something visually, but I can’t describe it.
5) What’s a non-key feature you would add to the app, if given the time and/or resources?
    - It would be fun if the account page had a ‘budgeting’ tab that shows how much I spend each week on groceries. 
6) What’s a key feature you would add to the app?
    - The product list should be expanded upon more. Clicking on products should let me add them to the calendar. Also, the login page needs a login button.


User: Sebastion Gentry
Interviewer: Justin Eggan
When: Wednesday, 27/4/2022, 3:45PM

1) How would you describe each page of our app?
    -The home page is boring.
    -The account page feels empty.
    -The product list is there.
    -The calendar is good.
2) What do you think is the hardest to use segment of our app?
     -Nothing is ‘hard to use’. If I had to give an answer, the calendar.
3) If our app were fleshed out more and completed, do you think you would use it?
    -Yea, probably. It just needs a few things.
4) What do you think of the visuals of our app?
    -Keep the simple vibes, but it still needs a few things changed. Add shadows to the product list so it’s not so flat. Stuff like that.
5) What’s a non-key feature you would add to the app, if given the time and/or resources?
    -I would add a favorite items page. Oh, and a clarification between apple types! It’s just ‘Apple’ on here. (asks to go back to product page)
6) What’s a key feature you would add to the app?
    -I still want the sales tab. And a search bar on the product list.

User: Jon Kalten
Interviewer: Justin Eggan
When: Wednesday, 27/4/2022, 5:00PM

1) How would you describe each page of our app?
    The home page should have your logo, like whatever you’d use on the app store.
    The account page isn’t complete, so I have no thoughts on it at the moment
    Product page is simple, I like that.
    Calendar is nice. I like being able to go into a daily view all the way from a monthly view.
2) What do you think is the hardest to use segment of our app?
    By default the calendar, there’s no way to get lost anywhere else on account of the lack of features elsewhere.
3) If our app were fleshed out more and completed, do you think you would use it?
    As long as you don’t charge for it.
4) What do you think of the visuals of our app?
    Change the colour to something else.
5) What’s a non-key feature you would add to the app, if given the time and/or resources?
    Push notifications! Maybe a way to change the first day of the week? 
6) What’s a key feature you would add to the app?
    Search bar everywhere. A way to look up specific items on the calendar. 


### Reflections ###

Looking back on the feedback we got from our users, we accomplished our goal to make our app simple and easy to use. There were no complaints about navigation and no confusion on how to use all of the currently implemented features. One thing that we would change if we continued development would be the visuals of the app. It is very bare bones and looks like any starter android app. We would need to create a logo and make the app visually pleasant so that users would not be put off by the look. There is no learning curve to our system, assuming the person using the app has used a smart phone before. The users had no trouble navigating the app and all tasks were completed as we expected. One of the two main features in our value proposition were completed. The calendar was functional and one of the users commented on their like for how it worked. The other main feature was partially implemented. This would be the portfolio. Due to the difficulty of machine learning, we were unable to implement a working learning portfolio. However, as it looks in the app now, is what it would look like if it were up and runnning.  
