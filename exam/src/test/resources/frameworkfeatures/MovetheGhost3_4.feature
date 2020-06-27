@S3 @framework
Feature: Move The Ghost
  As a ghost
  I get automatically moved around
  So that I can try to kill the player

  @S3.4:
  Scenario: The player dies
    Given the game has started ghost 04
    And  a ghost is next to a cell containing the player 04
    When  a tick event occurs 04
    Then  the ghost can move to the player 04
    And  the game is over ghost 04