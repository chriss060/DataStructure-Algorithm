package QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
	
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		
		if(dataList.size()<=1) {
			return dataList;
		}
		int pivot = dataList.get(0);
		
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		for(int index=1; index<dataList.size(); index++) {
			if(dataList.get(index)>pivot) {
				rightArr.add(dataList.get(index));
			}else {
				leftArr.add(dataList.get(index));
			}
		}
		ArrayList<Integer> mergedArr = new ArrayList<Integer>();
		mergedArr.addAll(this.sort(leftArr));
		mergedArr.addAll(Arrays.asList(pivot));
		mergedArr.addAll(this.sort(rightArr));
		
		return mergedArr;
	}

	public static void main(String[] args) {
		
		
		ArrayList<Integer> testData = new ArrayList<Integer>();

		//테스트 데이터 생성 
		for (int index = 0; index < 10; index++) {
		    testData.add((int)(Math.random() * 100));
		}
		System.out.println("Test Data: "+testData);

		//퀵 정렬 
		QuickSort qSort = new QuickSort();
		System.out.println("Quick Sort: "+qSort.sort(testData));

	}

}
