import java.util.ArrayList;
import java.util.Collections;

public class Heap {

	public ArrayList<Integer> heapArray = null;

	public Heap(Integer data) {

		heapArray = new ArrayList<Integer>();
		heapArray.add(null);
		heapArray.add(data);
	}

	// insert 함수에 사용할 move_up 함수
	public boolean move_up(Integer inserted_idx) {
		if (inserted_idx <= 1) {
			return false;
		}
		Integer parent_idx = inserted_idx;
		if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
			return true;
		} else {
			return false;
		}
	}

	// insert 함수
	public boolean insert(Integer data) {
		Integer inserted_idx, parent_idx;

		if (heapArray == null) {
			heapArray = new ArrayList<Integer>();

			heapArray.add(null);
			heapArray.add(data);
			return true;
		}

		this.heapArray.add(data);
		inserted_idx = this.heapArray.size() - 1;

		while (this.move_up(inserted_idx)) {
			parent_idx = inserted_idx / 2;
			Collections.swap(this.heapArray, inserted_idx, parent_idx);
			inserted_idx = parent_idx;
		}
		return true;
	}

	// move_down 메소드
	public boolean move_down(Integer popped_idx) {

		Integer left_child_popped_idx, right_child_popped_idx;

		left_child_popped_idx = popped_idx * 2;
		right_child_popped_idx = popped_idx * 2 + 1;

		// case 1 : 왼 자식노드도 없을때
		if (left_child_popped_idx >= this.heapArray.size()) {
			return false;
		} else if (right_child_popped_idx >= this.heapArray.size()) {
			return true;
		} else {
			return false;
		}

	}

	// 데이터 삭제 pop 메소
	public Integer pop() {
		Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

		if (this.heapArray == null) {
			return null;
		} else {
			returned_data = this.heapArray.get(1);
			this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
			this.heapArray.remove(this.heapArray.size() - 1);
			popped_idx = 1;
		}

		while (this.move_down(popped_idx)) {
			left_child_popped_idx = popped_idx * 2;
			right_child_popped_idx = popped_idx * 2 + 1;

			// case 2 : 오른쪽 자식노드만 있을때
			if (right_child_popped_idx >= this.heapArray.size()) {
				if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
					Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
					popped_idx = left_child_popped_idx;
				}
			} else {
				// case 3 : 왼쪽, 오른쪽 자식노드가 모두 있을때
				if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
					if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
						Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
						popped_idx = left_child_popped_idx;
					}
				} else {
					if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
						Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
						popped_idx = right_child_popped_idx;
					}
				}

			}

		}
		return returned_data;

	}

}
