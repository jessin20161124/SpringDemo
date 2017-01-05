#!/bin/bash
if [ ./test9.sh -nt ./test8.sh ] ; then
	echo "The test9 is newer than test8"
else
	echo "The test9 is older than test8"
fi
