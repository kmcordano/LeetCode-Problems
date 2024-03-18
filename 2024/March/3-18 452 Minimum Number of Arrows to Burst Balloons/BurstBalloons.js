/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    points.sort((a, b) => (a[1] - b[1]));

    let currentRange = 0;
    let x = points[0][1];
    let arrowsThrown = 1;

    while(currentRange < points.length) {
        if(x >= points[currentRange][0]
        && x <= points[currentRange][1]) {
            currentRange++;
        }
        else {
            arrowsThrown++;
            x = points[currentRange][1];
        }
    }

    return arrowsThrown;
};