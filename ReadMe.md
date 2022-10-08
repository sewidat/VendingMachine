# Snacks Vending Machine

## you can find the uml inside the uml folder.

### The project is divided into several parts based on their function:

### the snacks vending machine has been built by extending abstract parts that can be used to build other types of machines.

- mechanics: which are the real physical parts of the machine with their logic, being collected with each other using
  the:

> Validator

- products: the machine's products.

---

# Notes:

### 1- the application start by initiating a global price as its appears in the file.

> src/main/java/org/example/product/SnackCreator.java line 5

and in this application it has been initiated to 59.9$, fell free to chane it.

---

### 2- treasury class represents the finance department, initially it has been set to contain 20unit for each coin/note.

---

### 3- The Validator: `all roads leads to the Validator`, this class combines all the moving parts, perform the operations, and validate the transactions.

---

# Sample Run

``` Welcome ^_^
Please Enter The Row "from 1->5": 
To Exit Please Enter 0
-> 1

Please Enter The Col "from 1->5": 
To Exit Please Enter 0
-> 2
How do wish to pay
-> 1- cash
-> 2- visa
1
-----------------------
Please Add Cash
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
6
total amount: 50.0
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
5
total amount: 70.0
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
-1
-----------------------
here is your change:
[TenCoin, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar]
-----------------------
-----------------------
cash report:
-> view into the cash
{TwentyNote=21, TenCoin=19, FiftyCoin=20, FiftyNote=21, Dollar=10, TwentyCoin=20}
All the money"Cash+Visa"1495.9
Please Enter The Row "from 1->5": 
To Exit Please Enter 0
-> 1

Please Enter The Col "from 1->5": 
To Exit Please Enter 0
-> 2
How do wish to pay
-> 1- cash
-> 2- visa
1
-----------------------
Please Add Cash
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
6
total amount: 50.0
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
5
total amount: 70.0
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
-1
-----------------------
here is your change:
[TenCoin, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar, Dollar]
-----------------------
-----------------------
cash report:
-> view into the cash
{TwentyNote=22, TenCoin=18, FiftyCoin=20, FiftyNote=22, Dollar=0, TwentyCoin=20}
All the money"Cash+Visa"1555.8
Please Enter The Row "from 1->5": 
To Exit Please Enter 0
-> 2

Please Enter The Col "from 1->5": 
To Exit Please Enter 0
-> 3
How do wish to pay
-> 1- cash
-> 2- visa
1
-----------------------
Please Add Cash
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
6
total amount: 50.0
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
5
total amount: 70.0
What To Insert?!
[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]
To Finish Enter -1
-1
-----------------------
here is your change:
[TenCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin, FiftyCoin]
-----------------------
-----------------------
cash report:
-> view into the cash
{TwentyNote=23, TenCoin=17, FiftyCoin=0, FiftyNote=23, Dollar=0, TwentyCoin=20}
All the money"Cash+Visa"1615.7
Please Enter The Row "from 1->5": 
To Exit Please Enter 0
-> 1

Please Enter The Col "from 1->5": 
To Exit Please Enter 0
-> 3
How do wish to pay
-> 1- cash
-> 2- visa
2
-----------------------
please enter your visa
done
-----------------------
cash report:
-> view into the cash
{TwentyNote=23, TenCoin=17, FiftyCoin=0, FiftyNote=23, Dollar=0, TwentyCoin=20}
All the money"Cash+Visa"1675.6000000000001
Please Enter The Row "from 1->5": 
To Exit Please Enter 0
-> 0

Process finished with exit code 0
```