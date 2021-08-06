Feature: Looking up latest launches of rocket,
  core, capsule, starlink, launchpad, and landing pad data.

  Scenario: Looking up latest launches of Rockets
    When I look up a rocket latest launches
    Then the launch status should be success
    And I should see rocket fire date


  Scenario: Looking up links of items
    When I look up a rocket latest launches
    Then I should see the links has items
    And I should see youtube and wikipedia links


  Scenario: Looking up cores details
    When I look up a rocket latest launches
    Then I should see launch pad details
    Then I should see flight Number
    And I should see name and id
    And I should see core details
    And I should see capsule details



