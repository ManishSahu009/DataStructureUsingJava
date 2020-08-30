package org.ms.ds.binarytree;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"left","right","horizontalDistance"})
public class TreeNode<T> {
      public T data;
      public Integer horizontalDistance=0;
      public TreeNode<T> left;
      public TreeNode<T> right;

      public TreeNode(T data) {
            this.data = data;
      }

      public T getData() {
            return data;
      }

      public void setData(T data) {
            this.data = data;
      }

      public TreeNode<T> getLeft() {
            return left;
      }

      public void setLeft(TreeNode<T> left) {
            this.left = left;
      }

      public TreeNode<T> getRight() {
            return right;
      }

      public void setRight(TreeNode<T> right) {
            this.right = right;
      }
}
