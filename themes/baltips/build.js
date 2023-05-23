const sass = require('sass');
const fs = require('fs');

// Input and output file paths
const inputFile = 'scss/theme.scss';
const outputFile = 'assets/scss/theme.css';

// Compile SCSS to CSS
sass.render(
  {
    file: inputFile,
    outFile: outputFile,
  },
  function (error, result) {
    if (!error) {
      // Write the compiled CSS to the output file
      fs.writeFile(outputFile, result.css, function (err) {
        if (!err) {
          console.log('SCSS compiled successfully!');
        } else {
          console.error('Error writing CSS file:', err);
        }
      });
    } else {
      console.error('Error compiling SCSS:', error);
    }
  }
);