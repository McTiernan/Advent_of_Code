#!/bin/bash
# data file
INPUT=$1
Floor=0
count=1
charlocation=0
hasBeenSet=false
[ $# -eq 0 ] && { echo "Usage whattt : $0 filename"; exit 1; }
 
# Make sure file exits else die 
[ ! -f $INPUT ] && { echo "$0: file $INPUT not found."; exit 2; }

while IFS= read -r -n1 c 
do
	if [[ "$c" == "(" ]]; then 
		(( Floor++ ))
	else 
		(( Floor-- ))
	fi
	if [[ "$Floor" == "-1" && "$hasBeenSet" == "false" ]]; then
		charlocation=$count
		hasBeenSet=true
	fi
(( count++ ))
done < "$INPUT"

echo "Santa is on floor $Floor"
echo "Character Position that makes santa go to -1 is: $charlocation"