package BinarySearch;

import java.util.Collections;
import java.util.ArrayList;

public class BinarySearch {
	
	public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
		
		if (dataList.size()==1 && dataList.get(0)== searchItem) {
			return true;
		}
		
		if (dataList.size()==1 && dataList.get(0)!= searchItem) {
			return false;
		}
		
		int medium = dataList.size()/2;
		
		if(dataList.get(medium)== searchItem) {
			return true;
		}else {
			if(dataList.get(medium)>searchItem) {
				return this.searchFunc(new ArrayList<Integer>(dataList.subList(0,medium)), searchItem);
			}else {
				return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
			}
		}
	}

	public static void main(String[] args) {

		// 테스트 데이터 10개 준비 
		ArrayList<Integer> testData = new ArrayList<Integer>();

		for (int index = 0; index < 10; index++) {
		    testData.add((int)(Math.random() * 100));
		}

		Collections.sort(testData);
		System.out.println("Test Data: "+testData);
		
		// 이진 탐색 시작 
		BinarySearch bSearch = new BinarySearch();
		bSearch.searchFunc(testData, 2);
	}

}
