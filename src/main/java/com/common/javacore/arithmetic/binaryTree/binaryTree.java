package com.common.javacore.arithmetic.binaryTree;

/**
 * Description  二叉树遍历
 * Created by Administrator on 2017/8/6.
 */
public class binaryTree {


    public static void main(String[] args){
        /* 构造一棵树
                    50
                  20   540
                4
              0  8
         */
        Node root = new Node(50, 24);
        Tree tree = new Tree(root);
        tree.insert(20, 530);
        tree.insert(540, 520);
        tree.insert(4, 540);
        tree.insert(0, 550);
        tree.insert(8, 520);


        //前序遍历这棵树   预期50 20 4 0 8 540
        TREE_NO = 0;
        preOrderTraverse(root, TREE_NO);
/*
        System.out.println("中序遍历  begin!");
        //中序遍历这棵树  预期 0 4 8 20 50 540
        TREE_NO = 0;
        inorderTraverse(root, TREE_NO);
        System.out.println("中序遍历  end!");

        //后序遍历这棵树   预期0 8 4 20 540 50
        TREE_NO = 0;
        postOrderTraverse(root, TREE_NO);
        */


    }


    /** 树的层级 root = 0 */
    public static int TREE_NO = 0;

    /**
     * Description 前序遍历
     * @param node
     */
    public static void preOrderTraverse(Node node, int TREE_NO){
        if(node == null){
            return;
        }
        System.out.println("第"+ TREE_NO +"层"+ node.key + ":" + node.value);
        preOrderTraverse(node.leftChildNode, TREE_NO + 1);
        preOrderTraverse(node.rightChildNode, TREE_NO + 1);

    }

    /**
     * Description 中序遍历
     * @param  node 要查找的节点(首次入参为根节点)
     * @param  TREE_NO 树的层级
     */
    public static void inorderTraverse(Node node, int TREE_NO){
        if(node == null){
            return;
        }
        inorderTraverse(node.leftChildNode, TREE_NO + 1);
        System.out.println("第"+ TREE_NO +"层"+ node.key + ":" + node.value);
        inorderTraverse(node.rightChildNode, TREE_NO + 1);
    }


    /**
     * Description 后序遍历
     * @param node
     */
    public static void postOrderTraverse(Node node, int TREE_NO){
        if(node == null){
            return;
        }
        postOrderTraverse(node.leftChildNode, TREE_NO + 1);
        postOrderTraverse(node.rightChildNode, TREE_NO + 1);
        System.out.println("第"+ TREE_NO +"层"+ node.key + ":" + node.value);
    }
}
