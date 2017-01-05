#!/bin/bash
function addarray {
	local sum=0
	local newarray
	newarray=(`echo "$@"`)
	for value in ${newarray[*]}
		do
			sum=$[ $sum + $value ]
		done
	echo $sum
}
myarray=(1 2 3 4 5)
echo "The orginal array is : ${myarray[*]}"
arg1=`echo ${myarray[*]}`
result=`addarray $arg1`
echo "the result is $result"

