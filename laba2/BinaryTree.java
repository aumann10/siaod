import java.lang. *;

public class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;
    BinaryTree parent = null;

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(int value) {
        this.value = value;
    }
    public BinaryTree(int value, BinaryTree parent) {
        this.value = value;
        this.parent = parent;
    }

    public int sum() {
        int summ = value;

        if (left != null) {
            summ += left.sum();
        }
        if (right != null) {
            summ += right.sum();
        }
        return summ;
    }

    public int B_search(int num){
        if(num == value)
            return 1;

        if(num < value){
            if(left == null)
                return -1;
            return left.B_search(num);
        }
        else{
            if(right == null)
                return -1;
            return right.B_search(num);
        }
    }

    public int add(int num){
        if(num == value)
            return -1;

        if(num < value){
            if(left == null){
                left = new BinaryTree(num, this);
                return 1;
            }
            return left.add(num);
        }
        else{
            if(right == null){
                right = new BinaryTree(num, this);
                return 1;
            }
            return right.add(num);
        }
    }

    public int remove_min(){
        if(left == null){
            int a = value;
            remove(value);
            return a;
        }
        return left.remove_min();
    }

    public int remove_max(){
        if(right == null){
            int a = value;
            remove(value);
            return a;
        }
        return right.remove_max();
    }


    public void remove(int num){
        if(num < value){
            if(left != null)
                left.remove(num);
        }
        else if(num > value){
            if(right != null)
                right.remove(num);
        }
        else{
            if(parent != null){
                if(parent.left != null){
                    if(parent.left.value == num){
                        //???????? ?????????????? ???????????????? ?????????? ???????????? ????????????????
                        if(left == null && right == null){
                            parent.left = null;
                        }
                        //???????? ???????? ?????????? ??????????????????
                        else if(left != null && right == null){
                            parent.left = left;
                        }
                        else if(left == null && right != null){
                            parent.left = right;
                        }
                        else if(parent.left.left != null && parent.left.right != null){
                            value = right.remove_min();
                        }
                    }
                }
                if(parent.right != null){
                    if(parent.right.value == num){
                        //???????? ?????????????? ???????????????? ???????????? ???????????? ????????????????
                        if(left == null && right == null){
                            System.out.println("I'm here ");
                            parent.right = null;
                        }
                        else if(left != null && right == null){
                            parent.right = left;
                        }
                        else if(left == null && right != null){
                            parent.right = right;
                        }
                        else if(left != null && right != null){
                            value = right.remove_min();
                        }
                    }
                }
            }
            else{
                if(right != null && left != null || left == null && right != null){
                    value = right.remove_min();
                }
                else if(left != null && right == null){
                    value = left.remove_max();
                }
            }
        }
    }

}