import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Main from './components/Main';
import HeaderComponent from './components/Header';
import FooterComponent from './components/Footer';

import List from './components/academy/List';
import DetailAcademy from './components/academy/DetailAcademy';

import Boardlist from './components/board/BoardList';
import Boardwrite from './components/board/Boardwrite';
import ReadBoard from './components/board/ReadBoard';

import Login from './components/member/Login';
import signup from './components/member/signup';

import Main2 from './components/Main2';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent/>
        <br></br>

             <Switch>
                <Route path = "/" exact component = {Main}></Route>
                <Route path = "/list"  component = {List}></Route>
                <Route path = "/main"  component = {Main2}></Route>
                <Route path = "/boardlist"  component = {Boardlist}></Route>
                <Route path = "/boardwrite/:no"  component = {Boardwrite}></Route>
                <Route path = "/readboard/:no" component = {ReadBoard}></Route>
                <Route path = "/detailAcademy/:no" component = {DetailAcademy}></Route>
                <Route path = "/login" component = {Login}></Route>
                <Route path = "/signup" component = {signup}></Route>
             </Switch>

          <br></br>
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;