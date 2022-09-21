
Feature: Site overwiev
  As a user
  I want to see importance of site functionality
  I want be sure what all necessary functions work well
  Scenario Outline: Check correct open page
    Given User open '<Page>' site
    When I see correct home page
    Then I sure what page '<equals>' page
    Examples:
      | Page                | equals   |
      |https://www.ebay.com/|eBay |

  Scenario Outline: Check registration page
  Given User open '<Page>' site
  When I want to be able to register
  Then I see registration '<form>' name
  Examples:
    |Page                |  form                            |
    |https://www.ebay.com|Register: Create a personal account       |

  Scenario Outline: Try to register new user whith same name
    Given User open registration form
    When I want to enter '<FirstName>', '<LastName>', '<e-mail>', '<Password>'
    And I want Create accaunt
    Then I see warning page what an '<account>' already exists
    Examples:
      |FirstName |LastName       |e-mail                   |Password        |account                  |
      |Test      |Test           |pemajic689@ploneix.com   |Ci$rL^puyQ264v? |An account already exists|

    Scenario Outline: Try to login with incorrect parameters
      Given User open '<Page>'  site
      When User open login form
      And Enter incorect '<e-mail>'
      Then I see error "<message>" on the page

      Examples:
      |Page                         |e-mail                      |message|
      |https://www.ebay.com/        |pemajic689121@ploneix.com   |Oops, that's not a match.         |

      Scenario Outline: User can searc products
        Given User open home '<Page>' site
        When User "<search>" product
        Then User see <list> of products
        Examples:
          | Page                     |search                  | list |
          |https://www.ebay.com/     |Russian warship DONE!   | 0    |

      Scenario Outline:  User can logIn
        Given User open '<Page>'  site
        When User open login form
        And  User enter credentials '<e-mail>','<Password>'
        Then User authorisation
        Examples:
          | Page                         |e-mail                   |Password       |
          |https://www.ebay.com/         |tryamkin@gmail.com|g&ADN^Z3v*BH,m&|