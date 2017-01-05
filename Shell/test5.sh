#!/bin/bash

#source command, the function in the running context can be seen
. ./myfuncs
value1=10
value2=0
result1=`add $value1 $value2`
result2=`mul $value1 $value2`
result3=`divide $value1 $value2`
echo "The result of add is : $result1"
echo "The result of mul is : $result2"
echo "The result of divide is : $result3"
