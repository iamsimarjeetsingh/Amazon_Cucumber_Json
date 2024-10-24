#Author:SimarjeetSingh
@FeatureTag
Feature: As a user I want to Amazon and search for Iphone16Pro and Validate its specifications

  @ScenarioTag
  Scenario: User opens Amazon and searches for Iphone16Pro and validates specifications on screen from a json file
    Given User is on amazon homepage
      | Amazon |
      | Amazon |
    When User is on Amazon and searches iphone16pro and clicks on search btn
      | AmazonSearchBox | amzSearchBtn |
      | iphone16Pro     | amzSearchBtn |
    And User is on iphone listing page and clicks on Apple iPhone listing
      | iPhoneDesertTitanium |
      | iPhoneDesertTitanium |
    And User is redirected to new tab where user validates a unique label
      | LabelVerify           |
      | Visit the Apple Store |
    And User should validate the specifications wrt to data in a json file
    Then If Missmatch then Problem should be logged
