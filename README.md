**AIRPLANE EMBARK AND DISEMBARK APP** 

**Overview:** 

This project is designed to help simulate passengers embarking and disembarking off a plane using fundamental data structures. Passengers enter on a first come first served basis, and exit on a last in first out basis. 

**Key Concepts:**

- Queue (FIFO) for passenger boarding
- Stack (LIFO) for disembarking
- ArrayList to list all seated passengers

"How it Works"

**Boarding**
1. Once passengers check in, they are added to a boarding line
2. Passengers can be boarded onto the plane one at a time
3. The passenger is assigned a seat and boards the plane, and their name is removed from the boarding list

**Disembarking**
1. When the 'Start Disembarking' option is selected, all passengers currently on the plane will be placed into a Stack
2. Passengers are 'popped' out of the list one by one 
