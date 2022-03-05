package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinProblem {

	public void coinFunc(Integer price, ArrayList<Integer> coinList) {
		Integer totalCoinCount = 0;
		Integer coinNum = 0;
		ArrayList<Integer> details = new ArrayList<Integer>();

		for (int index = 0; index < coinList.size(); index++) {
			coinNum = price / coinList.get(index);
			totalCoinCount += coinNum;
			price -= coinNum * coinList.get(index);
			details.add(coinNum);
			System.out.println(coinList.get(index) + "원: " + coinNum + "개");
		}
		System.out.println("총 동전 갯수: " + totalCoinCount);
	}

	public static void main(String[] args) {
		CoinProblem object = new CoinProblem();
		ArrayList<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1));
		object.coinFunc(4720, coinList);

	}

}
