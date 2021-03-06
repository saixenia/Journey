# Journey
**Journey** helps you make the most of your travel experience. Before the trip, pin down your travel route, collect ideas for each leg and develop your personal itinerary. During the trip, reference your plans to make travel as easy as possible. After the trip, add photos and comments representative of your journey and share with friends.

## User Stories

The following **required** functionality is completed:

* [X] User can log into the app using a Google or Facebook account
* [X] Users can view a list of all Journeys created by them with general information about the legs.
* [X] User can create a new Journey by specifying the following:
   * [X] Journey name
   * [X] Journey legs - destination and start/end dates (partial)
   * [X] Journey tags - {solo, couple, group, family} & {adventure, relaxation, budget, luxury, foodie, culture}
* [X] Once journey is created, user is navigated to a *map-view* of the trip. Map view contains pins for each leg of the trip
* [X] User can *swipe off* the map view to see a calendar view of the trip.
* [X] User can view a view pager for days with all activities that have been added. The user will be able to select the day to view by selecting it.
* [X] A Drawer will contain items to navigate to the list of all journeys, edit legs, edit tags, and edit the current journey's name.
* [X] User can add / remove a leg of the trip. Information will be saved on the server.
* [X] User can add / remove custom activities to/from a specific day. Information will be saved on the server.
* [X] User can add / remove an activity from the recommendation page to/from a specific day. Information will be saved on the server.
* [X] The recommendations page will contain tabs with several activity categories that the user can navigate, and a grid of suggestions below. Suggestions will be populated using popular related APIs (like Google Places)

The following **optional** features are implemented:

* [ ] User can register for a new account
* [ ] User can login to the app using credentials specified during registration
* [X] User can see a zoomed in view of the map. This view contains destinations for a single day in the journey.
* [X] Users can pin/star recommendations; these pinned items are visible in a separate list to be added later to a day
* [X] User can bookmark multiple recommendations at once by tapping each to select/unselect
* [ ] User can add photos/comments to each leg of the trip
* [ ] User can take a photo directly from the app

The following **bonus** features are implemented:

* [ ] User can add other users to the trip, allowing them to collaborate on the planning
* [ ] User can search for other people's journeys and create a new journey based on a pre-existing one
* [ ] User can download their trip to their phone and enter offline mode. This mode has all details saved but does not access the internet.
* [ ] User can share their experience at any time in popular social media. 
  * [ ] They can share before their journey (their route)
  * [ ] They can share during or after their journey (things they did, photos they've taken)

## Walkthrough

* Week 1 Sprint
  - http://i.imgur.com/keJhu8T.gif
* Week 2 Sprint
  - http://i.imgur.com/zBOWX6J.gif
  - http://i.imgur.com/M0mQxTJ.gif (shows recommendations)

## Wireframes

Login 

![Imgur](http://i.imgur.com/AVQKwzo.jpg)

My Journeys - Empty

![Imgur](http://i.imgur.com/UhweanV.jpg)

My Journeys - Populated

![Imgur](http://i.imgur.com/mOY6FiU.jpg)

Wizard 1

![Imgur](http://i.imgur.com/cvW9ltR.jpg)

Wizard 2

![Imgur](http://i.imgur.com/RshVnN6.jpg)

Wizard 3

![Imgur](http://i.imgur.com/oExqX30.jpg)

Map View

![Imgur](http://i.imgur.com/kzjUc0j.jpg)

Leg Planner

![Imgur](http://i.imgur.com/UC42pRN.jpg)

Leg Planner - Drawer

![Imgur](http://i.imgur.com/RTXAC4x.jpg)

Leg Planner - Add pressed

![Imgur](http://i.imgur.com/yb0tipe.jpg)

Leg Planner - Add custom activity

![Imgur](http://i.imgur.com/uJzsUs2.jpg)

Explore Suggestions

![Imgur](http://i.imgur.com/ZNfe8pI.jpg)


## Open-source libraries used

- [Parcel](https://github.com/johncarl81/parceler) - Parcels made easy
