public class Run {
    public static final int NUM_TRIALS_PER = 2;
    public static final int HIGH_RANGE_TESTED = 3; //10^x
    public static final int HIGH_SIZE_TESTED = 3; //10^x
    public static void main(String[] args) {
	//main method

	
    }
    
    public static void runops() {
	//runs all of the operations set out in other files
	
	//variables are named in three parts.
	//first letter signifies data structure (Array=a, ArrayList=l, TreeSet=t, HashMap = h))
	//second letter signifies function (Insert = i, Search = s, Delete = d)
	//third letter signifies sum (s) or total (t) used for averaging times. sum is the sum of each value, t is the total number of values
	int ais, ait, ass, ast, ads, adt;
	int lis, lit, lss, lst, lds, ldt;
	int tis, tit, tss, tst, tds, tdt;
	int his, hit, hss, hst, hds, hdt;
	ais=ait=ass=ast=ads=adt=lis=lit=lss=lst=lds=ldt=tis=tit=tss=tst=tds=tdt=his=hit=hss=hst=hds=hdt=0;
	for(int i = 0; i <= HIGH_RANGE_TESTED; i++) {
	    for(int j = 0; j <= HIGH_SIZE_TESTED; j++) {
		for(int k = 0; k < NUM_TRIALS_PER; k++) {
		    
		}
	    }
	}
    }
}
