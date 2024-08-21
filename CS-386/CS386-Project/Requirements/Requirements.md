# Requirements

Group 6 - MyGroceryAssistant

Date - February 3, 2022

Group Members - Connor, Luke, Jack, Justin, Jonny, Nick

## 1. Positioning

### 1.1. Problem Statement
The problem of unorganized/unoptimized grocery shopping affects everyone who has ever shopped for groceries;
the impact of which can cost you finically as well as waste time with extra grocery trips.

### 1.2. Product Position Statement
For college students and young adults who have issues budgeting when shopping for groceries, MyGroceryAssistant is a planning and budgetization app that uses data to identify prices from multiple sources, informing users of better prices for their sought-after product. Unlike Instacart, our product accurately reflects the prices of products in the store, rather than s price that accounts for the service being used.

### 1.3. Value Proposition and Customer Segment
MyGroceryAssistant is a grocery tracking app that helps young adults who often forget to pick up certain grocery items remember when and what to buy from the store by providing an interactive calendar and reminder feature that offers easier use than other competitors. 

## 2. Stakeholders
Developers - Develop and maintain the software. Developers will also test and make changes to problems found to improve clients experience.

Users/Interviewees - The users will test the product through normal use and this will reveal problems and concerns with the software that we can improve for future users.

Competitors - Other shopping/budgeting apps that have similar features to ours. We can compare our app to the competition to get a gauge on our ideas and how they might perform. 

## 3. Functional Requirements (Features)

1. Automatically track the common items bought by the user and create a portfolio of their groceries.
2. Compare the price of each item to other stores in order to find the best overall priced shopping list and which store to get it.
3. Generate a calendar for the user that shows when they will need to restock on their common items and where to go. 
4. Remind the user using various methods of notifications for when they need to go to the store based off of their personalized portfolio and calendar.
5. Track seasonal items such as produce, holiday items, specials, etc and recommend items based on the season to the user. 
6. Allow the user to enter which items they bought, where they bought them, and what price they bought them for in order to better optimize their portfolio.
7. Allow the user to interact easily with the calendar, portfolio, settings, etc using a minimalist design with high functionality and customization. 
8. Allow any errors receeved by the app to be immediately sent as a report to the developers with an estimated risk level attached based on the number of users impacted. 

## 4. Non-Functional Requirements

1. Portability: This is very important because the app should be available on a mobile device with full functionality in order to use the application while shopping. 
2. Flexibility: The app should be able to help with a large variety of situations and shopping experiences. Because of this, the app will be very flexible in order to handle any shopping experience that the user may encounter. 
3. Reliability: The app needs to be very consistent so that every time the user goes shopping, it will perform accurately every time to ensure the user gets all of the products they need. 
4. Performance: Because there is not many moving parts happening at once, the performance shouldn't be an issue. It will need to connect to the MyGroceryAssistant servers quickly and generate a solid portfolio, calendar, and price mapping. Other than the connection side of the application, the UI will be minimalistic, allowing for a fast user experience. 
5. Security: The security of any app is important, however there wont be much personal information stored in the app besides your location, name, and grocery items. Because of this, there will be very little danger in using this app. Each user will create an account using their email and a password, allowing for extra protection for each user.  

## 5. MVP
Many young adults tend to forget little items when going to the grocery store. MyGroceryAssistant can help relieve some of these small yet annoying issues. The main features of the app include a calendar that keeps track of what items you should buy and on what day. This feature will then add all grocery items into a list once the certain date is reached, keeping track of all the items that you may want to go out and re-buy. The second main feature of the app is the reminder function. This part of the app will give you weekly reminders of what items you may need for the upcoming week. We can test these features by providing the app different groups of grocery shoppers making sure the app responds with a unique and beneficial response.

## 6. Use Cases

### 6.1. Use Case Diagram

<img src="/Requirements/useCaseDiagram.png" alt="UseCaseDiagram"/>

### 6.2. Use Case Descriptions and Interface Sketch

**Use Case #1:** Looking for closest store

**Actor:** User

**Description:** The user searches for what store has their item, looking for the closest available store with it.

**Pre-Conditions:** The user has an account. The user has said what unit of measurement to use.

**Post-Conditions:** The user has found what stores carry the given item, and knows which is closest.

**Main Flow:**
 * The user searches their item in the search bar.
 * The user can sort from a variety of options, including distance.
 * The user can click on the item to ‘favorite’ it.

**Alternative Flows:**
 * Users can access the items through the “Saved Items”, “Seasonal Items”, or “Deals & Coupons” tab rather than the search bar.
 * User can sort using different options from distance.

Sketchup Image: 

