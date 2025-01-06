import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import { TestHandler } from "./Handlers/testhandler";
import { GuessTable } from "./components/GuessScreen/GuessScreen";

function App() {
  const handler = new TestHandler();
  const [testString, setTestString] = useState("");
  useEffect(() => {
    handler.get().then((s) => setTestString(s));
  });
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
