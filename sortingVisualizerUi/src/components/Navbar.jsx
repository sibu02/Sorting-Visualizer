import React from 'react';
import { useNavigate } from 'react-router-dom';

const Navbar = () => {
    const navigate = useNavigate();

    const handleAlgorithmChange = (event) => {
        const algorithm = event.target.value;
        if (algorithm) {
        navigate(`/sorting/${algorithm}`);
        }
    };
    return (
        <nav className="navbar">
          <div className="navbar-title">Sorting Visualizer</div>
          <div className="navbar-dropdown">
            <select onChange={handleAlgorithmChange} defaultValue="">
              <option value="" disabled>Select Algorithm</option>
              <option value="quickSort">Quick Sort</option>
              <option value="mergeSort">Merge Sort</option>
              <option value="insertionSort">Insertion Sort</option>
              <option value="bubbleSort">Bubble Sort</option>
              <option value="selectionSort">Selection Sort</option>
              <option value="countingSort">Counting Sort</option>
            </select>
          </div>
        </nav>
      );
}

export default Navbar