<img src="/Requirements/UseCase.png" alt="Use Case #1"/>

**Use-Case #2:** Submit online grocery list

**Brief Description:** Gives store your grocery list as an online order that is ready for curb side pickup.

**Actor:** Customer

**Preconditions** The user has a grocery list already

**Post-conditions:** Their grocery list would be picked and ready for curbside pickup.

**Main Flow:**
 * The user access custom grocery list.
 * User can finialize their list if any changes are needed.
 * User submits list and waits until order is ready.
 * The use case ends.
	
**Alternative Flows:** If in step 3 of the basic flow a specfic item is out of stock, then 

 * User will be notified and given other possible stores if they have said item
 * The use case resumes at step 3
  
**Use case #3:** Recommend items

**Actor:** Admin

**Description:** The admin recommends a list of items that all shoppers on the app can see

**Pre-Conditions:** The admin has a confirmed list that has been ‘ok’d’ by the group of owners

**Post-Conditions:** The admin has posted a list and all users can now see the list

**Main Flow:** The admin creates a list of potential items a group of users might like and pushes the list out onto the app. Users can then see this list on their browse page 

**Alternative Flow:** Admins can send out reminders to all users with recommended/ seasonal / holiday items. 

**Use case #4:** Input Budget

**Brief Description:** The User decides the budget they want the app to track for them. 

**Actor:** Customer

**Preconditions:** None

**Post-Conditions:** The user can input groceries as they shop and get instant feedback on how much they have left to spend.

**Main Flow:** 

The user inputs the budget they want to follow

The user is given a graphic and percentage representation of the money they can still spend on their budget as they shop

**Alternate Flow:**

If on the second step the user exceeds their budget, the budget will turn red and alert the shopper. 

<img src="/Requirements/input budget.png" alt="Use Case #4"/>

**Use case #5:** Search Stores for prices

**Brief Description:** The Admin searches nearby stores prices to determine best deals

**Actor:** Admin

**Preconditions:** Having access to the stores information

**Post-Conditions:** The Admin can update the price on the app and give customers up to date prices. 

**Main Flow:** 

The Admin checks a store in the nearby vicinity. 

The Admin repeats step one until all stores in the chosen range of the user have been checked. 

**Alternate Flow:**

There is no alternate flow pattern. 

**Use Case #6:** View my grocery portfolio

**Brief Description:** The user opens the app and goes to their personal portfolio to view their items.

**Actor:** Customer

**Preconditions:** User had entered their groceries from 2 previous trips to generate their basic portfolio.

**Post-Conditions:** The user can now use this portfolio as a shopping list on future trips.

**Main Flow:**

 * User opens the application.
 * User clicks on their portfolio on the home page
 * User views the portfolio for their next shopping list.

**Alternative Flow:**

The user did not previously enter shopping items and therefore does not yet have a portfolio.

Sketch of portfolio page:

<img src="/Requirements/Use case 6.jpg" alt="Portfolio"/>

## 7. User Stories

* As a college student I want this app to remind me what items to buy so I don’t have to make multiple trips to the store (Priority 1, 10 hours)
* As a young adult I want this app to keep track of when I buy groceries so I can budget easier (Priority 3, 6 hours)
* As a developer I want to make a price match feature to give the user the best possible price on an item.(Priority 2, approximately 10 hours)
* As a user I want to be able to update grocery list so I can constantly optimize my list to suit my needs(Priority #5, approximately 2 hours)
* As a budgeting college student, I would love for this app to help remind me when to buy my essential groceries and where to get the best price. The ability to create a personalized portfolio of all of my commonly bought groceries would save so much time, effort, and money (Priority 4, 20 hours). 
* As a developer, I would like to design the best possible features to help users save the maximum amount of money. I would like people to view our app as a money and time saver rather then a money draining app. This sort of view would bring more people to the platform in the long run (Priority 6, 10 hours)
* As a user, I want the app to tell me when some ingredients are in season so I know when I should be buying them. (Priority 7, approximately 4 hours)
* As a developer, I want to make the user interface intuitive enough that user’s don’t need a long-winded guide to use it. (Priority 9, approximately 10 hours)
* As a user, I want this app to find the best grocery deals for me (Priority 10, 0 hours). 
* As a developer I want to create a list system that can draw in people who are used to doing their grocery list non digitally (Priority 8, 8 hours). 
  
## 8. Issue Tracker

The issue tracker we are using is the Github Issue Tracker. This can be found at this link: https://github.com/Luke-Frazer/CS386-Project/issues

Here is an image of our issue tracker:

<img src="/Requirements/Issue Tracker.jpg" alt="Issue Tracker"/>
