/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
function dailyTemperatures(temperatures) {
    const stack = [];
    const result = Array(temperatures.length).fill(0);

    for (let i = temperatures.length - 1; i >= 0; --i) {
        while (stack.length && temperatures[i] >= temperatures[stack[0]]) stack.shift();

        result[i] = stack.length ? stack[0] - i : 0;
        stack.unshift(i);
    }

    return result;
};