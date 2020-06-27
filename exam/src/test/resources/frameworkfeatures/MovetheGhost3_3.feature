@S3 @framework
Feature: Move The Ghost
  As a ghost
  I get automatically moved around
  So that I can try to kill the player

  @S3.3:
  Scenario: The ghost leaves a cell with a pellet
    Given a ghost is on a cell with a pellet (see S3.2) 03
    When  a tick even occurs 03
    Then  the ghost can move away from the cell with the pellet 03
    And  the pellet on that cell is is visible again 03