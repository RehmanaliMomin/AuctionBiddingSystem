# AuctionBiddingSystem


-Structure:
  User, Auction, Auction-bid, Item
The User and Auction table will be prepopulated, once we run the jar file.

With the get running auction API, we will get all the items from Auction table with running auction.
With the place bid API, we shall be entering the transaction into the table Auction-bid, and updated the last bid value in Auction if needed ie if bid is accepted.

Please find the postman collection for both the APIs - https://www.postman.com/collections/2044bbb55ab9fe9b83e6

In order to run locally, pre-requisites are MySQL, JDK.
Steps to run : 
  0. Run Mysql with username root, password root
  1. go to the jar file
  2. get into the bash, run 'java -jar auction-container.jar'
  3. You can test.
