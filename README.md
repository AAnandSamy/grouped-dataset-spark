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

-	Will read the each row in Dataframe and for form the Tuple2,  This will be WrapperArrayList, Here I have taken JSON format , because essay to parse and project the data.

`df.withColumn("JsonTuple", to_json(struct("*")) )`

country | states | city | JsonTuple
--- | --- | --- | ---
|USA    |California    |San Francisco|{"country":"USA","states":"California","city":"San Francisco"}|
|USA    |California    |Los Angeles  |{"country":"USA","states":"California","city":"Los Angeles"}  |
|USA    |Michiga       |Detroit      |{"country":"USA","states":"Michiga","city":"Detroit"}         |
|USA    |Missori       |St.Louis     |{"country":"USA","states":"Missori","city":"St.Louis"}        |
|IND    |Tamilnadu     |Chennai      |{"country":"IND","states":"Tamilnadu","city":"Chennai"}       |
|IND    |Tamilnadu     |Trichy       |{"country":"IND","states":"Tamilnadu","city":"Trichy"}        |
|IND    |Andhra pradesh|Hyderabad    |{"country":"IND","states":"Andhra pradesh","city":"Hyderabad"}|
|IND    |Andhra pradesh|thirumala    |{"country":"IND","states":"Andhra pradesh","city":"thirumala"}|
|IND    |Karnataka     |Bangalore    |{"country":"IND","states":"Karnataka","city":"Bangalore"}     |


- Since we added the tuples into column(JsonTuple), now we can group them based on key column(country) and collect the Tuples as form for List.

country | json_data 
--- | --- 
|USA  |[{"country":"USA","states":"California","city":"San Francisco"},{"country":"USA","states":"California","city":"Los Angeles"},{"country":"USA","states":"Michiga","city":"Detroit"},{"country":"USA","states":"Missori","city":"St.Louis"}] |
|IND  |[{"country":"IND","states":"Tamilnadu","city":"Chennai"},{"country":"IND","states":"Tamilnadu","city":"Trichy"},{"country":"IND","states":"Andhra pradesh","city":"Hyderabad"},{"country":"IND","states":"Andhra pradesh","city":"thirumala"},{"country":"IND","states":"Karnataka","city":"Bangalore"}]|

- Now we have grouped dataset's , json_data is Json data so we apply projection and filter/agg the data