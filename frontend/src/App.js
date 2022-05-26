import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Main from './components/Main';
import List from './components/List';
import Boardlist from './components/BoardList';
import Boardwrite from './components/Boardwrite';
import HeaderComponent from './components/Header';
import FooterComponent from './components/Footer';
import ReadBoard from './components/ReadBoard';
import DetailAcademy from './components/DetailAcademy';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent/>
          <div className="container">
             <Switch>
                <Route path = "/" exact component = {Main}></Route>
                <Route path = "/List"  component = {List}></Route>
                <Route path = "/Boardlist"  component = {Boardlist}></Route>
                <Route path = "/Boardwrite/:no"  component = {Boardwrite}></Route>
                <Route path = "/Readboard/:no" component = {ReadBoard}></Route>
                <Route path = "/DetailAcademy/:no" component = {DetailAcademy}></Route>
             </Switch>
          </div>
          <br></br>
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;