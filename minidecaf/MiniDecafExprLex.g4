lexer grammar MiniDecafExprLex;


// 关键字
Int
	: 'int'
	;

Return
	: 'return'
	;

If
	: 'if'
	;

Else
	: 'else'
	;

For
	: 'for'
	;

Do
	: 'do'
	;

While
	: 'while'
	;

Break
	: 'break'
	;

Continue
	: 'continue'
	;


// 标点、操作符
Lparen : '(' ;
Rparen : ')' ;
Lbrkt : '[' ;
Rbrkt : ']' ;
Lbrace : '{' ;
Rbrace : '}' ;
Comma : ',' ;
Semicolon : ';' ;

Punctuator
	: Lparen
	| Rparen
	| Lbrkt
	| Rbrkt
	| Lbrace
	| Rbrace
	| Comma
	| Semicolon
	;

Add : '+' ;
Sub : '-' ;
Mul : '*' ;
Div : '/' ;
Percent : '%' ;
Exclamation : '!' ;
Tilde : '~' ;
Ampersand : '&' ;
Langle : '<' ;
Rangle : '>' ;
Langle_eq : '<=' ;
Rangle_eq : '>=' ;
Double_eq : '==' ;
Exclam_eq : '!=' ;
Equal : '=' ;
Double_amp : '&&' ;
Double_bar : '||' ;

Operator
	: Add
	| Sub
	| Mul
	| Div
	| Percent
	| Exclamation
	| Tilde
	| Ampersand
	| Langle
	| Rangle
	| Langle_eq
	| Rangle_eq
	| Double_eq
	| Exclam_eq
	| Equal
	| Double_amp
	| Double_bar
	;


// 其他

Integer
	: Digit+
	;

Whitespace
	: [ \t\n\r]+ -> skip
	;

Identifier
	: IdentLead WordChar*
	;

fragment IdentLead: [a-zA-Z_];
fragment WordChar: [0-9a-zA-Z_];
fragment Digit: [0-9];