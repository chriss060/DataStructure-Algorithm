package SelectionSort;

import java.util.ArrayList;
import java.util.Collections;


public class SelectionSort {

	public ArrayList<Integer> selectionSort(ArrayList<Integer> dataList){
		
		int lowest;
		
		for(int stand=0; stand<dataList.size()-1; stand++) {
			
			lowest = stand; 
			
			for( int index=stand+1 ; index<dataList.size(); index++) {
				
				if(dataList.get(lowest)> dataList.get(index) ){
					lowest = index;
				}
				
			}
			Collections.swap(dataList, lowest, stand);
		}
		return dataList;
	}
	
	
	public static void main(String[] args) {

		//테스트 데이터 준비 
		ArrayList<Integer> testData = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
		    testData.add((int)(Math.random() * 100));
		}
		//테스트 데이터 출력
		System.out.println("Test data: "+ testData);
		
		//선택정렬 
		SelectionSort sSort = new SelectionSort();
		sSort.selectionSort(testData);
		
		System.out.println("Selection Sort: "+ testData);
	}

}
