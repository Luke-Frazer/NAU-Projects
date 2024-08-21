# D.5 Design #

## 1. Description ##
  MyGroceryHelper is a free, simple, and organized way to help you manage shopping and budget with no headaches. The main features of the software are a calendar that events can be manually entered in or events can appear automatically according to your shopping habits, and a clear portfolio to show what you buy weekly.
  Everything works together under one user friendly UI which makes scheduling trips to the grocery store, choosing the best place to shop, and analyzing previous shopping history a complete breeze.

## 2. Architecture ##

![image](https://user-images.githubusercontent.com/93493483/161470127-bcf71d2c-8816-4250-b574-fff058e604dd.png)


## 3. Class Diagram ##

![image](https://user-images.githubusercontent.com/71099197/161486092-0d8bcac9-4113-4eab-8dde-ce53fdc61ac9.png)

## 4. Sequence Diagram ##

### Description ###

**Use Case:** Looking for closest store

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

## Diagram ##

![image](https://user-images.githubusercontent.com/71099197/161470552-c2494502-c211-4a87-9413-c0f1d3e8921b.png)


## 5. Design Patterns ##
Design Pattern 1: Method to set the hour in the calendar so events can be set by hour

<img src="/Design/design1.png" alt="Designpattern #1"/>

Design Pattern 2: Method gives functionality to clicking on a date in the calendar

<img src="/Design/design 2.png" alt="Designpattern #2"/>

## 6. Design Principles ##
Single-Responsibility
Open-Closed
Liskov Substitution
Interface Segregation
Dependency Inversion

Our design observes 4 of the 5 SOLID principles in it’s current build state. It follows the first 4 principles of SOLID, but sadly not the last. It follows Single-Responsibility (S) the most with the adapter classes (RVAdapter and VPAdapter) for our main interface. Each of these has separate functions for each responsibility - in no case is one function doing the job of multiple - for example, getCount() only returns a size, addFragment() only adds a new fragment, et cetera.

It follows Open-Closed by having all variables and such be references and variables added in during calls or through builders. An example of this would be through the product list - rather than modifying the class to add new items to the list, there is a builder in a different class (setProductInfo()) that builds off of this function.

We observe Liskov Substitution by not having any derived classes or subclasses.

We observe Interface Segregation by making sure whatever functions or other such implementations we put in classes are all used, and none are dropped. An example of this is the class that runs our product view page - it imports View, ViewGroup, and LayoutInflator and each of those is used (View and ViewGroup to create the interface itself, LayoutInflater “shows” it). We do not import any unused classes in our builds.
