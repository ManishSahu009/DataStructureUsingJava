package org.ms.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Node<T> {
      T data;
      Node left;
      Node right;

      public Node(T data) {
            this.data = data;
      }
}
