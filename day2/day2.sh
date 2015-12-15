#!/bin/bash

INPUT=$1
Total=0
smallVar1=0
smallVar2=0
SmallestArea=0
Ribbon=0

[ $# -eq 0 ] && { echo "Usage : $0 filename"; exit 1; }
 
[ ! -f $INPUT ] && { echo "$0: file $INPUT not found."; exit 2; }

while IFS=x read -r l w h
do
	if [[ l -lt w ]]; then
		smallVar1=l
		if [[ h -lt w ]]; then
			smallVar2=h
		else
			smallVar2=w
		fi
	elif [[ l -lt h ]]; then
		smallVar1=l 
		smallVar2=w
	else 
		smallVar2=h
		smallVar1=w
	fi

	SmallestArea=$(( smallVar2 * smallVar1 ))
	Ribbon=$(( Ribbon + ( ( smallVar2 * 2 ) + ( smallVar1 * 2 ) + ( l * w * h ) )))
	Total=$(( Total + ( 2 * ( l * w ) + 2 * ( w * h ) + 2 * ( h * l ) + SmallestArea )  ))

done < "$INPUT"
echo "We need $Total feet of wrapping paper"
echo "We need $Ribbon feet of Ribbon"