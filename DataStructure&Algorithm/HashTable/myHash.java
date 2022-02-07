public class myHash {

	public static void main(String[] args) {

		//myHashChaining 예제
		myHashChaining mainObject = new myHashChaining(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.getData("fun-coding");
		
		
		//myHashLinear 예제
		myHashLinear mainObject2 = new myHashLinear(20);
		mainObject2.saveData("DaveLee", "01022223333");
		mainObject2.saveData("fun-coding", "01033334444");
		mainObject2.saveData("David", "01044445555");
		mainObject2.saveData("Dave", "01055556666");
		mainObject2.getData("fun-coding");
		
	}

}
