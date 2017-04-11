# Input Domain Partitioning

## 1.	Lab Objectives
 * Perform an input domain analysis on a given system
 * Construct test cases based upon the input domain 

## 2.  The Assignment
The UML for this system is provided in Figure 1 (see PDF), and a set of Java Documents for the project are available on the course website.  You also will have a fully functioning implementation of the system.  The billboard manager has been implemented, but needs unit tests written against it.  The unit tests will be based upon the input domain of the class.  To aid in the construction of the input domain analysis model, a markdown template is available that will help you construct the input domain.


## 3.  Analysis Template
| Method Name | Parameters | Return Types | Possible Values | Exceptions | Condition |
| --- | --- | --- | --- | --- | --- |
| constructor | width | An instance of the class. | Not null |   | C1 |
|   |   |   | Null | IllegalArgumentException | C2 |
| setWidth | Width, current width | None |   | Illegal Argument Exception | C3 |
|   |   | None |   |   | C4 |
| |   |   |   |   |   |
|   |   |   |   |   |   |
|   |   |   |   |   |   |

| Condition | Description |
| --- | --- |
| C1 | In this case, a valid width for the area that is to be displayed is provided.  A valid width is greater than 0. |
| C2 | In this case, an invalid width is provided, namely one that is less than or equal to 0. |
| C3 | In this case, an invalid width is passed in, one that is less than or equal to 0. |
| C4 | In this case, a valid width is passed in. |
|   |   |
|   |   |
|   |   |


## Deliverables
* Completed input domain analysis table.
* Completed unit tests for BillboardManager.java

## Grading
* Quality of analysis
* Quality of tests