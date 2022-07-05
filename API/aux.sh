#!bin/bash

read rute
if [ -d $rute ];
then
carp=$(echo $rute | tr "/" "\n")
compri=""
for addr in $carp 
do
    compri=""$addr
done
$(sudo zip -9 -r $compri.zip $rute)
echo "Archivo comprimido"
elif [ -f $rute ];
then
echo "Error es un archivo"
else
echo "Error"
fi