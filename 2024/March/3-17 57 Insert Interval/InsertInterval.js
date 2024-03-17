/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    let starts = [];
    let ends = [];
    let solution = [];

    for(let interval of intervals) {
        starts.push(interval[0]);
        ends.push(interval[1]);
    }

    starts.push(newInterval[0]);
    ends.push(newInterval[1]);

    starts.sort((a,b) => (a - b));
    ends.sort((a,b) => (a - b));

    console.log(starts);
    console.log(ends);

    while(starts.length > 0) {
        let start = starts.shift();
        let end = ends.shift();
        while(starts.length > 0 && end >= starts[0]) {
            starts.shift();
            end = ends.shift();
        }
        solution.push([start, end]);
    }

    return solution;
};