import React from 'react';
import './App.css';
import SpeciesApp from "./component/SpeciesApp";
import UserApp from "./component/UserApp";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import NavBar from "./component/NavBar";
import UserDetails from "./component/UserDetails";


function App() {



  return (
    <div>

        <BrowserRouter>
            <NavBar/>
            <Routes>
                <Route path={"/plants"} element={SpeciesApp()}/>
                <Route path={"/users"} element={UserApp()}/>
                <Route path={"/users/:id"} element={<UserDetails/>}></Route>
            </Routes>
        </BrowserRouter>
        <h1>Manage you plants<p/></h1>
    </div>
  );
}

export default App;
