package magicbinary.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



//accepted solution

public class Leet257 {
    TreeNode root;
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return null;
        StringBuilder strb = new StringBuilder();
        List<Integer> paths = new ArrayList<>();
        List<String> stringPaths = new ArrayList<>();
        return printNode(root, strb, paths, root, stringPaths);

    }

    List<String> printNode(TreeNode root, StringBuilder strb, List<Integer> paths, TreeNode origin, List<String> stringPaths) {
        paths.add(root.val);
        if (root.left != null) {
            printNode(root.left, strb, paths, root, stringPaths);
        }
        if (root.right != null) {
            printNode(root.right, strb, paths, root, stringPaths);
        }
        if (root.left == null && root.right == null) { 
            stringPaths.add(paths.stream().map(Object::toString).collect(Collectors.joining("->")));
        }
        paths.remove(paths.size()-1);
        return stringPaths;
    }
}
