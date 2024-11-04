You are given a list of integers called numbers. Write a function to return any subset
of numbers where the elements sum to zero and that does not contain the number 0. If there
are no combinations of elements that sum to zero, return an empty list.

## Example 1:
### Input:
numbers = [1,-2,6,7,1]
### Output:
def zero_sum(numbers) -> [1,-2,1] # only possible combination

## Example 2:
### Input:
numbers = [0,0,1,3,6,-4,-1]
https://www.interviewquery.com/interview-guides/revolut-software-engineer

### Output:
def zero_sum(numbers) -> [1,3,-4]
or
def zero_sum(numbers) -> [1,-1]
