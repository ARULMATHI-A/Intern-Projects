import React, { useState } from 'react';
import './App.css';

function App() {
  const [weight, setWeight] = useState('');
  const [height, setHeight] = useState('');
  const [result, setResult] = useState('');

  function calculateBMI() {
    const w = parseFloat(weight);
    const h = parseFloat(height);

    if (!w || !h) {
      setResult('Please enter valid numbers.');
      return;
    }

    const bmi = (w / ((h / 100) ** 2)).toFixed(2);
    let message = '';

    if (bmi < 18.5) message = 'Underweight';
    else if (bmi < 24.9) message = 'Normal weight';
    else if (bmi < 29.9) message = 'Overweight';
    else message = 'Obese';

    setResult(`Your BMI is ${bmi} (${message})`);
  }

  return (
    <div className="container">
      <h1>BMI Calculator</h1>
      <div className="bmi-box">
        <label>Weight (kg):</label>
        <input
          type="number"
          value={weight}
          onChange={(e) => setWeight(e.target.value)}
          placeholder="Enter weight"
        />

        <label>Height (cm):</label>
        <input
          type="number"
          value={height}
          onChange={(e) => setHeight(e.target.value)}
          placeholder="Enter height"
        />

        <button onClick={calculateBMI}>Calculate</button>
        <p id="result">{result}</p>
      </div>
    </div>
  );
}

export default App;

