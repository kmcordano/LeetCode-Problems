/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    let usefulPairs = [];

    candidates.reverse();
    candidates.forEach((candidate) => {
        if(candidate > target) {
            return;
        }

        let toPush = [];

        usefulPairs.forEach((pair) => {
            if(pair.sum + candidate <= target) {
                toPush.push(
                    {
                        sum  : pair.sum + candidate,
                        vals : new Array(...pair.vals, candidate)
                    }
                );
            }
        });

        toPush.push(
            {
                sum  : candidate,
                vals : [candidate]
            }
        );

        usefulPairs.push(...toPush)
    });

    usefulPairs = usefulPairs
        .filter(pair => pair.sum === target)
        .map(pair => pair.vals);
    usefulPairs.forEach((pair) => { pair.sort(); });

    return Array.from(new Set(usefulPairs.map(JSON.stringify)), JSON.parse);
};