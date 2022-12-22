题目：

编程实现 DH 密钥协商协议 

共同参数。素数P，P的一个生成元g 
1. A 随机选择一个 [1,p-1] 范围内的数`x`，计算 `X` = g^x 
2. B 随机选择一个 [1,p-1] 范围内的数`y`，计算 `Y` = g^y mod p, 并将结果发送给A。 
k` = Y^x = X^y 

### 提示 

编写 bool isPrime(int n) ; 判断 n是素数 
编写 int GCD(int a, int b); 计算 a，b最大公因子 
编写 int ExpMod(int b, int n, int m) 计算 b^n mod m . 
编写 bool isPrimeRoot(g, p); 判断 g是模p乘的生成元。 
寻找p的生成元 ，从 g 从2，3等较小的数开始进行穷举。 计算 g^n mod p ， 1<=n < p-1 的到的数据不同，g即为生成元。

---

解题结果：

代码会随机生成一个素数 p 和一个生成元 g，然后使用 DH 密钥协商协议计算出共享密钥 k。最后，它会检查 A 和 B 计算出的 k 是否相等，如果相等则输出 "Success!"，否则输出 "Error!"。

---

git操作：

在本地使用 git add & git commit 进行保存和提交记录

在完成后使用 git push 提交代码到仓库

https://github.com/sinsnittau44/awtpw.git

sinsnittau@hotmail.com

cuB4am39