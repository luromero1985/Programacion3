package tp2;

public class TreeNode {

		private Integer value;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(Integer value) { //es integer porque necesito que sea un objeto para poder hacerlo null
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		public TreeNode getLeft() {
			return left;
		}
		
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		
		public TreeNode getRight() {
			return right;
		}
		
		public void setRight(TreeNode right) {
			this.right = right;
		}
		
		public Integer getValue() {
			return value;
		}
		
		public void setValue(Integer value) {
			this.value=value;
		}
		
		
		
	}


