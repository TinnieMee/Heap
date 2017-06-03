public class Heap{
	private int size;
	private int currentSize;
	
	public Heap(int size){
		this.size = size;
		currentSize = 0;
	}
	
	public void maxInsert(int[] inputArray, int data){
		inputArray[inputArray.length-1] = data;
		maxSort(inputArray);
	}
	
	public void minInsert(int[] inputArray, int data){
		inputArray[inputArray.length-1] = data;
		minSort(inputArray);
	}
	
	public void maxSort(int[] inputArray){
		currentSize = inputArray.length;
		heapify(inputArray);
		for (int i=size; i > 0 ; i --){
			swap(inputArray, 0, i);
			size = size-1;
			maxHeap(inputArray, 0);
		}
	}
	
	public void minSort(int[] inputArray){
		currentSize = inputArray.length;
		heapifyMin(inputArray);
		for (int i = size ; i>0 ; i--){
			swap(inputArray, 0, i);
			size = size -1;
			minHeap(inputArray, 0);
		}
	}
	
	public void heapifyMin(int[] inputArray){
		size = inputArray.length -1;
		for (int i = size/2; i>=0 ; i--){
			minHeap(inputArray, i);
		}
	}
	
	public void heapify(int[] inputArray){
		size = inputArray.length - 1;
		for(int i = size/2 ; i>=0; i--){
			maxHeap(inputArray, i);
		}
	}
	
	public void minHeap(int[] inputArray, int i){
		int left = 2*i;
		int right = 2*i+1;
		int min = i;
		
		if (left<=size && inputArray[left] < inputArray[i]){
			min = left;
		}
		
		if (right <= size && inputArray[right] < inputArray[min]){
			min = right;
		}
		
		if (min!=i){
			swap(inputArray, i, min);
			minHeap(inputArray, min);
		}
	}
	
	public void maxHeap(int[] inputArray, int i){
		int left = 2*i;
		int right = 2*i+1;
		int max = i;
		
		if (left<=size && inputArray[left] > inputArray[i]){
			max = left;
		}
		
		if (right <= size && inputArray[right] > inputArray[max]){
			max = right;
		}
		
		if (max != i){
			swap(inputArray, i, max);
			maxHeap(inputArray, max);
		}
	}
	
	public void swap(int[] inputArray, int i, int j){
		int temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}
	
	public void delete(int[] inputArray){
		
		int temp[] = new int[inputArray.length-1];
		inputArray[0] = inputArray[inputArray.length-1];
		System.arraycopy(inputArray, 0, temp, 0, inputArray.length-1);
		size = inputArray.length-1;
		inputArray = temp;
	}
	
	public void show(int[] inputArray){
		size = inputArray.length - 1;
		int left, right;
		for(int i = size/2 ; i>=0; i--){
			left = 2*i;
			right = 2*i+1;
			System.out.println("Root: " + inputArray[i]);
			
			if (left < inputArray.length){
				System.out.println("Left: " + inputArray[left]);
			}
			
			if (right < inputArray.length){
				System.out.println("Right: " + inputArray[right]);
			}
			
		}
	}
}