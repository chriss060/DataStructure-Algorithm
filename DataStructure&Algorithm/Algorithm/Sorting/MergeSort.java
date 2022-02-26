package MergeSort;

import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {

	//분리한 데이터를 단계별로 합치는 mergeFunc 
	public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
		
		int leftPoint=0; int rightPoint=0;
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		
		//Case 1: left, right 배열 모두 있을 때
		while(leftList.size()>leftPoint && rightList.size()>rightPoint) {
			if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
				mergedList.add(rightList.get(rightPoint));
				rightPoint+=1;
				
			}else {
				mergedList.add(leftList.get(leftPoint));
				leftPoint+=1;
			}
		}
		//Case 2: rightlist 가 없을 때 
		while(leftList.size()>leftPoint) {
			mergedList.add(leftList.get(leftPoint));
			leftPoint+=1;
		}
		
		//Case 3: leftlist 가 없을 때 
		while(rightList.size()>rightPoint) {
			mergedList.add(rightList.get(rightPoint));
			rightPoint+=1;
			
		}
		return mergedList;
	}
	
	//데이터를 2개의 리스트로 분리하는 mergeSplitFunc
	public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
		
		  if (dataList.size() <= 1) {
	            return dataList;
	        }
	        int medium = dataList.size() / 2;  

	        ArrayList<Integer> leftArr = new ArrayList<Integer>();
	        ArrayList<Integer> rightArr = new ArrayList<Integer>();

	        leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium))); 
	        rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size()))); 

	        return this.mergeFunc(leftArr, rightArr);
	}
	
	
	
	public static void main(String[] args) {
		
		//테스트 데이터 생성 
		ArrayList<Integer> testData = new ArrayList<Integer>();

		for (int index = 0; index < 10; index++) {
		    testData.add((int)(Math.random() * 100));
		}
		System.out.println("Test Data: "+ testData);

		//mergeSort 수행
		MergeSort mSort = new MergeSort();
		
		System.out.println("Merge Sort: "+ mSort.mergeSplitFunc(testData));
	}

}
