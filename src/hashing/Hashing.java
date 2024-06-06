package hashing;

import java.util.*;

class Hashing { 
    private int[] hash_table = new int[10];

    Hashing(){ 
	for(int j=0; j<10; j++) 
	    hash_table[j] = -1;
    } 

    public void display() {
	System.out.print("Table: ");
	
	//add code here
	System.out.print("Table: ");
    for (int j = 0; j < 10; j++) {
        if (hash_table[j] != -1) {
            System.out.print(hash_table[j] + " ");
        } else {
            System.out.print("* ");
        }
    }
    System.out.println();
   }
   
   public void insert(int key)  { 

	//add code here
	   int index = key % 10; // Compute hash
       
       while (hash_table[index] != -1) {
           index = (index + 1) % 10; // Linear probing
       }
       
       hash_table[index] = key; // Insert key

   } 
   
   public static void main(String[] args) { 
        Hashing hashtab = new Hashing(); 
        String msg = "";
        int num=0,  i = 0;
        Scanner input = new Scanner(System.in);

        for(i=0; i<7; i++) {
            msg = input.nextLine();
            num = Integer.parseInt(msg);
            hashtab.insert(num);
        }
        hashtab.display(); 
    }
}
