package exam.stockmanager;

public class BinarySearchTreeStorage<E>
		extends BinarySearchTree<E> {

	public int updateStock(Object o, int num) {

		return updateUsingComparable(o, num);
	}

	private int updateUsingComparable(
			Object o,
			int num) {

		@SuppressWarnings("unchecked")
		Comparable<? super E> value =
				(Comparable<? super E>) o;

		Node<E> node = super.getRoot();

		while (node != null) {

			int res =
					value.compareTo(node.value);

			if (res < 0) {

				node = node.left;

			} else if (res > 0) {

				node = node.right;

			} else {

				Product prd =
						(Product) node.value;

				int tmpStock =
						prd.getProduct(num);

				if (tmpStock == 0) {

					return 0;

				} else if (tmpStock == -1) {

					return -1;

				} else {

					@SuppressWarnings("unchecked")
					E tmpValue = (E) prd;

					node.value = tmpValue;

					return 1;
				}
			}
		}

		return -2;
	}
}