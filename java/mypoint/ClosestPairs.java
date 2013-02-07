class ClosestPairs {
  public static myPoint[] CP(myPoint[] a) {
    double min = a[0].distanceTo(a[1]);
    myPoint[] ret = new myPoint[2];
    for(int i = 0; i < a.length; i++) {
      for(int j = i+1; j < a.length; j++) {
	if(a[i]
	   .distanceTo(a[j]) < min) {
	  ret[0] = a[i];
	  ret[1] = a[j];
	  min = ret[0].distanceTo(ret[1]);
	}
      }
    }
    return ret;
  }  
}