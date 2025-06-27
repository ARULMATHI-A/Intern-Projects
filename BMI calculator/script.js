function calculateBMI() {
      const weight = parseFloat(document.getElementById('weight').value);
      const height = parseFloat(document.getElementById('height').value);

      if (!weight || !height) {
        document.getElementById('result').textContent = "Please enter valid numbers.";
        return;
      }

      const bmi = (weight / ((height / 100) ** 2)).toFixed(2);
      let message = "";

      if (bmi < 18.5) message = "Underweight";
      else if (bmi < 24.9) message = "Normal weight";
      else if (bmi < 29.9) message = "Overweight";
      else message = "Obese";

      document.getElementById('result').textContent = `Your BMI is ${bmi} (${message})`;
    }