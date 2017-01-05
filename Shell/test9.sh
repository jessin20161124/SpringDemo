#!/bin/bash
pwfile=/etc/shadow
if [ -f $pwfile ]
then
	if [ -r $pwfile ]
	then
		tail $pwfile
	else
		echo "Sorry, I am unable to read the $pwfile file"
	fi
else
	echo "Sorry, the file $pwfile does not exist"
fi
