### Step8实验报告

2018013443 陈新 计82

#### 实验内容

step8要实现四种循环语句：for, for(带declaration), while, do while

用labelManger维护循环的label，确定break和continue跳转的标号；每次进入循环增加一个循环的label，退出循环弹出一个循环的label，若break/continue时没有循环label剩余，则说明是在循环外部，报错即可

根据四种循环不同的语法，添加loop的逻辑判断

由于带declaration的for循环要初始化声明的变量，并实现对父作用域的覆盖，因此for循环自带一个作用域

---------------------

#### 思考题

1. 设总共执行n次循环体(n>=1)，二者cond/body的IR没有区别，故不考虑，仅考虑其余部分

   第一种每次都要执行`beqz BREAK_LABEL：条件不满足就终止循环`和`br BEGINLOOP_LABEL：本轮迭代完成`即3、6两条指令，共计2n条；而第二种的第2条指令`beqz BREAK_LABEL：条件不满足就终止循环`只会在第一次迭代中执行，之后每次会执行指令7：`bnez BEGINLOOP_LABEL：本轮迭代完成，条件满足时进行下一次迭代`，共计n+1条

   因此当n=1时，二者执行条数相同；当n>1时，第二种执行条数少。综合来看第二种翻译方式更好

