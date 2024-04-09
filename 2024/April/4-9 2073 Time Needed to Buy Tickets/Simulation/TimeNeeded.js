/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
var timeRequiredToBuy = function(tickets, k) {
    var time = 0;
    var p = 0;
    var length = tickets.length;

    while(tickets[k] > 0) {
        if(tickets[p] > 0) {
            tickets[p] = tickets[p] - 1;
            time++;
        }

        p++;
        p = p % length;
    }

    return time;
};