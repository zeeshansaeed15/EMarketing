import java.util.ArrayList;
import java.util.List;


public class TestingClass {

	public static void main(String[] args) {
//		int[] a = {-1,3,-4,5,1,-6,2,1};
//		int result = solution(a);
//		System.out.println(result);
		//System.out.println(solution("a0Ba"));
		System.out.println(solution(2015,"April", "May", "Wednesday"));
	}
	
    public static int solution(int Y, String A, String B, String W) {
        String[] monthNames = {"January", "February","March","April", "May", "June","July","August", "September", "October","November", "December"};
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dayNames = {"Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        boolean leapYear = false;
        if (Y % 4 == 0) {
        	leapYear = true;
        }
        return firstDayOfMonth(W,monthNames,days,dayNames,leapYear,A,B);
        
    	
    }    
    private static int firstDayOfMonth(String W, String[] monthNames, int[] days, String[] dayNames, boolean leapYear, String A, String B){
    	int currentDayIndex = -1;
    	for (int i = 0; i < dayNames.length ; i++) {
    		if (dayNames[i].equalsIgnoreCase(W)) {
    			currentDayIndex = i;
    			break;
    		}
    	}
    	boolean startCountWeek = false;
    	boolean foundEndofWeek = false;
    	int weeks = 0;
    	for (int i = 0; i < monthNames.length ; i++) {
    		int daysLength = days[i];
    		if (monthNames[i].equalsIgnoreCase("February") && leapYear) {
    			daysLength = 29;
    		}
    		for (int j = 0; j < daysLength; j++){
    			if (currentDayIndex == 6) {
    				currentDayIndex = -1;
    			}
    			currentDayIndex++;
        		if (monthNames[i].equalsIgnoreCase(A) || monthNames[i].equalsIgnoreCase(B)) {
        			if (dayNames[currentDayIndex].equalsIgnoreCase("Monday")){
        				// now start counting weeks
        				if (startCountWeek && foundEndofWeek) {
        					weeks++;
        					foundEndofWeek = false;
        				}
        				startCountWeek = true;
        			}
        			if (startCountWeek && dayNames[currentDayIndex].equalsIgnoreCase("Sunday")) {
        				foundEndofWeek = true;
        			}
        			
        		}
    		}

    	}    	
    	return weeks;
    }
	
	static int solution(String S) {
		int result = -1;
		// checking for empty or null string
		if (S == null || S.isEmpty() || S.trim().isEmpty()){
			return -1;
		}
		int N = S.length();
		int subStrValidity = -1;
		for (int i =0; i< N; i++){
			// validity of password
			subStrValidity = validPassword(S.substring(i));
			if (subStrValidity > 0) {
				// return as soon as password is valid
				return subStrValidity;
			}
		}
		return result;
	}
	
	private static int validPassword(String password) {
		boolean hasUpperCase = false;
		int N = password.length();
	    for (int i =0; i< password.length(); i++){
	    	// it is assumed that charcters are in assci format
	    	if (password.charAt(i) >= 65 && password.charAt(i) <= 90 ) {
	    		hasUpperCase = true;
	    	} else if (password.charAt(i) >= 48 && password.charAt(i) <= 57 ) {
	    		return -1;
	    	}
	    }
	    if (hasUpperCase) {
	    	return N;
	    }  	    
		return -1;
	}
	
    static int solution(int A[]) {
    	int n = A.length;
        if (n==0) return -1; 
        long sum = 0;
        int i; 
        for(i=0;i<n;i++) sum+=(long) A[i]; 

        long sum_left = 0;    
        for(i=0;i<n;i++) {
            long sum_right = sum - sum_left - (long) A[i];
            if (sum_left == sum_right) return i;
            sum_left += (long) A[i];
        } 
        return -1;    	
        
    }
    
}
