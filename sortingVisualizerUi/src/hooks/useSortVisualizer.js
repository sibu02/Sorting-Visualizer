import { useEffect, useState } from "react";

export default function useSortVisualizer(){
  const [steps,setSteps] = useState([]);
  const [currStep,setCurrStep] = useState(0);
  useEffect(()=>{
    if(steps.length > 0 && currStep < steps.length){
        setTimeout(()=>{
            setCurrStep(()=>currStep+1);
        },100)
    }
  },[steps,currStep])

  return {steps, setSteps , currStep , setCurrStep};

}