### Step1实验报告

2018013443 陈新 计82

#### 实验内容

根据实验指导书，依次实现语法分析->词法分析->生成ir->asm。

在step1里面没有实现全面语义检查，仅作了最简单的int范围检查、main函数检查，并且也放在了parser中，没有独立出来

然后处理parser的mismatch报错，按照样例代码的示范，增添`BailErrorListener`与`BailErrorStrategy`将错误抛出，使程序中断

---------------------

#### 思考题

1. ```python
   lexer.setInput("
   int main() {
       return 清华;
   }
   ")
   ```

   由于
   
   ```python
       # 我们不认识的字符（比如汉字），报错。
       TokenKind("Error", f".", action="error")
   ```
   
   所以要引起lexer报错只需要将任意token改为汉字即可
   
2. ```python
   rules = "
   program    : function
   function   : type Identifier Lparen Rparen Lbrace statement Rbrace
   type       : Int
   statement  : Return Return Semicolon
   expression : Integer
       "
   ```

   将`statement  : Return expression Semicolon`中的`expression`改为无法与整数值正常匹配的终结符`Return`

3. a0

---------------

#### 参考代码

给的minidecaf-reference的部分代码