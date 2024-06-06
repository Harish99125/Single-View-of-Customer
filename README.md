# Single-View-of-Customer

Single View of Customer

1. Customer Table
2. Loyalty Points Table
3. Transactions Table
4. Account Details Table

For every credit transaction, user should get the 5% Loyalty points on transaction amount
For Loyalty Deposits , customer should get 15% Loyalty Points on the amount per annum

Customer Details :
Account Number (Auto Generation) 12 Digit Number
Card Number (Auto Generation) 12 Digit Number
Loyalty Points Number  10 Digit Number

Share Loyalty Points between customer

---

---

1. Create a DB with name SVCLP
2. Create resprctive tables as per the document

Customer Table
Customer
First Name
Last Name
Email ID
Mobile Number
Address
PINCODE
City
Loyalty_points
PAN
aadhar
Customer_account_Number

1. You have to develop an Create_Customer_API (POST_METHOD)
First Name
Last Name
Email ID
Mobile Number
Address
PINCODE
City
Loyalty_points ( 150 Points ) Default
PAN
aadhar
    
    ```
    Response :
      Status Code : 201
      Description :  Customer Created Successfully
      Customer Name :
      Account Number : (Auto Generation) 12 Digit Number
      Card Number : (Auto Generation) 12 Digit Number
      Loyalty Points Number : (Auto Generation)  10 Digit Number
    
    ```
    
2. Loyalty Points Table
2. Customer_account_Number: Sai_Account_number
Loyalty Points Number : Sai_Loyalty_Number
Loylaty Points : 225
3. Transactions Table:
Transaction ID
Transaction Type ( Card, Loyalty Deposits, Loyalty_Share)
Account_Number From
Account_Number To
Loyalty_Points_Credit_To
Loyalty_points_Debit_From
Loaylty Points ( Credit / Debit )
Transaction Amount
Loyalty_Points

Usecase-:
1256362  Card    Sai_Account_number   null      Sai_Loyalty_Point_Number_To   null    Credit   1000  50
1256363  Card    Sai_Account_number   Gopi_AcN  Sai_Loyalty_Point_Number_To   null    Credit   500   25
1256363  LS      Sai_Account_number   Gopi_AcN  Sai_Loyalty_Point_Number_To   Gopi_LPN Debit    0     25
1256364  LS      Sai_Account_number   Gopi_AcN  Sai_Loyalty_Point_Number_To   Gopi_LPN Credit   0     25
1256365  LD      Gopi_Account_number    null    Gopi_Loylaty_points Number     null    Credit  100000 10000
Points Logic:
For every credit transaction, user should get the 5% Loyalty points on transaction amount
For Loyalty Deposits , customer should get 10% Loyalty Points on the amount
