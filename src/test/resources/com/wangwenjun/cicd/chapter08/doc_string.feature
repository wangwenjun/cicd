@cicd @v1.0.0
Feature: this feature document will demo the Doc String
  The Doc String use """ """ wrap the text.

#  Scenario: multiple lines in step is invalid.
#    Given the action type is "POST" and payload as below:
#    {
#      "header":{
#        "Content-Length":100
#      },
#      "body":{
#        "userName":"alex",
#        "age":35
#      }
#    }
  @doc_string
  Scenario: multiple lines in step is valid.
    Given the action type is "POST" and payload as below:
    """
    {
      "header":{
        "Content-Length":100
      },
      "body":{
        "userName":"alex",
        "age":35
        }
     }
    """