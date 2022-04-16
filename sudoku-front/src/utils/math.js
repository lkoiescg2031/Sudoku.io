export function getRandomIntFromRange(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

const MathUtils = {
  getRandomIntFromRange
};

export default MathUtils;