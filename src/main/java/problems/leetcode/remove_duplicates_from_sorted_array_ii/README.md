## 80. Remove Duplicates from Sorted Array II
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/


## SolutionV2

0,0,1,1,1,1,2,3,3 
----i
----j
`nums[i] != nums[j-2]` 1 != 0 = true; j++ 

0,0,1,1,1,1,2,3,3 
------i 
------j
`nums[i] != nums[j-2]` 1 != 0 true; j++

0,0,1,1,1,1,2,3,3 
----i
------j
`nums[i] != nums[j-2]` 1 != 1 false; 
