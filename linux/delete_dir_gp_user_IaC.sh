#!/bin/bash

echo "Iniciando script que desfaz o script IaC do curso AWS da DIO.me"

echo "Excluindo diretórios"

sudo rm -Rf /publico /adm /ven /sec

ls -l /

echo "Removendo grupos"

sudo groupdel -f GRP_ADM 
sudo groupdel -f GRP_VEN
sudo groupdel -f GRP_SEC

echo "Removendo usuários"

sudo userdel -rf carlos
sudo userdel -rf maria 
sudo userdel -rf joao_ 
sudo userdel -rf debora 
sudo userdel -rf sebastiana 
sudo userdel -rf roberto 
sudo userdel -rf josefina
sudo userdel -rf amanda 
sudo userdel -rf rogerio 


echo "Terminando script"


