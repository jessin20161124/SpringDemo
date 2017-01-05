#!/bin/bash
function arrayblr {
	local old_array
	local new_array
	local elements
	local i=0
	# do not forget to add the bracket
	old_array=(`echo "$@"`)
	new_array=(`echo "$@"`)
	elements=$[ $# - 1 ]
	for (( i = 0; i <= $elements; i++ ))
	do
		new_array[$i]=$[ ${old_array[$i]} * 2 ]
	done
	
	echo ${new_array[*]}
}

myarray=(1 2 3 4 5)
echo "the original array is : ${myarray[*]}"
arg1=`echo ${myarray[*]}`
result=`arrayblr $arg1`
echo "the new array is : ${result[*]}"
