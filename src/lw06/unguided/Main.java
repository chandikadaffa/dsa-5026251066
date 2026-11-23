package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here
        BinarySearchTree tree = new BinarySearchTree();
        String line = read.nextLine();
        String[] numbers = line.split(" ");
        for (int i = 0; i < numbers.length; i++) {
            tree.insert(Integer.parseInt(numbers[i]));
        }
        int target = Integer.parseInt(read.nextLine());

        System.out.print("Preorder : ");
        tree.preOrder();

        System.out.print("Inorder : ");
        tree.inOrder();

        System.out.print("Postorder : ");
        tree.postOrder();

        System.out.println("Search " + target + " : " + tree.search(target));

        System.out.println("Minimum : " + tree.findMin());
        System.out.println("Maximum : " + tree.findMax());

        read.close();
    }
}
