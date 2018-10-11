# Grouped Dataset in Spark


-	We can build the relational dataset using spark, let’s see how build with this country dataset.
-	Here you go with below sample data

#### country Datasets

country | states | city
--- | --- | ---
|    USA|    California|San Francisco|
|    USA|    California|  Los Angeles|
|    USA|       Michiga|      Detroit|
|    USA|       Missori|     St.Louis|
|    IND|     Tamilnadu|      Chennai|
|    IND|     Tamilnadu|       Trichy|
|    IND|Andhra pradesh|    Hyderabad|
|    IND|Andhra pradesh|    thirumala|
|    IND|     Karnataka|    Bangalore|

Now let’s group them based on country name, As per  the dataset we so should get two datasets one for USA and other one for IND.
