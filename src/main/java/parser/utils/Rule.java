package parser.utils;

import parser.grammar.GrammarParser;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    private final String left;
    private final List<RuleBranch> branches;

    public Rule(GrammarParser.RuleObjContext ruleContext) {
        this.left = ruleContext.name.getText();

        this.branches = new ArrayList<>();
        GrammarParser.BranchListContext branchList = ruleContext.branches;
        while (branchList.headBranch != null) {
            branches.add(new RuleBranch(branchList.headBranch));
            branchList = branchList.tail;
        }
    }

    public String getLeft() {
        return left;
    }

    public List<RuleBranch> getBranches() {
        return branches;
    }

}
