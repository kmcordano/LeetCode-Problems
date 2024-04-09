/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
var timeRequiredToBuy = function(tickets, k) {
    var time = 0;
    var length = tickets.length;
    var val = tickets[k];

    for(let i = 0; i < length; i++) {
        if(i <= k) {
            time += Math.min(tickets[i], val);
        }
        else {
            time += Math.min(tickets[i], val - 1);
        }
    }

    return time;
};