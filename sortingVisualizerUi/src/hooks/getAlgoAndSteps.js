import axios from "axios";

export default function getAlgoAndSteps(algorithm,setSteps){
    function getSteps(array){
        const url = `http://localhost:8080/sorting/${algorithm}`;
        axios.post(url,array,{
            headers :{
                "Content-Type" : "application/json"
            }
        })
        .then((response)=>setSteps(response.data))
        .catch((err)=>console.log(err.message));
    }
    return getSteps;
}