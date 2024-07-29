import { useEffect, useState } from "react";
import axios from "axios";
export default function useArrayState() {
    const [array, setArray] = useState([]);

    useEffect(() => {
        generateArray();
    }, [])

    function generateArray(){
        axios.get('http://localhost:8080/sorting/generateArray')
            .then((response) => setArray(response.data))
            .catch((err) => console.log(err.message));
    }
    return {array, setArray, generateArray};
}