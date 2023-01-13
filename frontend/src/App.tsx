import React from 'react';
import './App.css';
import SpeciesApp from "./component/SpeciesApp";
import UserApp from "./component/UserApp";

function App() {
  return (
    <div>
        <h1>Manage you plants<p/></h1>
        <UserApp/>
        <SpeciesApp/>
    </div>
  );
}

export default App;
