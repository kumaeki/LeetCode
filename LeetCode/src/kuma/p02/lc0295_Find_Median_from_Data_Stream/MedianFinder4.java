package kuma.p02.lc0295_Find_Median_from_Data_Stream;

class MedianFinder4 {

    class TreeNode {
        int val;
        TreeNode parent, left, right;

        public TreeNode(int val, TreeNode parent) {
            this.val = val;
            this.parent = parent;
        }

        public void add(int num) {
            if (num >= val) {
                if (right == null)
                    right = new TreeNode(num, this);
                else
                    right.add(num);
            } else {
                if (left == null)
                    left = new TreeNode(num, this);
                else
                    left.add(num);
            }

        }

        public TreeNode getPre() {
            TreeNode res;
            if (left != null) {
                res = left;
                while (res.right != null)
                    res = res.right;
            } else {
                res = this;
                while (res.parent != null && res == res.parent.left)
                    res = res.parent;
                res = res.parent;
            }
            return res;
        }

        public TreeNode getNext() {
            TreeNode res;
            if (right != null) {
                res = right;
                while (res.left != null)
                    res = res.left;
            } else {
                res = this;
                while (res.parent != null && res.parent.right == res)
                    res = res.parent;
                res = res.parent;
            }
            return res;
        }
    }

    TreeNode root, cur;
    int count;

    public MedianFinder4() {
        root = cur = null;
        count = 0;
    }

    public void addNum(int num) {
        count++;
        if (root == null) {
            root = new TreeNode(num, null);
            cur = root;
        } else {
            root.add(num);
            if (count % 2 == 1) {
                if (num >= cur.val)
                    cur = cur.getNext();
            } else {
                if (num < cur.val)
                    cur = cur.getPre();
            }
        }

    }

    public double findMedian() {
        if (count % 2 == 1)
            return cur.val;
        else
            return (cur.val + cur.getNext().val) / 2.0;

    }

}