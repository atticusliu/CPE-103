import java.util.*;

public class BasicBST
{
    private class BSTNode()
    {
        int element;
        BSTNode left;
        BSTNote right;
    }

    private BSTNode root;

    public BasicBST()
    { root = null; }

    public void insert(int item)
    {
        root = insert(item, root);
    }

    private BSTNode insert(int item, BSTNode treeroot)
    {
        // if subtree is empty
        if(treeroot == null)
        {
            BSTNode temp = new BSTNode();
            treeroot = temp;
            temp.element = item;
        }
        else
        {
            if(item < treeroot.element)
                treeroot.left = insert(item, treeroot.left);
            else
                treeroot.right = insert(item, treeroot.right);
        }
        return treeroot;
    }

    public int countOdds()
    {
        countOdds(root);
    }

    private int countOdds(int counter, BSTNode treeroot)
    {
        int count = 0;
        if(treeroot == null)
            return 0;
        else
        {
            // check the root
            if(treeroot.element % 2 == 1)
                count++;
            count += countOdds(count, treeroot.left);
            count += countOdds(count, treeroot.right);
        }
        return count;
    }

    public int height()
    {
        height(root);
    }

    private int height(int counter, BSTNode treeroot)
    {
        int h1 = 0;
        int h2 = 0;
        int ret;
        if(treeroot == null)
            return -1;
        if(treeroot.left == null && treeroot.right == null)
            return 0;
        if(treeroot.left != null || treeroot.right != null)
            counter++;
        else
        {
            countLeft = height(h1, treeroot.left);
            countRight = height(h2, treeroot.right);
        }
        if(h1 > h2)
            ret = h1 + 1;
        else
            ret = h2 + 1;
        return ret;
    }

    public int countLeaves()
    {
        countLeaves(root);
    }

    private int countLeaves(BSTNode treeroot)
    {

    }

    public int countOneChildParents()
    {
        countOneChildParents(root);
    }

    private int countOneChildParents(BSTNode treeroot)
    {

    }
}