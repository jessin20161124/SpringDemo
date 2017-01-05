#!/bin/bash
if [ $# -ne 2 ] ; then
	echo "Usage : add2 a b"
else
	total=$[ $1  + $2 ]
	echo "The total is $total"
fi
