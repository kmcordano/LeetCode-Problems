/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let num0 = 0;
    let num1 = 0;

    for(let s of students) {
        if(s === 0) {
            num0++;
        }
        else {
            num1++;
        }
    }

    for(let s of sandwiches) {
        if(s === 0) {
            if(--num0 < 0) {
                return num1;
            }
        }
        else {
            if(--num1 < 0) {
                return num0;
            }
        }
    }

    return 0;
};