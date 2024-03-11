/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
var customSortString = function(order, s) {
    const map = new Map();
    var priority = 1

    Array.from(order).forEach((c) => { map.set(c, priority++); });
    
    return Array.from(s).sort((a, b) => {
        return (map.get(a) || 0) - (map.get(b) || 0);
    }).join('');
};