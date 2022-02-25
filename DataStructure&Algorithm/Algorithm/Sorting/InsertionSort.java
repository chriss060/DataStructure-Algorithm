package InsertionSort;

import java.util.ArrayList;
import java.util.Collections;


public class InsertionSort {
	
	public ArrayList<Integer> insertionSort( ArrayList<Integer> dataList){
		
		for(int index=0; index<dataList.size()-1; index++) {
			//삽입정렬은 두번째 데이터 부터 시작 index2 = index+1
			for(int index2=index+1; index2>0 ; index2-- ) {
				if(dataList.get(index2)< dataList.get(index2-1)) {
					Collections.swap(dataList, index2, index2-1);
				}else {
					break;
				}
			}
		}
		
		return dataList;
	}

	public static void main(String[] args) {
	
		//테스트데이터 준비 
		ArrayList<Integer> testData = new ArrayList<Integer>();

		for (int index = 0; index < 10; index++) {
		    testData.add((int)(Math.random() * 100));
		}
		
		System.out.println("Test data: "+ testData);
		
		//삽입정렬 
		InsertionSort iSort = new InsertionSort();
		iSort.insertionSort(testData);
		System.out.println("Insertion sort: "+ testData);

	}

}
