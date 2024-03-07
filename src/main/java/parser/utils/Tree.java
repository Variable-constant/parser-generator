package parser.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tree<T> {

    private final String node;
    private T value;
    private List<Tree<T>> children = Collections.emptyList();

    @SafeVarargs
    public Tree(String node, Tree<T>... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int writeTree(FileWriter fileWriter, int number) throws IOException {
        int currentNumber = number;
        fileWriter.write(String.format("    %d [label = \"%s\"];\n", currentNumber, node));
        for (Tree<T> child : children) {
            fileWriter.write(String.format("    %d -> %d;\n", currentNumber, number + 1));
            number = child.writeTree(fileWriter, number + 1);
        }
        return number;
    }

    public void getDigraph() {
        int number = 0;
        try (FileWriter fileWriter = new FileWriter("input.dot")) {
            fileWriter.write("strict digraph G {\n");
            writeTree(fileWriter, number);
            fileWriter.write("}\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public String getNode() {
        return node;
    }
}
