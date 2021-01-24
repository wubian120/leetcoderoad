package cn.bw.leetcode

object A144二叉树的前序遍历1 {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def preorderTraversal(root: TreeNode): List[Int] = {

    var res = List[Int]()
    if(root == null){
      return List[Int]()
    }

    res = res:::List[Int](root.value)
    res = res:::preorderTraversal(root.left)
    res = res:::preorderTraversal(root.right)
    res
  }

}
