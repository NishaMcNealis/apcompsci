import java.util.Arrays;

class Exercise12 {
    public static void main(String[] args) {
	System.out.println(compute(4,2,new int[]{1}));
    }

    public static int compute(int nRow, int nColumn, int[] nList) {
	System.out.println(Arrays.toString(nList));
	if (nRow == 0) {
	    if (nColumn > nList.length-1)
		return -1;
	    return nList[nColumn];
	}
	return compute(--nRow, nColumn, sumList(nList));
    }

    public static int[] sumList(int[] nList) {
	int[] list = new int[nList.length+1];
	list[0] = 1;
	for (int i = 1; i < nList.length; i++) {
	    list[i] = nList[i-1]+nList[i];
	}
	list[nList.length] = 1;
	return list;
    }
}