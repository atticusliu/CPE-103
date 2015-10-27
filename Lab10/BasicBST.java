import java.util.*;

public class BasicBST
{

    private class BSTNode
    {
        int element;
        BSTNode left;
        BSTNode right;
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
        return countOdds(root);
    }

    private int countOdds(BSTNode treeroot)
    {
        int count = 0;
        if(treeroot == null)
            return 0;
        else
        {
            // check the root
            if(treeroot.element % 2 == 1)
                count++;
            count += countOdds(treeroot.left);
            count += countOdds(treeroot.right);
        }
        return count;
    }


    public int height()
    {
        return height(root);
    }

    private int height(BSTNode treeroot)
    {
        int h1 = 0;
        int h2 = 0;
        if(treeroot == null)
            return -1;
        else
        {
            h1 = height(treeroot.left) + 1;
            h2 = height(treeroot.right) + 1;

            if (h1 > h2)
                return h1;
            else
                return h2;
        }

    }


    public int countLeaves()
    {
        return countLeaves(root);
    }

    private int countLeaves(BSTNode treeroot)
    {
        int count = 0;
        if(treeroot == null)
            return 0;
        else
        {
            // position roots until we reach roots where there are no children
            if(treeroot.left == null && treeroot.right == null)
                count++;
            else
            {
                count += countLeaves(treeroot.left);
                count += countLeaves(treeroot.right);
            }
        }
        return count;
    }

    public int countOneChildParents()
    {
        return countOneChildParents(root);
    }

    private int countOneChildParents(BSTNode treeroot)
    {
        int count = 0;
        if(treeroot == null)
            return 0;
        else
        {
            // one parent or the other
            if(treeroot.left == null && treeroot.right != null)
                count++;
            if(treeroot.left != null && treeroot.right == null)
                count++;
            else
            {
                count += countOneChildParents(treeroot.left);
                count += countOneChildParents(treeroot.right);
            }
        }
        return count;
    }
}