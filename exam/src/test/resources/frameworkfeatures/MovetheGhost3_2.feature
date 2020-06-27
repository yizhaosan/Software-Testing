@S3 @framework
Feature: Move The Ghost
  As a ghost
  I get automatically moved around
  So that I can try to kill the player

  @S3.2:
  Scenario: The ghost moves over a square with a pellet
    Given the game has started ghost 02
    And  a ghost is next to a cell containing a pellet 02
    When  a tick event occurs 02
    Then  the ghost can move to the cell with the pellet 02
    And  the pellet on that cell is not visible anymore 02