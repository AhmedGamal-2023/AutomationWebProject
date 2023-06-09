Feature: creation of course
  Scenario: Create a new course
    Given Open the Winjigo website
    When  sign in with username "testregister@aaa.com" and password "Wakram_123"
    And   open the courses page from left side navigation bar
    And   click on the create course button
    And   fill in the course basic info and click save course name is "AG-Testing Course" grade year is "6"
    Then  Back to courses list page and assert that course title is displayed "AG-Testing Course"