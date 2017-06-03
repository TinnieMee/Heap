import java.util.*;

public class HeapMain{
	
	public static int maxSize, data;
	Node node, root = null, current;
	static Heap heap;
	static int[] inputArray;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		char choice2;
		
		
		System.out.println("Start with [0/n]: ");
		maxSize = input.nextInt();
		
		heap = new Heap(maxSize);
		inputArray = new int[maxSize];
		
		System.out.println("Input Array of size n: ");
		for (int i = 0 ; i<maxSize; i++){
			data = input.nextInt();
			inputArray[i] = data;
		}
		
		System.out.println("Choose heap order[ ma(x) / mi(n) ]: " );
		char choice = input.next().charAt(0);
		
		if (choice == 'n' || choice == 'N'){
			System.out.println("Min heap order selected... Heapifying... done...");
			heap.maxSort(inputArray);
			
			
			System.out.println("Resulting Min Heap:");
			
			for (int i = 0; i<maxSize; i++){
				System.out.println(inputArray[i]);
			}
			
			heap.show(inputArray);
			
			do{
				System.out.println("Choose operation [(D)elete / (I)nsert / (E)xit]:");
				choice2 = input.next().charAt(0);
				
				if (choice2 == 'D' || choice2 == 'd'){
					
					if (maxSize <=0){
						System.out.println("Array is empty...");
					}
					
					else{
						heap.delete(inputArray);
						maxSize--;
						heap.maxSort(inputArray);
						
						System.out.println("Deleting... Done...");
						for (int i = 0; i<maxSize; i++){
							System.out.println(inputArray[i]);
						}
					}
				}
				
				else if (choice2 == 'I' || choice2 == 'i'){
					
					System.out.println("Input value to insert: ");
					int insertNum = input.nextInt();
					
					if (maxSize <= 0){
						maxSize++;
						inputArray = new int[maxSize];
						inputArray[maxSize-1] = insertNum;
						heap = new Heap(maxSize);
						heap.maxInsert(inputArray, insertNum);
					}
					
					else{
						maxSize++;
						int[] temp = new int[maxSize];
						System.arraycopy(inputArray, 0, temp, 0, inputArray.length);
						
						inputArray = new int[maxSize];
						inputArray = temp;
						inputArray[maxSize-1] = insertNum;
						heap = new Heap(maxSize);
						heap.maxInsert(inputArray, insertNum);
					}
					
					
					System.out.println("Done inserting...");
					System.out.println("Resulting Min Heap:");
					
					for (int i = 0; i<maxSize; i++){
						System.out.println(inputArray[i]);
					}
				}
				
				else if (choice2 == 'E' || choice2 == 'e'){
					System.out.println("Exiting program...");
					System.exit(0);
				}
				
			}while (choice2!='E'||choice2!='e');
		}
		
		else if (choice == 'X' || choice == 'x'){
			System.out.println("Max heap order selected... Heapifying... done...");
			heap.minSort(inputArray);
			System.out.println("Resulting Max Heap:");
			
			for (int i = 0; i<maxSize; i++){
				System.out.println(inputArray[i]);
			}
			
			do{
				System.out.println("Choose operation [(D)elete / (I)nsert / (E)xit]:");
				choice2 = input.next().charAt(0);
				
				if (choice2 == 'D' || choice2 == 'd'){
					if (maxSize <=0){
						System.out.println("Array is empty...");
					}
					
					else{
						heap.delete(inputArray);
						maxSize--;
						heap.minSort(inputArray);
						
						System.out.println("Deleting... Done...");
						for (int i = 0; i<maxSize; i++){
							System.out.println(inputArray[i]);
						}
					}
				}
				
				else if (choice2 == 'I' || choice2 == 'i'){
					System.out.println("Input value to insert: ");
					int insertNum = input.nextInt();
					
					if (maxSize <= 0){
						maxSize++;
						inputArray = new int[maxSize];
						inputArray[maxSize-1] = insertNum;
						heap = new Heap(maxSize);
						heap.minInsert(inputArray, insertNum);
					}
					
					else{
						maxSize++;
						int[] temp = new int[maxSize];
						System.arraycopy(inputArray, 0, temp, 0, inputArray.length);
						
						inputArray = new int[maxSize];
						inputArray = temp;
						inputArray[maxSize-1] = insertNum;
						heap = new Heap(maxSize);
						heap.minInsert(inputArray, insertNum);
						
						System.out.println("Done inserting...");
						System.out.println("Resulting Max Heap:");
						for (int i = 0; i<maxSize; i++){
							System.out.println(inputArray[i]);
						}
					}
				}
				
				else if (choice2 == 'E' || choice2 == 'e'){
					System.out.println("Exiting program...");
					System.exit(0);
				}
				
			}while (choice2!='E'||choice2!='e');
		}
		
		else{
			System.out.println("Keyword invalid...");
			System.exit(0);
		}
	}
}