### Discuss the implemented algorithms. 
- Tell us the input you chose for your experiment and the output (you can copy the last line of output showing the solution and count for each of them).
- In your own words, describe what each of the four approaches to solving the change making problem are doing in 2-3 sentences for each algorithm.


The first algorithm uses a void method called allsolutions and passes two arrays of integers and an integer. It calculates the needed coin 
denominations by checking if the amount is zero if not the method is called again inside of the method. This is also called recursion.

The second algorithm uses a method called backtrack and returns an integer type. This algorithm uses the backtracking algorithm where it tries to 
test all the possible solutions to get the final answer. This algorithm has to take some steps back to be able to test all of the solution types.

The third algorithm uses a method called subproblem memo that returns an array of integers and passes a two dimensional array of integers, an array of integers
and an integer. This algorithm uses meoization which is used to improve the recursion of the algorithm. The solutions are stored in the two dimensional array.

The fourth algorithm uses a method called subproblem that reeturns an array of integers and passes an integer and a an array of integers. This algorithm
also uses recursion it uses a for loop to save the coin denominations in array and this for loop also calls the method again to create the recursion.


