Feature: User Select only Special Offers food in Beef & Veal 

Scenario: User Print Href of only Special Offer food in Beef & Veal 
Given User is on home page
When select beef and Veal in meet category from categories menu
And get list of special offers food in beef and Veal page
Then user print href of special offer of product
