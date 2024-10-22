
public class QuickSort {

	public static void main(String args[]) {
		
		int arr[] = {13,21,-21,29,31,11,12,9,-13,4,2,77,88,8};
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+", ");
		}
		quickSort(arr,0,arr.length);
		System.out.println();
		System.out.println("Quick Sort");
		System.out.println();
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+", ");
		}
	}
	
	public static void quickSort(int arr[],int start,int end) {
		if((end-start)<2)return;
		int pivotIndex = partition(arr,start,end);
		quickSort(arr,start,pivotIndex);
		quickSort(arr,pivotIndex+1,end);
	}
	
	public static int partition(int arr[],int start,int end){
		int pivot = arr[start];
		int i= start;
		int j= end;
		while(i<j) {
			while(i<j && arr[--j]>=pivot);
			if(i<j) {
			arr[i]=arr[j];
			}
			
			while(i<j && arr[++i]<=pivot);
			if(i<j) {
				arr[j]=arr[i];
				}
		}
		arr[j]=pivot;
		return j;
	}
}
