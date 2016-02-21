# TurkishIdTool
This repository includes source code of a Java GUI program that validates and generates 11 digits long Turkish citizenship id numbers.

Executable of the program can be downloaded from <a href="https://github.com/erkutdemirhan/TurkishIdTool/releases/download/v1.0/TurkishIdTool.jar">here</a>.

## Screenshots of the GUI
<p align="center">
  <img 
    src="https://cloud.githubusercontent.com/assets/9785276/13205640/14d90052-d8f5-11e5-9c41-87684b242068.PNG"
    alt="Drawing"
    width="260" />
  <img 
    src="https://cloud.githubusercontent.com/assets/9785276/13205642/18d7b0cc-d8f5-11e5-8f16-9a6663d26fa7.PNG"
    alt="Drawing"
    width="260" />
</p>

## Turkish ID Number Algorithm
This project uses the following algorithm to validate and generate Turkish ID numbers:

Let n is an 11 digits long positive integer and < a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>11</sub>> represent digits of n, where a<sub>1</sub> is the leftmost digit.

n is a valid Turkish ID number if and only if the following conditions hold:

* a<sub>1</sub> is a non-zero digit
* a<sub>10</sub> = { (a<sub>1</sub>+a<sub>3</sub>+a<sub>5</sub>+a<sub>7</sub>+a<sub>9</sub>) * 7 - 
                    (a<sub>2</sub>+a<sub>4</sub>+a<sub>6</sub>+a<sub>8</sub>) } (mod 10)
* a<sub>11</sub> = (a<sub>1</sub>+a<sub>2</sub>+...+a<sub>10</sub>) (mod 10)



