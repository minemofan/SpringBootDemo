package com.common.javacore.arithmetic.binaryTree;

/**
 * Decription 二叉树算法
 * Created by Administrator on 2017/8/17.
 */
public class TreeTest {
    /**
     * 构造一棵树
     *               10
     *         5            12
     *      3     8        11    14
     *   2   4  6   9          13   15
     * 1          7
     * Node(二叉树序列，实际存储数据)
     */
    public static Node rootNode = new Node(10, 1010);

    public static Tree tree = new Tree(rootNode){
        {
            insert(5, 55);
            insert(3, 33);
            insert(8, 88);
            insert(2, 22);
            insert(4, 44);
            insert(6, 66);
            insert(9, 99);
            insert(1, 11);
            insert(7, 77);

            insert(12, 1212);
            insert(11, 1111);
            insert(14, 1414);
            insert(13, 1313);
            insert(15, 1515);
        }
    };

    /**
     * Description
     * @param args
     */
    public static void main(String[] args) {
        /*
        Node fnode = rootNode;
        while (true){
            System.out.println(fnode.key);
            fnode = fnode.rightChildNode;
            if(fnode == null){
                break;
            }
        }*/


/*
        System.out.println(tree);
        System.out.println("前序遍历");
        binaryTree.preOrderTraverse(rootNode, 0);

        System.out.println("中序遍历");
        binaryTree.inorderTraverse(rootNode, 0);

        System.out.println("后序遍历");
        binaryTree.postOrderTraverse(rootNode, 0);


*/
/*
        //测试根节点为最近父结点, 预测10
        Node node1 = new Node(1, 11);
        Node node2 = new Node(12, 1212);

        Node fnode = TreeTest.findSuperTwoNode(rootNode, node1 ,node2);
        System.out.println("-------------------"+ fnode.key);
*/
        //平衡树，预测结果 14
        Node node1 = new Node(13, 1313);
        Node node2 = new Node(15, 1515);

        Node fnode = TreeTest.findSuperTwoNode(rootNode, node1 ,node2);
        System.out.println("-------------------"+ fnode.key);
/*
        //不平衡树：测试同为左树，但不同分支 ；预测结果3
        node1 = new Node(1, 11);
        node2 = new Node(4, 44);

        fnode = TreeTest.findSuperTwoNode(rootNode, node1 ,node2);
        System.out.println("-------------------"+ fnode.key);
*/
/*
        //不平衡树：测试同为左树，且同一侧；预测结果null
        node1 = new Node(1, 11);
        node2 = new Node(2, 22);
*/
       // fnode = TreeTest.findSuperTwoNode(rootNode, node1 ,node2);
      //  System.out.println(fnode.key);

    }


    public static Node findSuperTwoNode(Node rootNode, Node node1, Node node2){
        //根节点没有左右树
        if(rootNode.leftChildNode == null || rootNode.rightChildNode == null){
            return null;
        }

        Node fnode = rootNode;

        boolean flag = true;
        while(flag){
            System.out.println("当前父节点："+ fnode.key
                    + ",node1:"+ node1.key +",node2:"+ node2.key);

            //首次：若在根节点两侧，则最近的父节点为根节点
            //判断两个节点是否在当前节点左右两侧
            if(node1.key < fnode.key && node2.key > fnode.key){
                flag = false;
                continue;
            }

            //判断两个节点是在当前父节点的左树、还是右树
            //若两个节点都比父节点-右树小则均为左树，否则为右树
            if(fnode.leftChildNode != null
                    && node1.key <= fnode.leftChildNode.key
                    && node2.key <= fnode.leftChildNode.key){
                System.out.println("》》当前父节点："+ fnode.key
                        + ",node1:"+ node1.key +",node2:"+ node2.key
                        + ",left:"+ fnode.leftChildNode.key);

                fnode = fnode.leftChildNode;




            }else if(fnode.rightChildNode != null
                    && node1.key <= fnode.rightChildNode.key
                    && node2.key <= fnode.rightChildNode.key){
                System.out.println("》》当前父节点："+ fnode.key
                        + ",node1:"+ node1.key +",node2:"+ node2.key
                        + ",left:"+ fnode.rightChildNode.key);

                fnode = fnode.rightChildNode;
            }
        }
        return null;
    }




}
