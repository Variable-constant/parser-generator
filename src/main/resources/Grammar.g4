grammar Grammar;

start
    : gn=grammarName
    grammarType=typeName
    headerList=header
    rules=ruleList
    tokens=tokenList
    codePart=additionalCode EOF
    ;

grammarName
    : 'grammar' name=NOT_WS ';'
    ;

typeName
    : 'type' name=CODE ';'
    |
    ;

header
    : '@header' headers=CODE
    ;

ruleList
    : rule=ruleObj tail=ruleList
    |
    ;

ruleObj
    : name=NOT_WS branches=branchList
    ;

branchList
    : '|' headBranch=branch tail=branchList
    | ';'
    ;

branch
    : elements=elementList calculation=calcResult
    | calculation=calcResult
    ;

calcResult
    : val=CODE
    |
    ;

elementList
    : headElement=NOT_WS tail=elementList
    |
    ;

tokenList
    : headToken=token tail=tokenList
    |
    ;

token
    : name=NOT_WS ':' regex=REGEX tail=tokenTail
    ;

tokenTail
    : val='-> skip' calculation=calcResult ';'
    | calculation=calcResult val=';'
    ;

additionalCode
    : code=REGEX
    |
    ;

WS : [\t\r\n ]+ -> skip;
REGEX : '~' ~'~'+ '~';
CODE : '[' ~']'+ ']';
NOT_WS : ~[\t\r\n ]+;
