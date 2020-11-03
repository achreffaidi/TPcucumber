Feature: Can the Client get refund ?

  Scenario Outline: Client wants a refund
    Given the user bring at item that he brought from "<source>" store
    Given the item is "<status>"
    Given the item "<refundable>" refundable
    Given the item "<under_warranty>" under warranty
    When The client ask for refund
    Then I should tell the client : "<answer>"

    Examples:
      | source  | status  | refundable | under_warranty | answer       |
      | another | broken  | is         | is             | not today    |
      | another | working | is         | is             | not today    |
      | another | working | is not     | is not         | not today    |
      | our     | working | is         | is not         | not today    |
      | our     | working | is not     | is not         | not today    |
      | our     | working | is         | is not         | not today    |
      | our     | broken  | is         | is             | not today    |
      | our     | working | is         | is             | here you are |
      | our     | broken  | is not     | is             | not today    |