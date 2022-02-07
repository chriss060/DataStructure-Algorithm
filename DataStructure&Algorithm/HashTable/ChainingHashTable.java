public class myHashChaining {

public Slot[] hashTable;
    
    public myHashChaining(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String key;
        String value;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            //맨앞의 슬롯으로 findSlot, prevSlot 초기화
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    //기존에 key에 해당하는 슬롯이 차있는 경우 : new value로 업데이트
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }
    
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }
}
