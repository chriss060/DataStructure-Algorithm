package SequentialSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class SequentialSearch {

	public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {

		for (int index = 0; index < dataList.size(); index++) {
			if (dataList.get(index) == searchItem) {
				return index;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// 임의 데이터 10개 생성
		ArrayList<Integer> testData = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testData.add((int) (Math.random() * 100));
		}
		System.out.println("Test Data: "+testData);
		Scanner scan = new Scanner(System.in);

		System.out.println("찾으려는 값을 입력하세요: ");
		Integer searchItem = scan.nextInt();

		SequentialSearch sSearch = new SequentialSearch();

		if (sSearch.searchFunc(testData, searchItem) != -1) {
			System.out.println("찾으려는 데이터의 인덱스: " + sSearch.searchFunc(testData, searchItem));
		} else {
			System.out.println("찾으려는 데이터가 해당 리스트에 없습니다.");
		}

	}

}
