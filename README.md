# mazesolverforimage
dumb pathfdinger for image i wrote in 30 minutes 

very poorly coded
i think that is dijkstra and a star i implemented not sure.

Basically Dijkstra loops through all of the squares by order as compared to Greedy and A Star.

Pseudo code
```
WHILE ENDNODE IS NULL AND OPENLIST IS NOT EMPTY
  GET THE FIRST TILE AND MARK IT CLOSED AND REMOVE FROM OPEN LIST
  ADD ALL ORTHOGONICALLY ADJACENT SQUARES TO THE TILE TO THE OPEN LIST
  CHECK IF THEY ARE END NODE, IF TRUE SET THIS TO END NODE OR ELSE REPEAT UNTIL OPENLIST IS EMPTY

IF ENDNODE IS NOT NULL
  BACKTRACK WITH THE ENDNODE PARENT UNTIL THE PARENT IS NULL WHICH IS THE STARTING POINT
```

Dijkstra Java with arraylists

```java
while (endNode == null && !openList.isEmpty()) {
  
  Node currentNode = closedList.remove(openList.get(0));
  for (// check for adjacent tiles. whether it may be diagonally or orthogonally adjacent tiles && can be added to list) {
    tempTile = //the tile you are checking;
    Node tempNode = new Node(temptile,currentNode /*parent*/);
    if (tempTile.equals(endTile)) {
      endNode = tempNode;
      break;
    }
    openList.add(tempNode);
  }
}
```

And so on... A Star and Greedy Algorithms aren't all that different to Dijkstra. It is just an added sorting and heuristics to loop.
That statement could be false however because I haven't looked into other algorithms. For all I know all algorithms are similar to this.

A Star - 

```
Calculates the move cost by adding parent move cost + 1 AND the heuristic cost which I used the manhattan to calculate
|x1 - x2| + |y1 - y2|
or euclidean c^2=a^2+b^2
sqrt ((x1 - x2) ^ 2 + (y1 - y2)^2)
```

and Greedy is more inbalance between the heuristics.
