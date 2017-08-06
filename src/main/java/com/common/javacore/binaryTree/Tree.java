package com.common.javacore.binaryTree;

/**
 * Created by Administrator on 2017/8/6.
 */
public class Tree {

    private Node root;  //根节点

    /**
     * Description 构造方法*/
    public Tree() {}

    /**
     * Description 构造方法
     * @param root 跟节点
     */
    public Tree(Node root) {
        this.root = root;
    }

    /**
     * Description  插入节点
     * @param key
     * @param value
     */
    public void insert(int key, Object value) {
        Node node = new Node(key, value);

        if (this.root == null) {
            //若根节点为空，则该节点作为根节点
            this.root = node;
        }else{
            //若根节点不为空，则进行判断是left分支还是right分支
            Node currentNode = this.root;
            while(true){
                //若大于根节点则为在右分支
                if (key > currentNode.key) {
                    if (currentNode.rightChildNode == null) {
                        //若右分支为空，则将插入节点放在右分支
                        currentNode.rightChildNode = node;
                        return;
                    } else {
                        //否则，说明右分支存在节点，需要再下沉一层，知道找到合适的位置插入为止。
                        currentNode = currentNode.rightChildNode;
                    }
                }else{
                    if(currentNode.leftChildNode == null){
                        currentNode.leftChildNode = node;
                        return;
                    } else {
                       currentNode = currentNode.leftChildNode;
                    }
                }
            }
        }
    }

    /**
     * Description 查找节点
     * @param  key  节点key
     * @return node 结果节点
     */
    public Node findNode(int key){
        if(this.root == null){
            return null;
        }
        Node currentNode = this.root;
        while(currentNode.key != key) {
            if(key > currentNode.key){
                currentNode = currentNode.rightChildNode;
            }else {
                currentNode = currentNode.leftChildNode;
            }

            //若找到的树为空，说明不存在树。
            if(currentNode == null){
                return  null;
            }
        }
        return currentNode;
    }
}