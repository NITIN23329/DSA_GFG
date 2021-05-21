package avlTree;


class AVLNode{
    int data;
    int height;
    AVLNode left;
    AVLNode right;
    AVLNode leftParent;
    AVLNode rightParent;
    public AVLNode(int data  ,AVLNode leftParent, AVLNode rightParent){
        this.data = data;
        this.height = 0;
        this.leftParent = leftParent;
        this.rightParent = rightParent;
    }
}

public class AVLTreeInsertion {
    public static void main(String[] args){
        insert(root,10);
        insert(root,20);
        insert(root,30);
        preOrder(root);
        insert(root,40);
//        insert(root,50);
//        insert(root,60);
//        insert(root,70);
        preOrder(root);

    }
    public static void preOrder(AVLNode iter){
        if(iter==null)return;
        System.out.println(iter.data +" "+iter.height);
        preOrder(iter.left);
        preOrder(iter.right);
    }
    static AVLNode root;
    public static  void insert(AVLNode iter , int data){
        if(iter==null){
            root = new AVLNode(data , null , null);
           return ;
        }
        if(data==iter.data)return;
        if(iter.data<data && iter.right!=null){
           int leftHeight ;
           if(iter.left==null)leftHeight=0;
           else leftHeight = iter.left.height;
           int rightHeight = iter.right.height;
           iter.height = Math.max(leftHeight,rightHeight)+2;
            System.out.println(iter.data+" a "+iter.height);
            insert(iter.right , data );
            return;
        }
        else if (iter.data>data && iter.left!=null)  {
            int leftHeight = iter.left.height;
            int rightHeight;
            if(iter.right==null)rightHeight = 0;
            else rightHeight = iter.right.height;
            iter.height = Math.max(leftHeight,rightHeight)+2;
            System.out.println(iter.data+" a "+iter.height);
            insert(iter.left , data);
            return;
        }
        else if(iter.data<data){
            iter.right = new AVLNode(data ,iter , null);
            iter.height++;
            iter = iter.right;

        }
        else{
            iter.left = new AVLNode(data ,null,iter);
            iter.height++;
            iter = iter.left;

        }
        checkForRotation(iter);
    }
    public static void checkForRotation(AVLNode iter ){
        StringBuilder str = new StringBuilder();
        int count = 0;
       while (true){

            if( str.length()>1 && iter.height>1){
                String random = ""+str.charAt(str.length()-2)+str.charAt(str.length()-1);
                if(random.contentEquals("RR")){
                    leftHelper(iter);

                }
                else if(random.contentEquals("LL")){
                   rightHelper(iter);

                }
                else if(random.contentEquals("RL")){
                    AVLNode head = rightRotation(iter.right);
                    iter.right = head;
                    head.leftParent = iter;
                    iter.right.height++;
                    iter.right.right.height--;
                    leftHelper(iter);

                }
                else{
                    AVLNode head = leftRotation(iter.left);
                    iter.left=head;
                    head.rightParent=iter;
                    iter.left.height++;
                    iter.left.leftParent.height--;
                    rightHelper(iter);
                }


                return;
            }
            if(iter.rightParent!=null){
                str.append("L");
                iter = iter.rightParent;
            }
            else if(iter.leftParent!=null){
                str.append("R");
                iter = iter.leftParent;
            }
           if(count>=1)return;
           if(iter.rightParent==null && iter.leftParent==null)count++;
        }
    }
    private static void leftHelper(AVLNode iter){
        if(iter == root)
            root = leftRotation(iter);
        else if(iter.leftParent!=null){
            AVLNode head =leftRotation(iter);
            iter.leftParent.right = head;
            head.leftParent = iter;
        }
        else{
            AVLNode head = leftRotation(iter);
            iter.rightParent.left = head;
            head.rightParent = iter;
        }
        if(iter==root)iter.height--;
        iter.height-=1;

    }
    private static void rightHelper(AVLNode iter){
        if(iter==root)
            root = rightRotation(iter);
        else if(iter.leftParent!=null){
            AVLNode head= rightRotation(iter);
            iter.leftParent.right = head;
            head.leftParent = iter;
        }
        else{
            AVLNode head = rightRotation(iter);
            iter.rightParent.left = head;
            head.rightParent = iter;
        }
        if(iter==root)iter.height--;
        iter.height-=1;
    }
    private static AVLNode leftRotation(AVLNode iter) {
        AVLNode head = iter.right;
        iter.right = null;
        head.leftParent=null;
        AVLNode left = head.left;
        head.left = iter;
        iter.rightParent = head;
        iter.leftParent=null;
        iter.right = left;
        if(left!=null){
            left.leftParent =  iter;
            left.rightParent = null;
        }

        return head;
    }
    private static AVLNode rightRotation(AVLNode iter){
        AVLNode head = iter.left;
        iter.left = null;
        head.rightParent = null;
        AVLNode right = head.right;
        head.right = iter;
        iter.leftParent = head;
        iter.rightParent = null;
        iter.left = right;
        if(right!=null){
            right.rightParent = iter;
            right.leftParent = null;
        }

        return head;
    }


 
}
