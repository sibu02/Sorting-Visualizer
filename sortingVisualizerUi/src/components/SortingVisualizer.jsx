import React, { useEffect, useState } from 'react'
import useArrayState from '../hooks/useArrayState'
import useSortVisualizer from '../hooks/useSortVisualizer';
import getAlgoAndSteps from '../hooks/getAlgoAndSteps';
import getBarColor from '../utility/GetBarColor';
import '../SortingVisualizer.css'

const SortingVisualizer = ({algorithm}) => {
    const {array,setArray,generateArray} = useArrayState();
    const {steps,setSteps,currStep,setCurrStep} = useSortVisualizer();
    const getSteps = getAlgoAndSteps(algorithm,setSteps);
    const [isSorting,setIsSorting] = useState(false);
    useEffect(()=>{
        if(steps.length > 0 && currStep < steps.length){
            setArray(steps[currStep].array);
        }
        if(currStep == steps.length){
            setIsSorting(false);
        }
    },[currStep,steps]);

    function sortHanlder(){
        setIsSorting(true);
        setCurrStep(0);
        getSteps(array);
    }
  return (
    <div className='main'>
        <div className='array-container'>
          {array.map((ele, idx) => {
            return <div className='arrayBar' key={idx} style={{
              height: `${ele * 20}px`,
              backgroundColor: getBarColor(idx,steps,currStep)
            }}></div>
          })}
        </div>
        <div>
        {!isSorting ? <button className='button-3' onClick={sortHanlder} >Start Sorting</button> : <button disabled className='button-3' onClick={sortHanlder} >Sorting...</button>}
        {/* <button className='button-3' onClick={sortHanlder} >Start Sorting</button> */}
        {!isSorting ? <button className='button-3' onClick={generateArray}>Generate New Array</button> : <button disabled className='button-3' onClick={generateArray}>Generate New Array</button>}
        </div>
    </div>
  )
}

export default SortingVisualizer

