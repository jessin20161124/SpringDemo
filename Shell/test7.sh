#!/bin/bash
val1=10
val2=20
if [ $val1 -le $val2 ] ; then
	echo "$val1 is less than $val2"
else
	echo "$val1 is greater than $val2"
fi
