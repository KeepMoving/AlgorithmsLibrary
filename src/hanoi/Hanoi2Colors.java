package hanoi;

public class Hanoi2Colors {
	 public static void help() {
	        System.out.println("Usage: java Hanoi2Colors number_of_disks");
	        System.out.println("\t number_of_disks: must be a even number.");
	        System.exit(0);
	    }
	    
	    public static void main(String[] args) {
	        int disks = 0;        
	        try {
	            disks = Integer.parseInt(args[0]);
	        } catch (Exception e) {
	            help();
	        }
	        if ((disks <= 0) || (disks % 2 != 0)) { 
	            help(); 
	        }
	        hanoi2colors(disks);
	    }
	     
	    public static void hanoi(int disks,char source, char temp, char target) {
	        if (disks == 1) {
	            System.out.println("move disk from " 
	                               + source + " to " + target);
	            System.out.println("move disk from " 
	                               + source + " to " + target);
	        } else {        
	            hanoi(disks-1, source, target, temp);
	            hanoi(1, source, temp, target);
	            hanoi(disks-1, temp, source, target);
	        }
	    }
	 
	    public static void hanoi2colors(int disks) {
	        char source = 'A';
	        char temp = 'B';
	        char target = 'C';
	        for (int i = disks / 2; i > 1; i--) {
	            hanoi(i-1, source, temp, target);
	            System.out.println("move disk from " 
	                                   + source + " to " + temp);
	            System.out.println("move disk from " 
	                                   + source + " to " + temp); 
	            hanoi(i-1, target, temp, source);
	            System.out.println("move disk from " 
	                                   + temp + " to " + target);
	        }
	        System.out.println("move disk from " 
	                                   + source + " to " + temp);
	        System.out.println("move disk from " 
	                                 + source + " to " + target);
	    }
}
