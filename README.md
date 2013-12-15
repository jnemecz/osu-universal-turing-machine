universal-turing-machine
========================

Implementace Turingova stroje do předmětu XVYS1 (AR 2013/2014 - ZS).

Požadavky: Java 1.7, Maven 3.

Použití:

```
 mvn assembly:assembly
 cd ./target/
 unzip maven-assembly-plugin-bin.zip
 cd ./maven-assembly-plugin-bin/
 chmod +x ./startup.sh
 java -jar maven-assembly-plugin.jar data.txt
```

Soubor ```data.txt``` obsahuje zakódovaný Turingův stroj ve formátu:

```
{pocatecni_stav}
$$$
{koncovy_stav_1}$${koncovy_stav_2}$${koncovy_stav_n}$$
$$$
{prechodova_funkce}$${prechodova_funkce}$${prechodova_funkce}
$$$
{data}
```

Přechodová funkce se skládá z pěti hodnot oddělených ```$```, např.:

```
0$#$0$#$000$$
```

je rozložena jako:

* vstupní stav - ```q1```
* vstupní symbol - ```#```
* výstupní stav - ```q1```
* výstupní symbol zapsaný na pásku - ```#```
* posun hlavy doprava (```0 - LEFT```, ```00 - STAND```, ```000 - RIGHT```)

Ex.: Zadání Turingova stroje navýšujícího binární číslo o 1:

```
0
$$$
00000
$$$
0$#$0$#$000
$$
0$0$00$0$000
$$
0$1$00$1$000
$$
00$#$000$#$0
$$
00$0$00$0$000
$$
00$1$00$1$000
$$
000$#$0000$1$000
$$
000$0$0000$1$000
$$
000$1$000$0$0
$$
0000$#$00000$#$00
$$
0000$0$0000$0$000
$$
0000$1$000$1$000
$$$
10000
```

Spuštění:

```
Konfigurace Turingova stroje
----------------------------
M = ({q1,q2,q3,q4,q5},{#,0,1},{#,0,1},δ,q1,{q5})

Přechodové funkce δ:
--------------------
δ(q1,#) = (q1,#,RIGHT)
δ(q1,0) = (q2,0,RIGHT)
δ(q1,1) = (q2,1,RIGHT)
δ(q2,#) = (q3,#,LEFT)
δ(q2,0) = (q2,0,RIGHT)
δ(q2,1) = (q2,1,RIGHT)
δ(q3,#) = (q4,1,RIGHT)
δ(q3,0) = (q4,1,RIGHT)
δ(q3,1) = (q3,0,LEFT)
δ(q4,#) = (q5,#,STAND)
δ(q4,0) = (q4,0,RIGHT)
δ(q4,1) = (q3,1,RIGHT)

Input data: #10000#
------------------
Before: actualState = q1, tape = #10000#
Input symbol: #, using transition function: δ(q1,#) = (q1,#,RIGHT)
After: actualState = q1, tape = #10000#
-----------------------
Before: actualState = q1, tape = #10000#
Input symbol: 1, using transition function: δ(q1,1) = (q2,1,RIGHT)
After: actualState = q2, tape = #10000#
-----------------------
Before: actualState = q2, tape = #10000#
Input symbol: 0, using transition function: δ(q2,0) = (q2,0,RIGHT)
After: actualState = q2, tape = #10000#
-----------------------
Before: actualState = q2, tape = #10000#
Input symbol: 0, using transition function: δ(q2,0) = (q2,0,RIGHT)
After: actualState = q2, tape = #10000#
-----------------------
Before: actualState = q2, tape = #10000#
Input symbol: 0, using transition function: δ(q2,0) = (q2,0,RIGHT)
After: actualState = q2, tape = #10000#
-----------------------
Before: actualState = q2, tape = #10000#
Input symbol: 0, using transition function: δ(q2,0) = (q2,0,RIGHT)
After: actualState = q2, tape = #10000#
-----------------------
Before: actualState = q2, tape = #10000#
Input symbol: #, using transition function: δ(q2,#) = (q3,#,LEFT)
After: actualState = q3, tape = #10000#
-----------------------
Before: actualState = q3, tape = #10000#
Input symbol: 0, using transition function: δ(q3,0) = (q4,1,RIGHT)
After: actualState = q4, tape = #10001#
-----------------------
Before: actualState = q4, tape = #10001#
Input symbol: #, using transition function: δ(q4,#) = (q5,#,STAND)
After: actualState = q5, tape = #10001#
-----------------------
DONE! Output data = #10001#
```
