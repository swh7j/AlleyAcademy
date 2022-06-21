import './App.css';
import {
  BrowserRouter,
  Routes,
  Route,
  Link,
  Router,
  HashRouter,
  useParams
} from "react-router-dom";

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
  let params = useParams();
  return (
    <div>
     <BrowserRouter>
        <HeaderComponent/>
        <br></br>
             <Routes>
                <Route path = "/" element={<Main/>} />
                <Route path = "/list"  element = {<List/>} />
                <Route path = "/main"  element = {<Main2/>} />
                <Route path = "/boardlist"  element = {<Boardlist/>} />
                <Route path = "/boardwrite/:no"  element = {<Boardwrite/>} />
                <Route path = "/readboard/:no" element = {<ReadBoard/>} />
                <Route path = "/detailAcademy/:no" element = {<DetailAcademy/>} />
                <Route path = "/login" element = {<Login/>} />
                <Route path = "/signup" element = {<signup/>} />
             </Routes>

          <br></br>



        <FooterComponent/>
      </BrowserRouter>
    </div>
  );
}

export default App;