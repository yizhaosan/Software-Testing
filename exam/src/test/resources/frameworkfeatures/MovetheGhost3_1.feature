@S3 @framework
Feature: Move The Ghost
  As a ghost
  I get automatically moved around
  So that I can try to kill the player

  @S3.1:
  Scenario: A ghost moves
    Given the game has started ghost 01
    And  a ghost is next to an empty cell 01
    When  a tick event occurs 01
    Then  the ghost can move to that cell 01
