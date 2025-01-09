// import React, { useEffect, useState } from "react";
// import logo from "./logo.svg";
import "./App.css";
import { GuessHandler } from "./Handlers/GuessHandler";
import { GuessTable } from "./components/GuessScreen/GuessScreen";

function App() {
  return (
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.tsx</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       {testString}
    //     </a>
    //   </header>
    <GuessTable></GuessTable>
    // </div>
  );
}

export default App;
