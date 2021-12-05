
Final Project for INFO6205 - Fall 2021
=============================
> This repository contains the code and reports for the final project of INFO6205 - Fall 2021

## Approach
To solve languages present in the unicode specification using MDS radixsort we required to the "sort" or linguistic order for each language. This order can be either created by hand or we can use the Unicode Collation Algorithm for these purposes.

### Unicode Collation Algorithm and CLDR

Unicode Collation algorithm provides rules created for linguistic orders for different algorithms. These rules were specified in the Common Locale Data Repository and are available to developers using the [ICU Library](https://icu.unicode.org/).

Our approach creates [CollationKey](https://unicode-org.github.io/icu-docs/apidoc/dev/icu4j/com/ibm/icu/text/CollationKey.html) for each input provided based on the locale of the language. Each CollationKey is represented in such a fashion that if key1 is greater than key2, then the byte[] of key1 will also be greater than byte[] of key2.

We simply modified the existing MSD implementations to work with byte[] and added an improvement to sort 2 bytes at a time rather than one.

Using this approach we can sort any string represented in Unicode encoding scheme as long as they follow the same language. Due to our independence from the language and adherence to rules provided by [CLDR](https://cldr.unicode.org/index) we sort a language using different ordering schemes.


## Structure
    ├── src                     # Source files (alternatively `lib` or `app`)
    ├── test                    # Automated tests (alternatively `spec` or `tests`)
    ├── input                   # Input Files for different languages 
    ├── outuput                 # Sorted output files and benchmarking results
    ├── tools                   # Tools and utilities
    └── README.md


### ./src 
    ├── io                      # Code for Reading from and Writing String[] to
							      files 
    ├── sort                    # 
	    ├── quicksort           # All Files have been stripped of dependencies 									
	                              not required for this project. Adapted from    
	                              class repo.
		  └── InsertionSort     # Modified to work without Helper.java and made  
                                  static
		  └── Partition         # Not Modified
		  └── Partitioner       # Not Modified
		  └── QuickSort         # Not Modified 
		  └── QuickSort_DualPivot # Not Modified
	
	    ├── radix               # Adapted from https://algs4.cs.princeton.edu/51radix/ to work with byte[], Unit Tests provided for all
		  └── RadixItem         # Helper class to store CollationKey without 
		                          creating a new byte[] for each access
		  └── MSDStringSort     # Most Significant Digit Sorting using the 
		                          byte[] of CollationKey provided by ibm/icu.
		  └── TwoByteMSDStringSort # Modification of MSDStringSort using two 
		                             bytes at a time rather than one
		  └── LSDRadixSort      # Least Significant Digit RadixSort.
		  
	    ├── timsort             # Implmented by us to Arrays.sort, Test Cases    
	                              provided
	                              
    ├── util                    # Contains benchmarking code adopted from 
							      repository
    └── Main.java               # Performs bencharking of all sorting methods


## Test Cases

![Test Cases Passing](https://i.imgur.com/J65Hw6q.png)

## Paper

[View](https://github.com/nshmadhani/FinalProject/blob/main/Paper.pdf)






## Contributors

* [Nishay Madhani](https://github.com/nshmadhani)
* [Aravind Polepeddi ](https://github.com/aravindpolepeddi)
* [Sai Poojitha Konduparti](https://github.com/poojithakonduparti)
