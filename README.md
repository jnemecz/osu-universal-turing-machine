universal-turing-machine
========================

Implementace Turingova stroje do předmětu XVYS1 (AR 2013/2014 - ZS).

Použití:

mvn assembly:assembly
cd ./target/
unzip maven-assembly-plugin-bin.zip
cd ./maven-assembly-plugin-bin/
chmod +x ./startup.sh
java -jar maven-assembly-plugin.jar data.txt
