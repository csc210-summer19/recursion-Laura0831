/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Laura Bolanos 
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
	  if(k==1) {
		  return n;
	  }
	  
	  else if(k==n) {
		  return 1;
	  }
	  else {
		  return combinations(n-1, k-1) + combinations(n-1, k);
	  }
	  
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
	 
	  if(n<=999) {
		  String number= String.valueOf(n);
		  return number;
	  }
	  else {
		  String num="";
		  if(n%1000 < 100) {
			num += "0";  
		  }
		  if(n%1000 < 10) {
			  num += "0";   
		  }

		  return intWithCommas(n/1000) + "," + num + intWithCommas(n%1000);
	  }
	  
    
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
	  if(index==len || index== len-1) {
		  return;	  
	  }
	  else if (index!=len) {
		  int first= x[index];
		  int last= x[len-1];
		  x[index]=last;
		  x[len-1]= first;
		  reverseArray(x, index+1, len-1);
	  }
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
	  
	  int max= a[0];
	  int min= a[0];
	  
	  int arrayMax= rangeMax(a,max, 1);
	  int arrayMin= rangeMin(a,min, 1);

    return arrayMax-arrayMin;
  }

  private int rangeMax(int[] a, int max, int index) {
	  if(index==a.length) {
		  return max;
	  }
	  else {
		  max= Math.max(max, a[index]);
		  return rangeMax(a,max, index+1);
	  }
  }
  
  private int rangeMin(int[] a, int min, int index) {
	  
	  if(index==a.length) {
		  return min;
	  }
	  else {
		  min= Math.min(min, a[index]);
		  return rangeMin(a,min, index+1);
	  }
  }
  
  
  // Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
	 if(nums.length==1 || nums.length==0 ) {
		 return true;
	 }
	 else {
    boolean check=false;
    return sortedHelper(nums, 0 , 1, check);
	 }
  }
  
  private boolean sortedHelper(int[] nums, int index, int next, boolean check) {
	  if(next==nums.length) {
		  return check;
	  }
	  if(nums[index]> nums[next]) {
		  return false;
	  }
	  
	  
	  return sortedHelper(nums, index+1 , next+1, true);
	  
  }
  
  
  

  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {

     return foundHelper(search, strs, 0);
  }
  
  private boolean foundHelper(String search, String[] strs, int index) {
	  
	  if(index== strs.length) {
		  return false;
	  }
	  
	  if(search.equals(strs[index])) {
		  return true;
	  }
	  return foundHelper(search, strs, index+1);
	  
  }
  
  
  
}
