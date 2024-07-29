export default function getBarColor(index,steps,currStep){
    if(index <= 0){
        return 'teal';
    }
    if (currStep == steps.length) return 'teal';
    const {currIndex,comparingIndex} = steps[currStep];
    return currIndex === index || comparingIndex === index ? 'red' : 'teal';
}