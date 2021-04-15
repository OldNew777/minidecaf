grammar MiniDecafExpr;
 
import MiniDecafExprLex;

program
	: externalDecline+ EOF
	;

externalDecline
	: function			# functionExternal
	| declaration ';'	# declarationExternal
	;

function
	: variableType Identifier '(' parameterList ')' block	# functionDefine
	| variableType Identifier '(' parameterList ')' ';'		# functionDeclaration
	;

variableType
	: Int				# intType
	| variableType '*'	# pointerType
	;

parameterList
	: (declaration (',' declaration)*)?
	;

declaration
	: variableType Identifier ('[' Integer ']')* ('=' expression)?
	;

block
	: '{' blockItem* '}'
	;

blockItem
	: statement			# blockItemStatement
	| declaration ';'	# blockItemDeclaration
	;

statement
	: Return expression ';'		# returnStatement
	| expression ';'			# expressionStatement
	| ';'						# blankStatement
	| If '(' expression ')' thenStatement=statement (Else elseStatement=statement)?	# ifStatement
	| block						# blockStatement
	| For '(' init=declaration ';' ctrl=expression? ';' post=expression? ')' statement	# forDeclarationStatement
	| For '(' init=expression? ';' ctrl=expression? ';' post=expression? ')' statement	# forStatement
	| While '(' expression ')' statement		# whileStatement
	| Do statement While '(' expression ')' ';'	# doWhileStatement
	| Break ';'					# breakStatement
	| Continue ';'				# continueStatement
	;

expression
	: assign
	;

assign
	: conditional			# tAssign
	| unary assignOperator assign		# cAssign
	;

conditional
	: logical_or									# tConditional
	| logical_or '?' expression ':' conditional		# cConditional
	;

logical_or
	: logical_and					# tLogical_or
	| logical_or '||' logical_and	# cLogical_or
	;

logical_and
	: bit_or						# tLogical_and
	| logical_and '&&' bit_or		# cLogical_and
	;

bit_or
	: bit_xor						# tBit_or
	| bit_or '|' bit_xor			# cBit_or
	;

bit_xor
	: bit_and						# tBit_xor
	| bit_xor '^' bit_and			# cBit_xor
	;

bit_and
	: equal							# tBit_and
	| bit_and '&' equal				# cBit_and
	;

equal
	: relational						# tEqual
	| equal equalOperator relational	# cEqual
	;

relational
	: add							# tRelational
	| relational relationalOperator add	# cRelational
	;

add
	: multiply						# tAdd
	| add addOperator multiply		# cAdd
	;

multiply
	: cast								# tMultiply
	| multiply multiplyOperator cast	# cMultiply
	;

cast
	: unary							# tCast
	| '(' variableType ')' cast		# cCast
	;

unary
	: postfix				# tUnary
	| unaryOperator cast	# cUnary
	;

postfix
	: atom								# tPostfix
	| postfix '[' expression ']'		# postfixArray
	| Identifier '(' argumentList ')'	# postfixCall
	;

argumentList
	: (expression (',' expression)*)?
	;

atom
	: Integer				# atomInteger
	| Identifier			# atomIdentifier
	| '(' expression ')'	# atomParen
	;

addOperator
	: '+' | '-'
	;

multiplyOperator
	: '*' | '/' | '%'
	;

equalOperator
	: '==' | '!='
	;

unaryOperator
	: '-' | '!' | '~' | '*' | '&'
	;

relationalOperator
	: '<' | '>' | '<=' | '>='
	;

assignOperator
	: '='
	;
	