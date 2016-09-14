## The google play link is 
https://play.google.com/apps/testing/com.wan.ubun17.purchasedecision

## Screen Shot
![serach image](./image/search_resize1.png)
![serach image](./image/twitt_resize.png)
![serach image](./image/cart_resize.png)

## Description of APP
This app compare prices from WalMart, Ebay and Best buy.Also, it search twitt about the item.

First, user input item of interest in Wart Search engine. The app shows the serach reslut which
is the list of item. And then this app search Ebay and BestBuy for individual item in WalMart Search item. The Ebay has many sellers. It shows range of prices. Also, this app shows twitts of each item.

A user can saved the search result in shopping card. The shopping cart is save in Firebase.
So the user can access it with any smart phone or computer.

The user can compare prices anywhere that it has cell phone signal.
##Technologies used
1. 4 APIes - Walmart, Ebay, BestBuy and Twitter
2. OKhttp - connecting API
3. FireBase - to save shopping cart
4. Picasso - retriving image from server
5. Recyclerview
6. Gson - to capture json data

## Design Process
when I desinged it, I focused on readibiliy of data. This app has much data from 4 APIs.
Most important things is to deliver the information effectively. If too many information in a singles
activity, a user may be confused and would not like to read it. The twitts messages is placed in other
screen to simplify the app. 

There are numberless android phones which have various screen size. The small screen may not show
all information which can be showed in screen. The font size should be carfully chosed. Or we can 
ajdust the amount of information in a screen according to screen size.

## Special Instruction for Android Studdio
The file structure of windows is different from linux and os x. Android project written in linux or os x
may not be emulated in Windows. However, project written in Windows works well in both linux and os x. And linux and mac are compatible each other for android emulator.

## Unsolved problems
I am moving code for twitter API from RecyclerView Aadapter to main. While scrolling the screen up and down, whenever a view apper in screen, any code in it is excuted. It is waste of API calling becuase most API has limitation of calling a day.

