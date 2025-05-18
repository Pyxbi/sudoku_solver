<h1 align="center">COSC2469|COSC2722 - Data Structure and Algorithm</h1>
<h2 align="center" style="font-size: 30px;">The Maze Navigation</h2>

### I. CONTRIBUTION INFORMATION

The starting score for each student is 5 points. Each group can decide to add/remove points to/from each member, but the total point of the whole group is kept unchanged (it is = (the number of members) * 5). Additional rules:

<ul>
    <li>The maximum point for a member is 7.
    <li>If a member gets zero points => that member gets zero for the whole group project assignment. In this case, the total point of the whole group = (the number of members whose scores > zero) * 5.
    <li>The contribution score must be agreed upon by all members. If there are disagreements, you must inform the lecturer/coordinator before the due time.
    <li>The maximum score for the whole project is 35. If you get more than 35 (due to a high contribution score), the final score is 35.
</ul>


#### TOTAL GROUP CONTRIBUTION SCORE: 15
#### CONTRIBUTOR 1: [PHAM LE GIA HUY](https://github.com/vhpx) (ID: S3975371)
#### Given score: 5

- Implemented data structure and algorithm of dlx.
- Report reaserching and writting.


#### CONTRIBUTOR 2: [NGUYEN THACH KHANH DZI](https://github.com/VanTaizz) (ID: S3980883)
#### Given score: 5

- write code backtracking to compare
- Complexity analyses of data structure and algorithm.
- Report reaserching and writting


#### CONTRIBUTOR 3: [NGUYEN PHAM TIEN HAI](https://github.com/TriDuong070803) (ID: S3979239)
#### Given score: 5

- write code constraint propagation
- Report reaserching and writting
- etc...

#### CONTRIBUTOR 4: [NGUYEN THI NGOAN](https://github.com/TriDuong070803) (ID: S3912026)
#### Given score: 5

- implemented testing and compare
- Report reaserching and writting
- etc...

#### CONTRIBUTOR 5: [NGUYEN VIET PHAP](https://github.com/TriDuong070803) (ID: S4012986)
#### Given score: 5

- design class diagram
- Report reaserching and writting
- etc...

### II. INSTRUCTION

#### a. Main class.
> The main method will be put in the file "Application", we already set up some of the data for user to run. The parameter to put in each method as below:

- **add(places)**: The "places" is an array of Places object.
- **map.edit(x, y, arrayListService)**: The "x" and the "y" will be the coordinate of the place that you want to fix it service list. The "arrayListService" will be an array of new service, it mean what ever you put in the "arrayListService", the places will offers that services after the edit proccess.
- **map.remove(x, y)**: The "x" and the "y" is the coordinate of the places that we want to remove
- **map.searchPlaces(location_x, location_y, half_width, half_height, service)**: "location_x" and "location_y" represents the coordinate of your current location, the "half_width" and "half_heigth" will be the half of width and heigth length of your bounding rectangle, the "service" will be the service that you want to search for. The return valud for this method will be a "PlaceList".

#### b. Test Effeciency class.
>The "TestEffeciency" file that we contain in the folder will be use for some particular reason. If the user want to test the method on a large number of data, this file can help you to generate the random number of data base on your choice. However, for the small test, we recommend you to use the created data that we put in the Main class.

### III. OTHER RESOURCES

#### a. DEMONSTRATION VIDEO
[CLICK HERE TO GO TO DEMONSTRATION VIDEO ON YOUTUBE]()


#### b. UML DIAGRAM
[CLICK HERE TO GO TO LUCID CHART](https://app.diagrams.net/?state=%7B%22ids%22:%5B%221gBDCsw3m3oXsf25Ln4gtHDm2BwQvoEaz%22%5D,%22action%22:%22open%22,%22userId%22:%22116853784373455700089%22,%22resourceKeys%22:%7B%7D%7D)
- if can not access click the "try opening via this page"
<img src = UML.png>