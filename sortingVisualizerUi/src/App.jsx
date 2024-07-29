import {BrowserRouter as Router,Routes, Route,useParams,Link} from 'react-router-dom';
import './App.css'
import SortingVisualizer from './components/SortingVisualizer';
import Navbar from './components/Navbar';
import Footer from './components/Footer';

function App() {
  function GetName(){
    const {sortingName} = useParams();
     return <SortingVisualizer algorithm={sortingName}/>
  }

  return (
    <Router>
      <div className="App">
      <Navbar/>
    <div>
      <Routes>
        <Route path='/sorting/:sortingName' element={<GetName/>} />
      </Routes>
    </div>
    <Footer/>
    </div>
  </Router>
  )
}

export default App
