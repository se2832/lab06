# Input Domain Partitioning

## 1.	Lab Objectives
 * Perform an input domain analysis on a given system
 * Construct test cases based upon the input domain
 * Compute the control flow graph on a given system.
 * Construct basis path tests. 

## 2.  The Assignment
The UML for this system is provided in Figure 1 (see PDF), and a set of Java Documents for the project are available on the course website.  You also will have a fully functioning implementation of the system.  The billboard manager has been implemented, but needs unit tests written against it.  The unit tests will be based upon the input domain of the class.  To aid in the construction of the input domain analysis model, a markdown template is available that will help you construct the input domain.


## 3.  IDM Analysis Template
| Method Name | Parameters | Return Types | Possible Values | Exceptions | Partition |
| --- | --- | --- | --- | --- | --- |
| constructor | width | An instance of the class. | Not null |   | P1 |
|   |   |   | Null | IllegalArgumentException | P2 |
| setWidth | Width, current width | None |   | Illegal Argument Exception | P3 |
|   |   | None |   |   | P4 |
| |   |   |   |   |   |
|   |   |   |   |   |   |
|   |   |   |   |   |   |

| Partition | Description |
| --- | --- |
| P1 | In this case, a valid width for the area that is to be displayed is provided.  A valid width is greater than 0. |
| P2 | In this case, an invalid width is provided, namely one that is less than or equal to 0. |
| P3 | In this case, an invalid width is passed in, one that is less than or equal to 0. |
| P4 | In this case, a valid width is passed in. |
|   |   |
|   |   |
|   |   |

## 4. Basis Path Analysis
| Method Name | MCC | Test Case Values | Expected Result | 
| --- | --- | --- | --- |
| constructor | 2 | width = 0 | IllegalArgumentException | 
|  |  | width = 10 | getWidth() = 10 | 


## Deliverables
A single file named Writeup.md that includes:
* Completed input domain analysis table in a file called Writeup.md. 
* Completed basis path calculations
* Two embedded images of control flow graphs.  These should be for the methods ```getDisplayedMessage``` and ```scrollLeft```

Completed unit tests for BillboardManager.java

## Grading
* Quality of analysis
* Quality of tests
* Quality of instruction following
